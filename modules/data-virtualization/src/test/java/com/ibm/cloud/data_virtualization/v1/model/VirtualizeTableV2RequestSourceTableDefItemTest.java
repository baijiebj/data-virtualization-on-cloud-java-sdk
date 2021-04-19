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

import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableV2RequestSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the VirtualizeTableV2RequestSourceTableDefItem model.
 */
public class VirtualizeTableV2RequestSourceTableDefItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testVirtualizeTableV2RequestSourceTableDefItem() throws Throwable {
    VirtualizeTableV2RequestSourceTableDefItem virtualizeTableV2RequestSourceTableDefItemModel = new VirtualizeTableV2RequestSourceTableDefItem.Builder()
      .columnName("Column1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeTableV2RequestSourceTableDefItemModel.columnName(), "Column1");
    assertEquals(virtualizeTableV2RequestSourceTableDefItemModel.columnType(), "INTEGER");

    String json = TestUtilities.serialize(virtualizeTableV2RequestSourceTableDefItemModel);

    VirtualizeTableV2RequestSourceTableDefItem virtualizeTableV2RequestSourceTableDefItemModelNew = TestUtilities.deserialize(json, VirtualizeTableV2RequestSourceTableDefItem.class);
    assertTrue(virtualizeTableV2RequestSourceTableDefItemModelNew instanceof VirtualizeTableV2RequestSourceTableDefItem);
    assertEquals(virtualizeTableV2RequestSourceTableDefItemModelNew.columnName(), "Column1");
    assertEquals(virtualizeTableV2RequestSourceTableDefItemModelNew.columnType(), "INTEGER");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeTableV2RequestSourceTableDefItemError() throws Throwable {
    new VirtualizeTableV2RequestSourceTableDefItem.Builder().build();
  }

}