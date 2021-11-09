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
package com.ibm.cloud.data_virtualization.v1;

import com.ibm.cloud.data_virtualization.v1.DataVirtualization;
import com.ibm.cloud.data_virtualization.v1.model.AddDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.CacheListResponse;
import com.ibm.cloud.data_virtualization.v1.model.CacheListResponseCachesItem;
import com.ibm.cloud.data_virtualization.v1.model.CacheResponse;
import com.ibm.cloud.data_virtualization.v1.model.CatalogPublishResponse;
import com.ibm.cloud.data_virtualization.v1.model.CatalogPublishResponseDuplicateAssetsItem;
import com.ibm.cloud.data_virtualization.v1.model.CatalogPublishResponseFailedAssetsItem;
import com.ibm.cloud.data_virtualization.v1.model.CatalogPublishResponsePublishedAssetsItem;
import com.ibm.cloud.data_virtualization.v1.model.CheckPolicyStatusV2Options;
import com.ibm.cloud.data_virtualization.v1.model.CheckPolicyStatusV2Response;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceConnectionsList;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceConnectionsListDatasourceConnectionsItem;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceConnectionsListDatasourceConnectionsItemDataSourcesItem;
import com.ibm.cloud.data_virtualization.v1.model.DeleteDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.DeletePrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.DeleteTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.DvaasRevokeRoleFromTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.DvaasVirtualizeTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetCacheOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetCacheStorageDetailOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetCachesListOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetObjectStoreConnectionsV2Options;
import com.ibm.cloud.data_virtualization.v1.model.GetPrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantRolesToVirtualizedTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToVirtualTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.ListDatasourceConnectionsOptions;
import com.ibm.cloud.data_virtualization.v1.model.ListTablesForRoleOptions;
import com.ibm.cloud.data_virtualization.v1.model.ObjStoreConnectionResponseV2;
import com.ibm.cloud.data_virtualization.v1.model.ObjStoreConnectionResponseV2CosConnectionsItem;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnection;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersProperties;
import com.ibm.cloud.data_virtualization.v1.model.PostPrimaryCatalog;
import com.ibm.cloud.data_virtualization.v1.model.PostPrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.PostPrimaryCatalogParametersAssetsItem;
import com.ibm.cloud.data_virtualization.v1.model.PrimaryCatalogInfo;
import com.ibm.cloud.data_virtualization.v1.model.PrimaryCatalogInfoEntity;
import com.ibm.cloud.data_virtualization.v1.model.PrimaryCatalogInfoMetadata;
import com.ibm.cloud.data_virtualization.v1.model.PublishAssetsOptions;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.StorageDetails;
import com.ibm.cloud.data_virtualization.v1.model.StorageDetailsDisabled;
import com.ibm.cloud.data_virtualization.v1.model.StorageDetailsEnabled;
import com.ibm.cloud.data_virtualization.v1.model.SuccessResponse;
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponse;
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponseObjectsItem;
import com.ibm.cloud.data_virtualization.v1.model.TurnOnPolicyV2Options;
import com.ibm.cloud.data_virtualization.v1.model.TurnOnPolicyV2Response;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeCosV2Options;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeCosV2RequestVirtualTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterVirtualTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableResponse;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DataVirtualization service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class DataVirtualizationTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected DataVirtualization dataVirtualizationService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    dataVirtualizationService = DataVirtualization.newInstance(serviceName);
    String url = server.url("/").toString();
    dataVirtualizationService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new DataVirtualization(serviceName, null);
  }

  @Test
  public void testListDatasourceConnectionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"datasource_connections\": [{\"node_name\": \"nodeName\", \"node_description\": \"nodeDescription\", \"agent_class\": \"agentClass\", \"hostname\": \"hostname\", \"port\": \"port\", \"os_user\": \"osUser\", \"is_docker\": \"isDocker\", \"dscount\": \"dscount\", \"data_sources\": [{\"cid\": \"cid\", \"dbname\": \"dbname\", \"connection_id\": \"connectionId\", \"srchostname\": \"srchostname\", \"srcport\": \"srcport\", \"srctype\": \"srctype\", \"usr\": \"usr\", \"uri\": \"uri\", \"status\": \"status\", \"connection_name\": \"connectionName\"}]}]}";
    String listDatasourceConnectionsPath = "/v2/datasource/connections";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListDatasourceConnectionsOptions model
    ListDatasourceConnectionsOptions listDatasourceConnectionsOptionsModel = new ListDatasourceConnectionsOptions();

    // Invoke operation with valid options model (positive test)
    Response<DatasourceConnectionsList> response = dataVirtualizationService.listDatasourceConnections(listDatasourceConnectionsOptionsModel).execute();
    assertNotNull(response);
    DatasourceConnectionsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDatasourceConnectionsPath);
  }
  
  public void testListDatasourceConnectionsWOptionsWRetries() throws Throwable {
    // Enable retries and run testListDatasourceConnectionsWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testListDatasourceConnectionsWOptions();

    // Disable retries and run testListDatasourceConnectionsWOptions.
    dataVirtualizationService.disableRetries();
    testListDatasourceConnectionsWOptions();
  }  

  @Test
  public void testAddDatasourceConnectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"connection_id\": \"connectionId\", \"datasource_type\": \"datasourceType\", \"name\": \"name\"}";
    String addDatasourceConnectionPath = "/v2/datasource/connections";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostDatasourceConnectionParametersProperties model
    PostDatasourceConnectionParametersProperties postDatasourceConnectionParametersPropertiesModel = new PostDatasourceConnectionParametersProperties.Builder()
    .accessToken("ya29.Il-_")
    .accountName("ibmdatastage.us-east-1")
    .apiKey("ApiKey-a31d60c5-0f7b-4995-a4ae-69bf09d3de50")
    .authType("Bearer Token")
    .clientId("81571342315")
    .clientSecret("uIn8rVyIRsd")
    .collection("test_collection")
    .credentials("-----BEGIN PRIVATE KEY-----")
    .database("TPCDS")
    .host("192.168.0.1")
    .httpPath("cliservice")
    .jarUris("/v2/asset_files/dbdrivers/ngdbc.jar")
    .jdbcDriver("Snowflake")
    .jdbcUrl("/v2/asset_files/dbdrivers/ngdbc.jar")
    .password("password")
    .port("50000")
    .projectId("housecanary-com")
    .xProperties("key=value")
    .refreshToken("1//06uwhP7_312g")
    .role("SYSADMIN")
    .sapGatewayUrl("https://sapes5.sapdevcenter.com")
    .server("ol_informix1410")
    .serviceName("pdborcl.fyre.ibm.com")
    .sid("orcl")
    .ssl("false")
    .sslCertificate("-----BEGIN CERTIFICATE-----")
    .sslCertificateHost("test.com")
    .sslCertificateValidation("false")
    .username("db2inst1")
    .warehouse("wdpcondev")
    .build();

    // Construct an instance of the AddDatasourceConnectionOptions model
    AddDatasourceConnectionOptions addDatasourceConnectionOptionsModel = new AddDatasourceConnectionOptions.Builder()
    .datasourceType("DB2")
    .name("DB2")
    .originCountry("us")
    .xProperties(postDatasourceConnectionParametersPropertiesModel)
    .assetCategory("USER")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PostDatasourceConnection> response = dataVirtualizationService.addDatasourceConnection(addDatasourceConnectionOptionsModel).execute();
    assertNotNull(response);
    PostDatasourceConnection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addDatasourceConnectionPath);
  }
  
  public void testAddDatasourceConnectionWOptionsWRetries() throws Throwable {
    // Enable retries and run testAddDatasourceConnectionWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testAddDatasourceConnectionWOptions();

    // Disable retries and run testAddDatasourceConnectionWOptions.
    dataVirtualizationService.disableRetries();
    testAddDatasourceConnectionWOptions();
  }  

  // Test the addDatasourceConnection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddDatasourceConnectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.addDatasourceConnection(null).execute();
  }

  @Test
  public void testDeleteDatasourceConnectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteDatasourceConnectionPath = "/v2/datasource/connections/75e4d01b-7417-4abc-b267-8ffb393fb970";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDatasourceConnectionOptions model
    DeleteDatasourceConnectionOptions deleteDatasourceConnectionOptionsModel = new DeleteDatasourceConnectionOptions.Builder()
    .connectionId("75e4d01b-7417-4abc-b267-8ffb393fb970")
    .cid("DB210013")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.deleteDatasourceConnection(deleteDatasourceConnectionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("cid"), "DB210013");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDatasourceConnectionPath);
  }
  
  public void testDeleteDatasourceConnectionWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteDatasourceConnectionWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testDeleteDatasourceConnectionWOptions();

    // Disable retries and run testDeleteDatasourceConnectionWOptions.
    dataVirtualizationService.disableRetries();
    testDeleteDatasourceConnectionWOptions();
  }  

  // Test the deleteDatasourceConnection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDatasourceConnectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.deleteDatasourceConnection(null).execute();
  }

  @Test
  public void testGetObjectStoreConnectionsV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"cos_connections\": [{\"bucket_name\": \"newbigsqlbucket\", \"ccid\": \"c28e0248-82ad-4aca-a658-90a626769fba\", \"cid\": \"CEPH10000\", \"endpoint\": \"http://jobs-m-2.fyre.ibm.com\", \"removed\": false, \"service_type\": \"CEPH\", \"status\": \"VALID\"}]}";
    String getObjectStoreConnectionsV2Path = "/v2/datasource/objectstore_connections";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectStoreConnectionsV2Options model
    GetObjectStoreConnectionsV2Options getObjectStoreConnectionsV2OptionsModel = new GetObjectStoreConnectionsV2Options.Builder()
    .jwtAuthUserPayload("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjStoreConnectionResponseV2> response = dataVirtualizationService.getObjectStoreConnectionsV2(getObjectStoreConnectionsV2OptionsModel).execute();
    assertNotNull(response);
    ObjStoreConnectionResponseV2 responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getObjectStoreConnectionsV2Path);
  }
  
  public void testGetObjectStoreConnectionsV2WOptionsWRetries() throws Throwable {
    // Enable retries and run testGetObjectStoreConnectionsV2WOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGetObjectStoreConnectionsV2WOptions();

    // Disable retries and run testGetObjectStoreConnectionsV2WOptions.
    dataVirtualizationService.disableRetries();
    testGetObjectStoreConnectionsV2WOptions();
  }  

  @Test
  public void testGrantUserToVirtualTableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String grantUserToVirtualTablePath = "/v2/privileges/users";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GrantUserToVirtualTableOptions model
    GrantUserToVirtualTableOptions grantUserToVirtualTableOptionsModel = new GrantUserToVirtualTableOptions.Builder()
    .tableName("EMPLOYEE")
    .tableSchema("dv_ibmid_060000s4y5")
    .authid("PUBLIC")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.grantUserToVirtualTable(grantUserToVirtualTableOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, grantUserToVirtualTablePath);
  }
  
  public void testGrantUserToVirtualTableWOptionsWRetries() throws Throwable {
    // Enable retries and run testGrantUserToVirtualTableWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGrantUserToVirtualTableWOptions();

    // Disable retries and run testGrantUserToVirtualTableWOptions.
    dataVirtualizationService.disableRetries();
    testGrantUserToVirtualTableWOptions();
  }  

  // Test the grantUserToVirtualTable operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGrantUserToVirtualTableNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.grantUserToVirtualTable(null).execute();
  }

  @Test
  public void testRevokeUserFromObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String revokeUserFromObjectPath = "/v2/privileges/users/PUBLIC";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RevokeUserFromObjectOptions model
    RevokeUserFromObjectOptions revokeUserFromObjectOptionsModel = new RevokeUserFromObjectOptions.Builder()
    .authid("PUBLIC")
    .tableName("EMPLOYEE")
    .tableSchema("dv_ibmid_060000s4y5")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.revokeUserFromObject(revokeUserFromObjectOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("table_name"), "EMPLOYEE");
    assertEquals(query.get("table_schema"), "dv_ibmid_060000s4y5");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, revokeUserFromObjectPath);
  }
  
  public void testRevokeUserFromObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testRevokeUserFromObjectWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testRevokeUserFromObjectWOptions();

    // Disable retries and run testRevokeUserFromObjectWOptions.
    dataVirtualizationService.disableRetries();
    testRevokeUserFromObjectWOptions();
  }  

  // Test the revokeUserFromObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRevokeUserFromObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.revokeUserFromObject(null).execute();
  }

  @Test
  public void testGrantRolesToVirtualizedTableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String grantRolesToVirtualizedTablePath = "/v2/privileges/roles";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GrantRolesToVirtualizedTableOptions model
    GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptionsModel = new GrantRolesToVirtualizedTableOptions.Builder()
    .tableName("EMPLOYEE")
    .tableSchema("dv_ibmid_060000s4y5")
    .roleName("PUBLIC")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.grantRolesToVirtualizedTable(grantRolesToVirtualizedTableOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, grantRolesToVirtualizedTablePath);
  }
  
  public void testGrantRolesToVirtualizedTableWOptionsWRetries() throws Throwable {
    // Enable retries and run testGrantRolesToVirtualizedTableWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGrantRolesToVirtualizedTableWOptions();

    // Disable retries and run testGrantRolesToVirtualizedTableWOptions.
    dataVirtualizationService.disableRetries();
    testGrantRolesToVirtualizedTableWOptions();
  }  

  // Test the grantRolesToVirtualizedTable operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGrantRolesToVirtualizedTableNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.grantRolesToVirtualizedTable(null).execute();
  }

  @Test
  public void testDvaasRevokeRoleFromTableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String dvaasRevokeRoleFromTablePath = "/v2/privileges/roles/DV_ENGINEER";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DvaasRevokeRoleFromTableOptions model
    DvaasRevokeRoleFromTableOptions dvaasRevokeRoleFromTableOptionsModel = new DvaasRevokeRoleFromTableOptions.Builder()
    .roleName("DV_ENGINEER")
    .tableName("EMPLOYEE")
    .tableSchema("dv_ibmid_060000s4y5")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.dvaasRevokeRoleFromTable(dvaasRevokeRoleFromTableOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("table_name"), "EMPLOYEE");
    assertEquals(query.get("table_schema"), "dv_ibmid_060000s4y5");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, dvaasRevokeRoleFromTablePath);
  }
  
  public void testDvaasRevokeRoleFromTableWOptionsWRetries() throws Throwable {
    // Enable retries and run testDvaasRevokeRoleFromTableWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testDvaasRevokeRoleFromTableWOptions();

    // Disable retries and run testDvaasRevokeRoleFromTableWOptions.
    dataVirtualizationService.disableRetries();
    testDvaasRevokeRoleFromTableWOptions();
  }  

  // Test the dvaasRevokeRoleFromTable operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDvaasRevokeRoleFromTableNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.dvaasRevokeRoleFromTable(null).execute();
  }

  @Test
  public void testListTablesForRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"objects\": [{\"table_name\": \"tableName\", \"table_schema\": \"tableSchema\"}]}";
    String listTablesForRolePath = "/v2/privileges/tables";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListTablesForRoleOptions model
    ListTablesForRoleOptions listTablesForRoleOptionsModel = new ListTablesForRoleOptions.Builder()
    .rolename("MANAGER | STEWARD | ENGINEER | USER")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TablesForRoleResponse> response = dataVirtualizationService.listTablesForRole(listTablesForRoleOptionsModel).execute();
    assertNotNull(response);
    TablesForRoleResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("rolename"), "MANAGER | STEWARD | ENGINEER | USER");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTablesForRolePath);
  }
  
  public void testListTablesForRoleWOptionsWRetries() throws Throwable {
    // Enable retries and run testListTablesForRoleWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testListTablesForRoleWOptions();

    // Disable retries and run testListTablesForRoleWOptions.
    dataVirtualizationService.disableRetries();
    testListTablesForRoleWOptions();
  }  

  // Test the listTablesForRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTablesForRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.listTablesForRole(null).execute();
  }

  @Test
  public void testTurnOnPolicyV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"enabled\"}";
    String turnOnPolicyV2Path = "/v2/security/policy/status";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TurnOnPolicyV2Options model
    TurnOnPolicyV2Options turnOnPolicyV2OptionsModel = new TurnOnPolicyV2Options.Builder()
    .status("enabled")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TurnOnPolicyV2Response> response = dataVirtualizationService.turnOnPolicyV2(turnOnPolicyV2OptionsModel).execute();
    assertNotNull(response);
    TurnOnPolicyV2Response responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("status"), "enabled");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, turnOnPolicyV2Path);
  }
  
  public void testTurnOnPolicyV2WOptionsWRetries() throws Throwable {
    // Enable retries and run testTurnOnPolicyV2WOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testTurnOnPolicyV2WOptions();

    // Disable retries and run testTurnOnPolicyV2WOptions.
    dataVirtualizationService.disableRetries();
    testTurnOnPolicyV2WOptions();
  }  

  // Test the turnOnPolicyV2 operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTurnOnPolicyV2NoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.turnOnPolicyV2(null).execute();
  }

  @Test
  public void testCheckPolicyStatusV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"enabled\"}";
    String checkPolicyStatusV2Path = "/v2/security/policy/status";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CheckPolicyStatusV2Options model
    CheckPolicyStatusV2Options checkPolicyStatusV2OptionsModel = new CheckPolicyStatusV2Options();

    // Invoke operation with valid options model (positive test)
    Response<CheckPolicyStatusV2Response> response = dataVirtualizationService.checkPolicyStatusV2(checkPolicyStatusV2OptionsModel).execute();
    assertNotNull(response);
    CheckPolicyStatusV2Response responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, checkPolicyStatusV2Path);
  }
  
  public void testCheckPolicyStatusV2WOptionsWRetries() throws Throwable {
    // Enable retries and run testCheckPolicyStatusV2WOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testCheckPolicyStatusV2WOptions();

    // Disable retries and run testCheckPolicyStatusV2WOptions.
    dataVirtualizationService.disableRetries();
    testCheckPolicyStatusV2WOptions();
  }  

  @Test
  public void testDvaasVirtualizeTableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"table_name\": \"Tab1\", \"schema_name\": \"dv_ibmid_060000s4y5\"}";
    String dvaasVirtualizeTablePath = "/v2/virtualization/tables";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the VirtualizeTableParameterSourceTableDefItem model
    VirtualizeTableParameterSourceTableDefItem virtualizeTableParameterSourceTableDefItemModel = new VirtualizeTableParameterSourceTableDefItem.Builder()
    .columnName("Column1")
    .columnType("INTEGER")
    .build();

    // Construct an instance of the VirtualizeTableParameterVirtualTableDefItem model
    VirtualizeTableParameterVirtualTableDefItem virtualizeTableParameterVirtualTableDefItemModel = new VirtualizeTableParameterVirtualTableDefItem.Builder()
    .columnName("Column_1")
    .columnType("INTEGER")
    .build();

    // Construct an instance of the DvaasVirtualizeTableOptions model
    DvaasVirtualizeTableOptions dvaasVirtualizeTableOptionsModel = new DvaasVirtualizeTableOptions.Builder()
    .sourceName("Tab1")
    .sourceTableDef(new java.util.ArrayList<VirtualizeTableParameterSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterSourceTableDefItemModel)))
    .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("DB210001:\"Hjq1\"")))
    .virtualName("Tab1")
    .virtualSchema("dv_ibmid_060000s4y5")
    .virtualTableDef(new java.util.ArrayList<VirtualizeTableParameterVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterVirtualTableDefItemModel)))
    .isIncludedColumns("Y, Y, N")
    .replace(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<VirtualizeTableResponse> response = dataVirtualizationService.dvaasVirtualizeTable(dvaasVirtualizeTableOptionsModel).execute();
    assertNotNull(response);
    VirtualizeTableResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, dvaasVirtualizeTablePath);
  }
  
  public void testDvaasVirtualizeTableWOptionsWRetries() throws Throwable {
    // Enable retries and run testDvaasVirtualizeTableWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testDvaasVirtualizeTableWOptions();

    // Disable retries and run testDvaasVirtualizeTableWOptions.
    dataVirtualizationService.disableRetries();
    testDvaasVirtualizeTableWOptions();
  }  

  // Test the dvaasVirtualizeTable operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDvaasVirtualizeTableNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.dvaasVirtualizeTable(null).execute();
  }

  @Test
  public void testDeleteTableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteTablePath = "/v2/virtualization/tables/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTableOptions model
    DeleteTableOptions deleteTableOptionsModel = new DeleteTableOptions.Builder()
    .virtualSchema("testString")
    .virtualName("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.deleteTable(deleteTableOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("virtual_schema"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTablePath);
  }
  
  public void testDeleteTableWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteTableWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testDeleteTableWOptions();

    // Disable retries and run testDeleteTableWOptions.
    dataVirtualizationService.disableRetries();
    testDeleteTableWOptions();
  }  

  // Test the deleteTable operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTableNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.deleteTable(null).execute();
  }

  @Test
  public void testVirtualizeCosV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"message\": \"message\"}";
    String virtualizeCosV2Path = "/v2/virtualization/cloud_object_storages";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the VirtualizeCosV2RequestVirtualTableDefItem model
    VirtualizeCosV2RequestVirtualTableDefItem virtualizeCosV2RequestVirtualTableDefItemModel = new VirtualizeCosV2RequestVirtualTableDefItem.Builder()
    .columnName("Column_1")
    .columnType("INTEGER")
    .build();

    // Construct an instance of the VirtualizeCosV2Options model
    VirtualizeCosV2Options virtualizeCosV2OptionsModel = new VirtualizeCosV2Options.Builder()
    .url("s3a://testBucket/home/data.csv")
    .virtualName("testString")
    .virtualSchema("testString")
    .virtualTableDef(new java.util.ArrayList<VirtualizeCosV2RequestVirtualTableDefItem>(java.util.Arrays.asList(virtualizeCosV2RequestVirtualTableDefItemModel)))
    .isReplace(false)
    .options("INCPARTS=true")
    .jwtAuthUserPayload("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SuccessResponse> response = dataVirtualizationService.virtualizeCosV2(virtualizeCosV2OptionsModel).execute();
    assertNotNull(response);
    SuccessResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, virtualizeCosV2Path);
  }
  
  public void testVirtualizeCosV2WOptionsWRetries() throws Throwable {
    // Enable retries and run testVirtualizeCosV2WOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testVirtualizeCosV2WOptions();

    // Disable retries and run testVirtualizeCosV2WOptions.
    dataVirtualizationService.disableRetries();
    testVirtualizeCosV2WOptions();
  }  

  // Test the virtualizeCosV2 operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeCosV2NoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.virtualizeCosV2(null).execute();
  }

  @Test
  public void testGetPrimaryCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"entity\": {\"auto_profiling\": true, \"bss_account_id\": \"999\", \"capacity_limit\": 0, \"description\": \"The governed catalog where data assets are synchronized with the Information assets view.\", \"generator\": \"Catalog-OMRS-Synced\", \"is_governed\": true, \"name\": \"Primary Catalog\"}, \"href\": \"/v2/catalogs/648fb4e0-3f6c-4ce3-afbb-317acc03faa4\", \"metadata\": {\"create_time\": \"2021-01-11T10:37:03Z\", \"creator_id\": \"648fb4e01000330999\", \"guid\": \"648fb4e0-3f6c-4ce3-afbb-317acc03faa4\", \"url\": \"648fb4e0/v2/catalogs/648fb4e0-3f6c-4ce3-afbb-317acc03faa4\"}}";
    String getPrimaryCatalogPath = "/v2/catalog/primary";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPrimaryCatalogOptions model
    GetPrimaryCatalogOptions getPrimaryCatalogOptionsModel = new GetPrimaryCatalogOptions();

    // Invoke operation with valid options model (positive test)
    Response<PrimaryCatalogInfo> response = dataVirtualizationService.getPrimaryCatalog(getPrimaryCatalogOptionsModel).execute();
    assertNotNull(response);
    PrimaryCatalogInfo responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPrimaryCatalogPath);
  }
  
  public void testGetPrimaryCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetPrimaryCatalogWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGetPrimaryCatalogWOptions();

    // Disable retries and run testGetPrimaryCatalogWOptions.
    dataVirtualizationService.disableRetries();
    testGetPrimaryCatalogWOptions();
  }  

  @Test
  public void testPostPrimaryCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"guid\": \"d77fc432-9b1a-4938-a2a5-9f37e08041f6\", \"name\": \"Default Catalog\", \"description\": \"The governed catalog where data assets are synchronized with the Information assets view.\"}";
    String postPrimaryCatalogPath = "/v2/catalog/primary";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPrimaryCatalogOptions model
    PostPrimaryCatalogOptions postPrimaryCatalogOptionsModel = new PostPrimaryCatalogOptions.Builder()
    .guid("d77fc432-9b1a-4938-a2a5-9f37e08041f6")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PostPrimaryCatalog> response = dataVirtualizationService.postPrimaryCatalog(postPrimaryCatalogOptionsModel).execute();
    assertNotNull(response);
    PostPrimaryCatalog responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPrimaryCatalogPath);
  }
  
  public void testPostPrimaryCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testPostPrimaryCatalogWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testPostPrimaryCatalogWOptions();

    // Disable retries and run testPostPrimaryCatalogWOptions.
    dataVirtualizationService.disableRetries();
    testPostPrimaryCatalogWOptions();
  }  

  // Test the postPrimaryCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPrimaryCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.postPrimaryCatalog(null).execute();
  }

  @Test
  public void testDeletePrimaryCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deletePrimaryCatalogPath = "/v2/catalog/primary";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeletePrimaryCatalogOptions model
    DeletePrimaryCatalogOptions deletePrimaryCatalogOptionsModel = new DeletePrimaryCatalogOptions.Builder()
    .guid("d77fc432-9b1a-4938-a2a5-9f37e08041f6")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.deletePrimaryCatalog(deletePrimaryCatalogOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("guid"), "d77fc432-9b1a-4938-a2a5-9f37e08041f6");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deletePrimaryCatalogPath);
  }
  
  public void testDeletePrimaryCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeletePrimaryCatalogWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testDeletePrimaryCatalogWOptions();

    // Disable retries and run testDeletePrimaryCatalogWOptions.
    dataVirtualizationService.disableRetries();
    testDeletePrimaryCatalogWOptions();
  }  

  // Test the deletePrimaryCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeletePrimaryCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.deletePrimaryCatalog(null).execute();
  }

  @Test
  public void testPublishAssetsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"duplicate_assets\": [{\"schema_name\": \"USER999\", \"table_name\": \"customer\"}], \"failed_assets\": [{\"error_msg\": \"37fa4a15-1071-4a20-bc9e-0283d3dfb6e\", \"schema_name\": \"USER999\", \"table_name\": \"customer\"}], \"published_assets\": [{\"schema_name\": \"USER999\", \"table_name\": \"customer\", \"wkc_asset_id\": \"37fa4a15-1071-4a20-bc9e-0283d3dfb6e1\"}]}";
    String publishAssetsPath = "/v2/integration/catalog/publish";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPrimaryCatalogParametersAssetsItem model
    PostPrimaryCatalogParametersAssetsItem postPrimaryCatalogParametersAssetsItemModel = new PostPrimaryCatalogParametersAssetsItem.Builder()
    .schema("db2inst1")
    .table("EMPLOYEE")
    .build();

    // Construct an instance of the PublishAssetsOptions model
    PublishAssetsOptions publishAssetsOptionsModel = new PublishAssetsOptions.Builder()
    .catalogId("2b6b9fc5-626c-47a9-a836-56b76c0bc826")
    .allowDuplicates(false)
    .assets(new java.util.ArrayList<PostPrimaryCatalogParametersAssetsItem>(java.util.Arrays.asList(postPrimaryCatalogParametersAssetsItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogPublishResponse> response = dataVirtualizationService.publishAssets(publishAssetsOptionsModel).execute();
    assertNotNull(response);
    CatalogPublishResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, publishAssetsPath);
  }
  
  public void testPublishAssetsWOptionsWRetries() throws Throwable {
    // Enable retries and run testPublishAssetsWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testPublishAssetsWOptions();

    // Disable retries and run testPublishAssetsWOptions.
    dataVirtualizationService.disableRetries();
    testPublishAssetsWOptions();
  }  

  // Test the publishAssets operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPublishAssetsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.publishAssets(null).execute();
  }

  @Test
  public void testGetCachesListWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"caches\": [{\"name\": \"name\", \"id\": \"id\", \"query\": \"query\", \"owner_id\": \"ownerId\", \"type\": \"type\", \"created_timestamp\": \"createdTimestamp\", \"last_modified_timestamp\": \"lastModifiedTimestamp\", \"last_refresh_timestamp\": \"lastRefreshTimestamp\", \"last_used_timestamp\": \"lastUsedTimestamp\", \"state\": \"state\", \"size\": 4, \"cardinality\": 11, \"time_taken_for_refresh\": 19, \"refresh_count\": 12, \"hit_count\": 8, \"refresh_schedule\": \"refreshSchedule\", \"refresh_schedule_desc\": \"refreshScheduleDesc\", \"status_msg\": \"statusMsg\"}]}";
    String getCachesListPath = "/v1/caching/caches";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCachesListOptions model
    GetCachesListOptions getCachesListOptionsModel = new GetCachesListOptions();

    // Invoke operation with valid options model (positive test)
    Response<CacheListResponse> response = dataVirtualizationService.getCachesList(getCachesListOptionsModel).execute();
    assertNotNull(response);
    CacheListResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCachesListPath);
  }
  
  public void testGetCachesListWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCachesListWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGetCachesListWOptions();

    // Disable retries and run testGetCachesListWOptions.
    dataVirtualizationService.disableRetries();
    testGetCachesListWOptions();
  }  

  @Test
  public void testGetCacheWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"id\": \"id\", \"query\": \"query\", \"owner_id\": \"ownerId\", \"type\": \"type\", \"created_timestamp\": \"createdTimestamp\", \"last_modified_timestamp\": \"lastModifiedTimestamp\", \"last_refresh_timestamp\": \"lastRefreshTimestamp\", \"last_used_timestamp\": \"lastUsedTimestamp\", \"state\": \"state\", \"size\": 4, \"cardinality\": 11, \"time_taken_for_refresh\": 19, \"refresh_count\": 12, \"hit_count\": 8, \"refresh_schedule\": \"refreshSchedule\", \"refresh_schedule_desc\": \"refreshScheduleDesc\", \"status_msg\": \"statusMsg\"}";
    String getCachePath = "/v1/caching/caches/DV20210810191252390327";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCacheOptions model
    GetCacheOptions getCacheOptionsModel = new GetCacheOptions.Builder()
    .id("DV20210810191252390327")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CacheResponse> response = dataVirtualizationService.getCache(getCacheOptionsModel).execute();
    assertNotNull(response);
    CacheResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCachePath);
  }
  
  public void testGetCacheWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCacheWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGetCacheWOptions();

    // Disable retries and run testGetCacheWOptions.
    dataVirtualizationService.disableRetries();
    testGetCacheWOptions();
  }  

  // Test the getCache operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCacheNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.getCache(null).execute();
  }

  @Test
  public void testGetCacheStorageDetailWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_size\": \"totalSize\", \"enabled\": {\"size\": 4, \"count\": 5}, \"disabled\": {\"size\": 4, \"count\": 5}}";
    String getCacheStorageDetailPath = "/v1/caching/storage";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCacheStorageDetailOptions model
    GetCacheStorageDetailOptions getCacheStorageDetailOptionsModel = new GetCacheStorageDetailOptions();

    // Invoke operation with valid options model (positive test)
    Response<StorageDetails> response = dataVirtualizationService.getCacheStorageDetail(getCacheStorageDetailOptionsModel).execute();
    assertNotNull(response);
    StorageDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCacheStorageDetailPath);
  }
  
  public void testGetCacheStorageDetailWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCacheStorageDetailWOptions.
    dataVirtualizationService.enableRetries(4, 30);
    testGetCacheStorageDetailWOptions();

    // Disable retries and run testGetCacheStorageDetailWOptions.
    dataVirtualizationService.disableRetries();
    testGetCacheStorageDetailWOptions();
  }  

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    dataVirtualizationService = null;
  }
}