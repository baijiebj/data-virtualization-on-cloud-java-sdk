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
 * The deleteDatasourceConnection options.
 */
public class DeleteDatasourceConnectionOptions extends GenericModel {

  protected String cid;
  protected String connectionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String cid;
    private String connectionId;

    private Builder(DeleteDatasourceConnectionOptions deleteDatasourceConnectionOptions) {
      this.cid = deleteDatasourceConnectionOptions.cid;
      this.connectionId = deleteDatasourceConnectionOptions.connectionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param cid the cid
     * @param connectionId the connectionId
     */
    public Builder(String cid, String connectionId) {
      this.cid = cid;
      this.connectionId = connectionId;
    }

    /**
     * Builds a DeleteDatasourceConnectionOptions.
     *
     * @return the new DeleteDatasourceConnectionOptions instance
     */
    public DeleteDatasourceConnectionOptions build() {
      return new DeleteDatasourceConnectionOptions(this);
    }

    /**
     * Set the cid.
     *
     * @param cid the cid
     * @return the DeleteDatasourceConnectionOptions builder
     */
    public Builder cid(String cid) {
      this.cid = cid;
      return this;
    }

    /**
     * Set the connectionId.
     *
     * @param connectionId the connectionId
     * @return the DeleteDatasourceConnectionOptions builder
     */
    public Builder connectionId(String connectionId) {
      this.connectionId = connectionId;
      return this;
    }
  }

  protected DeleteDatasourceConnectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cid,
      "cid cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.connectionId,
      "connectionId cannot be null");
    cid = builder.cid;
    connectionId = builder.connectionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteDatasourceConnectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the cid.
   *
   * The identifier of the connection.
   *
   * @return the cid
   */
  public String cid() {
    return cid;
  }

  /**
   * Gets the connectionId.
   *
   * The name of the connection.
   *
   * @return the connectionId
   */
  public String connectionId() {
    return connectionId;
  }
}

