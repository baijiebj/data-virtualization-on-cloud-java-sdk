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
    assertEquals(postDatasourceConnectionParametersPropertiesModel.accessToken(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.accountName(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.apiKey(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.authType(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.clientId(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.clientSecret(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.collection(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.credentials(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.database(), "TPCDS");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.host(), "192.168.0.1");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.httpPath(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.jarUris(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.jdbcDriver(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.jdbcUrl(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.password(), "password");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.port(), "50000");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.projectId(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.xProperties(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.refreshToken(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.role(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sapGatewayUrl(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.server(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.serviceName(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sid(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.ssl(), "false");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sslCertificate(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sslCertificateHost(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.sslCertificateValidation(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.username(), "db2inst1");
    assertEquals(postDatasourceConnectionParametersPropertiesModel.warehouse(), "testString");

    String json = TestUtilities.serialize(postDatasourceConnectionParametersPropertiesModel);

    PostDatasourceConnectionParametersProperties postDatasourceConnectionParametersPropertiesModelNew = TestUtilities.deserialize(json, PostDatasourceConnectionParametersProperties.class);
    assertTrue(postDatasourceConnectionParametersPropertiesModelNew instanceof PostDatasourceConnectionParametersProperties);
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.accessToken(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.accountName(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.apiKey(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.authType(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.clientId(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.clientSecret(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.collection(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.credentials(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.database(), "TPCDS");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.host(), "192.168.0.1");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.httpPath(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.jarUris(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.jdbcDriver(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.jdbcUrl(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.password(), "password");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.port(), "50000");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.projectId(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.xProperties(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.refreshToken(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.role(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sapGatewayUrl(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.server(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.serviceName(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sid(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.ssl(), "false");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sslCertificate(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sslCertificateHost(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.sslCertificateValidation(), "testString");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.username(), "db2inst1");
    assertEquals(postDatasourceConnectionParametersPropertiesModelNew.warehouse(), "testString");
  }
}