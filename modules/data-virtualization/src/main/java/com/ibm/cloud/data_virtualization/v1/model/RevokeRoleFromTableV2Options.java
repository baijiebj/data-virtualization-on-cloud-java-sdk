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
 * The revokeRoleFromTableV2 options.
 */
public class RevokeRoleFromTableV2Options extends GenericModel {

  protected String roleToRevoke;
  protected String tableName;
  protected String tableSchema;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleToRevoke;
    private String tableName;
    private String tableSchema;

    private Builder(RevokeRoleFromTableV2Options revokeRoleFromTableV2Options) {
      this.roleToRevoke = revokeRoleFromTableV2Options.roleToRevoke;
      this.tableName = revokeRoleFromTableV2Options.tableName;
      this.tableSchema = revokeRoleFromTableV2Options.tableSchema;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleToRevoke the roleToRevoke
     * @param tableName the tableName
     * @param tableSchema the tableSchema
     */
    public Builder(String roleToRevoke, String tableName, String tableSchema) {
      this.roleToRevoke = roleToRevoke;
      this.tableName = tableName;
      this.tableSchema = tableSchema;
    }

    /**
     * Builds a RevokeRoleFromTableV2Options.
     *
     * @return the new RevokeRoleFromTableV2Options instance
     */
    public RevokeRoleFromTableV2Options build() {
      return new RevokeRoleFromTableV2Options(this);
    }

    /**
     * Set the roleToRevoke.
     *
     * @param roleToRevoke the roleToRevoke
     * @return the RevokeRoleFromTableV2Options builder
     */
    public Builder roleToRevoke(String roleToRevoke) {
      this.roleToRevoke = roleToRevoke;
      return this;
    }

    /**
     * Set the tableName.
     *
     * @param tableName the tableName
     * @return the RevokeRoleFromTableV2Options builder
     */
    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    /**
     * Set the tableSchema.
     *
     * @param tableSchema the tableSchema
     * @return the RevokeRoleFromTableV2Options builder
     */
    public Builder tableSchema(String tableSchema) {
      this.tableSchema = tableSchema;
      return this;
    }
  }

  protected RevokeRoleFromTableV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roleToRevoke,
      "roleToRevoke cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableName,
      "tableName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableSchema,
      "tableSchema cannot be null");
    roleToRevoke = builder.roleToRevoke;
    tableName = builder.tableName;
    tableSchema = builder.tableSchema;
  }

  /**
   * New builder.
   *
   * @return a RevokeRoleFromTableV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleToRevoke.
   *
   * The Data Virtualization role type, the value could be DV_ADMIN, DV_ENGINEER, DV_STEWARD or DV_WORKER.
   *
   * @return the roleToRevoke
   */
  public String roleToRevoke() {
    return roleToRevoke;
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

