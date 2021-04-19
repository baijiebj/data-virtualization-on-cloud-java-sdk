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

import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2Options;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2RequestSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2RequestVirtualTableDefItem;
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
 * Unit test class for the VirtualizeTableV2Options model.
 */
public class VirtualizeTableV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testVirtualizeTableV2Options() throws Throwable {
    VirtualizeTableV2RequestSourceTableDefItem virtualizeTableV2RequestSourceTableDefItemModel = new VirtualizeTableV2RequestSourceTableDefItem.Builder()
      .columnName("Column1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeTableV2RequestSourceTableDefItemModel.columnName(), "Column1");
    assertEquals(virtualizeTableV2RequestSourceTableDefItemModel.columnType(), "INTEGER");

    VirtualizeTableV2RequestVirtualTableDefItem virtualizeTableV2RequestVirtualTableDefItemModel = new VirtualizeTableV2RequestVirtualTableDefItem.Builder()
      .columnName("Column_1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeTableV2RequestVirtualTableDefItemModel.columnName(), "Column_1");
    assertEquals(virtualizeTableV2RequestVirtualTableDefItemModel.columnType(), "INTEGER");

    VirtualizeTableV2Options virtualizeTableV2OptionsModel = new VirtualizeTableV2Options.Builder()
      .sourceName("Tab1")
      .sourceTableDef(new java.util.ArrayList<VirtualizeTableV2RequestSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableV2RequestSourceTableDefItemModel)))
      .sources(new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")))
      .virtualName("Tab1")
      .virtualSchema("USER999")
      .virtualTableDef(new java.util.ArrayList<VirtualizeTableV2RequestVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableV2RequestVirtualTableDefItemModel)))
      .isIncludedColumns("Y, Y, N")
      .replace(false)
      .build();
    assertEquals(virtualizeTableV2OptionsModel.sourceName(), "Tab1");
    assertEquals(virtualizeTableV2OptionsModel.sourceTableDef(), new java.util.ArrayList<VirtualizeTableV2RequestSourceTableDefItem>(java.util.Arrays.asList(virtualizeTableV2RequestSourceTableDefItemModel)));
    assertEquals(virtualizeTableV2OptionsModel.sources(), new java.util.ArrayList<String>(java.util.Arrays.asList("\"DB210001:\"Hjq1\"\"")));
    assertEquals(virtualizeTableV2OptionsModel.virtualName(), "Tab1");
    assertEquals(virtualizeTableV2OptionsModel.virtualSchema(), "USER999");
    assertEquals(virtualizeTableV2OptionsModel.virtualTableDef(), new java.util.ArrayList<VirtualizeTableV2RequestVirtualTableDefItem>(java.util.Arrays.asList(virtualizeTableV2RequestVirtualTableDefItemModel)));
    assertEquals(virtualizeTableV2OptionsModel.isIncludedColumns(), "Y, Y, N");
    assertEquals(virtualizeTableV2OptionsModel.replace(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeTableV2OptionsError() throws Throwable {
    new VirtualizeTableV2Options.Builder().build();
  }

}