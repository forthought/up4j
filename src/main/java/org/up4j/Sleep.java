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

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sleep
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

    private String title;

    @JsonProperty("user_xid")
    private String userXid;

    private String date;

    private String type;

    @JsonProperty("sub_type")
    private String subType;

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
     * @return the userXid
     */
    public String getUserXid()
    {
        return userXid;
    }

    /**
     * @param userXid the userXid to set
     */
    public void setUserXid(String userXid)
    {
        this.userXid = userXid;
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
     * @return the subType
     */
    public String getSubType()
    {
        return subType;
    }

    /**
     * @param subType the subType to set
     */
    public void setSubType(String subType)
    {
        this.subType = subType;
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
    public static class Details
    {

        private Integer body;

        @JsonProperty("smart_alarm_fire")
        private Integer smartAlarmFire;

        private Integer awakenings;

        private Integer light;

        private Integer mind;

        @JsonProperty("asleep_time")
        private Integer asleepTime;

        private Integer deep;

        private Integer awake;

        private Integer duration;

        @JsonProperty("tz")
        private String timezone;

        private Integer quality;

        @JsonProperty("awake_time")
        private Date awakeTime;

        /**
         * @return the body
         */
        public Integer getBody()
        {
            return body;
        }

        /**
         * @param body the body to set
         */
        public void setBody(Integer body)
        {
            this.body = body;
        }

        /**
         * @return the smartAlarmFire
         */
        public Integer getSmartAlarmFire()
        {
            return smartAlarmFire;
        }

        /**
         * @param smartAlarmFire the smartAlarmFire to set
         */
        public void setSmartAlarmFire(Integer smartAlarmFire)
        {
            this.smartAlarmFire = smartAlarmFire;
        }

        /**
         * @return the awakenings
         */
        public Integer getAwakenings()
        {
            return awakenings;
        }

        /**
         * @param awakenings the awakenings to set
         */
        public void setAwakenings(Integer awakenings)
        {
            this.awakenings = awakenings;
        }

        /**
         * @return the light
         */
        public Integer getLight()
        {
            return light;
        }

        /**
         * @param light the light to set
         */
        public void setLight(Integer light)
        {
            this.light = light;
        }

        /**
         * @return the mind
         */
        public Integer getMind()
        {
            return mind;
        }

        /**
         * @param mind the mind to set
         */
        public void setMind(Integer mind)
        {
            this.mind = mind;
        }

        /**
         * @return the asleepTime
         */
        public Integer getAsleepTime()
        {
            return asleepTime;
        }

        /**
         * @param asleepTime the asleepTime to set
         */
        public void setAsleepTime(Integer asleepTime)
        {
            this.asleepTime = asleepTime;
        }

        /**
         * @return the deep
         */
        public Integer getDeep()
        {
            return deep;
        }

        /**
         * @param deep the deep to set
         */
        public void setDeep(Integer deep)
        {
            this.deep = deep;
        }

        /**
         * @return the awake
         */
        public Integer getAwake()
        {
            return awake;
        }

        /**
         * @param awake the awake to set
         */
        public void setAwake(Integer awake)
        {
            this.awake = awake;
        }

        /**
         * @return the duration
         */
        public Integer getDuration()
        {
            return duration;
        }

        /**
         * @param duration the duration to set
         */
        public void setDuration(Integer duration)
        {
            this.duration = duration;
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
         * @return the quality
         */
        public Integer getQuality()
        {
            return quality;
        }

        /**
         * @param quality the quality to set
         */
        public void setQuality(Integer quality)
        {
            this.quality = quality;
        }

        /**
         * @return the awakeTime
         */
        public Date getAwakeTime()
        {
            return awakeTime;
        }

        /**
         * @param awakeTime the awakeTime to set
         */
        public void setAwakeTime(Date awakeTime)
        {
            this.awakeTime = awakeTime;
        }
    }
}
