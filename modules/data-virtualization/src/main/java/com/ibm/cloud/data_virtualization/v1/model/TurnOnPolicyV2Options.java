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
 * The turnOnPolicyV2 options.
 */
public class TurnOnPolicyV2Options extends GenericModel {

  protected String status;

  /**
   * Builder.
   */
  public static class Builder {
    private String status;

    private Builder(TurnOnPolicyV2Options turnOnPolicyV2Options) {
      this.status = turnOnPolicyV2Options.status;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param status the status
     */
    public Builder(String status) {
      this.status = status;
    }

    /**
     * Builds a TurnOnPolicyV2Options.
     *
     * @return the new TurnOnPolicyV2Options instance
     */
    public TurnOnPolicyV2Options build() {
      return new TurnOnPolicyV2Options(this);
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the TurnOnPolicyV2Options builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }
  }

  protected TurnOnPolicyV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.status,
      "status cannot be null");
    status = builder.status;
  }

  /**
   * New builder.
   *
   * @return a TurnOnPolicyV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the status.
   *
   * Set the status of WKC policy.
   *
   * @return the status
   */
  public String status() {
    return status;
  }
}

