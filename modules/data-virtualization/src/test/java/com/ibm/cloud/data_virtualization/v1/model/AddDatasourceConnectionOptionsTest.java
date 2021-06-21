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

package com.ibm.cloud.data_virtualization.v1.model;

import com.ibm.cloud.data_virtualization.v1.model.AddDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersProperties;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddDatasourceConnectionOptions model.
 */
public class AddDatasourceConnectionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddDatasourceConnectionOptions() throws Throwable {
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
    assertEquals(postDatasourceConnectionParametersPropertiesModel.accessToken(), "ya29.Il-_");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.accountName(), "ibmdatastage.us-east-1");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.apiKey(), "ApiKey-a31d60c5-0f7b-4995-a4ae-69bf09d3de50");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.authType(), "Bearer Token");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.clientId(), "81571342315");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.clientSecret(), "uIn8rVyIRsd");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.collection(), "test_collection");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.credentials(), "-----BEGIN PRIVATE KEY-----");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.database(), "TPCDS");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.host(), "192.168.0.1");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.httpPath(), "cliservice");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.jarUris(), "/v2/asset_files/dbdrivers/ngdbc.jar");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.jdbcDriver(), "Snowflake");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.jdbcUrl(), "/v2/asset_files/dbdrivers/ngdbc.jar");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.password(), "password");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.port(), "50000");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.projectId(), "housecanary-com");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.xProperties(), "key=value");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.refreshToken(), "1//06uwhP7_312g");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.role(), "SYSADMIN");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sapGatewayUrl(), "https://sapes5.sapdevcenter.com");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.server(), "ol_informix1410");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.serviceName(), "pdborcl.fyre.ibm.com");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sid(), "orcl");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.ssl(), "false");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sslCertificate(), "-----BEGIN CERTIFICATE-----");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sslCertificateHost(), "test.com");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sslCertificateValidation(), "false");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.username(), "db2inst1");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.warehouse(), "wdpcondev");

    AddDatasourceConnectionOptions addDatasourceConnectionOptionsModel = new AddDatasourceConnectionOptions.Builder()
      .datasourceType("DB2")
      .name("DB2")
      .originCountry("us")
      .xProperties(postDatasourceConnectionParametersPropertiesModel)
      .assetCategory("USER")
      .build();
    assertEquals(addDatasourceConnectionOptionsModel.datasourceType(), "DB2");
    assertEquals(addDatasourceConnectionOptionsModel.name(), "DB2");
    assertEquals(addDatasourceConnectionOptionsModel.originCountry(), "us");
    assertEquals(addDatasourceConnectionOptionsModel.xProperties(), postDatasourceConnectionParametersPropertiesModel);
    assertEquals(addDatasourceConnectionOptionsModel.assetCategory(), "USER");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddDatasourceConnectionOptionsError() throws Throwable {
    new AddDatasourceConnectionOptions.Builder().build();
  }

}