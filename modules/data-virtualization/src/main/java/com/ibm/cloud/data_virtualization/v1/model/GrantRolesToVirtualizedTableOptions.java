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
 * The grantRolesToVirtualizedTable options.
 */
public class GrantRolesToVirtualizedTableOptions extends GenericModel {

  protected List<PostRolePrivilegesParametersBodyItem> body;

  /**
   * Builder.
   */
  public static class Builder {
    private List<PostRolePrivilegesParametersBodyItem> body;

    private Builder(GrantRolesToVirtualizedTableOptions grantRolesToVirtualizedTableOptions) {
      this.body = grantRolesToVirtualizedTableOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GrantRolesToVirtualizedTableOptions.
     *
     * @return the new GrantRolesToVirtualizedTableOptions instance
     */
    public GrantRolesToVirtualizedTableOptions build() {
      return new GrantRolesToVirtualizedTableOptions(this);
    }

    /**
     * Adds an body to body.
     *
     * @param body the new body
     * @return the GrantRolesToVirtualizedTableOptions builder
     */
    public Builder addBody(PostRolePrivilegesParametersBodyItem body) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(body,
        "body cannot be null");
      if (this.body == null) {
        this.body = new ArrayList<PostRolePrivilegesParametersBodyItem>();
      }
      this.body.add(body);
      return this;
    }

    /**
     * Set the body.
     * Existing body will be replaced.
     *
     * @param body the body
     * @return the GrantRolesToVirtualizedTableOptions builder
     */
    public Builder body(List<PostRolePrivilegesParametersBodyItem> body) {
      this.body = body;
      return this;
    }
  }

  protected GrantRolesToVirtualizedTableOptions(Builder builder) {
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a GrantRolesToVirtualizedTableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the body.
   *
   * @return the body
   */
  public List<PostRolePrivilegesParametersBodyItem> body() {
    return body;
  }
}

