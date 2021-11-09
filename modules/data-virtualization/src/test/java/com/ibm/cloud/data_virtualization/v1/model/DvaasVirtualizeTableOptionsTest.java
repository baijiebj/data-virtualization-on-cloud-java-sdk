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

import com.ibm.cloud.data_virtualization.v1.model.DvaasVirtualizeTableOptions;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterVirtualTableDefItem;
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
 * Unit test class for the DvaasVirtualizeTableOptions model.
 */
public class DvaasVirtualizeTableOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDvaasVirtualizeTableOptions() throws Throwable {
    VirtualizeTableParameterSourceTableDefItem virtualizeTableParameterSourceTableDefItemModel = new VirtualizeTableParameterSourceTableDefItem.Builder()
      .columnName("Column1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeTableParameterSourceTableDefItemModel.columnName(), "Column1");
    assertEquals(virtualizeTableParameterSourceTableDefItemModel.columnType(), "INTEGER");

    VirtualizeTableParameterVirtualTableDefItem virtualizeTableParameterVirtualTableDefItemModel = new VirtualizeTableParameterVirtualTableDefItem.Builder()
      .columnName("Column_1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeTableParameterVirtualTableDefItemModel.columnName(), "Column_1");
    assertEquals(virtualizeTableParameterVirtualTableDefItemModel.columnType(), "INTEGER");

    DvaasVirtualizeTableOptions dvaasVirtualizeTableOptionsModel = new DvaasVirtualizeTableOptions.Builder()
      .sourceName("Tab1")
      .sourceTableDef(new java.util.ArrayList<VirtualizeTableParameterSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterSourceTableDefItemModel)))
      .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("DB210001:\"Hjq1\"")))
      .virtualName("Tab1")
      .virtualSchema("dv_ibmid_060000s4y5")
      .virtualTableDef(new java.util.ArrayList<VirtualizeTableParameterVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterVirtualTableDefItemModel)))
      .isIncludedColumns("Y, Y, N")
      .replace(false)
      .build();
    assertEquals(dvaasVirtualizeTableOptionsModel.sourceName(), "Tab1");
    assertEquals(dvaasVirtualizeTableOptionsModel.sourceTableDef(), new java.util.ArrayList<VirtualizeTableParameterSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterSourceTableDefItemModel)));
    assertEquals(dvaasVirtualizeTableOptionsModel.sources(), new java.util.ArrayList<String>(java.util.Arrays.asList("DB210001:\"Hjq1\"")));
    assertEquals(dvaasVirtualizeTableOptionsModel.virtualName(), "Tab1");
    assertEquals(dvaasVirtualizeTableOptionsModel.virtualSchema(), "dv_ibmid_060000s4y5");
    assertEquals(dvaasVirtualizeTableOptionsModel.virtualTableDef(), new java.util.ArrayList<VirtualizeTableParameterVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableParameterVirtualTableDefItemModel)));
    assertEquals(dvaasVirtualizeTableOptionsModel.isIncludedColumns(), "Y, Y, N");
    assertEquals(dvaasVirtualizeTableOptionsModel.replace(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDvaasVirtualizeTableOptionsError() throws Throwable {
    new DvaasVirtualizeTableOptions.Builder().build();
  }

}