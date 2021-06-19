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
 * PrimaryCatalogInfoEntity.
 */
public class PrimaryCatalogInfoEntity extends GenericModel {

  @SerializedName("auto_profiling")
  protected Boolean autoProfiling;
  @SerializedName("bss_account_id")
  protected String bssAccountId;
  @SerializedName("capacity_limit")
  protected Long capacityLimit;
  protected String description;
  protected String generator;
  @SerializedName("is_governed")
  protected Boolean isGoverned;
  protected String name;

  /**
   * Gets the autoProfiling.
   *
   * @return the autoProfiling
   */
  public Boolean isAutoProfiling() {
    return autoProfiling;
  }

  /**
   * Gets the bssAccountId.
   *
   * @return the bssAccountId
   */
  public String getBssAccountId() {
    return bssAccountId;
  }

  /**
   * Gets the capacityLimit.
   *
   * @return the capacityLimit
   */
  public Long getCapacityLimit() {
    return capacityLimit;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the generator.
   *
   * @return the generator
   */
  public String getGenerator() {
    return generator;
  }

  /**
   * Gets the isGoverned.
   *
   * @return the isGoverned
   */
  public Boolean isIsGoverned() {
    return isGoverned;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}

