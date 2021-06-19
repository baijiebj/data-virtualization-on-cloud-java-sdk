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

import com.ibm.cloud.data_virtualization.v1.model.PrimaryCatalogInfoEntity;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PrimaryCatalogInfoEntity model.
 */
public class PrimaryCatalogInfoEntityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPrimaryCatalogInfoEntity() throws Throwable {
    PrimaryCatalogInfoEntity primaryCatalogInfoEntityModel = new PrimaryCatalogInfoEntity();
    assertNull(primaryCatalogInfoEntityModel.isAutoProfiling());
    assertNull(primaryCatalogInfoEntityModel.getBssAccountId());
    assertNull(primaryCatalogInfoEntityModel.getCapacityLimit());
    assertNull(primaryCatalogInfoEntityModel.getDescription());
    assertNull(primaryCatalogInfoEntityModel.getGenerator());
    assertNull(primaryCatalogInfoEntityModel.isIsGoverned());
    assertNull(primaryCatalogInfoEntityModel.getName());
  }
}