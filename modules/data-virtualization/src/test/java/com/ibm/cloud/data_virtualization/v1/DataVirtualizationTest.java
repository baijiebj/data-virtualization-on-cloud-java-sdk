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
import com.ibm.cloud.data_virtualization.v1.model.GetPrimaryCatalogOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantRolesToVirtualizedTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToVirtualTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.ListDatasourceConnectionsOptions;
import com.ibm.cloud.data_virtualization.v1.model.ListTablesForRoleOptions;
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
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponse;
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponseObjectsItem;
import com.ibm.cloud.data_virtualization.v1.model.TurnOnPolicyV2Options;
import com.ibm.cloud.data_virtualization.v1.model.TurnOnPolicyV2Response;
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
    .accessToken("testString")
    .accountName("testString")
    .apiKey("testString")
    .authType("testString")
    .clientId("testString")
    .clientSecret("testString")
    .collection("testString")
    .credentials("testString")
    .database("TPCDS")
    .host("192.168.0.1")
    .httpPath("testString")
    .jarUris("testString")
    .jdbcDriver("testString")
    .jdbcUrl("testString")
    .password("password")
    .port("50000")
    .projectId("testString")
    .xProperties("testString")
    .refreshToken("testString")
    .role("testString")
    .sapGatewayUrl("testString")
    .server("testString")
    .serviceName("testString")
    .sid("testString")
    .ssl("false")
    .sslCertificate("testString")
    .sslCertificateHost("testString")
    .sslCertificateValidation("testString")
    .username("db2inst1")
    .warehouse("testString")
    .build();

    // Construct an instance of the AddDatasourceConnectionOptions model
    AddDatasourceConnectionOptions addDatasourceConnectionOptionsModel = new AddDatasourceConnectionOptions.Builder()
    .datasourceType("DB2")
    .name("DB2")
    .originCountry("us")
    .xProperties(postDatasourceConnectionParametersPropertiesModel)
    .assetCategory("testString")
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
    .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")))
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

  // Test the publishAssets operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPublishAssetsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.publishAssets(null).execute();
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