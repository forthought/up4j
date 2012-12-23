/*
 * Copyright (C) 2012 forthought, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.up4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import java.util.List;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Move
{

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    @JsonProperty("time_completed")
    private Date completed;

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    @JsonProperty("time_created")
    private Date created;

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    @JsonProperty("time_updated")
    private Date updated;

    private String xid;

    @JsonProperty("band_ids")
    private List<String> bandIds;

    private String title;

    private User user;

    private String date;

    private boolean shared;

    private String type;

    private List<Comment> comments;

    private Details details;

    /**
     * @return the completed
     */
    public Date getCompleted()
    {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Date completed)
    {
        this.completed = completed;
    }

    /**
     * @return the xid
     */
    public String getXid()
    {
        return xid;
    }

    /**
     * @param xid the xid to set
     */
    public void setXid(String xid)
    {
        this.xid = xid;
    }

    /**
     * @return the bandIds
     */
    public List<String> getBandIds()
    {
        return bandIds;
    }

    /**
     * @param bandIds the bandIds to set
     */
    public void setBandIds(List<String> bandIds)
    {
        this.bandIds = bandIds;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * @return the created
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * @return the updated
     */
    public Date getUpdated()
    {
        return updated;
    }

    /**
     * @param updated the updated to set
     */
    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }

    /**
     * @return the date
     */
    public String getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * @return the shared
     */
    public boolean isShared()
    {
        return shared;
    }

    /**
     * @param shared the shared to set
     */
    public void setShared(boolean shared)
    {
        this.shared = shared;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments()
    {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

    /**
     * @return the details
     */
    public Details getDetails()
    {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(Details details)
    {
        this.details = details;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Details
    {

        private Integer distance;

//            private "tzs": [[1355807340, "America/Detroit"]], 
        @JsonProperty("tz")
        private String timezone;

        @JsonProperty("longest_active")
        private Integer longestActive;

        @JsonProperty("active_time")
        private Integer activeTime;

        private Double calories;

        @JsonProperty("bmr_day")
        private Double bmrDay;

        @JsonProperty("wo_count")
        private Integer workoutCount;

        @JsonProperty("wo_longest")
        private Integer workoutLongest;

        private Double bmr;

        private Integer steps;

        @JsonProperty("km")
        private Double kilometers;

        @JsonProperty("wo_calories")
        private Integer workoutCalories;

        @JsonProperty("wo_time")
        private Integer workoutTime;

        @JsonProperty("wo_active_time")
        private Integer workoutActiveTime;

        @JsonProperty("longest_idle")
        private Integer longestIdle;

        /**
         * @return the distance
         */
        public Integer getDistance()
        {
            return distance;
        }

        /**
         * @param distance the distance to set
         */
        public void setDistance(Integer distance)
        {
            this.distance = distance;
        }

        /**
         * @return the timezone
         */
        public String getTimezone()
        {
            return timezone;
        }

        /**
         * @param timezone the timezone to set
         */
        public void setTimezone(String timezone)
        {
            this.timezone = timezone;
        }

        /**
         * @return the longestActive
         */
        public Integer getLongestActive()
        {
            return longestActive;
        }

        /**
         * @param longestActive the longestActive to set
         */
        public void setLongestActive(Integer longestActive)
        {
            this.longestActive = longestActive;
        }

        /**
         * @return the activeTime
         */
        public Integer getActiveTime()
        {
            return activeTime;
        }

        /**
         * @param activeTime the activeTime to set
         */
        public void setActiveTime(Integer activeTime)
        {
            this.activeTime = activeTime;
        }

        /**
         * @return the calories
         */
        public Double getCalories()
        {
            return calories;
        }

        /**
         * @param calories the calories to set
         */
        public void setCalories(Double calories)
        {
            this.calories = calories;
        }

        /**
         * @return the bmrDay
         */
        public Double getBmrDay()
        {
            return bmrDay;
        }

        /**
         * @param bmrDay the bmrDay to set
         */
        public void setBmrDay(Double bmrDay)
        {
            this.bmrDay = bmrDay;
        }

        /**
         * @return the workoutCount
         */
        public Integer getWorkoutCount()
        {
            return workoutCount;
        }

        /**
         * @param workoutCount the workoutCount to set
         */
        public void setWorkoutCount(Integer workoutCount)
        {
            this.workoutCount = workoutCount;
        }

        /**
         * @return the workoutLongest
         */
        public Integer getWorkoutLongest()
        {
            return workoutLongest;
        }

        /**
         * @param workoutLongest the workoutLongest to set
         */
        public void setWorkoutLongest(Integer workoutLongest)
        {
            this.workoutLongest = workoutLongest;
        }

        /**
         * @return the bmr
         */
        public Double getBmr()
        {
            return bmr;
        }

        /**
         * @param bmr the bmr to set
         */
        public void setBmr(Double bmr)
        {
            this.bmr = bmr;
        }

        /**
         * @return the steps
         */
        public Integer getSteps()
        {
            return steps;
        }

        /**
         * @param steps the steps to set
         */
        public void setSteps(Integer steps)
        {
            this.steps = steps;
        }

        /**
         * @return the kilometers
         */
        public Double getKilometers()
        {
            return kilometers;
        }

        /**
         * @param kilometers the kilometers to set
         */
        public void setKilometers(Double kilometers)
        {
            this.kilometers = kilometers;
        }

        /**
         * @return the workoutCalories
         */
        public Integer getWorkoutCalories()
        {
            return workoutCalories;
        }

        /**
         * @param workoutCalories the workoutCalories to set
         */
        public void setWorkoutCalories(Integer workoutCalories)
        {
            this.workoutCalories = workoutCalories;
        }

        /**
         * @return the workoutTime
         */
        public Integer getWorkoutTime()
        {
            return workoutTime;
        }

        /**
         * @param workoutTime the workoutTime to set
         */
        public void setWorkoutTime(Integer workoutTime)
        {
            this.workoutTime = workoutTime;
        }

        /**
         * @return the workoutActiveTime
         */
        public Integer getWorkoutActiveTime()
        {
            return workoutActiveTime;
        }

        /**
         * @param workoutActiveTime the workoutActiveTime to set
         */
        public void setWorkoutActiveTime(Integer workoutActiveTime)
        {
            this.workoutActiveTime = workoutActiveTime;
        }

        /**
         * @return the longestIdle
         */
        public Integer getLongestIdle()
        {
            return longestIdle;
        }

        /**
         * @param longestIdle the longestIdle to set
         */
        public void setLongestIdle(Integer longestIdle)
        {
            this.longestIdle = longestIdle;
        }
    }
}
