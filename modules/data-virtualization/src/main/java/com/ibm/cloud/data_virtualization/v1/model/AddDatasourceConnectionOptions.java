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
 * The addDatasourceConnection options.
 */
public class AddDatasourceConnectionOptions extends GenericModel {

  protected String datasourceType;
  protected String name;
  protected String originCountry;
  protected PostDatasourceConnectionParametersV2Properties xProperties;
  protected String assetCategory;
  protected String remoteNodes;

  /**
   * Builder.
   */
  public static class Builder {
    private String datasourceType;
    private String name;
    private String originCountry;
    private PostDatasourceConnectionParametersV2Properties xProperties;
    private String assetCategory;
    private String remoteNodes;

    private Builder(AddDatasourceConnectionOptions addDatasourceConnectionOptions) {
      this.datasourceType = addDatasourceConnectionOptions.datasourceType;
      this.name = addDatasourceConnectionOptions.name;
      this.originCountry = addDatasourceConnectionOptions.originCountry;
      this.xProperties = addDatasourceConnectionOptions.xProperties;
      this.assetCategory = addDatasourceConnectionOptions.assetCategory;
      this.remoteNodes = addDatasourceConnectionOptions.remoteNodes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param datasourceType the datasourceType
     * @param name the name
     * @param originCountry the originCountry
     * @param xProperties the xProperties
     */
    public Builder(String datasourceType, String name, String originCountry, PostDatasourceConnectionParametersV2Properties xProperties) {
      this.datasourceType = datasourceType;
      this.name = name;
      this.originCountry = originCountry;
      this.xProperties = xProperties;
    }

    /**
     * Builds a AddDatasourceConnectionOptions.
     *
     * @return the new AddDatasourceConnectionOptions instance
     */
    public AddDatasourceConnectionOptions build() {
      return new AddDatasourceConnectionOptions(this);
    }

    /**
     * Set the datasourceType.
     *
     * @param datasourceType the datasourceType
     * @return the AddDatasourceConnectionOptions builder
     */
    public Builder datasourceType(String datasourceType) {
      this.datasourceType = datasourceType;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AddDatasourceConnectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the originCountry.
     *
     * @param originCountry the originCountry
     * @return the AddDatasourceConnectionOptions builder
     */
    public Builder originCountry(String originCountry) {
      this.originCountry = originCountry;
      return this;
    }

    /**
     * Set the xProperties.
     *
     * @param xProperties the xProperties
     * @return the AddDatasourceConnectionOptions builder
     */
    public Builder xProperties(PostDatasourceConnectionParametersV2Properties xProperties) {
      this.xProperties = xProperties;
      return this;
    }

    /**
     * Set the assetCategory.
     *
     * @param assetCategory the assetCategory
     * @return the AddDatasourceConnectionOptions builder
     */
    public Builder assetCategory(String assetCategory) {
      this.assetCategory = assetCategory;
      return this;
    }

    /**
     * Set the remoteNodes.
     *
     * @param remoteNodes the remoteNodes
     * @return the AddDatasourceConnectionOptions builder
     */
    public Builder remoteNodes(String remoteNodes) {
      this.remoteNodes = remoteNodes;
      return this;
    }
  }

  protected AddDatasourceConnectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.datasourceType,
      "datasourceType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.originCountry,
      "originCountry cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xProperties,
      "xProperties cannot be null");
    datasourceType = builder.datasourceType;
    name = builder.name;
    originCountry = builder.originCountry;
    xProperties = builder.xProperties;
    assetCategory = builder.assetCategory;
    remoteNodes = builder.remoteNodes;
  }

  /**
   * New builder.
   *
   * @return a AddDatasourceConnectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the datasourceType.
   *
   * The type of data source that you want to add.
   *
   * @return the datasourceType
   */
  public String datasourceType() {
    return datasourceType;
  }

  /**
   * Gets the name.
   *
   * The name of data source.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the originCountry.
   *
   * The location of data source that you want to add.
   *
   * @return the originCountry
   */
  public String originCountry() {
    return originCountry;
  }

  /**
   * Gets the xProperties.
   *
   * @return the xProperties
   */
  public PostDatasourceConnectionParametersV2Properties xProperties() {
    return xProperties;
  }

  /**
   * Gets the assetCategory.
   *
   * @return the assetCategory
   */
  public String assetCategory() {
    return assetCategory;
  }

  /**
   * Gets the remoteNodes.
   *
   * The remote connector to associate to the data source.
   *
   * @return the remoteNodes
   */
  public String remoteNodes() {
    return remoteNodes;
  }
}

