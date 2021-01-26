/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_08_01.implementation;

import java.util.List;
import com.microsoft.azure.management.network.v2020_08_01.FirewallPolicyRuleCollection;
import com.microsoft.azure.management.network.v2020_08_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * Rule Collection Group resource.
 */
@JsonFlatten
public class FirewallPolicyRuleCollectionGroupInner extends SubResource {
    /**
     * Priority of the Firewall Policy Rule Collection Group resource.
     */
    @JsonProperty(value = "properties.priority")
    private Integer priority;

    /**
     * Group of Firewall Policy rule collections.
     */
    @JsonProperty(value = "properties.ruleCollections")
    private List<FirewallPolicyRuleCollection> ruleCollections;

    /**
     * The provisioning state of the firewall policy rule collection group
     * resource. Possible values include: 'Succeeded', 'Updating', 'Deleting',
     * 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The name of the resource that is unique within a resource group. This
     * name can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Rule Group type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get priority of the Firewall Policy Rule Collection Group resource.
     *
     * @return the priority value
     */
    public Integer priority() {
        return this.priority;
    }

    /**
     * Set priority of the Firewall Policy Rule Collection Group resource.
     *
     * @param priority the priority value to set
     * @return the FirewallPolicyRuleCollectionGroupInner object itself.
     */
    public FirewallPolicyRuleCollectionGroupInner withPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Get group of Firewall Policy rule collections.
     *
     * @return the ruleCollections value
     */
    public List<FirewallPolicyRuleCollection> ruleCollections() {
        return this.ruleCollections;
    }

    /**
     * Set group of Firewall Policy rule collections.
     *
     * @param ruleCollections the ruleCollections value to set
     * @return the FirewallPolicyRuleCollectionGroupInner object itself.
     */
    public FirewallPolicyRuleCollectionGroupInner withRuleCollections(List<FirewallPolicyRuleCollection> ruleCollections) {
        this.ruleCollections = ruleCollections;
        return this;
    }

    /**
     * Get the provisioning state of the firewall policy rule collection group resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @param name the name value to set
     * @return the FirewallPolicyRuleCollectionGroupInner object itself.
     */
    public FirewallPolicyRuleCollectionGroupInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get rule Group type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}
