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
 * The postPrimaryCatalog options.
 */
public class PostPrimaryCatalogOptions extends GenericModel {

  protected String guid;

  /**
   * Builder.
   */
  public static class Builder {
    private String guid;

    private Builder(PostPrimaryCatalogOptions postPrimaryCatalogOptions) {
      this.guid = postPrimaryCatalogOptions.guid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param guid the guid
     */
    public Builder(String guid) {
      this.guid = guid;
    }

    /**
     * Builds a PostPrimaryCatalogOptions.
     *
     * @return the new PostPrimaryCatalogOptions instance
     */
    public PostPrimaryCatalogOptions build() {
      return new PostPrimaryCatalogOptions(this);
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the PostPrimaryCatalogOptions builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }
  }

  protected PostPrimaryCatalogOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.guid,
      "guid cannot be null");
    guid = builder.guid;
  }

  /**
   * New builder.
   *
   * @return a PostPrimaryCatalogOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the guid.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }
}

