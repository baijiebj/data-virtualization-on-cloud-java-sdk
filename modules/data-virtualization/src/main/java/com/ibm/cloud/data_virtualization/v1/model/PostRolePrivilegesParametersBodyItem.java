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
 * PostRolePrivilegesParametersBodyItem.
 */
public class PostRolePrivilegesParametersBodyItem extends GenericModel {

  @SerializedName("object_name")
  protected String objectName;
  @SerializedName("object_schema")
  protected String objectSchema;
  @SerializedName("role_to_grant")
  protected String roleToGrant;

  /**
   * Builder.
   */
  public static class Builder {
    private String objectName;
    private String objectSchema;
    private String roleToGrant;

    private Builder(PostRolePrivilegesParametersBodyItem postRolePrivilegesParametersBodyItem) {
      this.objectName = postRolePrivilegesParametersBodyItem.objectName;
      this.objectSchema = postRolePrivilegesParametersBodyItem.objectSchema;
      this.roleToGrant = postRolePrivilegesParametersBodyItem.roleToGrant;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostRolePrivilegesParametersBodyItem.
     *
     * @return the new PostRolePrivilegesParametersBodyItem instance
     */
    public PostRolePrivilegesParametersBodyItem build() {
      return new PostRolePrivilegesParametersBodyItem(this);
    }

    /**
     * Set the objectName.
     *
     * @param objectName the objectName
     * @return the PostRolePrivilegesParametersBodyItem builder
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }

    /**
     * Set the objectSchema.
     *
     * @param objectSchema the objectSchema
     * @return the PostRolePrivilegesParametersBodyItem builder
     */
    public Builder objectSchema(String objectSchema) {
      this.objectSchema = objectSchema;
      return this;
    }

    /**
     * Set the roleToGrant.
     *
     * @param roleToGrant the roleToGrant
     * @return the PostRolePrivilegesParametersBodyItem builder
     */
    public Builder roleToGrant(String roleToGrant) {
      this.roleToGrant = roleToGrant;
      return this;
    }
  }

  protected PostRolePrivilegesParametersBodyItem(Builder builder) {
    objectName = builder.objectName;
    objectSchema = builder.objectSchema;
    roleToGrant = builder.roleToGrant;
  }

  /**
   * New builder.
   *
   * @return a PostRolePrivilegesParametersBodyItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the objectName.
   *
   * The name of the virtualized table.
   *
   * @return the objectName
   */
  public String objectName() {
    return objectName;
  }

  /**
   * Gets the objectSchema.
   *
   * The schema of the virtualized table.
   *
   * @return the objectSchema
   */
  public String objectSchema() {
    return objectSchema;
  }

  /**
   * Gets the roleToGrant.
   *
   * The identifier of the authorization, if grant access to all users, the value is PUBLIC, othervise the value is the
   * data virtualization username.
   *
   * @return the roleToGrant
   */
  public String roleToGrant() {
    return roleToGrant;
  }
}

