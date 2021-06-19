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
 * PostDatasourceConnection.
 */
public class PostDatasourceConnection extends GenericModel {

  @SerializedName("connection_id")
  protected String connectionId;
  @SerializedName("datasource_type")
  protected String datasourceType;
  protected String name;

  /**
   * Gets the connectionId.
   *
   * The identifier of data source connection.
   *
   * @return the connectionId
   */
  public String getConnectionId() {
    return connectionId;
  }

  /**
   * Gets the datasourceType.
   *
   * The type of data source that you want to add.
   *
   * @return the datasourceType
   */
  public String getDatasourceType() {
    return datasourceType;
  }

  /**
   * Gets the name.
   *
   * The name of data source.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}

