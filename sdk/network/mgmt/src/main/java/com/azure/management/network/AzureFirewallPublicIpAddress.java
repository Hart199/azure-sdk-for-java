// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.network;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The AzureFirewallPublicIpAddress model. */
@Fluent
public final class AzureFirewallPublicIpAddress {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AzureFirewallPublicIpAddress.class);

    /*
     * Public IP Address value.
     */
    @JsonProperty(value = "address")
    private String address;

    /**
     * Get the address property: Public IP Address value.
     *
     * @return the address value.
     */
    public String address() {
        return this.address;
    }

    /**
     * Set the address property: Public IP Address value.
     *
     * @param address the address value to set.
     * @return the AzureFirewallPublicIpAddress object itself.
     */
    public AzureFirewallPublicIpAddress withAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}