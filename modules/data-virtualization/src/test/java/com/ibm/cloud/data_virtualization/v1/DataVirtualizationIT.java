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
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.test.SdkIntegrationTestBase;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the DataVirtualization service.
 */
public class DataVirtualizationIT extends SdkIntegrationTestBase {
  public DataVirtualization service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../data_virtualization_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = new DataVirtualization();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(DataVirtualization.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetDatasourceConnections() throws Exception {
    try {
      GetDatasourceConnectionsOptions getDatasourceConnectionsOptions = new GetDatasourceConnectionsOptions();

      // Invoke operation
      Response<DatasourceNodesResponseV2> response = service.getDatasourceConnections(getDatasourceConnectionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DatasourceNodesResponseV2 datasourceNodesResponseV2Result = response.getResult();

      assertNotNull(datasourceNodesResponseV2Result);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testAddDatasourceConnection() throws Exception {
    try {
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

      AddDatasourceConnectionOptions addDatasourceConnectionOptions = new AddDatasourceConnectionOptions.Builder()
      .datasourceType("testString")
      .name("testString")
      .originCountry("testString")
      .xProperties(postDatasourceConnectionParametersPropertiesModel)
      .assetCategory("testString")
      .build();

      // Invoke operation
      Response<PostDatasourceConnectionResponse> response = service.addDatasourceConnection(addDatasourceConnectionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PostDatasourceConnectionResponse postDatasourceConnectionResponseResult = response.getResult();

      assertNotNull(postDatasourceConnectionResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGrantUserToVirtualTable() throws Exception {
    try {
      PostUserPrivilegesParametersBodyItem postUserPrivilegesParametersBodyItemModel = new PostUserPrivilegesParametersBodyItem.Builder()
      .tableName("EMPLOYEE")
      .tableSchema("USER999")
      .authid("PUBLIC")
      .build();

      GrantUserToVirtualTableOptions grantUserToVirtualTableOptions = new GrantUserToVirtualTableOptions.Builder()
      .body(new java.util.ArrayList<PostUserPrivilegesParametersBodyItem>(java.util.Arrays.asList(postUserPrivilegesParametersBodyItemModel)))
      .build();

      // Invoke operation
      Response<Void> response = service.grantUserToVirtualTable(grantUserToVirtualTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGrantRolesToVirtualizedTable() throws Exception {
    try {
      PostRolePrivilegesParametersBodyItem postRolePrivilegesParametersBodyItemModel = new PostRolePrivilegesParametersBodyItem.Builder()
      .tableName("EMPLOYEE")
      .tableSchema("USER999")
      .roleToGrant("PUBLIC")
      .build();

      GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptions = new GrantRolesToVirtualizedTableOptions.Builder()
      .body(new java.util.ArrayList<PostRolePrivilegesParametersBodyItem>(java.util.Arrays.asList(postRolePrivilegesParametersBodyItemModel)))
      .build();

      // Invoke operation
      Response<Void> response = service.grantRolesToVirtualizedTable(grantRolesToVirtualizedTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTablesForRole() throws Exception {
    try {
      GetTablesForRoleOptions getTablesForRoleOptions = new GetTablesForRoleOptions.Builder()
      .rolename("ADMIN | STEWARD | ENGINEER | USER")
      .build();

      // Invoke operation
      Response<TablesForRoleResponse> response = service.getTablesForRole(getTablesForRoleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TablesForRoleResponse tablesForRoleResponseResult = response.getResult();

      assertNotNull(tablesForRoleResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testVirtualizeTableV2() throws Exception {
    try {
      VirtualizeTableParameterSourceTableDefItem virtualizeTableParameterSourceTableDefItemModel = new VirtualizeTableParameterSourceTableDefItem.Builder()
      .columnName("Column1")
      .columnType("INTEGER")
      .build();

      VirtualizeTableParameterVirtualTableDefItem virtualizeTableParameterVirtualTableDefItemModel = new VirtualizeTableParameterVirtualTableDefItem.Builder()
      .columnName("Column_1")
      .columnType("INTEGER")
      .build();

      VirtualizeTableV2Options virtualizeTableV2Options = new VirtualizeTableV2Options.Builder()
      .sourceName("Tab1")
      .sourceTableDef(new java.util.ArrayList<VirtualizeTableParameterSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterSourceTableDefItemModel)))
      .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")))
      .virtualName("Tab1")
      .virtualSchema("USER999")
      .virtualTableDef(new java.util.ArrayList<VirtualizeTableParameterVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterVirtualTableDefItemModel)))
      .isIncludedColumns("Y, Y, N")
      .replace(false)
      .build();

      // Invoke operation
      Response<VirtualizeTableResponse> response = service.virtualizeTableV2(virtualizeTableV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      VirtualizeTableResponse virtualizeTableResponseResult = response.getResult();

      assertNotNull(virtualizeTableResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testRevokeUserFromObject() throws Exception {
    try {
      RevokeUserFromObjectOptions revokeUserFromObjectOptions = new RevokeUserFromObjectOptions.Builder()
      .authid("PUBLIC")
      .tableName("EMPLOYEE")
      .tableSchema("USER999")
      .build();

      // Invoke operation
      Response<Void> response = service.revokeUserFromObject(revokeUserFromObjectOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testRevokeRoleFromTableV2() throws Exception {
    try {
      RevokeRoleFromTableV2Options revokeRoleFromTableV2Options = new RevokeRoleFromTableV2Options.Builder()
      .roleToRevoke("DV_ENGINEER")
      .tableName("EMPLOYEE")
      .tableSchema("USER999")
      .build();

      // Invoke operation
      Response<Void> response = service.revokeRoleFromTableV2(revokeRoleFromTableV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTable() throws Exception {
    try {
      DeleteTableOptions deleteTableOptions = new DeleteTableOptions.Builder()
      .schemaName("testString")
      .tableName("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteTable(deleteTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteDatasourceConnection() throws Exception {
    try {
      DeleteDatasourceConnectionOptions deleteDatasourceConnectionOptions = new DeleteDatasourceConnectionOptions.Builder()
      .cid("DB210013")
      .connectionId("75e4d01b-7417-4abc-b267-8ffb393fb970")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteDatasourceConnection(deleteDatasourceConnectionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
