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
 * RevokeUserFromObjectRequestBodyItem.
 */
public class RevokeUserFromObjectRequestBodyItem extends GenericModel {

  @SerializedName("object_name")
  protected String objectName;
  @SerializedName("object_schema")
  protected String objectSchema;
  protected String authid;

  /**
   * Builder.
   */
  public static class Builder {
    private String objectName;
    private String objectSchema;
    private String authid;

    private Builder(RevokeUserFromObjectRequestBodyItem revokeUserFromObjectRequestBodyItem) {
      this.objectName = revokeUserFromObjectRequestBodyItem.objectName;
      this.objectSchema = revokeUserFromObjectRequestBodyItem.objectSchema;
      this.authid = revokeUserFromObjectRequestBodyItem.authid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RevokeUserFromObjectRequestBodyItem.
     *
     * @return the new RevokeUserFromObjectRequestBodyItem instance
     */
    public RevokeUserFromObjectRequestBodyItem build() {
      return new RevokeUserFromObjectRequestBodyItem(this);
    }

    /**
     * Set the objectName.
     *
     * @param objectName the objectName
     * @return the RevokeUserFromObjectRequestBodyItem builder
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }

    /**
     * Set the objectSchema.
     *
     * @param objectSchema the objectSchema
     * @return the RevokeUserFromObjectRequestBodyItem builder
     */
    public Builder objectSchema(String objectSchema) {
      this.objectSchema = objectSchema;
      return this;
    }

    /**
     * Set the authid.
     *
     * @param authid the authid
     * @return the RevokeUserFromObjectRequestBodyItem builder
     */
    public Builder authid(String authid) {
      this.authid = authid;
      return this;
    }
  }

  protected RevokeUserFromObjectRequestBodyItem(Builder builder) {
    objectName = builder.objectName;
    objectSchema = builder.objectSchema;
    authid = builder.authid;
  }

  /**
   * New builder.
   *
   * @return a RevokeUserFromObjectRequestBodyItem builder
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
   * Gets the authid.
   *
   * The identifier of the authorization.
   *
   * @return the authid
   */
  public String authid() {
    return authid;
  }
}

