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
 * The revokeRoleFromObjectV2 options.
 */
public class RevokeRoleFromObjectV2Options extends GenericModel {

  protected String roleToRevoke;
  protected String objectName;
  protected String objectSchema;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleToRevoke;
    private String objectName;
    private String objectSchema;

    private Builder(RevokeRoleFromObjectV2Options revokeRoleFromObjectV2Options) {
      this.roleToRevoke = revokeRoleFromObjectV2Options.roleToRevoke;
      this.objectName = revokeRoleFromObjectV2Options.objectName;
      this.objectSchema = revokeRoleFromObjectV2Options.objectSchema;
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
     * @param objectName the objectName
     * @param objectSchema the objectSchema
     */
    public Builder(String roleToRevoke, String objectName, String objectSchema) {
      this.roleToRevoke = roleToRevoke;
      this.objectName = objectName;
      this.objectSchema = objectSchema;
    }

    /**
     * Builds a RevokeRoleFromObjectV2Options.
     *
     * @return the new RevokeRoleFromObjectV2Options instance
     */
    public RevokeRoleFromObjectV2Options build() {
      return new RevokeRoleFromObjectV2Options(this);
    }

    /**
     * Set the roleToRevoke.
     *
     * @param roleToRevoke the roleToRevoke
     * @return the RevokeRoleFromObjectV2Options builder
     */
    public Builder roleToRevoke(String roleToRevoke) {
      this.roleToRevoke = roleToRevoke;
      return this;
    }

    /**
     * Set the objectName.
     *
     * @param objectName the objectName
     * @return the RevokeRoleFromObjectV2Options builder
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }

    /**
     * Set the objectSchema.
     *
     * @param objectSchema the objectSchema
     * @return the RevokeRoleFromObjectV2Options builder
     */
    public Builder objectSchema(String objectSchema) {
      this.objectSchema = objectSchema;
      return this;
    }
  }

  protected RevokeRoleFromObjectV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roleToRevoke,
      "roleToRevoke cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.objectName,
      "objectName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.objectSchema,
      "objectSchema cannot be null");
    roleToRevoke = builder.roleToRevoke;
    objectName = builder.objectName;
    objectSchema = builder.objectSchema;
  }

  /**
   * New builder.
   *
   * @return a RevokeRoleFromObjectV2Options builder
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
   * Gets the objectName.
   *
   * The virtualized table's name.
   *
   * @return the objectName
   */
  public String objectName() {
    return objectName;
  }

  /**
   * Gets the objectSchema.
   *
   * The virtualized table's schema name.
   *
   * @return the objectSchema
   */
  public String objectSchema() {
    return objectSchema;
  }
}

