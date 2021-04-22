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
 * PostDatasourceConnectionParametersProperties.
 */
public class PostDatasourceConnectionParametersProperties extends GenericModel {

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
  protected String collection;
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
  protected String role;
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
    private String collection;
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
    private String role;
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

    private Builder(PostDatasourceConnectionParametersProperties postDatasourceConnectionParametersProperties) {
      this.accessToken = postDatasourceConnectionParametersProperties.accessToken;
      this.accountName = postDatasourceConnectionParametersProperties.accountName;
      this.apiKey = postDatasourceConnectionParametersProperties.apiKey;
      this.authType = postDatasourceConnectionParametersProperties.authType;
      this.clientId = postDatasourceConnectionParametersProperties.clientId;
      this.clientSecret = postDatasourceConnectionParametersProperties.clientSecret;
      this.collection = postDatasourceConnectionParametersProperties.collection;
      this.credentials = postDatasourceConnectionParametersProperties.credentials;
      this.database = postDatasourceConnectionParametersProperties.database;
      this.host = postDatasourceConnectionParametersProperties.host;
      this.httpPath = postDatasourceConnectionParametersProperties.httpPath;
      this.jarUris = postDatasourceConnectionParametersProperties.jarUris;
      this.jdbcDriver = postDatasourceConnectionParametersProperties.jdbcDriver;
      this.jdbcUrl = postDatasourceConnectionParametersProperties.jdbcUrl;
      this.password = postDatasourceConnectionParametersProperties.password;
      this.port = postDatasourceConnectionParametersProperties.port;
      this.projectId = postDatasourceConnectionParametersProperties.projectId;
      this.xProperties = postDatasourceConnectionParametersProperties.xProperties;
      this.refreshToken = postDatasourceConnectionParametersProperties.refreshToken;
      this.role = postDatasourceConnectionParametersProperties.role;
      this.sapGatewayUrl = postDatasourceConnectionParametersProperties.sapGatewayUrl;
      this.server = postDatasourceConnectionParametersProperties.server;
      this.serviceName = postDatasourceConnectionParametersProperties.serviceName;
      this.sid = postDatasourceConnectionParametersProperties.sid;
      this.ssl = postDatasourceConnectionParametersProperties.ssl;
      this.sslCertificate = postDatasourceConnectionParametersProperties.sslCertificate;
      this.sslCertificateHost = postDatasourceConnectionParametersProperties.sslCertificateHost;
      this.sslCertificateValidation = postDatasourceConnectionParametersProperties.sslCertificateValidation;
      this.username = postDatasourceConnectionParametersProperties.username;
      this.warehouse = postDatasourceConnectionParametersProperties.warehouse;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostDatasourceConnectionParametersProperties.
     *
     * @return the new PostDatasourceConnectionParametersProperties instance
     */
    public PostDatasourceConnectionParametersProperties build() {
      return new PostDatasourceConnectionParametersProperties(this);
    }

    /**
     * Set the accessToken.
     *
     * @param accessToken the accessToken
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    /**
     * Set the accountName.
     *
     * @param accountName the accountName
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder accountName(String accountName) {
      this.accountName = accountName;
      return this;
    }

    /**
     * Set the apiKey.
     *
     * @param apiKey the apiKey
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Set the authType.
     *
     * @param authType the authType
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder authType(String authType) {
      this.authType = authType;
      return this;
    }

    /**
     * Set the clientId.
     *
     * @param clientId the clientId
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder clientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Set the clientSecret.
     *
     * @param clientSecret the clientSecret
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder clientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /**
     * Set the collection.
     *
     * @param collection the collection
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder collection(String collection) {
      this.collection = collection;
      return this;
    }

    /**
     * Set the credentials.
     *
     * @param credentials the credentials
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder credentials(String credentials) {
      this.credentials = credentials;
      return this;
    }

    /**
     * Set the database.
     *
     * @param database the database
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder database(String database) {
      this.database = database;
      return this;
    }

    /**
     * Set the host.
     *
     * @param host the host
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder host(String host) {
      this.host = host;
      return this;
    }

    /**
     * Set the httpPath.
     *
     * @param httpPath the httpPath
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder httpPath(String httpPath) {
      this.httpPath = httpPath;
      return this;
    }

    /**
     * Set the jarUris.
     *
     * @param jarUris the jarUris
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder jarUris(String jarUris) {
      this.jarUris = jarUris;
      return this;
    }

    /**
     * Set the jdbcDriver.
     *
     * @param jdbcDriver the jdbcDriver
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder jdbcDriver(String jdbcDriver) {
      this.jdbcDriver = jdbcDriver;
      return this;
    }

    /**
     * Set the jdbcUrl.
     *
     * @param jdbcUrl the jdbcUrl
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder jdbcUrl(String jdbcUrl) {
      this.jdbcUrl = jdbcUrl;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the port.
     *
     * @param port the port
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder port(String port) {
      this.port = port;
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the xProperties.
     *
     * @param xProperties the xProperties
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder xProperties(String xProperties) {
      this.xProperties = xProperties;
      return this;
    }

    /**
     * Set the refreshToken.
     *
     * @param refreshToken the refreshToken
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder refreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder role(String role) {
      this.role = role;
      return this;
    }

    /**
     * Set the sapGatewayUrl.
     *
     * @param sapGatewayUrl the sapGatewayUrl
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder sapGatewayUrl(String sapGatewayUrl) {
      this.sapGatewayUrl = sapGatewayUrl;
      return this;
    }

    /**
     * Set the server.
     *
     * @param server the server
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder server(String server) {
      this.server = server;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the sid.
     *
     * @param sid the sid
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder sid(String sid) {
      this.sid = sid;
      return this;
    }

    /**
     * Set the ssl.
     *
     * @param ssl the ssl
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder ssl(String ssl) {
      this.ssl = ssl;
      return this;
    }

    /**
     * Set the sslCertificate.
     *
     * @param sslCertificate the sslCertificate
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder sslCertificate(String sslCertificate) {
      this.sslCertificate = sslCertificate;
      return this;
    }

    /**
     * Set the sslCertificateHost.
     *
     * @param sslCertificateHost the sslCertificateHost
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder sslCertificateHost(String sslCertificateHost) {
      this.sslCertificateHost = sslCertificateHost;
      return this;
    }

    /**
     * Set the sslCertificateValidation.
     *
     * @param sslCertificateValidation the sslCertificateValidation
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder sslCertificateValidation(String sslCertificateValidation) {
      this.sslCertificateValidation = sslCertificateValidation;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * Set the warehouse.
     *
     * @param warehouse the warehouse
     * @return the PostDatasourceConnectionParametersProperties builder
     */
    public Builder warehouse(String warehouse) {
      this.warehouse = warehouse;
      return this;
    }
  }

  protected PostDatasourceConnectionParametersProperties(Builder builder) {
    accessToken = builder.accessToken;
    accountName = builder.accountName;
    apiKey = builder.apiKey;
    authType = builder.authType;
    clientId = builder.clientId;
    clientSecret = builder.clientSecret;
    collection = builder.collection;
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
    role = builder.role;
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
   * @return a PostDatasourceConnectionParametersProperties builder
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
   * Gets the collection.
   *
   * @return the collection
   */
  public String collection() {
    return collection;
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
   * Gets the role.
   *
   * @return the role
   */
  public String role() {
    return role;
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

