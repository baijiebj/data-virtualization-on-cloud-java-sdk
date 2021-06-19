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
 * The revokeUserFromObject options.
 */
public class RevokeUserFromObjectOptions extends GenericModel {

  protected String authid;
  protected String tableName;
  protected String tableSchema;

  /**
   * Builder.
   */
  public static class Builder {
    private String authid;
    private String tableName;
    private String tableSchema;

    private Builder(RevokeUserFromObjectOptions revokeUserFromObjectOptions) {
      this.authid = revokeUserFromObjectOptions.authid;
      this.tableName = revokeUserFromObjectOptions.tableName;
      this.tableSchema = revokeUserFromObjectOptions.tableSchema;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param authid the authid
     * @param tableName the tableName
     * @param tableSchema the tableSchema
     */
    public Builder(String authid, String tableName, String tableSchema) {
      this.authid = authid;
      this.tableName = tableName;
      this.tableSchema = tableSchema;
    }

    /**
     * Builds a RevokeUserFromObjectOptions.
     *
     * @return the new RevokeUserFromObjectOptions instance
     */
    public RevokeUserFromObjectOptions build() {
      return new RevokeUserFromObjectOptions(this);
    }

    /**
     * Set the authid.
     *
     * @param authid the authid
     * @return the RevokeUserFromObjectOptions builder
     */
    public Builder authid(String authid) {
      this.authid = authid;
      return this;
    }

    /**
     * Set the tableName.
     *
     * @param tableName the tableName
     * @return the RevokeUserFromObjectOptions builder
     */
    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    /**
     * Set the tableSchema.
     *
     * @param tableSchema the tableSchema
     * @return the RevokeUserFromObjectOptions builder
     */
    public Builder tableSchema(String tableSchema) {
      this.tableSchema = tableSchema;
      return this;
    }
  }

  protected RevokeUserFromObjectOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.authid,
      "authid cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableName,
      "tableName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableSchema,
      "tableSchema cannot be null");
    authid = builder.authid;
    tableName = builder.tableName;
    tableSchema = builder.tableSchema;
  }

  /**
   * New builder.
   *
   * @return a RevokeUserFromObjectOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the authid.
   *
   * The Data Virtualization user name, if the value is PUBLIC, it means revoke access privilege from all Data
   * Virtualization users.
   *
   * @return the authid
   */
  public String authid() {
    return authid;
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

