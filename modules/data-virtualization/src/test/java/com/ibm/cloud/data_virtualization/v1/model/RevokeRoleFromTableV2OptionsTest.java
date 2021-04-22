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

import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromTableV2Options;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RevokeRoleFromTableV2Options model.
 */
public class RevokeRoleFromTableV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRevokeRoleFromTableV2Options() throws Throwable {
    RevokeRoleFromTableV2Options revokeRoleFromTableV2OptionsModel = new RevokeRoleFromTableV2Options.Builder()
      .roleToRevoke("DV_ENGINEER")
      .tableName("EMPLOYEE")
      .tableSchema("USER999")
      .build();
    assertEquals(revokeRoleFromTableV2OptionsModel.roleToRevoke(), "DV_ENGINEER");
    assertEquals(revokeRoleFromTableV2OptionsModel.tableName(), "EMPLOYEE");
    assertEquals(revokeRoleFromTableV2OptionsModel.tableSchema(), "USER999");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRevokeRoleFromTableV2OptionsError() throws Throwable {
    new RevokeRoleFromTableV2Options.Builder().build();
  }

}