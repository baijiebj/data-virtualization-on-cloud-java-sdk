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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DatasourceConnectionsListDatasourceConnectionsItemDataSourcesItem.
 */
public class DatasourceConnectionsListDatasourceConnectionsItemDataSourcesItem extends GenericModel {

  protected String cid;
  protected String dbname;
  @SerializedName("connection_id")
  protected String connectionId;
  protected String srchostname;
  protected String srcport;
  protected String srctype;
  protected String usr;
  protected String uri;
  protected String status;
  @SerializedName("connection_name")
  protected String connectionName;

  /**
   * Gets the cid.
   *
   * The identifier of the connection for the Data Virtualization.
   *
   * @return the cid
   */
  public String getCid() {
    return cid;
  }

  /**
   * Gets the dbname.
   *
   * The name of the database.
   *
   * @return the dbname
   */
  public String getDbname() {
    return dbname;
  }

  /**
   * Gets the connectionId.
   *
   * The connection identifier for the platform.
   *
   * @return the connectionId
   */
  public String getConnectionId() {
    return connectionId;
  }

  /**
   * Gets the srchostname.
   *
   * The hostname or IP address of the data source.
   *
   * @return the srchostname
   */
  public String getSrchostname() {
    return srchostname;
  }

  /**
   * Gets the srcport.
   *
   * The port number of the data source.
   *
   * @return the srcport
   */
  public String getSrcport() {
    return srcport;
  }

  /**
   * Gets the srctype.
   *
   * The type of the data source.
   *
   * @return the srctype
   */
  public String getSrctype() {
    return srctype;
  }

  /**
   * Gets the usr.
   *
   * The user that has access to the data source.
   *
   * @return the usr
   */
  public String getUsr() {
    return usr;
  }

  /**
   * Gets the uri.
   *
   * The URI of the data source.
   *
   * @return the uri
   */
  public String getUri() {
    return uri;
  }

  /**
   * Gets the status.
   *
   * The status of the data source.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the connectionName.
   *
   * The name of the connection.
   *
   * @return the connectionName
   */
  public String getConnectionName() {
    return connectionName;
  }
}

