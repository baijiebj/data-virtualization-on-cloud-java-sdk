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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteTable options.
 */
public class DeleteTableOptions extends GenericModel {

  protected String schemaName;
  protected String tableName;

  /**
   * Builder.
   */
  public static class Builder {
    private String schemaName;
    private String tableName;

    private Builder(DeleteTableOptions deleteTableOptions) {
      this.schemaName = deleteTableOptions.schemaName;
      this.tableName = deleteTableOptions.tableName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param schemaName the schemaName
     * @param tableName the tableName
     */
    public Builder(String schemaName, String tableName) {
      this.schemaName = schemaName;
      this.tableName = tableName;
    }

    /**
     * Builds a DeleteTableOptions.
     *
     * @return the new DeleteTableOptions instance
     */
    public DeleteTableOptions build() {
      return new DeleteTableOptions(this);
    }

    /**
     * Set the schemaName.
     *
     * @param schemaName the schemaName
     * @return the DeleteTableOptions builder
     */
    public Builder schemaName(String schemaName) {
      this.schemaName = schemaName;
      return this;
    }

    /**
     * Set the tableName.
     *
     * @param tableName the tableName
     * @return the DeleteTableOptions builder
     */
    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }
  }

  protected DeleteTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.schemaName,
      "schemaName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.tableName,
      "tableName cannot be empty");
    schemaName = builder.schemaName;
    tableName = builder.tableName;
  }

  /**
   * New builder.
   *
   * @return a DeleteTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the schemaName.
   *
   * The schema of virtualized table to be deleted.
   *
   * @return the schemaName
   */
  public String schemaName() {
    return schemaName;
  }

  /**
   * Gets the tableName.
   *
   * The name of virtualized table to be deleted.
   *
   * @return the tableName
   */
  public String tableName() {
    return tableName;
  }
}

