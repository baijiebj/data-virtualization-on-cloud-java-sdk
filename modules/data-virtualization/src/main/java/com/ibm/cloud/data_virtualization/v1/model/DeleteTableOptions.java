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
 * The deleteTable options.
 */
public class DeleteTableOptions extends GenericModel {

  protected String virtualSchema;
  protected String virtualName;

  /**
   * Builder.
   */
  public static class Builder {
    private String virtualSchema;
    private String virtualName;

    private Builder(DeleteTableOptions deleteTableOptions) {
      this.virtualSchema = deleteTableOptions.virtualSchema;
      this.virtualName = deleteTableOptions.virtualName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param virtualSchema the virtualSchema
     * @param virtualName the virtualName
     */
    public Builder(String virtualSchema, String virtualName) {
      this.virtualSchema = virtualSchema;
      this.virtualName = virtualName;
    }

    /**
     * Builds a DeleteTableOptions.
     *
     * @return the new DeleteTableOptions instance
     */
    public DeleteTableOptions build() {
      return new DeleteTableOptions(this);
    }

    /**
     * Set the virtualSchema.
     *
     * @param virtualSchema the virtualSchema
     * @return the DeleteTableOptions builder
     */
    public Builder virtualSchema(String virtualSchema) {
      this.virtualSchema = virtualSchema;
      return this;
    }

    /**
     * Set the virtualName.
     *
     * @param virtualName the virtualName
     * @return the DeleteTableOptions builder
     */
    public Builder virtualName(String virtualName) {
      this.virtualName = virtualName;
      return this;
    }
  }

  protected DeleteTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualSchema,
      "virtualSchema cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.virtualName,
      "virtualName cannot be empty");
    virtualSchema = builder.virtualSchema;
    virtualName = builder.virtualName;
  }

  /**
   * New builder.
   *
   * @return a DeleteTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the virtualSchema.
   *
   * The schema of virtualized table to be deleted.
   *
   * @return the virtualSchema
   */
  public String virtualSchema() {
    return virtualSchema;
  }

  /**
   * Gets the virtualName.
   *
   * The name of virtualized table to be deleted.
   *
   * @return the virtualName
   */
  public String virtualName() {
    return virtualName;
  }
}

