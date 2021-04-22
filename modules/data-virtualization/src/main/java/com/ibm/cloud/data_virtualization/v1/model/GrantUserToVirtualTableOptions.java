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
 * The grantUserToVirtualTable options.
 */
public class GrantUserToVirtualTableOptions extends GenericModel {

  protected List<PostUserPrivilegesParametersBodyItem> body;

  /**
   * Builder.
   */
  public static class Builder {
    private List<PostUserPrivilegesParametersBodyItem> body;

    private Builder(GrantUserToVirtualTableOptions grantUserToVirtualTableOptions) {
      this.body = grantUserToVirtualTableOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GrantUserToVirtualTableOptions.
     *
     * @return the new GrantUserToVirtualTableOptions instance
     */
    public GrantUserToVirtualTableOptions build() {
      return new GrantUserToVirtualTableOptions(this);
    }

    /**
     * Adds an body to body.
     *
     * @param body the new body
     * @return the GrantUserToVirtualTableOptions builder
     */
    public Builder addBody(PostUserPrivilegesParametersBodyItem body) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(body,
        "body cannot be null");
      if (this.body == null) {
        this.body = new ArrayList<PostUserPrivilegesParametersBodyItem>();
      }
      this.body.add(body);
      return this;
    }

    /**
     * Set the body.
     * Existing body will be replaced.
     *
     * @param body the body
     * @return the GrantUserToVirtualTableOptions builder
     */
    public Builder body(List<PostUserPrivilegesParametersBodyItem> body) {
      this.body = body;
      return this;
    }
  }

  protected GrantUserToVirtualTableOptions(Builder builder) {
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a GrantUserToVirtualTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the body.
   *
   * @return the body
   */
  public List<PostUserPrivilegesParametersBodyItem> body() {
    return body;
  }
}

