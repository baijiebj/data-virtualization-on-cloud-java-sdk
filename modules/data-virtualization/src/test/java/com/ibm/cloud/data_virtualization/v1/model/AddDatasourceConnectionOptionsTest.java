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
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersV2Properties;
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
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.accessToken(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.accountName(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.apiKey(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.authType(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.clientId(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.clientSecret(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.credentials(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.database(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.host(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.httpPath(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.jarUris(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.jdbcDriver(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.jdbcUrl(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.password(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.port(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.projectId(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.xProperties(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.refreshToken(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.sapGatewayUrl(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.server(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.serviceName(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.sid(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.ssl(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.sslCertificate(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.sslCertificateHost(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.sslCertificateValidation(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.username(), "testString");
    assertEquals(postDatasourceConnectionParametersV2PropertiesModel.warehouse(), "testString");

    AddDatasourceConnectionOptions addDatasourceConnectionOptionsModel = new AddDatasourceConnectionOptions.Builder()
      .datasourceType("testString")
      .name("testString")
      .originCountry("testString")
      .xProperties(postDatasourceConnectionParametersV2PropertiesModel)
      .assetCategory("testString")
      .remoteNodes("testString")
      .build();
    assertEquals(addDatasourceConnectionOptionsModel.datasourceType(), "testString");
    assertEquals(addDatasourceConnectionOptionsModel.name(), "testString");
    assertEquals(addDatasourceConnectionOptionsModel.originCountry(), "testString");
    assertEquals(addDatasourceConnectionOptionsModel.xProperties(), postDatasourceConnectionParametersV2PropertiesModel);
    assertEquals(addDatasourceConnectionOptionsModel.assetCategory(), "testString");
    assertEquals(addDatasourceConnectionOptionsModel.remoteNodes(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddDatasourceConnectionOptionsError() throws Throwable {
    new AddDatasourceConnectionOptions.Builder().build();
  }

}