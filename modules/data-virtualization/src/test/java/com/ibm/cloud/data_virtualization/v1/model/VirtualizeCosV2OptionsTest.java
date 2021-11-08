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

import com.ibm.cloud.data_virtualization.v1.model.VirtualizeCosV2Options;
import com.ibm.cloud.data_virtualization.v1.model.VirtualizeCosV2RequestVirtualTableDefItem;
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
 * Unit test class for the VirtualizeCosV2Options model.
 */
public class VirtualizeCosV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testVirtualizeCosV2Options() throws Throwable {
    VirtualizeCosV2RequestVirtualTableDefItem virtualizeCosV2RequestVirtualTableDefItemModel = new VirtualizeCosV2RequestVirtualTableDefItem.Builder()
      .columnName("Column_1")
      .columnType("INTEGER")
      .build();
    assertEquals(virtualizeCosV2RequestVirtualTableDefItemModel.columnName(), "Column_1");
    assertEquals(virtualizeCosV2RequestVirtualTableDefItemModel.columnType(), "INTEGER");

    VirtualizeCosV2Options virtualizeCosV2OptionsModel = new VirtualizeCosV2Options.Builder()
      .url("s3a://testBucket/home/data.csv")
      .virtualName("testString")
      .virtualSchema("testString")
      .virtualTableDef(new java.util.ArrayList<VirtualizeCosV2RequestVirtualTableDefItem>(java.util.Arrays.asList(virtualizeCosV2RequestVirtualTableDefItemModel)))
      .isReplace(false)
      .options("INCPARTS=true")
      .jwtAuthUserPayload("testString")
      .build();
    assertEquals(virtualizeCosV2OptionsModel.url(), "s3a://testBucket/home/data.csv");
    assertEquals(virtualizeCosV2OptionsModel.virtualName(), "testString");
    assertEquals(virtualizeCosV2OptionsModel.virtualSchema(), "testString");
    assertEquals(virtualizeCosV2OptionsModel.virtualTableDef(), new java.util.ArrayList<VirtualizeCosV2RequestVirtualTableDefItem>(java.util.Arrays.asList(virtualizeCosV2RequestVirtualTableDefItemModel)));
    assertEquals(virtualizeCosV2OptionsModel.isReplace(), Boolean.valueOf(false));
    assertEquals(virtualizeCosV2OptionsModel.options(), "INCPARTS=true");
    assertEquals(virtualizeCosV2OptionsModel.jwtAuthUserPayload(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testVirtualizeCosV2OptionsError() throws Throwable {
    new VirtualizeCosV2Options.Builder().build();
  }

}