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

import com.ibm.cloud.data_virtualization.v1.model.CacheResponse;
import com.ibm.cloud.data_virtualization.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CacheResponse model.
 */
public class CacheResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCacheResponse() throws Throwable {
    CacheResponse cacheResponseModel = new CacheResponse();
    assertNull(cacheResponseModel.getName());
    assertNull(cacheResponseModel.getId());
    assertNull(cacheResponseModel.getQuery());
    assertNull(cacheResponseModel.getOwnerId());
    assertNull(cacheResponseModel.getType());
    assertNull(cacheResponseModel.getCreatedTimestamp());
    assertNull(cacheResponseModel.getLastModifiedTimestamp());
    assertNull(cacheResponseModel.getLastRefreshTimestamp());
    assertNull(cacheResponseModel.getLastUsedTimestamp());
    assertNull(cacheResponseModel.getState());
    assertNull(cacheResponseModel.getSize());
    assertNull(cacheResponseModel.getCardinality());
    assertNull(cacheResponseModel.getTimeTakenForRefresh());
    assertNull(cacheResponseModel.getRefreshCount());
    assertNull(cacheResponseModel.getHitCount());
    assertNull(cacheResponseModel.getRefreshSchedule());
    assertNull(cacheResponseModel.getRefreshScheduleDesc());
    assertNull(cacheResponseModel.getStatusMsg());
  }
}