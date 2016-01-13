/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.14.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

/* jshint latedef:false */
/* jshint forin:false */
/* jshint noempty:false */

'use strict';

var util = require('util');
var msRest = require('ms-rest');
var msRestAzure = require('ms-rest-azure');
var ServiceClient = msRestAzure.AzureServiceClient;

var models = require('./models');
var operations = require('./operations');

/**
 * @class
 * Initializes a new instance of the AutoRestAzureSpecialParametersTestClient class.
 * @constructor
 *
 * @param {Credentials} credentials Gets Azure subscription credentials.
 *
 * @param {String} subscriptionId The subscription id, which appears in the path, always modeled in credentials. The value is always '1234-5678-9012-3456'
 *
 * @param {string} [baseUri] - The base URI of the service.
 *
 * @param {object} [options] - The parameter options
 *
 * @param {Array} [options.filters] - Filters to be added to the request pipeline
 *
 * @param {object} [options.requestOptions] - Options for the underlying request object
 * {@link https://github.com/request/request#requestoptions-callback Options doc}
 *
 * @param {bool} [options.noRetryPolicy] - If set to true, turn off default retry policy
 */
function AutoRestAzureSpecialParametersTestClient(credentials, subscriptionId, baseUri, options) {
  if (credentials === null || credentials === undefined) {
    throw new Error('\'credentials\' cannot be null.');
  }
  if (subscriptionId === null || subscriptionId === undefined) {
    throw new Error('\'subscriptionId\' cannot be null.');
  }

  if (!options) options = {};

  AutoRestAzureSpecialParametersTestClient['super_'].call(this, credentials, options);
  this.baseUri = baseUri;
  if (!this.baseUri) {
    this.baseUri = 'http://localhost';
  }
  this.credentials = credentials;
  this.subscriptionId = subscriptionId;

  if(!this.apiVersion) {
    this.apiVersion = '2015-07-01-preview';
  }
  if(!this.acceptLanguage) {
    this.acceptLanguage = 'en-US';
  }
  this.xMsClientRequestId = new operations.XMsClientRequestId(this);
  this.subscriptionInCredentials = new operations.SubscriptionInCredentials(this);
  this.subscriptionInMethod = new operations.SubscriptionInMethod(this);
  this.apiVersionDefault = new operations.ApiVersionDefault(this);
  this.apiVersionLocal = new operations.ApiVersionLocal(this);
  this.skipUrlEncoding = new operations.SkipUrlEncoding(this);
  this.odata = new operations.Odata(this);
  this.header = new operations.Header(this);
  this.models = models;
  msRest.addSerializationMixin(this);
}

util.inherits(AutoRestAzureSpecialParametersTestClient, ServiceClient);

module.exports = AutoRestAzureSpecialParametersTestClient;
