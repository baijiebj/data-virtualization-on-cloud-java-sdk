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

import com.ibm.cloud.data_virtualization.v1.model.PostUserPrivilegesParametersBodyItem;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostUserPrivilegesParametersBodyItem model.
 */
public class PostUserPrivilegesParametersBodyItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostUserPrivilegesParametersBodyItem() throws Throwable {
    PostUserPrivilegesParametersBodyItem postUserPrivilegesParametersBodyItemModel = new PostUserPrivilegesParametersBodyItem.Builder()
      .tableName("EMPLOYEE")
      .tableSchema("USER999")
      .authid("PUBLIC")
      .build();
    assertEquals(postUserPrivilegesParametersBodyItemModel.tableName(), "EMPLOYEE");
    assertEquals(postUserPrivilegesParametersBodyItemModel.tableSchema(), "USER999");
    assertEquals(postUserPrivilegesParametersBodyItemModel.authid(), "PUBLIC");

    String json = TestUtilities.serialize(postUserPrivilegesParametersBodyItemModel);

    PostUserPrivilegesParametersBodyItem postUserPrivilegesParametersBodyItemModelNew = TestUtilities.deserialize(json, PostUserPrivilegesParametersBodyItem.class);
    assertTrue(postUserPrivilegesParametersBodyItemModelNew instanceof PostUserPrivilegesParametersBodyItem);
    assertEquals(postUserPrivilegesParametersBodyItemModelNew.tableName(), "EMPLOYEE");
    assertEquals(postUserPrivilegesParametersBodyItemModelNew.tableSchema(), "USER999");
    assertEquals(postUserPrivilegesParametersBodyItemModelNew.authid(), "PUBLIC");
  }
}