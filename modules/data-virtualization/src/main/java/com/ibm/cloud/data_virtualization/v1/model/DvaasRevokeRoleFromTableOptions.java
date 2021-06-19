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
 * The dvaasRevokeRoleFromTable options.
 */
public class DvaasRevokeRoleFromTableOptions extends GenericModel {

  protected String roleName;
  protected String tableName;
  protected String tableSchema;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleName;
    private String tableName;
    private String tableSchema;

    private Builder(DvaasRevokeRoleFromTableOptions dvaasRevokeRoleFromTableOptions) {
      this.roleName = dvaasRevokeRoleFromTableOptions.roleName;
      this.tableName = dvaasRevokeRoleFromTableOptions.tableName;
      this.tableSchema = dvaasRevokeRoleFromTableOptions.tableSchema;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleName the roleName
     * @param tableName the tableName
     * @param tableSchema the tableSchema
     */
    public Builder(String roleName, String tableName, String tableSchema) {
      this.roleName = roleName;
      this.tableName = tableName;
      this.tableSchema = tableSchema;
    }

    /**
     * Builds a DvaasRevokeRoleFromTableOptions.
     *
     * @return the new DvaasRevokeRoleFromTableOptions instance
     */
    public DvaasRevokeRoleFromTableOptions build() {
      return new DvaasRevokeRoleFromTableOptions(this);
    }

    /**
     * Set the roleName.
     *
     * @param roleName the roleName
     * @return the DvaasRevokeRoleFromTableOptions builder
     */
    public Builder roleName(String roleName) {
      this.roleName = roleName;
      return this;
    }

    /**
     * Set the tableName.
     *
     * @param tableName the tableName
     * @return the DvaasRevokeRoleFromTableOptions builder
     */
    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    /**
     * Set the tableSchema.
     *
     * @param tableSchema the tableSchema
     * @return the DvaasRevokeRoleFromTableOptions builder
     */
    public Builder tableSchema(String tableSchema) {
      this.tableSchema = tableSchema;
      return this;
    }
  }

  protected DvaasRevokeRoleFromTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleName,
      "roleName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableName,
      "tableName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableSchema,
      "tableSchema cannot be null");
    roleName = builder.roleName;
    tableName = builder.tableName;
    tableSchema = builder.tableSchema;
  }

  /**
   * New builder.
   *
   * @return a DvaasRevokeRoleFromTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleName.
   *
   * The Data Virtualization role type. Values can be DV_ADMIN, DV_ENGINEER, DV_STEWARD, or DV_WORKER, which correspond
   * to MANAGER, ENGINEER, STEWARD, and USER roles in the user interface.
   *
   * @return the roleName
   */
  public String roleName() {
    return roleName;
  }

  /**
   * Gets the tableName.
   *
   * The virtualized table's name.
   *
   * @return the tableName
   */
  public String tableName() {
    return tableName;
  }

  /**
   * Gets the tableSchema.
   *
   * The virtualized table's schema name.
   *
   * @return the tableSchema
   */
  public String tableSchema() {
    return tableSchema;
  }
}

