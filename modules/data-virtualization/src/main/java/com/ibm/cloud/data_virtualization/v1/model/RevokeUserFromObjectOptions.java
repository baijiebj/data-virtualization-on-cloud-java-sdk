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
  protected String objectName;
  protected String objectSchema;

  /**
   * Builder.
   */
  public static class Builder {
    private String authid;
    private String objectName;
    private String objectSchema;

    private Builder(RevokeUserFromObjectOptions revokeUserFromObjectOptions) {
      this.authid = revokeUserFromObjectOptions.authid;
      this.objectName = revokeUserFromObjectOptions.objectName;
      this.objectSchema = revokeUserFromObjectOptions.objectSchema;
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
     * @param objectName the objectName
     * @param objectSchema the objectSchema
     */
    public Builder(String authid, String objectName, String objectSchema) {
      this.authid = authid;
      this.objectName = objectName;
      this.objectSchema = objectSchema;
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
     * Set the objectName.
     *
     * @param objectName the objectName
     * @return the RevokeUserFromObjectOptions builder
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }

    /**
     * Set the objectSchema.
     *
     * @param objectSchema the objectSchema
     * @return the RevokeUserFromObjectOptions builder
     */
    public Builder objectSchema(String objectSchema) {
      this.objectSchema = objectSchema;
      return this;
    }
  }

  protected RevokeUserFromObjectOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.authid,
      "authid cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.objectName,
      "objectName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.objectSchema,
      "objectSchema cannot be null");
    authid = builder.authid;
    objectName = builder.objectName;
    objectSchema = builder.objectSchema;
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

