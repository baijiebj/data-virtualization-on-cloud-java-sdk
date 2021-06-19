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
 * The grantRolesToVirtualizedTable options.
 */
public class GrantRolesToVirtualizedTableOptions extends GenericModel {

  protected String tableName;
  protected String tableSchema;
  protected String roleName;

  /**
   * Builder.
   */
  public static class Builder {
    private String tableName;
    private String tableSchema;
    private String roleName;

    private Builder(GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptions) {
      this.tableName = grantRolesToVirtualizedTableOptions.tableName;
      this.tableSchema = grantRolesToVirtualizedTableOptions.tableSchema;
      this.roleName = grantRolesToVirtualizedTableOptions.roleName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param tableName the tableName
     * @param tableSchema the tableSchema
     */
    public Builder(String tableName, String tableSchema) {
      this.tableName = tableName;
      this.tableSchema = tableSchema;
    }

    /**
     * Builds a GrantRolesToVirtualizedTableOptions.
     *
     * @return the new GrantRolesToVirtualizedTableOptions instance
     */
    public GrantRolesToVirtualizedTableOptions build() {
      return new GrantRolesToVirtualizedTableOptions(this);
    }

    /**
     * Set the tableName.
     *
     * @param tableName the tableName
     * @return the GrantRolesToVirtualizedTableOptions builder
     */
    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    /**
     * Set the tableSchema.
     *
     * @param tableSchema the tableSchema
     * @return the GrantRolesToVirtualizedTableOptions builder
     */
    public Builder tableSchema(String tableSchema) {
      this.tableSchema = tableSchema;
      return this;
    }

    /**
     * Set the roleName.
     *
     * @param roleName the roleName
     * @return the GrantRolesToVirtualizedTableOptions builder
     */
    public Builder roleName(String roleName) {
      this.roleName = roleName;
      return this;
    }
  }

  protected GrantRolesToVirtualizedTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableName,
      "tableName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableSchema,
      "tableSchema cannot be null");
    tableName = builder.tableName;
    tableSchema = builder.tableSchema;
    roleName = builder.roleName;
  }

  /**
   * New builder.
   *
   * @return a GrantRolesToVirtualizedTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tableName.
   *
   * The name of the virtualized table.
   *
   * @return the tableName
   */
  public String tableName() {
    return tableName;
  }

  /**
   * Gets the tableSchema.
   *
   * The schema of the virtualized table.
   *
   * @return the tableSchema
   */
  public String tableSchema() {
    return tableSchema;
  }

  /**
   * Gets the roleName.
   *
   * The identifier of the authorization, if grant access to all users, the value is PUBLIC, othervise the value is the
   * data virtualization username.
   *
   * @return the roleName
   */
  public String roleName() {
    return roleName;
  }
}

