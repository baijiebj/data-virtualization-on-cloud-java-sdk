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
 * The dvaasVirtualizeTable options.
 */
public class DvaasVirtualizeTableOptions extends GenericModel {

  protected String sourceName;
  protected List<VirtualizeTableParameterSourceTableDefItem> sourceTableDef;
  protected List<String> sources;
  protected String virtualName;
  protected String virtualSchema;
  protected List<VirtualizeTableParameterVirtualTableDefItem> virtualTableDef;
  protected String isIncludedColumns;
  protected Boolean replace;

  /**
   * Builder.
   */
  public static class Builder {
    private String sourceName;
    private List<VirtualizeTableParameterSourceTableDefItem> sourceTableDef;
    private List<String> sources;
    private String virtualName;
    private String virtualSchema;
    private List<VirtualizeTableParameterVirtualTableDefItem> virtualTableDef;
    private String isIncludedColumns;
    private Boolean replace;

    private Builder(DvaasVirtualizeTableOptions dvaasVirtualizeTableOptions) {
      this.sourceName = dvaasVirtualizeTableOptions.sourceName;
      this.sourceTableDef = dvaasVirtualizeTableOptions.sourceTableDef;
      this.sources = dvaasVirtualizeTableOptions.sources;
      this.virtualName = dvaasVirtualizeTableOptions.virtualName;
      this.virtualSchema = dvaasVirtualizeTableOptions.virtualSchema;
      this.virtualTableDef = dvaasVirtualizeTableOptions.virtualTableDef;
      this.isIncludedColumns = dvaasVirtualizeTableOptions.isIncludedColumns;
      this.replace = dvaasVirtualizeTableOptions.replace;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param sourceName the sourceName
     * @param sourceTableDef the sourceTableDef
     * @param sources the sources
     * @param virtualName the virtualName
     * @param virtualSchema the virtualSchema
     * @param virtualTableDef the virtualTableDef
     */
    public Builder(String sourceName, List<VirtualizeTableParameterSourceTableDefItem> sourceTableDef, List<String> sources, String virtualName, String virtualSchema, List<VirtualizeTableParameterVirtualTableDefItem> virtualTableDef) {
      this.sourceName = sourceName;
      this.sourceTableDef = sourceTableDef;
      this.sources = sources;
      this.virtualName = virtualName;
      this.virtualSchema = virtualSchema;
      this.virtualTableDef = virtualTableDef;
    }

    /**
     * Builds a DvaasVirtualizeTableOptions.
     *
     * @return the new DvaasVirtualizeTableOptions instance
     */
    public DvaasVirtualizeTableOptions build() {
      return new DvaasVirtualizeTableOptions(this);
    }

    /**
     * Adds an sourceTableDef to sourceTableDef.
     *
     * @param sourceTableDef the new sourceTableDef
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder addSourceTableDef(VirtualizeTableParameterSourceTableDefItem sourceTableDef) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sourceTableDef,
        "sourceTableDef cannot be null");
      if (this.sourceTableDef == null) {
        this.sourceTableDef = new ArrayList<VirtualizeTableParameterSourceTableDefItem>();
      }
      this.sourceTableDef.add(sourceTableDef);
      return this;
    }

    /**
     * Adds an sources to sources.
     *
     * @param sources the new sources
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder addSources(String sources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sources,
        "sources cannot be null");
      if (this.sources == null) {
        this.sources = new ArrayList<String>();
      }
      this.sources.add(sources);
      return this;
    }

    /**
     * Adds an virtualTableDef to virtualTableDef.
     *
     * @param virtualTableDef the new virtualTableDef
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder addVirtualTableDef(VirtualizeTableParameterVirtualTableDefItem virtualTableDef) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(virtualTableDef,
        "virtualTableDef cannot be null");
      if (this.virtualTableDef == null) {
        this.virtualTableDef = new ArrayList<VirtualizeTableParameterVirtualTableDefItem>();
      }
      this.virtualTableDef.add(virtualTableDef);
      return this;
    }

    /**
     * Set the sourceName.
     *
     * @param sourceName the sourceName
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder sourceName(String sourceName) {
      this.sourceName = sourceName;
      return this;
    }

    /**
     * Set the sourceTableDef.
     * Existing sourceTableDef will be replaced.
     *
     * @param sourceTableDef the sourceTableDef
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder sourceTableDef(List<VirtualizeTableParameterSourceTableDefItem> sourceTableDef) {
      this.sourceTableDef = sourceTableDef;
      return this;
    }

    /**
     * Set the sources.
     * Existing sources will be replaced.
     *
     * @param sources the sources
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder sources(List<String> sources) {
      this.sources = sources;
      return this;
    }

    /**
     * Set the virtualName.
     *
     * @param virtualName the virtualName
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder virtualName(String virtualName) {
      this.virtualName = virtualName;
      return this;
    }

    /**
     * Set the virtualSchema.
     *
     * @param virtualSchema the virtualSchema
     * @return the DvaasVirtualizeTableOptions builder
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
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder virtualTableDef(List<VirtualizeTableParameterVirtualTableDefItem> virtualTableDef) {
      this.virtualTableDef = virtualTableDef;
      return this;
    }

    /**
     * Set the isIncludedColumns.
     *
     * @param isIncludedColumns the isIncludedColumns
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder isIncludedColumns(String isIncludedColumns) {
      this.isIncludedColumns = isIncludedColumns;
      return this;
    }

    /**
     * Set the replace.
     *
     * @param replace the replace
     * @return the DvaasVirtualizeTableOptions builder
     */
    public Builder replace(Boolean replace) {
      this.replace = replace;
      return this;
    }
  }

  protected DvaasVirtualizeTableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.sourceName,
      "sourceName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.sourceTableDef,
      "sourceTableDef cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.sources,
      "sources cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualName,
      "virtualName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualSchema,
      "virtualSchema cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.virtualTableDef,
      "virtualTableDef cannot be null");
    sourceName = builder.sourceName;
    sourceTableDef = builder.sourceTableDef;
    sources = builder.sources;
    virtualName = builder.virtualName;
    virtualSchema = builder.virtualSchema;
    virtualTableDef = builder.virtualTableDef;
    isIncludedColumns = builder.isIncludedColumns;
    replace = builder.replace;
  }

  /**
   * New builder.
   *
   * @return a DvaasVirtualizeTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sourceName.
   *
   * The name of the source table.
   *
   * @return the sourceName
   */
  public String sourceName() {
    return sourceName;
  }

  /**
   * Gets the sourceTableDef.
   *
   * @return the sourceTableDef
   */
  public List<VirtualizeTableParameterSourceTableDefItem> sourceTableDef() {
    return sourceTableDef;
  }

  /**
   * Gets the sources.
   *
   * @return the sources
   */
  public List<String> sources() {
    return sources;
  }

  /**
   * Gets the virtualName.
   *
   * The name of the table that will be virtualized.
   *
   * @return the virtualName
   */
  public String virtualName() {
    return virtualName;
  }

  /**
   * Gets the virtualSchema.
   *
   * The schema of the table that will be virtualized.
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
  public List<VirtualizeTableParameterVirtualTableDefItem> virtualTableDef() {
    return virtualTableDef;
  }

  /**
   * Gets the isIncludedColumns.
   *
   * The columns that are included in the source table.
   *
   * @return the isIncludedColumns
   */
  public String isIncludedColumns() {
    return isIncludedColumns;
  }

  /**
   * Gets the replace.
   *
   * Determines whether to replace columns in the virtualized table.
   *
   * @return the replace
   */
  public Boolean replace() {
    return replace;
  }
}

