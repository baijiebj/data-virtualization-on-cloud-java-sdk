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

import com.ibm.cloud.data_virtualization.v1.model.VirtualizeTableParameterSourceTableDefItem;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the VirtualizeTableParameterSourceTableDefItem model.
 */
public class VirtualizeTableParameterSourceTableDefItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testVirtualizeTableParameterSourceTableDefItem() throws Throwable {
    VirtualizeTableParameterSourceTableDefItem virtualizeTableParameterSourceTableDefItemModel = new VirtualizeTableParameterSourceTableDefItem.Builder()
      .columnName("Column1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeTableParameterSourceTableDefItemModel.columnName(), "Column1");
    assertEquals(virtualizeTableParameterSourceTableDefItemModel.columnType(), "INTEGER");

    String json = TestUtilities.serialize(virtualizeTableParameterSourceTableDefItemModel);

    VirtualizeTableParameterSourceTableDefItem virtualizeTableParameterSourceTableDefItemModelNew = TestUtilities.deserialize(json, VirtualizeTableParameterSourceTableDefItem.class);
    assertTrue(virtualizeTableParameterSourceTableDefItemModelNew instanceof VirtualizeTableParameterSourceTableDefItem);
    assertEquals(virtualizeTableParameterSourceTableDefItemModelNew.columnName(), "Column1");
    assertEquals(virtualizeTableParameterSourceTableDefItemModelNew.columnType(), "INTEGER");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeTableParameterSourceTableDefItemError() throws Throwable {
    new VirtualizeTableParameterSourceTableDefItem.Builder().build();
  }

}