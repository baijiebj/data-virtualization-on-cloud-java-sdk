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

import com.ibm.cloud.data_virtualization.v1.model.RevokeRoleFromObjectV2Options;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RevokeRoleFromObjectV2Options model.
 */
public class RevokeRoleFromObjectV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRevokeRoleFromObjectV2Options() throws Throwable {
    RevokeRoleFromObjectV2Options revokeRoleFromObjectV2OptionsModel = new RevokeRoleFromObjectV2Options.Builder()
      .roleToRevoke("DV_ENGINEER")
      .objectName("EMPLOYEE")
      .objectSchema("USER999")
      .build();
    assertEquals(revokeRoleFromObjectV2OptionsModel.roleToRevoke(), "DV_ENGINEER");
    assertEquals(revokeRoleFromObjectV2OptionsModel.objectName(), "EMPLOYEE");
    assertEquals(revokeRoleFromObjectV2OptionsModel.objectSchema(), "USER999");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRevokeRoleFromObjectV2OptionsError() throws Throwable {
    new RevokeRoleFromObjectV2Options.Builder().build();
  }

}