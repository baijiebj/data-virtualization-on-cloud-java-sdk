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

import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectOptions;
import com.ibm.cloud.data_virtualization.v1.model.RevokeUserFromObjectRequestBodyItem;
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
 * Unit test class for the RevokeUserFromObjectOptions model.
 */
public class RevokeUserFromObjectOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRevokeUserFromObjectOptions() throws Throwable {
    RevokeUserFromObjectRequestBodyItem revokeUserFromObjectRequestBodyItemModel = new RevokeUserFromObjectRequestBodyItem.Builder()
      .objectName("EMPLOYEE")
      .objectSchema("USER999")
      .authid("PUBLIC")
      .build();
    assertEquals(revokeUserFromObjectRequestBodyItemModel.objectName(), "EMPLOYEE");
    assertEquals(revokeUserFromObjectRequestBodyItemModel.objectSchema(), "USER999");
    assertEquals(revokeUserFromObjectRequestBodyItemModel.authid(), "PUBLIC");

    RevokeUserFromObjectOptions revokeUserFromObjectOptionsModel = new RevokeUserFromObjectOptions.Builder()
      .body(new java.util.ArrayList<RevokeUserFromObjectRequestBodyItem>(java.util.Arrays.asList(revokeUserFromObjectRequestBodyItemModel)))
      .build();
    assertEquals(revokeUserFromObjectOptionsModel.body(), new java.util.ArrayList<RevokeUserFromObjectRequestBodyItem>(java.util.Arrays.asList(revokeUserFromObjectRequestBodyItemModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRevokeUserFromObjectOptionsError() throws Throwable {
    new RevokeUserFromObjectOptions.Builder().build();
  }

}