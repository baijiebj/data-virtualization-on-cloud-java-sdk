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
 * VirtualizeTableResponse.
 */
public class VirtualizeTableResponse extends GenericModel {

  @SerializedName("source_name")
  protected String sourceName;
  @SerializedName("virtual_name")
  protected String virtualName;
  @SerializedName("virtual_schema")
  protected String virtualSchema;

  /**
   * Gets the sourceName.
   *
   * The name of the source table.
   *
   * @return the sourceName
   */
  public String getSourceName() {
    return sourceName;
  }

  /**
   * Gets the virtualName.
   *
   * The name of the table that will be virtualized.
   *
   * @return the virtualName
   */
  public String getVirtualName() {
    return virtualName;
  }

  /**
   * Gets the virtualSchema.
   *
   * The schema of the table that will be virtualized.
   *
   * @return the virtualSchema
   */
  public String getVirtualSchema() {
    return virtualSchema;
  }
}

