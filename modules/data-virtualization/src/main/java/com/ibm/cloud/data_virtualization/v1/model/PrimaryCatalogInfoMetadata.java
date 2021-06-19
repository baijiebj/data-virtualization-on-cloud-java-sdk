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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * PrimaryCatalogInfoMetadata.
 */
public class PrimaryCatalogInfoMetadata extends GenericModel {

  @SerializedName("create_time")
  protected String createTime;
  @SerializedName("creator_id")
  protected String creatorId;
  protected String guid;
  protected String url;

  /**
   * Gets the createTime.
   *
   * @return the createTime
   */
  public String getCreateTime() {
    return createTime;
  }

  /**
   * Gets the creatorId.
   *
   * @return the creatorId
   */
  public String getCreatorId() {
    return creatorId;
  }

  /**
   * Gets the guid.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}

