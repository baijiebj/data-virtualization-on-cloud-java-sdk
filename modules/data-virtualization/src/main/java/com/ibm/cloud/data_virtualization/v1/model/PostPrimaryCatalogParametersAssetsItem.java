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
 * PostPrimaryCatalogParametersAssetsItem.
 */
public class PostPrimaryCatalogParametersAssetsItem extends GenericModel {

  protected String schema;
  protected String table;

  /**
   * Builder.
   */
  public static class Builder {
    private String schema;
    private String table;

    private Builder(PostPrimaryCatalogParametersAssetsItem postPrimaryCatalogParametersAssetsItem) {
      this.schema = postPrimaryCatalogParametersAssetsItem.schema;
      this.table = postPrimaryCatalogParametersAssetsItem.table;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param schema the schema
     * @param table the table
     */
    public Builder(String schema, String table) {
      this.schema = schema;
      this.table = table;
    }

    /**
     * Builds a PostPrimaryCatalogParametersAssetsItem.
     *
     * @return the new PostPrimaryCatalogParametersAssetsItem instance
     */
    public PostPrimaryCatalogParametersAssetsItem build() {
      return new PostPrimaryCatalogParametersAssetsItem(this);
    }

    /**
     * Set the schema.
     *
     * @param schema the schema
     * @return the PostPrimaryCatalogParametersAssetsItem builder
     */
    public Builder schema(String schema) {
      this.schema = schema;
      return this;
    }

    /**
     * Set the table.
     *
     * @param table the table
     * @return the PostPrimaryCatalogParametersAssetsItem builder
     */
    public Builder table(String table) {
      this.table = table;
      return this;
    }
  }

  protected PostPrimaryCatalogParametersAssetsItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.schema,
      "schema cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.table,
      "table cannot be null");
    schema = builder.schema;
    table = builder.table;
  }

  /**
   * New builder.
   *
   * @return a PostPrimaryCatalogParametersAssetsItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the schema.
   *
   * @return the schema
   */
  public String schema() {
    return schema;
  }

  /**
   * Gets the table.
   *
   * @return the table
   */
  public String table() {
    return table;
  }
}

