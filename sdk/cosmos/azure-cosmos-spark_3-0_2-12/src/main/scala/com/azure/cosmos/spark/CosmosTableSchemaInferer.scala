// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.spark

import com.azure.cosmos.CosmosAsyncClient
import com.azure.cosmos.models.CosmosQueryRequestOptions
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.{ArrayNode, BinaryNode, BooleanNode, DecimalNode, DoubleNode,
    FloatNode, IntNode, LongNode, NullNode, ObjectNode, TextNode}


// scalastyle:off underscore.import
import org.apache.spark.sql.types._
import scala.collection.JavaConverters._
// scalastyle:on underscore.import

// Infers a schema by reading sample data from a source container.
private object CosmosTableSchemaInferer
    extends CosmosLoggingTrait {

    def inferSchema(inferredItems : Seq[ObjectNode]): StructType = {
        if (inferredItems.isEmpty){
            // No documents to infer from
            StructType(Seq())
        }

        // Create a unique map of all distinct properties from documents
        // If 2 documents contain the same property name but different type, the last scanned one would define the final
        // type
        val uniqueStructFields = inferredItems.foldLeft(Map.empty[String, StructField])({
            case (map, item) => inferDataTypeFromObjectNode(item) match {
                case Some(mappedList) => map ++ mappedList
            }
        })

        StructType(uniqueStructFields.valuesIterator.toSeq)
    }

    def inferSchema(client: CosmosAsyncClient,
                    userConfig: Map[String, String]): StructType = {
        val cosmosContainerConfig = CosmosContainerConfig.parseCosmosContainerConfig(userConfig)
        val cosmosReadConfig = CosmosReadConfig.parseCosmosContainerConfig(userConfig)
        val sourceContainer = client.getDatabase(cosmosContainerConfig.database).getContainer(cosmosContainerConfig.container)

        val queryOptions = new CosmosQueryRequestOptions()
        queryOptions.setMaxBufferedItemCount(cosmosReadConfig.inferSchemaSamplingSize)
        val queryText = s"select TOP ${cosmosReadConfig.inferSchemaSamplingSize} * from c"

        val queryObservable =
            sourceContainer.queryItems(queryText, queryOptions, classOf[ObjectNode])

        val feedResponseList = queryObservable.byPage().collectList().block()
        inferSchema(feedResponseList.asScala.flatten(feedResponse => feedResponse.getResults.asScala))
    }

    private def inferDataTypeFromObjectNode(node: ObjectNode) : Option[Seq[(String, StructField)]] = {
        Option(node).map(n =>
            n.fields().asScala
                .filter(field => propertyFilter.isUserProperty(field.getKey))
                .map(field =>
                    field.getKey ->
                    StructField(field.getKey, inferDataTypeFromJsonNode(field.getValue), true))
                .toSeq)
    }

    // scalastyle:off
    private def inferDataTypeFromJsonNode(jsonNode: JsonNode) : DataType = {
        jsonNode match {
            case _: NullNode => NullType
            case _: BinaryNode => BinaryType
            case _: BooleanNode => BooleanType
            case _: TextNode => StringType
            case _: FloatNode => FloatType
            case _: DoubleNode => DoubleType
            case _: LongNode => LongType
            case _: IntNode => IntegerType
            case decimalNode: DecimalNode if decimalNode.isBigDecimal =>
                val asBigDecimal = decimalNode.decimalValue()
                val precision = Integer.min(asBigDecimal.precision, DecimalType.MAX_PRECISION)
                val scale = Integer.min(asBigDecimal.scale, DecimalType.MAX_SCALE)
                DecimalType(precision, scale)
            case decimalNode: DecimalNode if decimalNode.isFloat => FloatType
            case decimalNode: DecimalNode if decimalNode.isDouble => DoubleType
            case decimalNode: DecimalNode if decimalNode.isInt => IntegerType case arrayNode: ArrayNode => inferDataTypeFromArrayNode(arrayNode) match {
                case Some(valueType) => ArrayType(valueType)
                case None => NullType
            }
            case objectNode: ObjectNode => inferDataTypeFromObjectNode(objectNode) match {
                case Some(mappedList) =>
                    val nestedFields = mappedList.map(f => f._2)
                    StructType(nestedFields)
                case None => NullType
                }
            case _ =>
                this.logError(s"Unsupported document node conversion [${jsonNode.getNodeType}]")
                StringType // Defaulting to a string representation for values that we cannot convert
        }
    }
    // scalastyle:on

    private def inferDataTypeFromArrayNode(node: ArrayNode) : Option[DataType] = {
        Option(node.get(0)).map(firstElement => inferDataTypeFromJsonNode(firstElement))
    }

    private object propertyFilter {
        private val systemProperties = List("_etag", "_rid", "_ts", "_self", "_attachments")
        def isUserProperty(propertyName: String): Boolean = !systemProperties.contains(propertyName)
    }
}
