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

import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersProperties;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostDatasourceConnectionParametersProperties model.
 */
public class PostDatasourceConnectionParametersPropertiesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostDatasourceConnectionParametersProperties() throws Throwable {
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

    String json = TestUtilities.serialize(postDatasourceConnectionParametersPropertiesModel);

    PostDatasourceConnectionParametersProperties postDatasourceConnectionParametersPropertiesModelNew = TestUtilities.deserialize(json, PostDatasourceConnectionParametersProperties.class);
    assertTrue(postDatasourceConnectionParametersPropertiesModelNew instanceof PostDatasourceConnectionParametersProperties);
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.accessToken(), "ya29.Il-_");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.accountName(), "ibmdatastage.us-east-1");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.apiKey(), "ApiKey-a31d60c5-0f7b-4995-a4ae-69bf09d3de50");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.authType(), "Bearer Token");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.clientId(), "81571342315");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.clientSecret(), "uIn8rVyIRsd");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.collection(), "test_collection");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.credentials(), "-----BEGIN PRIVATE KEY-----");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.database(), "TPCDS");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.host(), "192.168.0.1");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.httpPath(), "cliservice");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.jarUris(), "/v2/asset_files/dbdrivers/ngdbc.jar");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.jdbcDriver(), "Snowflake");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.jdbcUrl(), "/v2/asset_files/dbdrivers/ngdbc.jar");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.password(), "password");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.port(), "50000");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.projectId(), "housecanary-com");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.xProperties(), "key=value");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.refreshToken(), "1//06uwhP7_312g");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.role(), "SYSADMIN");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sapGatewayUrl(), "https://sapes5.sapdevcenter.com");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.server(), "ol_informix1410");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.serviceName(), "pdborcl.fyre.ibm.com");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sid(), "orcl");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.ssl(), "false");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sslCertificate(), "-----BEGIN CERTIFICATE-----");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sslCertificateHost(), "test.com");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sslCertificateValidation(), "false");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.username(), "db2inst1");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.warehouse(), "wdpcondev");
  }
}