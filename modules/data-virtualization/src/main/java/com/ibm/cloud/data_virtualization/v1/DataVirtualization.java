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
 * IBM OpenAPI SDK Code Generator Version: 3.34.1-ad041667-20210617-195430
 */

package com.ibm.cloud.data_virtualization.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.common.SdkCommon;
import com.ibm.cloud.data_virtualization.v1.model.AddDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.CatalogPublishResponse;
import com.ibm.cloud.data_virtualization.v1.model.CheckPolicyStatusV2Options;
import com.ibm.cloud.data_virtualization.v1.model.CheckPolicyStatusV2Response;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceConnectionsList;
import com.ibm.cloud.data_virtualization.v1.model.DeleteDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.DeletePrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.DeleteTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.DvaasRevokeRoleFromTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.DvaasVirtualizeTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetPrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantRolesToVirtualizedTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToVirtualTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.ListDatasourceConnectionsOptions;
import com.ibm.cloud.data_virtualization.v1.model.ListTablesForRoleOptions;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnection;
import com.ibm.cloud.data_virtualization.v1.model.PostPrimaryCatalog;
import com.ibm.cloud.data_virtualization.v1.model.PostPrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.PrimaryCatalogInfo;
import com.ibm.cloud.data_virtualization.v1.model.PublishAssetsOptions;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponse;
import com.ibm.cloud.data_virtualization.v1.model.TurnOnPolicyV2Options;
import com.ibm.cloud.data_virtualization.v1.model.TurnOnPolicyV2Response;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableResponse;
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


 /**
   * Class method which constructs an instance of the `DataVirtualization` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `DataVirtualization` client using external configuration
   */
  public static DataVirtualization newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `DataVirtualization` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `DataVirtualization` client using external configuration
   */
  public static DataVirtualization newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    DataVirtualization service = new DataVirtualization(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
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
  }

  /**
   * Get data source connections.
   *
   * Gets all data source connections that are connected to the service.
   *
   * @param listDatasourceConnectionsOptions the {@link ListDatasourceConnectionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DatasourceConnectionsList}
   */
  public ServiceCall<DatasourceConnectionsList> listDatasourceConnections(ListDatasourceConnectionsOptions listDatasourceConnectionsOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/datasource/connections"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "listDatasourceConnections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DatasourceConnectionsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DatasourceConnectionsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get data source connections.
   *
   * Gets all data source connections that are connected to the service.
   *
   * @return a {@link ServiceCall} with a result of type {@link DatasourceConnectionsList}
   */
  public ServiceCall<DatasourceConnectionsList> listDatasourceConnections() {
    return listDatasourceConnections(null);
  }

  /**
   * Add data source connection.
   *
   * Adds a data source connection to the Data Virtualization service.
   *
   * @param addDatasourceConnectionOptions the {@link AddDatasourceConnectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PostDatasourceConnection}
   */
  public ServiceCall<PostDatasourceConnection> addDatasourceConnection(AddDatasourceConnectionOptions addDatasourceConnectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addDatasourceConnectionOptions,
      "addDatasourceConnectionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/datasource/connections"));
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
    builder.bodyJson(contentJson);
    ResponseConverter<PostDatasourceConnection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PostDatasourceConnection>() { }.getType());
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
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("connection_id", deleteDatasourceConnectionOptions.connectionId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/datasource/connections/{connection_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "deleteDatasourceConnection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteDatasourceConnectionOptions.cid() != null) {
      builder.query("cid", String.valueOf(deleteDatasourceConnectionOptions.cid()));
    }
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
    contentJson.addProperty("table_name", grantUserToVirtualTableOptions.tableName());
    contentJson.addProperty("table_schema", grantUserToVirtualTableOptions.tableSchema());
    contentJson.addProperty("authid", grantUserToVirtualTableOptions.authid());
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Revoke user acccess.
   *
   * Revokes user access to the virtualized table.
   *
   * @param revokeUserFromObjectOptions the {@link RevokeUserFromObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> revokeUserFromObject(RevokeUserFromObjectOptions revokeUserFromObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(revokeUserFromObjectOptions,
      "revokeUserFromObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("authid", revokeUserFromObjectOptions.authid());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/users/{authid}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "revokeUserFromObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("table_name", String.valueOf(revokeUserFromObjectOptions.tableName()));
    builder.query("table_schema", String.valueOf(revokeUserFromObjectOptions.tableSchema()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Grant user role.
   *
   * Grants a user role access to a specific virtualized table.
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
    contentJson.addProperty("table_name", grantRolesToVirtualizedTableOptions.tableName());
    contentJson.addProperty("table_schema", grantRolesToVirtualizedTableOptions.tableSchema());
    if (grantRolesToVirtualizedTableOptions.roleName() != null) {
      contentJson.addProperty("role_name", grantRolesToVirtualizedTableOptions.roleName());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete role.
   *
   * Revokes roles for a virtualized table.
   *
   * @param dvaasRevokeRoleFromTableOptions the {@link DvaasRevokeRoleFromTableOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> dvaasRevokeRoleFromTable(DvaasRevokeRoleFromTableOptions dvaasRevokeRoleFromTableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(dvaasRevokeRoleFromTableOptions,
      "dvaasRevokeRoleFromTableOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("role_name", dvaasRevokeRoleFromTableOptions.roleName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/roles/{role_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "dvaasRevokeRoleFromTable");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("table_name", String.valueOf(dvaasRevokeRoleFromTableOptions.tableName()));
    builder.query("table_schema", String.valueOf(dvaasRevokeRoleFromTableOptions.tableSchema()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get virtualized tables by role.
   *
   * Retrieves the list of virtualized tables that have a specific role.
   *
   * @param listTablesForRoleOptions the {@link ListTablesForRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TablesForRoleResponse}
   */
  public ServiceCall<TablesForRoleResponse> listTablesForRole(ListTablesForRoleOptions listTablesForRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTablesForRoleOptions,
      "listTablesForRoleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/privileges/tables"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "listTablesForRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("rolename", String.valueOf(listTablesForRoleOptions.rolename()));
    ResponseConverter<TablesForRoleResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TablesForRoleResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Turn on or off WKC policy enforcement status.
   *
   * Turn on WKC policy enforcement status.
   *
   * @param turnOnPolicyV2Options the {@link TurnOnPolicyV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TurnOnPolicyV2Response}
   */
  public ServiceCall<TurnOnPolicyV2Response> turnOnPolicyV2(TurnOnPolicyV2Options turnOnPolicyV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(turnOnPolicyV2Options,
      "turnOnPolicyV2Options cannot be null");
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/security/policy/status"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "turnOnPolicyV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("status", String.valueOf(turnOnPolicyV2Options.status()));
    ResponseConverter<TurnOnPolicyV2Response> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TurnOnPolicyV2Response>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get WKC policy enforcement status.
   *
   * Get WKC policy enforcement status, return enabled or disabled.
   *
   * @param checkPolicyStatusV2Options the {@link CheckPolicyStatusV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CheckPolicyStatusV2Response}
   */
  public ServiceCall<CheckPolicyStatusV2Response> checkPolicyStatusV2(CheckPolicyStatusV2Options checkPolicyStatusV2Options) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/security/policy/status"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "checkPolicyStatusV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CheckPolicyStatusV2Response> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CheckPolicyStatusV2Response>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get WKC policy enforcement status.
   *
   * Get WKC policy enforcement status, return enabled or disabled.
   *
   * @return a {@link ServiceCall} with a result of type {@link CheckPolicyStatusV2Response}
   */
  public ServiceCall<CheckPolicyStatusV2Response> checkPolicyStatusV2() {
    return checkPolicyStatusV2(null);
  }

  /**
   * Virtualize table.
   *
   * Transforms a given data source table into a virtualized table.
   *
   * @param dvaasVirtualizeTableOptions the {@link DvaasVirtualizeTableOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link VirtualizeTableResponse}
   */
  public ServiceCall<VirtualizeTableResponse> dvaasVirtualizeTable(DvaasVirtualizeTableOptions dvaasVirtualizeTableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(dvaasVirtualizeTableOptions,
      "dvaasVirtualizeTableOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/virtualization/tables"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "dvaasVirtualizeTable");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("source_name", dvaasVirtualizeTableOptions.sourceName());
    contentJson.add("source_table_def", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(dvaasVirtualizeTableOptions.sourceTableDef()));
    contentJson.add("sources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(dvaasVirtualizeTableOptions.sources()));
    contentJson.addProperty("virtual_name", dvaasVirtualizeTableOptions.virtualName());
    contentJson.addProperty("virtual_schema", dvaasVirtualizeTableOptions.virtualSchema());
    contentJson.add("virtual_table_def", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(dvaasVirtualizeTableOptions.virtualTableDef()));
    if (dvaasVirtualizeTableOptions.isIncludedColumns() != null) {
      contentJson.addProperty("is_included_columns", dvaasVirtualizeTableOptions.isIncludedColumns());
    }
    if (dvaasVirtualizeTableOptions.replace() != null) {
      contentJson.addProperty("replace", dvaasVirtualizeTableOptions.replace());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<VirtualizeTableResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<VirtualizeTableResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete virtualized table.
   *
   * Removes the specified virtualized table. You must specify the schema and table name.
   *
   * @param deleteTableOptions the {@link DeleteTableOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTable(DeleteTableOptions deleteTableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTableOptions,
      "deleteTableOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("virtual_name", deleteTableOptions.virtualName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/virtualization/tables/{virtual_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "deleteTable");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("virtual_schema", String.valueOf(deleteTableOptions.virtualSchema()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get primary catalog ID.
   *
   * Get primary catalog ID from the table DVSYS.INSTANCE_INFO.
   *
   * @param getPrimaryCatalogOptions the {@link GetPrimaryCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PrimaryCatalogInfo}
   */
  public ServiceCall<PrimaryCatalogInfo> getPrimaryCatalog(GetPrimaryCatalogOptions getPrimaryCatalogOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/catalog/primary"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "getPrimaryCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PrimaryCatalogInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PrimaryCatalogInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get primary catalog ID.
   *
   * Get primary catalog ID from the table DVSYS.INSTANCE_INFO.
   *
   * @return a {@link ServiceCall} with a result of type {@link PrimaryCatalogInfo}
   */
  public ServiceCall<PrimaryCatalogInfo> getPrimaryCatalog() {
    return getPrimaryCatalog(null);
  }

  /**
   * Add primary catalog.
   *
   * Insert primary catalog ID into table DVSYS.INSTANCE_INFO.
   *
   * @param postPrimaryCatalogOptions the {@link PostPrimaryCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PostPrimaryCatalog}
   */
  public ServiceCall<PostPrimaryCatalog> postPrimaryCatalog(PostPrimaryCatalogOptions postPrimaryCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPrimaryCatalogOptions,
      "postPrimaryCatalogOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/catalog/primary"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "postPrimaryCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("guid", postPrimaryCatalogOptions.guid());
    builder.bodyJson(contentJson);
    ResponseConverter<PostPrimaryCatalog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PostPrimaryCatalog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete primary catalog.
   *
   * Delete primary catalog item in the DVSYS.INSTANCE_INFO table.
   *
   * @param deletePrimaryCatalogOptions the {@link DeletePrimaryCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deletePrimaryCatalog(DeletePrimaryCatalogOptions deletePrimaryCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deletePrimaryCatalogOptions,
      "deletePrimaryCatalogOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/catalog/primary"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "deletePrimaryCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("guid", String.valueOf(deletePrimaryCatalogOptions.guid()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * publish virtual table to WKC.
   *
   * publish virtual tables to WKC.
   *
   * @param publishAssetsOptions the {@link PublishAssetsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogPublishResponse}
   */
  public ServiceCall<CatalogPublishResponse> publishAssets(PublishAssetsOptions publishAssetsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(publishAssetsOptions,
      "publishAssetsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/integration/catalog/publish"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("data_virtualization", "v1", "publishAssets");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("catalog_id", publishAssetsOptions.catalogId());
    contentJson.addProperty("allow_duplicates", publishAssetsOptions.allowDuplicates());
    contentJson.add("assets", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(publishAssetsOptions.assets()));
    builder.bodyJson(contentJson);
    ResponseConverter<CatalogPublishResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogPublishResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
