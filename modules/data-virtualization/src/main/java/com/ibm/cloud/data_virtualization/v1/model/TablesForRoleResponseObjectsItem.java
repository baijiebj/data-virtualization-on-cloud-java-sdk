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
 * TablesForRoleResponseObjectsItem.
 */
public class TablesForRoleResponseObjectsItem extends GenericModel {

  @SerializedName("table_name")
  protected String tableName;
  @SerializedName("table_schema")
  protected String tableSchema;

  /**
   * Gets the tableName.
   *
   * The virtualized table name that is granted access to role ROLENAME.
   *
   * @return the tableName
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * Gets the tableSchema.
   *
   * The SCHEMA of virtualized table that is granted access to role ROLENAME.
   *
   * @return the tableSchema
   */
  public String getTableSchema() {
    return tableSchema;
  }
}

