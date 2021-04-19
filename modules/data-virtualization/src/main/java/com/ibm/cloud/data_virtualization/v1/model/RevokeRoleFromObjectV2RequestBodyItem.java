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
 * RevokeRoleFromObjectV2RequestBodyItem.
 */
public class RevokeRoleFromObjectV2RequestBodyItem extends GenericModel {

  @SerializedName("object_name")
  protected String objectName;
  @SerializedName("object_schema")
  protected String objectSchema;
  @SerializedName("role_to_revoke")
  protected String roleToRevoke;

  /**
   * Builder.
   */
  public static class Builder {
    private String objectName;
    private String objectSchema;
    private String roleToRevoke;

    private Builder(RevokeRoleFromObjectV2RequestBodyItem revokeRoleFromObjectV2RequestBodyItem) {
      this.objectName = revokeRoleFromObjectV2RequestBodyItem.objectName;
      this.objectSchema = revokeRoleFromObjectV2RequestBodyItem.objectSchema;
      this.roleToRevoke = revokeRoleFromObjectV2RequestBodyItem.roleToRevoke;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RevokeRoleFromObjectV2RequestBodyItem.
     *
     * @return the new RevokeRoleFromObjectV2RequestBodyItem instance
     */
    public RevokeRoleFromObjectV2RequestBodyItem build() {
      return new RevokeRoleFromObjectV2RequestBodyItem(this);
    }

    /**
     * Set the objectName.
     *
     * @param objectName the objectName
     * @return the RevokeRoleFromObjectV2RequestBodyItem builder
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }

    /**
     * Set the objectSchema.
     *
     * @param objectSchema the objectSchema
     * @return the RevokeRoleFromObjectV2RequestBodyItem builder
     */
    public Builder objectSchema(String objectSchema) {
      this.objectSchema = objectSchema;
      return this;
    }

    /**
     * Set the roleToRevoke.
     *
     * @param roleToRevoke the roleToRevoke
     * @return the RevokeRoleFromObjectV2RequestBodyItem builder
     */
    public Builder roleToRevoke(String roleToRevoke) {
      this.roleToRevoke = roleToRevoke;
      return this;
    }
  }

  protected RevokeRoleFromObjectV2RequestBodyItem(Builder builder) {
    objectName = builder.objectName;
    objectSchema = builder.objectSchema;
    roleToRevoke = builder.roleToRevoke;
  }

  /**
   * New builder.
   *
   * @return a RevokeRoleFromObjectV2RequestBodyItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the objectName.
   *
   * The name of the virtual object.
   *
   * @return the objectName
   */
  public String objectName() {
    return objectName;
  }

  /**
   * Gets the objectSchema.
   *
   * The schema of the virtual object.
   *
   * @return the objectSchema
   */
  public String objectSchema() {
    return objectSchema;
  }

  /**
   * Gets the roleToRevoke.
   *
   * The role to revoke from the user.
   *
   * @return the roleToRevoke
   */
  public String roleToRevoke() {
    return roleToRevoke;
  }
}

