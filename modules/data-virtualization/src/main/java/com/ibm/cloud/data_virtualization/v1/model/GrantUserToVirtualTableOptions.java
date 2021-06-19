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
 * The grantUserToVirtualTable options.
 */
public class GrantUserToVirtualTableOptions extends GenericModel {

  protected String tableName;
  protected String tableSchema;
  protected String authid;

  /**
   * Builder.
   */
  public static class Builder {
    private String tableName;
    private String tableSchema;
    private String authid;

    private Builder(GrantUserToVirtualTableOptions grantUserToVirtualTableOptions) {
      this.tableName = grantUserToVirtualTableOptions.tableName;
      this.tableSchema = grantUserToVirtualTableOptions.tableSchema;
      this.authid = grantUserToVirtualTableOptions.authid;
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
     * @param authid the authid
     */
    public Builder(String tableName, String tableSchema, String authid) {
      this.tableName = tableName;
      this.tableSchema = tableSchema;
      this.authid = authid;
    }

    /**
     * Builds a GrantUserToVirtualTableOptions.
     *
     * @return the new GrantUserToVirtualTableOptions instance
     */
    public GrantUserToVirtualTableOptions build() {
      return new GrantUserToVirtualTableOptions(this);
    }

    /**
     * Set the tableName.
     *
     * @param tableName the tableName
     * @return the GrantUserToVirtualTableOptions builder
     */
    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    /**
     * Set the tableSchema.
     *
     * @param tableSchema the tableSchema
     * @return the GrantUserToVirtualTableOptions builder
     */
    public Builder tableSchema(String tableSchema) {
      this.tableSchema = tableSchema;
      return this;
    }

    /**
     * Set the authid.
     *
     * @param authid the authid
     * @return the GrantUserToVirtualTableOptions builder
     */
    public Builder authid(String authid) {
      this.authid = authid;
      return this;
    }
  }

  protected GrantUserToVirtualTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableName,
      "tableName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tableSchema,
      "tableSchema cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.authid,
      "authid cannot be null");
    tableName = builder.tableName;
    tableSchema = builder.tableSchema;
    authid = builder.authid;
  }

  /**
   * New builder.
   *
   * @return a GrantUserToVirtualTableOptions builder
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
   * Gets the authid.
   *
   * The identifier of the authorization, if grant access to all users, the value is PUBLIC, othervise the value is the
   * data virtualization username.
   *
   * @return the authid
   */
  public String authid() {
    return authid;
  }
}

