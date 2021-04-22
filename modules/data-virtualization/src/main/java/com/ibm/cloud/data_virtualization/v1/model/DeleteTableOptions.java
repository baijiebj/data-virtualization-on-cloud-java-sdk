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

  protected String schemaName;
  protected String objectName;

  /**
   * Builder.
   */
  public static class Builder {
    private String schemaName;
    private String objectName;

    private Builder(DeleteTableOptions deleteTableOptions) {
      this.schemaName = deleteTableOptions.schemaName;
      this.objectName = deleteTableOptions.objectName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param schemaName the schemaName
     * @param objectName the objectName
     */
    public Builder(String schemaName, String objectName) {
      this.schemaName = schemaName;
      this.objectName = objectName;
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
     * Set the schemaName.
     *
     * @param schemaName the schemaName
     * @return the DeleteTableOptions builder
     */
    public Builder schemaName(String schemaName) {
      this.schemaName = schemaName;
      return this;
    }

    /**
     * Set the objectName.
     *
     * @param objectName the objectName
     * @return the DeleteTableOptions builder
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }
  }

  protected DeleteTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.schemaName,
      "schemaName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.objectName,
      "objectName cannot be empty");
    schemaName = builder.schemaName;
    objectName = builder.objectName;
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
   * Gets the schemaName.
   *
   * The schema of table to be deleted.
   *
   * @return the schemaName
   */
  public String schemaName() {
    return schemaName;
  }

  /**
   * Gets the objectName.
   *
   * The name of table to be deleted.
   *
   * @return the objectName
   */
  public String objectName() {
    return objectName;
  }
}

