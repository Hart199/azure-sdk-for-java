/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_08_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Intrusion detection signatures specification states.
 */
public class FirewallPolicyIntrusionDetectionSignatureSpecification {
    /**
     * Signature id.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The signature state. Possible values include: 'Off', 'Alert', 'Deny'.
     */
    @JsonProperty(value = "mode")
    private FirewallPolicyIntrusionDetectionStateType mode;

    /**
     * Get signature id.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set signature id.
     *
     * @param id the id value to set
     * @return the FirewallPolicyIntrusionDetectionSignatureSpecification object itself.
     */
    public FirewallPolicyIntrusionDetectionSignatureSpecification withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the signature state. Possible values include: 'Off', 'Alert', 'Deny'.
     *
     * @return the mode value
     */
    public FirewallPolicyIntrusionDetectionStateType mode() {
        return this.mode;
    }

    /**
     * Set the signature state. Possible values include: 'Off', 'Alert', 'Deny'.
     *
     * @param mode the mode value to set
     * @return the FirewallPolicyIntrusionDetectionSignatureSpecification object itself.
     */
    public FirewallPolicyIntrusionDetectionSignatureSpecification withMode(FirewallPolicyIntrusionDetectionStateType mode) {
        this.mode = mode;
        return this;
    }

}
