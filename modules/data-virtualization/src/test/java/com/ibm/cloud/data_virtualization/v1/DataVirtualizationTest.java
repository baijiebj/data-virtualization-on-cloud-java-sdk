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
import com.ibm.cloud.data_virtualization.v1.model.GetDatasourceNodesOptions;
import com.ibm.cloud.data_virtualization.v1.model.GetObjectsForRoleOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantRolesToVirtualizedTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.GrantUserToObjectRequestBodyItem;
import com.ibm.cloud.data_virtualization.v1.model.ObjectsForRoleResponse;
import com.ibm.cloud.data_virtualization.v1.model.ObjectsForRoleResponseObjectsItem;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersV2Properties;
import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromObjectV2Options;
import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromObjectV2RequestBodyItem;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectRequestBodyItem;
import com.ibm.cloud.data_virtualization.v1.model.SuccessResponse;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2Options;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2RequestSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2RequestVirtualTableDefItem;
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
  public void testAddDatasourceConnectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addDatasourceConnectionPath = "/v2/datasource_connections";

    server.enqueue(new MockResponse()
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostDatasourceConnectionParametersV2Properties model
    PostDatasourceConnectionParametersV2Properties postDatasourceConnectionParametersV2PropertiesModel = new PostDatasourceConnectionParametersV2Properties.Builder()
    .accessToken("testString")
    .accountName("testString")
    .apiKey("testString")
    .authType("testString")
    .clientId("testString")
    .clientSecret("testString")
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
    .xProperties(postDatasourceConnectionParametersV2PropertiesModel)
    .assetCategory("testString")
    .remoteNodes("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.addDatasourceConnection(addDatasourceConnectionOptionsModel).execute();
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
    .setResponseCode(200)
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
    assertNull(query);

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
  public void testGetDatasourceNodesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"datasource_nodes_array\": [{\"node_name\": \"nodeName\", \"node_description\": \"nodeDescription\", \"agent_class\": \"agentClass\", \"hostname\": \"hostname\", \"port\": \"port\", \"os_user\": \"osUser\", \"is_docker\": \"isDocker\", \"dscount\": \"dscount\", \"data_sources\": [{\"cid\": \"cid\", \"dbname\": \"dbname\", \"srchostname\": \"srchostname\", \"srcport\": \"srcport\", \"srctype\": \"srctype\", \"usr\": \"usr\", \"uri\": \"uri\", \"status\": \"status\", \"connection_name\": \"connectionName\"}]}]}";
    String getDatasourceNodesPath = "/v2/datasource_nodes";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDatasourceNodesOptions model
    GetDatasourceNodesOptions getDatasourceNodesOptionsModel = new GetDatasourceNodesOptions();

    // Invoke operation with valid options model (positive test)
    Response<DatasourceNodesResponseV2> response = dataVirtualizationService.getDatasourceNodes(getDatasourceNodesOptionsModel).execute();
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
    assertEquals(parsedPath, getDatasourceNodesPath);
  }

  @Test
  public void testGrantUserToObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String grantUserToObjectPath = "/v2/privileges/users";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GrantUserToObjectRequestBodyItem model
    GrantUserToObjectRequestBodyItem grantUserToObjectRequestBodyItemModel = new GrantUserToObjectRequestBodyItem.Builder()
    .objectName("EMPLOYEE")
    .objectSchema("USER999")
    .authid("PUBLIC")
    .build();

    // Construct an instance of the GrantUserToObjectOptions model
    GrantUserToObjectOptions grantUserToObjectOptionsModel = new GrantUserToObjectOptions.Builder()
    .body(new java.util.ArrayList<GrantUserToObjectRequestBodyItem>(java.util.Arrays.asList(grantUserToObjectRequestBodyItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.grantUserToObject(grantUserToObjectOptionsModel).execute();
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
    assertEquals(parsedPath, grantUserToObjectPath);
  }

  // Test the grantUserToObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGrantUserToObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.grantUserToObject(null).execute();
  }

  @Test
  public void testRevokeUserFromObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String revokeUserFromObjectPath = "/v2/privileges/users";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RevokeUserFromObjectRequestBodyItem model
    RevokeUserFromObjectRequestBodyItem revokeUserFromObjectRequestBodyItemModel = new RevokeUserFromObjectRequestBodyItem.Builder()
    .objectName("EMPLOYEE")
    .objectSchema("USER999")
    .authid("PUBLIC")
    .build();

    // Construct an instance of the RevokeUserFromObjectOptions model
    RevokeUserFromObjectOptions revokeUserFromObjectOptionsModel = new RevokeUserFromObjectOptions.Builder()
    .body(new java.util.ArrayList<RevokeUserFromObjectRequestBodyItem>(java.util.Arrays.asList(revokeUserFromObjectRequestBodyItemModel)))
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
    assertNull(query);

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
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GrantRolesToVirtualizedTableOptions model
    GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptionsModel = new GrantRolesToVirtualizedTableOptions.Builder()
    .authid("PUBLIC")
    .objectName("EMPLOYEE")
    .objectSchema("USER999")
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
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("authid"), "PUBLIC");
    assertEquals(query.get("object_name"), "EMPLOYEE");
    assertEquals(query.get("object_schema"), "USER999");
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
  public void testRevokeRoleFromObjectV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String revokeRoleFromObjectV2Path = "/v2/privileges/roles";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RevokeRoleFromObjectV2RequestBodyItem model
    RevokeRoleFromObjectV2RequestBodyItem revokeRoleFromObjectV2RequestBodyItemModel = new RevokeRoleFromObjectV2RequestBodyItem.Builder()
    .objectName("EMPLOYEE")
    .objectSchema("USER999")
    .roleToRevoke("DV_ENGINEER")
    .build();

    // Construct an instance of the RevokeRoleFromObjectV2Options model
    RevokeRoleFromObjectV2Options revokeRoleFromObjectV2OptionsModel = new RevokeRoleFromObjectV2Options.Builder()
    .body(new java.util.ArrayList<RevokeRoleFromObjectV2RequestBodyItem>(java.util.Arrays.asList(revokeRoleFromObjectV2RequestBodyItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = dataVirtualizationService.revokeRoleFromObjectV2(revokeRoleFromObjectV2OptionsModel).execute();
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
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, revokeRoleFromObjectV2Path);
  }

  @Test
  public void testGetObjectsForRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"objects\": [{\"object_name\": \"objectName\", \"object_schema\": \"objectSchema\", \"object_type\": \"objectType\"}]}";
    String getObjectsForRolePath = "/v1/privileges/objects/role/User";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectsForRoleOptions model
    GetObjectsForRoleOptions getObjectsForRoleOptionsModel = new GetObjectsForRoleOptions.Builder()
    .rolename("User")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectsForRoleResponse> response = dataVirtualizationService.getObjectsForRole(getObjectsForRoleOptionsModel).execute();
    assertNotNull(response);
    ObjectsForRoleResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getObjectsForRolePath);
  }

  // Test the getObjectsForRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetObjectsForRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    dataVirtualizationService.getObjectsForRole(null).execute();
  }

  @Test
  public void testVirtualizeTableV2WOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"message\": \"message\"}";
    String virtualizeTableV2Path = "/v2/virtualize/tables";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the VirtualizeTableV2RequestSourceTableDefItem model
    VirtualizeTableV2RequestSourceTableDefItem virtualizeTableV2RequestSourceTableDefItemModel = new VirtualizeTableV2RequestSourceTableDefItem.Builder()
    .columnName("Column1")
    .columnType("INTEGER")
    .build();

    // Construct an instance of the VirtualizeTableV2RequestVirtualTableDefItem model
    VirtualizeTableV2RequestVirtualTableDefItem virtualizeTableV2RequestVirtualTableDefItemModel = new VirtualizeTableV2RequestVirtualTableDefItem.Builder()
    .columnName("Column_1")
    .columnType("INTEGER")
    .build();

    // Construct an instance of the VirtualizeTableV2Options model
    VirtualizeTableV2Options virtualizeTableV2OptionsModel = new VirtualizeTableV2Options.Builder()
    .sourceName("Tab1")
    .sourceTableDef(new java.util.ArrayList<VirtualizeTableV2RequestSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableV2RequestSourceTableDefItemModel)))
    .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")))
    .virtualName("Tab1")
    .virtualSchema("USER999")
    .virtualTableDef(new java.util.ArrayList<VirtualizeTableV2RequestVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableV2RequestVirtualTableDefItemModel)))
    .isIncludedColumns("Y, Y, N")
    .replace(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SuccessResponse> response = dataVirtualizationService.virtualizeTableV2(virtualizeTableV2OptionsModel).execute();
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
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTableOptions model
    DeleteTableOptions deleteTableOptionsModel = new DeleteTableOptions.Builder()
    .schemaName("testString")
    .objectName("testString")
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