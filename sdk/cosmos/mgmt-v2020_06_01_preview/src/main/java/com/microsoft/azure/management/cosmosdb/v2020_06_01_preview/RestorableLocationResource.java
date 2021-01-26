/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2020_06_01_preview;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of the regional restorable account.
 */
public class RestorableLocationResource {
    /**
     * The location of the regional restorable account.
     */
    @JsonProperty(value = "locationName", access = JsonProperty.Access.WRITE_ONLY)
    private String locationName;

    /**
     * The instance id of the regional restorable account.
     */
    @JsonProperty(value = "regionalDatabaseAccountInstanceId", access = JsonProperty.Access.WRITE_ONLY)
    private String regionalDatabaseAccountInstanceId;

    /**
     * The creation time of the regional restorable database account (ISO-8601
     * format).
     */
    @JsonProperty(value = "creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationTime;

    /**
     * The time at which the regional restorable database account has been
     * deleted (ISO-8601 format).
     */
    @JsonProperty(value = "deletionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime deletionTime;

    /**
     * Get the location of the regional restorable account.
     *
     * @return the locationName value
     */
    public String locationName() {
        return this.locationName;
    }

    /**
     * Get the instance id of the regional restorable account.
     *
     * @return the regionalDatabaseAccountInstanceId value
     */
    public String regionalDatabaseAccountInstanceId() {
        return this.regionalDatabaseAccountInstanceId;
    }

    /**
     * Get the creation time of the regional restorable database account (ISO-8601 format).
     *
     * @return the creationTime value
     */
    public DateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Get the time at which the regional restorable database account has been deleted (ISO-8601 format).
     *
     * @return the deletionTime value
     */
    public DateTime deletionTime() {
        return this.deletionTime;
    }

}
