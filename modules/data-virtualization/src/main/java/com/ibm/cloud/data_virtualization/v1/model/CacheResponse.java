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
 * CacheResponse.
 */
public class CacheResponse extends GenericModel {

  protected String name;
  protected String id;
  protected String query;
  @SerializedName("owner_id")
  protected String ownerId;
  protected String type;
  @SerializedName("created_timestamp")
  protected String createdTimestamp;
  @SerializedName("last_modified_timestamp")
  protected String lastModifiedTimestamp;
  @SerializedName("last_refresh_timestamp")
  protected String lastRefreshTimestamp;
  @SerializedName("last_used_timestamp")
  protected String lastUsedTimestamp;
  protected String state;
  protected Long size;
  protected Long cardinality;
  @SerializedName("time_taken_for_refresh")
  protected Long timeTakenForRefresh;
  @SerializedName("refresh_count")
  protected Long refreshCount;
  @SerializedName("hit_count")
  protected Long hitCount;
  @SerializedName("refresh_schedule")
  protected String refreshSchedule;
  @SerializedName("refresh_schedule_desc")
  protected String refreshScheduleDesc;
  @SerializedName("status_msg")
  protected String statusMsg;

  /**
   * Gets the name.
   *
   * The name of this cache.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the id.
   *
   * The unique ID of this cache.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the query.
   *
   * The query that defines this cache.
   *
   * @return the query
   */
  public String getQuery() {
    return query;
  }

  /**
   * Gets the ownerId.
   *
   * Owner ID of this cache.
   *
   * @return the ownerId
   */
  public String getOwnerId() {
    return ownerId;
  }

  /**
   * Gets the type.
   *
   * Type of the cache - User-defined (U), Recommended (R).
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the createdTimestamp.
   *
   * Database timestamp at the time of cache creation.
   *
   * @return the createdTimestamp
   */
  public String getCreatedTimestamp() {
    return createdTimestamp;
  }

  /**
   * Gets the lastModifiedTimestamp.
   *
   * Database timestamp when this cache was last modified (state change).
   *
   * @return the lastModifiedTimestamp
   */
  public String getLastModifiedTimestamp() {
    return lastModifiedTimestamp;
  }

  /**
   * Gets the lastRefreshTimestamp.
   *
   * Database timestamp when this cache was last refreshed.
   *
   * @return the lastRefreshTimestamp
   */
  public String getLastRefreshTimestamp() {
    return lastRefreshTimestamp;
  }

  /**
   * Gets the lastUsedTimestamp.
   *
   * Database timestamp when this cache was last used.
   *
   * @return the lastUsedTimestamp
   */
  public String getLastUsedTimestamp() {
    return lastUsedTimestamp;
  }

  /**
   * Gets the state.
   *
   * State of this cache - one of
   * Enabled,Disabled,Deleted,Failed,Populating,Activating,Enabling,Disabling,Refreshing,Deleting.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the size.
   *
   * Size of this cache (in KB).
   *
   * @return the size
   */
  public Long getSize() {
    return size;
  }

  /**
   * Gets the cardinality.
   *
   * Cardinality (number of rows) of this cache.
   *
   * @return the cardinality
   */
  public Long getCardinality() {
    return cardinality;
  }

  /**
   * Gets the timeTakenForRefresh.
   *
   * Time taken to refresh this cache most recently (in milliseconds).
   *
   * @return the timeTakenForRefresh
   */
  public Long getTimeTakenForRefresh() {
    return timeTakenForRefresh;
  }

  /**
   * Gets the refreshCount.
   *
   * Number of times this cache has been refreshed since creation.
   *
   * @return the refreshCount
   */
  public Long getRefreshCount() {
    return refreshCount;
  }

  /**
   * Gets the hitCount.
   *
   * Hit Count of the cache (number of times this cache was used).
   *
   * @return the hitCount
   */
  public Long getHitCount() {
    return hitCount;
  }

  /**
   * Gets the refreshSchedule.
   *
   * Encoded cron-style representation of the cache refresh schedule.
   *
   * @return the refreshSchedule
   */
  public String getRefreshSchedule() {
    return refreshSchedule;
  }

  /**
   * Gets the refreshScheduleDesc.
   *
   * Human-readable description of the cache refresh schedule.
   *
   * @return the refreshScheduleDesc
   */
  public String getRefreshScheduleDesc() {
    return refreshScheduleDesc;
  }

  /**
   * Gets the statusMsg.
   *
   * Status message indicating the most recent error/issue with the cache, if any.
   *
   * @return the statusMsg
   */
  public String getStatusMsg() {
    return statusMsg;
  }
}

