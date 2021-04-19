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
 * The grantUserToObject options.
 */
public class GrantUserToObjectOptions extends GenericModel {

  protected List<GrantUserToObjectRequestBodyItem> body;

  /**
   * Builder.
   */
  public static class Builder {
    private List<GrantUserToObjectRequestBodyItem> body;

    private Builder(GrantUserToObjectOptions grantUserToObjectOptions) {
      this.body = grantUserToObjectOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param body the body
     */
    public Builder(List<GrantUserToObjectRequestBodyItem> body) {
      this.body = body;
    }

    /**
     * Builds a GrantUserToObjectOptions.
     *
     * @return the new GrantUserToObjectOptions instance
     */
    public GrantUserToObjectOptions build() {
      return new GrantUserToObjectOptions(this);
    }

    /**
     * Adds an body to body.
     *
     * @param body the new body
     * @return the GrantUserToObjectOptions builder
     */
    public Builder addBody(GrantUserToObjectRequestBodyItem body) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(body,
        "body cannot be null");
      if (this.body == null) {
        this.body = new ArrayList<GrantUserToObjectRequestBodyItem>();
      }
      this.body.add(body);
      return this;
    }

    /**
     * Set the body.
     * Existing body will be replaced.
     *
     * @param body the body
     * @return the GrantUserToObjectOptions builder
     */
    public Builder body(List<GrantUserToObjectRequestBodyItem> body) {
      this.body = body;
      return this;
    }
  }

  protected GrantUserToObjectOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body,
      "body cannot be null");
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a GrantUserToObjectOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the body.
   *
   * @return the body
   */
  public List<GrantUserToObjectRequestBodyItem> body() {
    return body;
  }
}

