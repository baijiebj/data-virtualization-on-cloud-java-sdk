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
 * The deletePrimaryCatalog options.
 */
public class DeletePrimaryCatalogOptions extends GenericModel {

  protected String guid;

  /**
   * Builder.
   */
  public static class Builder {
    private String guid;

    private Builder(DeletePrimaryCatalogOptions deletePrimaryCatalogOptions) {
      this.guid = deletePrimaryCatalogOptions.guid;
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
     * Builds a DeletePrimaryCatalogOptions.
     *
     * @return the new DeletePrimaryCatalogOptions instance
     */
    public DeletePrimaryCatalogOptions build() {
      return new DeletePrimaryCatalogOptions(this);
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the DeletePrimaryCatalogOptions builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }
  }

  protected DeletePrimaryCatalogOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.guid,
      "guid cannot be null");
    guid = builder.guid;
  }

  /**
   * New builder.
   *
   * @return a DeletePrimaryCatalogOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the guid.
   *
   * The Data Virtualization user name, if the value is PUBLIC, it means revoke access privilege from all Data
   * Virtualization users.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }
}

