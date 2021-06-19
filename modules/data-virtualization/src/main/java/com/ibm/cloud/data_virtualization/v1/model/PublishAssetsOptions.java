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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The publishAssets options.
 */
public class PublishAssetsOptions extends GenericModel {

  protected String catalogId;
  protected Boolean allowDuplicates;
  protected List<PostPrimaryCatalogParametersAssetsItem> assets;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogId;
    private Boolean allowDuplicates;
    private List<PostPrimaryCatalogParametersAssetsItem> assets;

    private Builder(PublishAssetsOptions publishAssetsOptions) {
      this.catalogId = publishAssetsOptions.catalogId;
      this.allowDuplicates = publishAssetsOptions.allowDuplicates;
      this.assets = publishAssetsOptions.assets;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param catalogId the catalogId
     * @param allowDuplicates the allowDuplicates
     * @param assets the assets
     */
    public Builder(String catalogId, Boolean allowDuplicates, List<PostPrimaryCatalogParametersAssetsItem> assets) {
      this.catalogId = catalogId;
      this.allowDuplicates = allowDuplicates;
      this.assets = assets;
    }

    /**
     * Builds a PublishAssetsOptions.
     *
     * @return the new PublishAssetsOptions instance
     */
    public PublishAssetsOptions build() {
      return new PublishAssetsOptions(this);
    }

    /**
     * Adds an assets to assets.
     *
     * @param assets the new assets
     * @return the PublishAssetsOptions builder
     */
    public Builder addAssets(PostPrimaryCatalogParametersAssetsItem assets) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(assets,
        "assets cannot be null");
      if (this.assets == null) {
        this.assets = new ArrayList<PostPrimaryCatalogParametersAssetsItem>();
      }
      this.assets.add(assets);
      return this;
    }

    /**
     * Set the catalogId.
     *
     * @param catalogId the catalogId
     * @return the PublishAssetsOptions builder
     */
    public Builder catalogId(String catalogId) {
      this.catalogId = catalogId;
      return this;
    }

    /**
     * Set the allowDuplicates.
     *
     * @param allowDuplicates the allowDuplicates
     * @return the PublishAssetsOptions builder
     */
    public Builder allowDuplicates(Boolean allowDuplicates) {
      this.allowDuplicates = allowDuplicates;
      return this;
    }

    /**
     * Set the assets.
     * Existing assets will be replaced.
     *
     * @param assets the assets
     * @return the PublishAssetsOptions builder
     */
    public Builder assets(List<PostPrimaryCatalogParametersAssetsItem> assets) {
      this.assets = assets;
      return this;
    }
  }

  protected PublishAssetsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.catalogId,
      "catalogId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.allowDuplicates,
      "allowDuplicates cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.assets,
      "assets cannot be null");
    catalogId = builder.catalogId;
    allowDuplicates = builder.allowDuplicates;
    assets = builder.assets;
  }

  /**
   * New builder.
   *
   * @return a PublishAssetsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalogId.
   *
   * @return the catalogId
   */
  public String catalogId() {
    return catalogId;
  }

  /**
   * Gets the allowDuplicates.
   *
   * The type of data source that you want to add.
   *
   * @return the allowDuplicates
   */
  public Boolean allowDuplicates() {
    return allowDuplicates;
  }

  /**
   * Gets the assets.
   *
   * @return the assets
   */
  public List<PostPrimaryCatalogParametersAssetsItem> assets() {
    return assets;
  }
}

