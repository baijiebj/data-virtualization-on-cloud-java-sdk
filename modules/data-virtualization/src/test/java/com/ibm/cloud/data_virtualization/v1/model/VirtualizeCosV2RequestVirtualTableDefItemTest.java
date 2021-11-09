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

import com.ibm.cloud.data_virtualization.v1.model.VirtualizeCosV2RequestVirtualTableDefItem;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the VirtualizeCosV2RequestVirtualTableDefItem model.
 */
public class VirtualizeCosV2RequestVirtualTableDefItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testVirtualizeCosV2RequestVirtualTableDefItem() throws Throwable {
    VirtualizeCosV2RequestVirtualTableDefItem virtualizeCosV2RequestVirtualTableDefItemModel = new VirtualizeCosV2RequestVirtualTableDefItem.Builder()
      .columnName("Column_1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeCosV2RequestVirtualTableDefItemModel.columnName(), "Column_1");
    assertEquals(virtualizeCosV2RequestVirtualTableDefItemModel.columnType(), "INTEGER");

    String json = TestUtilities.serialize(virtualizeCosV2RequestVirtualTableDefItemModel);

    VirtualizeCosV2RequestVirtualTableDefItem virtualizeCosV2RequestVirtualTableDefItemModelNew = TestUtilities.deserialize(json, VirtualizeCosV2RequestVirtualTableDefItem.class);
    assertTrue(virtualizeCosV2RequestVirtualTableDefItemModelNew instanceof VirtualizeCosV2RequestVirtualTableDefItem);
    assertEquals(virtualizeCosV2RequestVirtualTableDefItemModelNew.columnName(), "Column_1");
    assertEquals(virtualizeCosV2RequestVirtualTableDefItemModelNew.columnType(), "INTEGER");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeCosV2RequestVirtualTableDefItemError() throws Throwable {
    new VirtualizeCosV2RequestVirtualTableDefItem.Builder().build();
  }

}