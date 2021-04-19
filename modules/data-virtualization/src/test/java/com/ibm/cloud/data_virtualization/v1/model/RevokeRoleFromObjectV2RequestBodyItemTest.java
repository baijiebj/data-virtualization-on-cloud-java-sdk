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

import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromObjectV2RequestBodyItem;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RevokeRoleFromObjectV2RequestBodyItem model.
 */
public class RevokeRoleFromObjectV2RequestBodyItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRevokeRoleFromObjectV2RequestBodyItem() throws Throwable {
    RevokeRoleFromObjectV2RequestBodyItem revokeRoleFromObjectV2RequestBodyItemModel = new RevokeRoleFromObjectV2RequestBodyItem.Builder()
      .objectName("EMPLOYEE")
      .objectSchema("USER999")
      .roleToRevoke("DV_ENGINEER")
      .build();
    assertEquals(revokeRoleFromObjectV2RequestBodyItemModel.objectName(), "EMPLOYEE");
    assertEquals(revokeRoleFromObjectV2RequestBodyItemModel.objectSchema(), "USER999");
    assertEquals(revokeRoleFromObjectV2RequestBodyItemModel.roleToRevoke(), "DV_ENGINEER");

    String json = TestUtilities.serialize(revokeRoleFromObjectV2RequestBodyItemModel);

    RevokeRoleFromObjectV2RequestBodyItem revokeRoleFromObjectV2RequestBodyItemModelNew = TestUtilities.deserialize(json, RevokeRoleFromObjectV2RequestBodyItem.class);
    assertTrue(revokeRoleFromObjectV2RequestBodyItemModelNew instanceof RevokeRoleFromObjectV2RequestBodyItem);
    assertEquals(revokeRoleFromObjectV2RequestBodyItemModelNew.objectName(), "EMPLOYEE");
    assertEquals(revokeRoleFromObjectV2RequestBodyItemModelNew.objectSchema(), "USER999");
    assertEquals(revokeRoleFromObjectV2RequestBodyItemModelNew.roleToRevoke(), "DV_ENGINEER");
  }
}