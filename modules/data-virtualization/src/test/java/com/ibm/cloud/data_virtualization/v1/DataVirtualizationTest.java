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
import com.ibm.cloud.data_virtualization.v1.model.DatasourceNodesResponseV2;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceNodesResponseV2DatasourceNodesArrayItem;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceNodesResponseV2DatasourceNodesArrayItemDataSourcesItem;
import com.ibm.cloud.data_virtualization.v1.model.DeleteDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.DeleteTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetDatasourceConnectionsOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetTablesForRoleOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantRolesToVirtualizedTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToVirtualTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersProperties;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionResponse;
import com.ibm.cloud.data_virtualization.v1.model.PostRolePrivilegesParametersBodyItem;
import com.ibm.cloud.data_virtualization.v1.model.PostUserPrivilegesParametersBodyItem;
import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromTableV2Options;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponse;
import com.ibm.cloud.data_virtualization.v1.model.TablesForRoleResponseObjectsItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterVirtualTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableResponse;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2Options;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DataVirtualization service.
 */
public class DataVirtualizationTest  {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected DataVirtualization dataVirtualizationService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";

    final Authenticator authenticator = new NoAuthAuthenticator();

    dataVirtualizationService = new DataVirtualization(serviceName, authenticator);
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
  public void testGetDatasourceConnectionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"datasource_nodes_array\": [{\"node_name\": \"nodeName\", \"node_description\": \"nodeDescription\", \"agent_class\": \"agentClass\", \"hostname\": \"hostname\", \"port\": \"port\", \"os_user\": \"osUser\", \"is_docker\": \"isDocker\", \"dscount\": \"dscount\", \"data_sources\": [{\"cid\": \"cid\", \"dbname\": \"dbname\", \"srchostname\": \"srchostname\", \"srcport\": \"srcport\", \"srctype\": \"srctype\", \"usr\": \"usr\", \"uri\": \"uri\", \"status\": \"status\", \"connection_name\": \"connectionName\"}]}]}";
    String getDatasourceConnectionsPath = "/v2/datasource_connections";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDatasourceConnectionsOptions model
    GetDatasourceConnectionsOptions getDatasourceConnectionsOptionsModel = new GetDatasourceConnectionsOptions();

    // Invoke operation with valid options model (positive test)
    Response<DatasourceNodesResponseV2> response = dataVirtualizationService.getDatasourceConnections(getDatasourceConnectionsOptionsModel).execute();
    assertNotNull(response);
    DatasourceNodesResponseV2 responseObj = response.getResult();
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
    assertEquals(parsedPath, getDatasourceConnectionsPath);
  }

  @Test
  public void testAddDatasourceConnectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"datasource_type\": \"datasourceType\", \"name\": \"name\"}";
    String addDatasourceConnectionPath = "/v2/datasource_connections";

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
    .database("testString")
    .host("testString")
    .httpPath("testString")
    .jarUris("testString")
    .jdbcDriver("testString")
    .jdbcUrl("testString")
    .password("testString")
    .port("testString")
    .projectId("testString")
    .xProperties("testString")
    .refreshToken("testString")
    .role("testString")
    .sapGatewayUrl("testString")
    .server("testString")
    .serviceName("testString")
    .sid("testString")
    .ssl("testString")
    .sslCertificate("testString")
    .sslCertificateHost("testString")
    .sslCertificateValidation("testString")
    .username("testString")
    .warehouse("testString")
    .build();

    // Construct an instance of the AddDatasourceConnectionOptions model
    AddDatasourceConnectionOptions addDatasourceConnectionOptionsModel = new AddDatasourceConnectionOptions.Builder()
    .datasourceType("testString")
    .name("testString")
    .originCountry("testString")
    .xProperties(postDatasourceConnectionParametersPropertiesModel)
    .assetCategory("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PostDatasourceConnectionResponse> response = dataVirtualizationService.addDatasourceConnection(addDatasourceConnectionOptionsModel).execute();
    assertNotNull(response);
    PostDatasourceConnectionResponse responseObj = response.getResult();
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
    String deleteDatasourceConnectionPath = "/v2/datasource_connections";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDatasourceConnectionOptions model
    DeleteDatasourceConnectionOptions deleteDatasourceConnectionOptionsModel = new DeleteDatasourceConnectionOptions.Builder()
    .cid("DB210013")
    .connectionId("75e4d01b-7417-4abc-b267-8ffb393fb970")
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
    assertEquals(query.get("connection_id"), "75e4d01b-7417-4abc-b267-8ffb393fb970");
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

    // Construct an instance of the PostUserPrivilegesParametersBodyItem model
    PostUserPrivilegesParametersBodyItem postUserPrivilegesParametersBodyItemModel = new PostUserPrivilegesParametersBodyItem.Builder()
    .tableName("EMPLOYEE")
    .tableSchema("USER999")
    .authid("PUBLIC")
    .build();

    // Construct an instance of the GrantUserToVirtualTableOptions model
    GrantUserToVirtualTableOptions grantUserToVirtualTableOptionsModel = new GrantUserToVirtualTableOptions.Builder()
    .body(new java.util.ArrayList<PostUserPrivilegesParametersBodyItem>(java.util.Arrays.asList(postUserPrivilegesParametersBodyItemModel)))
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

  @Test
  public void testRevokeUserFromObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String revokeUserFromObjectPath = "/v2/privileges/users";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RevokeUserFromObjectOptions model
    RevokeUserFromObjectOptions revokeUserFromObjectOptionsModel = new RevokeUserFromObjectOptions.Builder()
    .authid("PUBLIC")
    .tableName("EMPLOYEE")
    .tableSchema("USER999")
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
    assertEquals(query.get("authid"), "PUBLIC");
    assertEquals(query.get("table_name"), "EMPLOYEE");
    assertEquals(query.get("table_schema"), "USER999");
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

    // Construct an instance of the PostRolePrivilegesParametersBodyItem model
    PostRolePrivilegesParametersBodyItem postRolePrivilegesParametersBodyItemModel = new PostRolePrivilegesParametersBodyItem.Builder()
    .tableName("EMPLOYEE")
    .tableSchema("USER999")
    .roleToGrant("PUBLIC")
    .build();

    // Construct an instance of the GrantRolesToVirtualizedTableOptions model
    GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptionsModel = new GrantRolesToVirtualizedTableOptions.Builder()
    .body(new java.util.ArrayList<PostRolePrivilegesParametersBodyItem>(java.util.Arrays.asList(postRolePrivilegesParametersBodyItemModel)))
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

  @Test
  public void testRevokeRoleFromTableV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String revokeRoleFromTableV2Path = "/v2/privileges/roles";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RevokeRoleFromTableV2Options model
    RevokeRoleFromTableV2Options revokeRoleFromTableV2OptionsModel = new RevokeRoleFromTableV2Options.Builder()
    .roleToRevoke("DV_ENGINEER")
    .tableName("EMPLOYEE")
    .tableSchema("USER999")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.revokeRoleFromTableV2(revokeRoleFromTableV2OptionsModel).execute();
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
    assertEquals(query.get("role_to_revoke"), "DV_ENGINEER");
    assertEquals(query.get("table_name"), "EMPLOYEE");
    assertEquals(query.get("table_schema"), "USER999");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, revokeRoleFromTableV2Path);
  }

  // Test the revokeRoleFromTableV2 operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRevokeRoleFromTableV2NoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.revokeRoleFromTableV2(null).execute();
  }

  @Test
  public void testGetTablesForRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"objects\": [{\"table_name\": \"tableName\", \"table_schema\": \"tableSchema\"}]}";
    String getTablesForRolePath = "/v2/privileges/tables/role/ADMIN%20%7C%20STEWARD%20%7C%20ENGINEER%20%7C%20USER";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTablesForRoleOptions model
    GetTablesForRoleOptions getTablesForRoleOptionsModel = new GetTablesForRoleOptions.Builder()
    .rolename("ADMIN | STEWARD | ENGINEER | USER")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TablesForRoleResponse> response = dataVirtualizationService.getTablesForRole(getTablesForRoleOptionsModel).execute();
    assertNotNull(response);
    TablesForRoleResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getTablesForRolePath);
  }

  // Test the getTablesForRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTablesForRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.getTablesForRole(null).execute();
  }

  @Test
  public void testVirtualizeTableV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"source_name\": \"Tab1\", \"virtual_name\": \"Tab1\", \"virtual_schema\": \"USER999\"}";
    String virtualizeTableV2Path = "/v2/virtualize/tables";

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

    // Construct an instance of the VirtualizeTableV2Options model
    VirtualizeTableV2Options virtualizeTableV2OptionsModel = new VirtualizeTableV2Options.Builder()
    .sourceName("Tab1")
    .sourceTableDef(new java.util.ArrayList<VirtualizeTableParameterSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterSourceTableDefItemModel)))
    .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")))
    .virtualName("Tab1")
    .virtualSchema("USER999")
    .virtualTableDef(new java.util.ArrayList<VirtualizeTableParameterVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterVirtualTableDefItemModel)))
    .isIncludedColumns("Y, Y, N")
    .replace(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<VirtualizeTableResponse> response = dataVirtualizationService.virtualizeTableV2(virtualizeTableV2OptionsModel).execute();
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
    assertEquals(parsedPath, virtualizeTableV2Path);
  }

  // Test the virtualizeTableV2 operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeTableV2NoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.virtualizeTableV2(null).execute();
  }

  @Test
  public void testDeleteTableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteTablePath = "/v2/mydata/tables/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTableOptions model
    DeleteTableOptions deleteTableOptionsModel = new DeleteTableOptions.Builder()
    .schemaName("testString")
    .tableName("testString")
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
    assertEquals(query.get("schema_name"), "testString");
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