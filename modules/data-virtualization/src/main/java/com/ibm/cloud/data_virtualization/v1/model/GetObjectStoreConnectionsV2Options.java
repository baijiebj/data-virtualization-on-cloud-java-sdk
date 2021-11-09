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
 * The getObjectStoreConnectionsV2 options.
 */
public class GetObjectStoreConnectionsV2Options extends GenericModel {

  protected String jwtAuthUserPayload;

  /**
   * Builder.
   */
  public static class Builder {
    private String jwtAuthUserPayload;

    private Builder(GetObjectStoreConnectionsV2Options getObjectStoreConnectionsV2Options) {
      this.jwtAuthUserPayload = getObjectStoreConnectionsV2Options.jwtAuthUserPayload;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetObjectStoreConnectionsV2Options.
     *
     * @return the new GetObjectStoreConnectionsV2Options instance
     */
    public GetObjectStoreConnectionsV2Options build() {
      return new GetObjectStoreConnectionsV2Options(this);
    }

    /**
     * Set the jwtAuthUserPayload.
     *
     * @param jwtAuthUserPayload the jwtAuthUserPayload
     * @return the GetObjectStoreConnectionsV2Options builder
     */
    public Builder jwtAuthUserPayload(String jwtAuthUserPayload) {
      this.jwtAuthUserPayload = jwtAuthUserPayload;
      return this;
    }
  }

  protected GetObjectStoreConnectionsV2Options(Builder builder) {
    jwtAuthUserPayload = builder.jwtAuthUserPayload;
  }

  /**
   * New builder.
   *
   * @return a GetObjectStoreConnectionsV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

