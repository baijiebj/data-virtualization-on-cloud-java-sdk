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
 * PostDatasourceConnectionParametersV2Properties.
 */
public class PostDatasourceConnectionParametersV2Properties extends GenericModel {

  @SerializedName("access_token")
  protected String accessToken;
  @SerializedName("account_name")
  protected String accountName;
  @SerializedName("api_key")
  protected String apiKey;
  @SerializedName("auth_type")
  protected String authType;
  @SerializedName("client_id")
  protected String clientId;
  @SerializedName("client_secret")
  protected String clientSecret;
  protected String credentials;
  protected String database;
  protected String host;
  @SerializedName("http_path")
  protected String httpPath;
  @SerializedName("jar_uris")
  protected String jarUris;
  @SerializedName("jdbc_driver")
  protected String jdbcDriver;
  @SerializedName("jdbc_url")
  protected String jdbcUrl;
  protected String password;
  protected String port;
  @SerializedName("project_id")
  protected String projectId;
  @SerializedName("properties")
  protected String xProperties;
  @SerializedName("refresh_token")
  protected String refreshToken;
  @SerializedName("sap_gateway_url")
  protected String sapGatewayUrl;
  protected String server;
  @SerializedName("service_name")
  protected String serviceName;
  protected String sid;
  protected String ssl;
  @SerializedName("ssl_certificate")
  protected String sslCertificate;
  @SerializedName("ssl_certificate_host")
  protected String sslCertificateHost;
  @SerializedName("ssl_certificate_validation")
  protected String sslCertificateValidation;
  protected String username;
  protected String warehouse;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessToken;
    private String accountName;
    private String apiKey;
    private String authType;
    private String clientId;
    private String clientSecret;
    private String credentials;
    private String database;
    private String host;
    private String httpPath;
    private String jarUris;
    private String jdbcDriver;
    private String jdbcUrl;
    private String password;
    private String port;
    private String projectId;
    private String xProperties;
    private String refreshToken;
    private String sapGatewayUrl;
    private String server;
    private String serviceName;
    private String sid;
    private String ssl;
    private String sslCertificate;
    private String sslCertificateHost;
    private String sslCertificateValidation;
    private String username;
    private String warehouse;

    private Builder(PostDatasourceConnectionParametersV2Properties postDatasourceConnectionParametersV2Properties) {
      this.accessToken = postDatasourceConnectionParametersV2Properties.accessToken;
      this.accountName = postDatasourceConnectionParametersV2Properties.accountName;
      this.apiKey = postDatasourceConnectionParametersV2Properties.apiKey;
      this.authType = postDatasourceConnectionParametersV2Properties.authType;
      this.clientId = postDatasourceConnectionParametersV2Properties.clientId;
      this.clientSecret = postDatasourceConnectionParametersV2Properties.clientSecret;
      this.credentials = postDatasourceConnectionParametersV2Properties.credentials;
      this.database = postDatasourceConnectionParametersV2Properties.database;
      this.host = postDatasourceConnectionParametersV2Properties.host;
      this.httpPath = postDatasourceConnectionParametersV2Properties.httpPath;
      this.jarUris = postDatasourceConnectionParametersV2Properties.jarUris;
      this.jdbcDriver = postDatasourceConnectionParametersV2Properties.jdbcDriver;
      this.jdbcUrl = postDatasourceConnectionParametersV2Properties.jdbcUrl;
      this.password = postDatasourceConnectionParametersV2Properties.password;
      this.port = postDatasourceConnectionParametersV2Properties.port;
      this.projectId = postDatasourceConnectionParametersV2Properties.projectId;
      this.xProperties = postDatasourceConnectionParametersV2Properties.xProperties;
      this.refreshToken = postDatasourceConnectionParametersV2Properties.refreshToken;
      this.sapGatewayUrl = postDatasourceConnectionParametersV2Properties.sapGatewayUrl;
      this.server = postDatasourceConnectionParametersV2Properties.server;
      this.serviceName = postDatasourceConnectionParametersV2Properties.serviceName;
      this.sid = postDatasourceConnectionParametersV2Properties.sid;
      this.ssl = postDatasourceConnectionParametersV2Properties.ssl;
      this.sslCertificate = postDatasourceConnectionParametersV2Properties.sslCertificate;
      this.sslCertificateHost = postDatasourceConnectionParametersV2Properties.sslCertificateHost;
      this.sslCertificateValidation = postDatasourceConnectionParametersV2Properties.sslCertificateValidation;
      this.username = postDatasourceConnectionParametersV2Properties.username;
      this.warehouse = postDatasourceConnectionParametersV2Properties.warehouse;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostDatasourceConnectionParametersV2Properties.
     *
     * @return the new PostDatasourceConnectionParametersV2Properties instance
     */
    public PostDatasourceConnectionParametersV2Properties build() {
      return new PostDatasourceConnectionParametersV2Properties(this);
    }

    /**
     * Set the accessToken.
     *
     * @param accessToken the accessToken
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    /**
     * Set the accountName.
     *
     * @param accountName the accountName
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder accountName(String accountName) {
      this.accountName = accountName;
      return this;
    }

    /**
     * Set the apiKey.
     *
     * @param apiKey the apiKey
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Set the authType.
     *
     * @param authType the authType
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder authType(String authType) {
      this.authType = authType;
      return this;
    }

    /**
     * Set the clientId.
     *
     * @param clientId the clientId
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder clientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Set the clientSecret.
     *
     * @param clientSecret the clientSecret
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder clientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /**
     * Set the credentials.
     *
     * @param credentials the credentials
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder credentials(String credentials) {
      this.credentials = credentials;
      return this;
    }

    /**
     * Set the database.
     *
     * @param database the database
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder database(String database) {
      this.database = database;
      return this;
    }

    /**
     * Set the host.
     *
     * @param host the host
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder host(String host) {
      this.host = host;
      return this;
    }

    /**
     * Set the httpPath.
     *
     * @param httpPath the httpPath
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder httpPath(String httpPath) {
      this.httpPath = httpPath;
      return this;
    }

    /**
     * Set the jarUris.
     *
     * @param jarUris the jarUris
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder jarUris(String jarUris) {
      this.jarUris = jarUris;
      return this;
    }

    /**
     * Set the jdbcDriver.
     *
     * @param jdbcDriver the jdbcDriver
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder jdbcDriver(String jdbcDriver) {
      this.jdbcDriver = jdbcDriver;
      return this;
    }

    /**
     * Set the jdbcUrl.
     *
     * @param jdbcUrl the jdbcUrl
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder jdbcUrl(String jdbcUrl) {
      this.jdbcUrl = jdbcUrl;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the port.
     *
     * @param port the port
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder port(String port) {
      this.port = port;
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the xProperties.
     *
     * @param xProperties the xProperties
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder xProperties(String xProperties) {
      this.xProperties = xProperties;
      return this;
    }

    /**
     * Set the refreshToken.
     *
     * @param refreshToken the refreshToken
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder refreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    /**
     * Set the sapGatewayUrl.
     *
     * @param sapGatewayUrl the sapGatewayUrl
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder sapGatewayUrl(String sapGatewayUrl) {
      this.sapGatewayUrl = sapGatewayUrl;
      return this;
    }

    /**
     * Set the server.
     *
     * @param server the server
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder server(String server) {
      this.server = server;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the sid.
     *
     * @param sid the sid
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder sid(String sid) {
      this.sid = sid;
      return this;
    }

    /**
     * Set the ssl.
     *
     * @param ssl the ssl
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder ssl(String ssl) {
      this.ssl = ssl;
      return this;
    }

    /**
     * Set the sslCertificate.
     *
     * @param sslCertificate the sslCertificate
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder sslCertificate(String sslCertificate) {
      this.sslCertificate = sslCertificate;
      return this;
    }

    /**
     * Set the sslCertificateHost.
     *
     * @param sslCertificateHost the sslCertificateHost
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder sslCertificateHost(String sslCertificateHost) {
      this.sslCertificateHost = sslCertificateHost;
      return this;
    }

    /**
     * Set the sslCertificateValidation.
     *
     * @param sslCertificateValidation the sslCertificateValidation
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder sslCertificateValidation(String sslCertificateValidation) {
      this.sslCertificateValidation = sslCertificateValidation;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * Set the warehouse.
     *
     * @param warehouse the warehouse
     * @return the PostDatasourceConnectionParametersV2Properties builder
     */
    public Builder warehouse(String warehouse) {
      this.warehouse = warehouse;
      return this;
    }
  }

  protected PostDatasourceConnectionParametersV2Properties(Builder builder) {
    accessToken = builder.accessToken;
    accountName = builder.accountName;
    apiKey = builder.apiKey;
    authType = builder.authType;
    clientId = builder.clientId;
    clientSecret = builder.clientSecret;
    credentials = builder.credentials;
    database = builder.database;
    host = builder.host;
    httpPath = builder.httpPath;
    jarUris = builder.jarUris;
    jdbcDriver = builder.jdbcDriver;
    jdbcUrl = builder.jdbcUrl;
    password = builder.password;
    port = builder.port;
    projectId = builder.projectId;
    xProperties = builder.xProperties;
    refreshToken = builder.refreshToken;
    sapGatewayUrl = builder.sapGatewayUrl;
    server = builder.server;
    serviceName = builder.serviceName;
    sid = builder.sid;
    ssl = builder.ssl;
    sslCertificate = builder.sslCertificate;
    sslCertificateHost = builder.sslCertificateHost;
    sslCertificateValidation = builder.sslCertificateValidation;
    username = builder.username;
    warehouse = builder.warehouse;
  }

  /**
   * New builder.
   *
   * @return a PostDatasourceConnectionParametersV2Properties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessToken.
   *
   * @return the accessToken
   */
  public String accessToken() {
    return accessToken;
  }

  /**
   * Gets the accountName.
   *
   * @return the accountName
   */
  public String accountName() {
    return accountName;
  }

  /**
   * Gets the apiKey.
   *
   * @return the apiKey
   */
  public String apiKey() {
    return apiKey;
  }

  /**
   * Gets the authType.
   *
   * @return the authType
   */
  public String authType() {
    return authType;
  }

  /**
   * Gets the clientId.
   *
   * @return the clientId
   */
  public String clientId() {
    return clientId;
  }

  /**
   * Gets the clientSecret.
   *
   * @return the clientSecret
   */
  public String clientSecret() {
    return clientSecret;
  }

  /**
   * Gets the credentials.
   *
   * @return the credentials
   */
  public String credentials() {
    return credentials;
  }

  /**
   * Gets the database.
   *
   * @return the database
   */
  public String database() {
    return database;
  }

  /**
   * Gets the host.
   *
   * @return the host
   */
  public String host() {
    return host;
  }

  /**
   * Gets the httpPath.
   *
   * @return the httpPath
   */
  public String httpPath() {
    return httpPath;
  }

  /**
   * Gets the jarUris.
   *
   * @return the jarUris
   */
  public String jarUris() {
    return jarUris;
  }

  /**
   * Gets the jdbcDriver.
   *
   * @return the jdbcDriver
   */
  public String jdbcDriver() {
    return jdbcDriver;
  }

  /**
   * Gets the jdbcUrl.
   *
   * @return the jdbcUrl
   */
  public String jdbcUrl() {
    return jdbcUrl;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String password() {
    return password;
  }

  /**
   * Gets the port.
   *
   * @return the port
   */
  public String port() {
    return port;
  }

  /**
   * Gets the projectId.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the xProperties.
   *
   * @return the xProperties
   */
  public String xProperties() {
    return xProperties;
  }

  /**
   * Gets the refreshToken.
   *
   * @return the refreshToken
   */
  public String refreshToken() {
    return refreshToken;
  }

  /**
   * Gets the sapGatewayUrl.
   *
   * @return the sapGatewayUrl
   */
  public String sapGatewayUrl() {
    return sapGatewayUrl;
  }

  /**
   * Gets the server.
   *
   * @return the server
   */
  public String server() {
    return server;
  }

  /**
   * Gets the serviceName.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the sid.
   *
   * @return the sid
   */
  public String sid() {
    return sid;
  }

  /**
   * Gets the ssl.
   *
   * @return the ssl
   */
  public String ssl() {
    return ssl;
  }

  /**
   * Gets the sslCertificate.
   *
   * @return the sslCertificate
   */
  public String sslCertificate() {
    return sslCertificate;
  }

  /**
   * Gets the sslCertificateHost.
   *
   * @return the sslCertificateHost
   */
  public String sslCertificateHost() {
    return sslCertificateHost;
  }

  /**
   * Gets the sslCertificateValidation.
   *
   * @return the sslCertificateValidation
   */
  public String sslCertificateValidation() {
    return sslCertificateValidation;
  }

  /**
   * Gets the username.
   *
   * @return the username
   */
  public String username() {
    return username;
  }

  /**
   * Gets the warehouse.
   *
   * @return the warehouse
   */
  public String warehouse() {
    return warehouse;
  }
}

