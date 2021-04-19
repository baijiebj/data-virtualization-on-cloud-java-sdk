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
 * VirtualizeTableV2RequestVirtualTableDefItem.
 */
public class VirtualizeTableV2RequestVirtualTableDefItem extends GenericModel {

  @SerializedName("column_name")
  protected String columnName;
  @SerializedName("column_type")
  protected String columnType;

  /**
   * Builder.
   */
  public static class Builder {
    private String columnName;
    private String columnType;

    private Builder(VirtualizeTableV2RequestVirtualTableDefItem virtualizeTableV2RequestVirtualTableDefItem) {
      this.columnName = virtualizeTableV2RequestVirtualTableDefItem.columnName;
      this.columnType = virtualizeTableV2RequestVirtualTableDefItem.columnType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param columnName the columnName
     * @param columnType the columnType
     */
    public Builder(String columnName, String columnType) {
      this.columnName = columnName;
      this.columnType = columnType;
    }

    /**
     * Builds a VirtualizeTableV2RequestVirtualTableDefItem.
     *
     * @return the new VirtualizeTableV2RequestVirtualTableDefItem instance
     */
    public VirtualizeTableV2RequestVirtualTableDefItem build() {
      return new VirtualizeTableV2RequestVirtualTableDefItem(this);
    }

    /**
     * Set the columnName.
     *
     * @param columnName the columnName
     * @return the VirtualizeTableV2RequestVirtualTableDefItem builder
     */
    public Builder columnName(String columnName) {
      this.columnName = columnName;
      return this;
    }

    /**
     * Set the columnType.
     *
     * @param columnType the columnType
     * @return the VirtualizeTableV2RequestVirtualTableDefItem builder
     */
    public Builder columnType(String columnType) {
      this.columnType = columnType;
      return this;
    }
  }

  protected VirtualizeTableV2RequestVirtualTableDefItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.columnName,
      "columnName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.columnType,
      "columnType cannot be null");
    columnName = builder.columnName;
    columnType = builder.columnType;
  }

  /**
   * New builder.
   *
   * @return a VirtualizeTableV2RequestVirtualTableDefItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the columnName.
   *
   * The name of the column.
   *
   * @return the columnName
   */
  public String columnName() {
    return columnName;
  }

  /**
   * Gets the columnType.
   *
   * The type of the column.
   *
   * @return the columnType
   */
  public String columnType() {
    return columnType;
  }
}

