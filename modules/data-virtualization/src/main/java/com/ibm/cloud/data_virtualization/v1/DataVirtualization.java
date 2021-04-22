/*
 * (C) Copyright IBM Corp. 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

/*
 * IBM OpenAPI SDK Code Generator Version: 3.19.0-be3b4618-20201113-200858
 */

package com.ibm.cloud.data_virtualization.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.common.SdkCommon;
import com.ibm.cloud.data_virtualization.v1.model.AddDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceNodesResponseV2;
import com.ibm.cloud.data_virtualization.v1.model.DeleteDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.DeleteTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetDatasourceConnectionsOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetObjectsForRoleOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantRolesToVirtualizedTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToVirtualTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.ObjectsForRoleResponse;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionResponse;
import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromObjectV2Options;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableResponse;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2Options;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Data Virtualization REST API connects to your service, so you can manage your virtual data, data sources, and
 * user roles.
 *
 * @version v1
 */
public class DataVirtualization extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "data_virtualization";

  public static final String DEFAULT_SERVICE_URL = "https://data-virtualization.cloud.ibm.com";

/**
   * Constructs an instance of the `DataVirtualization` client.
   * The default service name is used to configure the client instance.
   *
   */
  public DataVirtualization() {
    this(DEFAULT_SERVICE_NAME, ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `DataVirtualization` client.
   * The default service name and specified authenticator are used to configure the client instance.
   *
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public DataVirtualization(Authenticator authenticator) {
    this(DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `DataVirtualization` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   */
  public DataVirtualization(String serviceName) {
    this(serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `DataVirtualization` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public DataVirtualization(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    this.configureService(serviceName);
  }

  /**
   * Get data source connections.
   *
   * Gets all data source connections that are connected to the service.
   *
   * @param getDatasourceConnectionsOptions the {@link GetDatasourceConnectionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DatasourceNodesResponseV2}
   */
  public ServiceCall<DatasourceNodesResponseV2> getDatasourceConnections(GetDatasourceConnectionsOptions getDatasourceConnectionsOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/datasource_connections"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "getDatasourceConnections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DatasourceNodesResponseV2> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DatasourceNodesResponseV2>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get data source connections.
   *
   * Gets all data source connections that are connected to the service.
   *
   * @return a {@link ServiceCall} with a result of type {@link DatasourceNodesResponseV2}
   */
  public ServiceCall<DatasourceNodesResponseV2> getDatasourceConnections() {
    return getDatasourceConnections(null);
  }

  /**
   * Add data source connection.
   *
   * Adds a data source connection to the Data Virtualization service.
   *
   * @param addDatasourceConnectionOptions the {@link AddDatasourceConnectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PostDatasourceConnectionResponse}
   */
  public ServiceCall<PostDatasourceConnectionResponse> addDatasourceConnection(AddDatasourceConnectionOptions addDatasourceConnectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addDatasourceConnectionOptions,
      "addDatasourceConnectionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/datasource_connections"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "addDatasourceConnection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("datasource_type", addDatasourceConnectionOptions.datasourceType());
    contentJson.addProperty("name", addDatasourceConnectionOptions.name());
    contentJson.addProperty("origin_country", addDatasourceConnectionOptions.originCountry());
    contentJson.add("properties", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addDatasourceConnectionOptions.xProperties()));
    if (addDatasourceConnectionOptions.assetCategory() != null) {
      contentJson.addProperty("asset_category", addDatasourceConnectionOptions.assetCategory());
    }
    if (addDatasourceConnectionOptions.remoteNodes() != null) {
      contentJson.addProperty("remote_nodes", addDatasourceConnectionOptions.remoteNodes());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PostDatasourceConnectionResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PostDatasourceConnectionResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete data source connection.
   *
   * Deletes a data source connection from the Data Virtualization service.
   *
   * @param deleteDatasourceConnectionOptions the {@link DeleteDatasourceConnectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteDatasourceConnection(DeleteDatasourceConnectionOptions deleteDatasourceConnectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteDatasourceConnectionOptions,
      "deleteDatasourceConnectionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/datasource_connections"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "deleteDatasourceConnection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("cid", String.valueOf(deleteDatasourceConnectionOptions.cid()));
    builder.query("connection_id", String.valueOf(deleteDatasourceConnectionOptions.connectionId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Grant user access.
   *
   * Grants a user access to a specific virtualized table.
   *
   * @param grantUserToVirtualTableOptions the {@link GrantUserToVirtualTableOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> grantUserToVirtualTable(GrantUserToVirtualTableOptions grantUserToVirtualTableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(grantUserToVirtualTableOptions,
      "grantUserToVirtualTableOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/users"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "grantUserToVirtualTable");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (grantUserToVirtualTableOptions.body() != null) {
      contentJson.add("body", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(grantUserToVirtualTableOptions.body()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Grant user access.
   *
   * Grants a user access to a specific virtualized table.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> grantUserToVirtualTable() {
    return grantUserToVirtualTable(null);
  }

  /**
   * Revoke user acccess.
   *
   * Revokes user access to the virtualized tables.
   *
   * @param revokeUserFromObjectOptions the {@link RevokeUserFromObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> revokeUserFromObject(RevokeUserFromObjectOptions revokeUserFromObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(revokeUserFromObjectOptions,
      "revokeUserFromObjectOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/users"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "revokeUserFromObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("authid", String.valueOf(revokeUserFromObjectOptions.authid()));
    builder.query("object_name", String.valueOf(revokeUserFromObjectOptions.objectName()));
    builder.query("object_schema", String.valueOf(revokeUserFromObjectOptions.objectSchema()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Grant user role.
   *
   * Grants a user role access to a specific virtualized tables.
   *
   * @param grantRolesToVirtualizedTableOptions the {@link GrantRolesToVirtualizedTableOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> grantRolesToVirtualizedTable(GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(grantRolesToVirtualizedTableOptions,
      "grantRolesToVirtualizedTableOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/roles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "grantRolesToVirtualizedTable");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (grantRolesToVirtualizedTableOptions.body() != null) {
      contentJson.add("body", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(grantRolesToVirtualizedTableOptions.body()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Grant user role.
   *
   * Grants a user role access to a specific virtualized tables.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> grantRolesToVirtualizedTable() {
    return grantRolesToVirtualizedTable(null);
  }

  /**
   * Delete role.
   *
   * Revokes roles for a virtualized tables.
   *
   * @param revokeRoleFromObjectV2Options the {@link RevokeRoleFromObjectV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> revokeRoleFromObjectV2(RevokeRoleFromObjectV2Options revokeRoleFromObjectV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(revokeRoleFromObjectV2Options,
      "revokeRoleFromObjectV2Options cannot be null");
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/roles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "revokeRoleFromObjectV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("role_to_revoke", String.valueOf(revokeRoleFromObjectV2Options.roleToRevoke()));
    builder.query("object_name", String.valueOf(revokeRoleFromObjectV2Options.objectName()));
    builder.query("object_schema", String.valueOf(revokeRoleFromObjectV2Options.objectSchema()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get objects by role.
   *
   * Retrieves the list of virtualized tables or views that have a specific role.
   *
   * @param getObjectsForRoleOptions the {@link GetObjectsForRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectsForRoleResponse}
   */
  public ServiceCall<ObjectsForRoleResponse> getObjectsForRole(GetObjectsForRoleOptions getObjectsForRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getObjectsForRoleOptions,
      "getObjectsForRoleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rolename", getObjectsForRoleOptions.rolename());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/privileges/objects/role/{rolename}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "getObjectsForRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ObjectsForRoleResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ObjectsForRoleResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Virtualize table.
   *
   * Transforms a given data source table into a virtualized table.
   *
   * @param virtualizeTableV2Options the {@link VirtualizeTableV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link VirtualizeTableResponse}
   */
  public ServiceCall<VirtualizeTableResponse> virtualizeTableV2(VirtualizeTableV2Options virtualizeTableV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(virtualizeTableV2Options,
      "virtualizeTableV2Options cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/virtualize/tables"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "virtualizeTableV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("source_name", virtualizeTableV2Options.sourceName());
    contentJson.add("source_table_def", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(virtualizeTableV2Options.sourceTableDef()));
    contentJson.add("sources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(virtualizeTableV2Options.sources()));
    contentJson.addProperty("virtual_name", virtualizeTableV2Options.virtualName());
    contentJson.addProperty("virtual_schema", virtualizeTableV2Options.virtualSchema());
    contentJson.add("virtual_table_def", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(virtualizeTableV2Options.virtualTableDef()));
    if (virtualizeTableV2Options.isIncludedColumns() != null) {
      contentJson.addProperty("is_included_columns", virtualizeTableV2Options.isIncludedColumns());
    }
    if (virtualizeTableV2Options.replace() != null) {
      contentJson.addProperty("replace", virtualizeTableV2Options.replace());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<VirtualizeTableResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<VirtualizeTableResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete table or view.
   *
   * Removes the specified table. You must specify the schema and table name.
   *
   * @param deleteTableOptions the {@link DeleteTableOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTable(DeleteTableOptions deleteTableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTableOptions,
      "deleteTableOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("object_name", deleteTableOptions.objectName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/mydata/tables/{object_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "deleteTable");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("schema_name", String.valueOf(deleteTableOptions.schemaName()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
