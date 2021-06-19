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

import com.ibm.cloud.data_virtualization.v1.model.PostPrimaryCatalogParametersAssetsItem;
import com.ibm.cloud.data_virtualization.v1.model.PublishAssetsOptions;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PublishAssetsOptions model.
 */
public class PublishAssetsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPublishAssetsOptions() throws Throwable {
    PostPrimaryCatalogParametersAssetsItem postPrimaryCatalogParametersAssetsItemModel = new PostPrimaryCatalogParametersAssetsItem.Builder()
      .schema("db2inst1")
      .table("EMPLOYEE")
      .build();
    assertEquals(postPrimaryCatalogParametersAssetsItemModel.schema(), "db2inst1");
    assertEquals(postPrimaryCatalogParametersAssetsItemModel.table(), "EMPLOYEE");

    PublishAssetsOptions publishAssetsOptionsModel = new PublishAssetsOptions.Builder()
      .catalogId("2b6b9fc5-626c-47a9-a836-56b76c0bc826")
      .allowDuplicates(false)
      .assets(new java.util.ArrayList<PostPrimaryCatalogParametersAssetsItem>(java.util.Arrays.asList(postPrimaryCatalogParametersAssetsItemModel)))
      .build();
    assertEquals(publishAssetsOptionsModel.catalogId(), "2b6b9fc5-626c-47a9-a836-56b76c0bc826");
    assertEquals(publishAssetsOptionsModel.allowDuplicates(), Boolean.valueOf(false));
    assertEquals(publishAssetsOptionsModel.assets(), new java.util.ArrayList<PostPrimaryCatalogParametersAssetsItem>(java.util.Arrays.asList(postPrimaryCatalogParametersAssetsItemModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPublishAssetsOptionsError() throws Throwable {
    new PublishAssetsOptions.Builder().build();
  }

}