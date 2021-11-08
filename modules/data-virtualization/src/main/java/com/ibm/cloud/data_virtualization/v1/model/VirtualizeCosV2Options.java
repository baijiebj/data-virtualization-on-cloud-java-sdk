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
 * The virtualizeCosV2 options.
 */
public class VirtualizeCosV2Options extends GenericModel {

  protected String url;
  protected String virtualName;
  protected String virtualSchema;
  protected List<VirtualizeCosV2RequestVirtualTableDefItem> virtualTableDef;
  protected Boolean isReplace;
  protected String options;
  protected String jwtAuthUserPayload;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String virtualName;
    private String virtualSchema;
    private List<VirtualizeCosV2RequestVirtualTableDefItem> virtualTableDef;
    private Boolean isReplace;
    private String options;
    private String jwtAuthUserPayload;

    private Builder(VirtualizeCosV2Options virtualizeCosV2Options) {
      this.url = virtualizeCosV2Options.url;
      this.virtualName = virtualizeCosV2Options.virtualName;
      this.virtualSchema = virtualizeCosV2Options.virtualSchema;
      this.virtualTableDef = virtualizeCosV2Options.virtualTableDef;
      this.isReplace = virtualizeCosV2Options.isReplace;
      this.options = virtualizeCosV2Options.options;
      this.jwtAuthUserPayload = virtualizeCosV2Options.jwtAuthUserPayload;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     * @param virtualName the virtualName
     * @param virtualSchema the virtualSchema
     * @param virtualTableDef the virtualTableDef
     */
    public Builder(String url, String virtualName, String virtualSchema, List<VirtualizeCosV2RequestVirtualTableDefItem> virtualTableDef) {
      this.url = url;
      this.virtualName = virtualName;
      this.virtualSchema = virtualSchema;
      this.virtualTableDef = virtualTableDef;
    }

    /**
     * Builds a VirtualizeCosV2Options.
     *
     * @return the new VirtualizeCosV2Options instance
     */
    public VirtualizeCosV2Options build() {
      return new VirtualizeCosV2Options(this);
    }

    /**
     * Adds an virtualTableDef to virtualTableDef.
     *
     * @param virtualTableDef the new virtualTableDef
     * @return the VirtualizeCosV2Options builder
     */
    public Builder addVirtualTableDef(VirtualizeCosV2RequestVirtualTableDefItem virtualTableDef) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(virtualTableDef,
        "virtualTableDef cannot be null");
      if (this.virtualTableDef == null) {
        this.virtualTableDef = new ArrayList<VirtualizeCosV2RequestVirtualTableDefItem>();
      }
      this.virtualTableDef.add(virtualTableDef);
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the VirtualizeCosV2Options builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the virtualName.
     *
     * @param virtualName the virtualName
     * @return the VirtualizeCosV2Options builder
     */
    public Builder virtualName(String virtualName) {
      this.virtualName = virtualName;
      return this;
    }

    /**
     * Set the virtualSchema.
     *
     * @param virtualSchema the virtualSchema
     * @return the VirtualizeCosV2Options builder
     */
    public Builder virtualSchema(String virtualSchema) {
      this.virtualSchema = virtualSchema;
      return this;
    }

    /**
     * Set the virtualTableDef.
     * Existing virtualTableDef will be replaced.
     *
     * @param virtualTableDef the virtualTableDef
     * @return the VirtualizeCosV2Options builder
     */
    public Builder virtualTableDef(List<VirtualizeCosV2RequestVirtualTableDefItem> virtualTableDef) {
      this.virtualTableDef = virtualTableDef;
      return this;
    }

    /**
     * Set the isReplace.
     *
     * @param isReplace the isReplace
     * @return the VirtualizeCosV2Options builder
     */
    public Builder isReplace(Boolean isReplace) {
      this.isReplace = isReplace;
      return this;
    }

    /**
     * Set the options.
     *
     * @param options the options
     * @return the VirtualizeCosV2Options builder
     */
    public Builder options(String options) {
      this.options = options;
      return this;
    }

    /**
     * Set the jwtAuthUserPayload.
     *
     * @param jwtAuthUserPayload the jwtAuthUserPayload
     * @return the VirtualizeCosV2Options builder
     */
    public Builder jwtAuthUserPayload(String jwtAuthUserPayload) {
      this.jwtAuthUserPayload = jwtAuthUserPayload;
      return this;
    }
  }

  protected VirtualizeCosV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url,
      "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualName,
      "virtualName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualSchema,
      "virtualSchema cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualTableDef,
      "virtualTableDef cannot be null");
    url = builder.url;
    virtualName = builder.virtualName;
    virtualSchema = builder.virtualSchema;
    virtualTableDef = builder.virtualTableDef;
    isReplace = builder.isReplace;
    options = builder.options;
    jwtAuthUserPayload = builder.jwtAuthUserPayload;
  }

  /**
   * New builder.
   *
   * @return a VirtualizeCosV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * the file path with bucket name.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the virtualName.
   *
   * the virtual table name.
   *
   * @return the virtualName
   */
  public String virtualName() {
    return virtualName;
  }

  /**
   * Gets the virtualSchema.
   *
   * the virtual table schema.
   *
   * @return the virtualSchema
   */
  public String virtualSchema() {
    return virtualSchema;
  }

  /**
   * Gets the virtualTableDef.
   *
   * @return the virtualTableDef
   */
  public List<VirtualizeCosV2RequestVirtualTableDefItem> virtualTableDef() {
    return virtualTableDef;
  }

  /**
   * Gets the isReplace.
   *
   * if repalce the existing one when create the virtual table.
   *
   * @return the isReplace
   */
  public Boolean isReplace() {
    return isReplace;
  }

  /**
   * Gets the options.
   *
   * the options used to virtualize file.
   *
   * @return the options
   */
  public String options() {
    return options;
  }

  /**
   * Gets the jwtAuthUserPayload.
   *
   * Supplied by proxy.  Do NOT add your own value.
   *
   * @return the jwtAuthUserPayload
   */
  public String jwtAuthUserPayload() {
    return jwtAuthUserPayload;
  }
}

