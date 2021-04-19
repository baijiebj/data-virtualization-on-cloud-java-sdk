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

import com.ibm.cloud.data_virtualization.v1.model.DatasourceNodesResponseV2DatasourceNodesArrayItem;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceNodesResponseV2DatasourceNodesArrayItemDataSourcesItem;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DatasourceNodesResponseV2DatasourceNodesArrayItem model.
 */
public class DatasourceNodesResponseV2DatasourceNodesArrayItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDatasourceNodesResponseV2DatasourceNodesArrayItem() throws Throwable {
    DatasourceNodesResponseV2DatasourceNodesArrayItem datasourceNodesResponseV2DatasourceNodesArrayItemModel = new DatasourceNodesResponseV2DatasourceNodesArrayItem();
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getNodeName());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getNodeDescription());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getAgentClass());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getHostname());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getPort());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getOsUser());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getIsDocker());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getDscount());
    assertNull(datasourceNodesResponseV2DatasourceNodesArrayItemModel.getDataSources());
  }
}