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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DatasourceNodesResponseV2DatasourceNodesArrayItem.
 */
public class DatasourceNodesResponseV2DatasourceNodesArrayItem extends GenericModel {

  @SerializedName("node_name")
  protected String nodeName;
  @SerializedName("node_description")
  protected String nodeDescription;
  @SerializedName("agent_class")
  protected String agentClass;
  protected String hostname;
  protected String port;
  @SerializedName("os_user")
  protected String osUser;
  @SerializedName("is_docker")
  protected String isDocker;
  protected String dscount;
  @SerializedName("data_sources")
  protected List<DatasourceNodesResponseV2DatasourceNodesArrayItemDataSourcesItem> dataSources;

  /**
   * Gets the nodeName.
   *
   * The name of the node that a datasource connection associates.
   *
   * @return the nodeName
   */
  public String getNodeName() {
    return nodeName;
  }

  /**
   * Gets the nodeDescription.
   *
   * The description of the node that a datasource connection associates.
   *
   * @return the nodeDescription
   */
  public String getNodeDescription() {
    return nodeDescription;
  }

  /**
   * Gets the agentClass.
   *
   * The type of connector, for example, H stands for Hosted, ie running within the cluster, F means Fenced Mode
   * Process, ie direct within Data Virtualization instance.
   *
   * @return the agentClass
   */
  public String getAgentClass() {
    return agentClass;
  }

  /**
   * Gets the hostname.
   *
   * The hostname or IP address that is used to access the connection.
   *
   * @return the hostname
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * Gets the port.
   *
   * The port number that is used to access the connection.
   *
   * @return the port
   */
  public String getPort() {
    return port;
  }

  /**
   * Gets the osUser.
   *
   * @return the osUser
   */
  public String getOsUser() {
    return osUser;
  }

  /**
   * Gets the isDocker.
   *
   * Determines whether the data source uses Docker.
   *
   * @return the isDocker
   */
  public String getIsDocker() {
    return isDocker;
  }

  /**
   * Gets the dscount.
   *
   * The number of data sources.
   *
   * @return the dscount
   */
  public String getDscount() {
    return dscount;
  }

  /**
   * Gets the dataSources.
   *
   * @return the dataSources
   */
  public List<DatasourceNodesResponseV2DatasourceNodesArrayItemDataSourcesItem> getDataSources() {
    return dataSources;
  }
}

