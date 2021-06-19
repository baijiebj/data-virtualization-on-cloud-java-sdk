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

    service = DataVirtualization.newInstance();
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
  public void testListDatasourceConnections() throws Exception {
    try {
      ListDatasourceConnectionsOptions listDatasourceConnectionsOptions = new ListDatasourceConnectionsOptions();

      // Invoke operation
      Response<DatasourceConnectionsList> response = service.listDatasourceConnections(listDatasourceConnectionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DatasourceConnectionsList datasourceConnectionsListResult = response.getResult();

      assertNotNull(datasourceConnectionsListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
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

      AddDatasourceConnectionOptions addDatasourceConnectionOptions = new AddDatasourceConnectionOptions.Builder()
      .datasourceType("DB2")
      .name("DB2")
      .originCountry("us")
      .xProperties(postDatasourceConnectionParametersPropertiesModel)
      .assetCategory("testString")
      .build();

      // Invoke operation
      Response<PostDatasourceConnection> response = service.addDatasourceConnection(addDatasourceConnectionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PostDatasourceConnection postDatasourceConnectionResult = response.getResult();

      assertNotNull(postDatasourceConnectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGrantUserToVirtualTable() throws Exception {
    try {
      GrantUserToVirtualTableOptions grantUserToVirtualTableOptions = new GrantUserToVirtualTableOptions.Builder()
      .tableName("EMPLOYEE")
      .tableSchema("dv_ibmid_060000s4y5")
      .authid("PUBLIC")
      .build();

      // Invoke operation
      Response<Void> response = service.grantUserToVirtualTable(grantUserToVirtualTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGrantRolesToVirtualizedTable() throws Exception {
    try {
      GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptions = new GrantRolesToVirtualizedTableOptions.Builder()
      .tableName("EMPLOYEE")
      .tableSchema("dv_ibmid_060000s4y5")
      .roleName("PUBLIC")
      .build();

      // Invoke operation
      Response<Void> response = service.grantRolesToVirtualizedTable(grantRolesToVirtualizedTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListTablesForRole() throws Exception {
    try {
      ListTablesForRoleOptions listTablesForRoleOptions = new ListTablesForRoleOptions.Builder()
      .rolename("MANAGER | STEWARD | ENGINEER | USER")
      .build();

      // Invoke operation
      Response<TablesForRoleResponse> response = service.listTablesForRole(listTablesForRoleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TablesForRoleResponse tablesForRoleResponseResult = response.getResult();

      assertNotNull(tablesForRoleResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testTurnOnPolicyV2() throws Exception {
    try {
      TurnOnPolicyV2Options turnOnPolicyV2Options = new TurnOnPolicyV2Options.Builder()
      .status("enabled")
      .build();

      // Invoke operation
      Response<TurnOnPolicyV2Response> response = service.turnOnPolicyV2(turnOnPolicyV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TurnOnPolicyV2Response turnOnPolicyV2ResponseResult = response.getResult();

      assertNotNull(turnOnPolicyV2ResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCheckPolicyStatusV2() throws Exception {
    try {
      CheckPolicyStatusV2Options checkPolicyStatusV2Options = new CheckPolicyStatusV2Options();

      // Invoke operation
      Response<CheckPolicyStatusV2Response> response = service.checkPolicyStatusV2(checkPolicyStatusV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CheckPolicyStatusV2Response checkPolicyStatusV2ResponseResult = response.getResult();

      assertNotNull(checkPolicyStatusV2ResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDvaasVirtualizeTable() throws Exception {
    try {
      VirtualizeTableParameterSourceTableDefItem virtualizeTableParameterSourceTableDefItemModel = new VirtualizeTableParameterSourceTableDefItem.Builder()
      .columnName("Column1")
      .columnType("INTEGER")
      .build();

      VirtualizeTableParameterVirtualTableDefItem virtualizeTableParameterVirtualTableDefItemModel = new VirtualizeTableParameterVirtualTableDefItem.Builder()
      .columnName("Column_1")
      .columnType("INTEGER")
      .build();

      DvaasVirtualizeTableOptions dvaasVirtualizeTableOptions = new DvaasVirtualizeTableOptions.Builder()
      .sourceName("Tab1")
      .sourceTableDef(new java.util.ArrayList<VirtualizeTableParameterSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterSourceTableDefItemModel)))
      .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")))
      .virtualName("Tab1")
      .virtualSchema("dv_ibmid_060000s4y5")
      .virtualTableDef(new java.util.ArrayList<VirtualizeTableParameterVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterVirtualTableDefItemModel)))
      .isIncludedColumns("Y, Y, N")
      .replace(false)
      .build();

      // Invoke operation
      Response<VirtualizeTableResponse> response = service.dvaasVirtualizeTable(dvaasVirtualizeTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      VirtualizeTableResponse virtualizeTableResponseResult = response.getResult();

      assertNotNull(virtualizeTableResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetPrimaryCatalog() throws Exception {
    try {
      GetPrimaryCatalogOptions getPrimaryCatalogOptions = new GetPrimaryCatalogOptions();

      // Invoke operation
      Response<PrimaryCatalogInfo> response = service.getPrimaryCatalog(getPrimaryCatalogOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PrimaryCatalogInfo primaryCatalogInfoResult = response.getResult();

      assertNotNull(primaryCatalogInfoResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testPostPrimaryCatalog() throws Exception {
    try {
      PostPrimaryCatalogOptions postPrimaryCatalogOptions = new PostPrimaryCatalogOptions.Builder()
      .guid("d77fc432-9b1a-4938-a2a5-9f37e08041f6")
      .build();

      // Invoke operation
      Response<PostPrimaryCatalog> response = service.postPrimaryCatalog(postPrimaryCatalogOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PostPrimaryCatalog postPrimaryCatalogResult = response.getResult();

      assertNotNull(postPrimaryCatalogResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testPublishAssets() throws Exception {
    try {
      PostPrimaryCatalogParametersAssetsItem postPrimaryCatalogParametersAssetsItemModel = new PostPrimaryCatalogParametersAssetsItem.Builder()
      .schema("db2inst1")
      .table("EMPLOYEE")
      .build();

      PublishAssetsOptions publishAssetsOptions = new PublishAssetsOptions.Builder()
      .catalogId("2b6b9fc5-626c-47a9-a836-56b76c0bc826")
      .allowDuplicates(false)
      .assets(new java.util.ArrayList<PostPrimaryCatalogParametersAssetsItem>(java.util.Arrays.asList(postPrimaryCatalogParametersAssetsItemModel)))
      .build();

      // Invoke operation
      Response<CatalogPublishResponse> response = service.publishAssets(publishAssetsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CatalogPublishResponse catalogPublishResponseResult = response.getResult();

      assertNotNull(catalogPublishResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testRevokeUserFromObject() throws Exception {
    try {
      RevokeUserFromObjectOptions revokeUserFromObjectOptions = new RevokeUserFromObjectOptions.Builder()
      .authid("PUBLIC")
      .tableName("EMPLOYEE")
      .tableSchema("dv_ibmid_060000s4y5")
      .build();

      // Invoke operation
      Response<Void> response = service.revokeUserFromObject(revokeUserFromObjectOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDvaasRevokeRoleFromTable() throws Exception {
    try {
      DvaasRevokeRoleFromTableOptions dvaasRevokeRoleFromTableOptions = new DvaasRevokeRoleFromTableOptions.Builder()
      .roleName("DV_ENGINEER")
      .tableName("EMPLOYEE")
      .tableSchema("dv_ibmid_060000s4y5")
      .build();

      // Invoke operation
      Response<Void> response = service.dvaasRevokeRoleFromTable(dvaasRevokeRoleFromTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTable() throws Exception {
    try {
      DeleteTableOptions deleteTableOptions = new DeleteTableOptions.Builder()
      .virtualSchema("testString")
      .virtualName("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteTable(deleteTableOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeletePrimaryCatalog() throws Exception {
    try {
      DeletePrimaryCatalogOptions deletePrimaryCatalogOptions = new DeletePrimaryCatalogOptions.Builder()
      .guid("d77fc432-9b1a-4938-a2a5-9f37e08041f6")
      .build();

      // Invoke operation
      Response<Void> response = service.deletePrimaryCatalog(deletePrimaryCatalogOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteDatasourceConnection() throws Exception {
    try {
      DeleteDatasourceConnectionOptions deleteDatasourceConnectionOptions = new DeleteDatasourceConnectionOptions.Builder()
      .connectionId("75e4d01b-7417-4abc-b267-8ffb393fb970")
      .cid("DB210013")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteDatasourceConnection(deleteDatasourceConnectionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
