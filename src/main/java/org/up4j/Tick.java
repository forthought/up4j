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
public class Tick
{

    private Integer distance;

    @JsonProperty("active_time")
    private Integer activeTime;

    private boolean aerobic;

    private Double calories;

    private Integer steps;

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    private Date time;

    private Double speed;

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
     * @return the aerobic
     */
    public boolean isAerobic()
    {
        return aerobic;
    }

    /**
     * @param aerobic the aerobic to set
     */
    public void setAerobic(boolean aerobic)
    {
        this.aerobic = aerobic;
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
     * @return the time
     */
    public Date getTime()
    {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time)
    {
        this.time = time;
    }

    /**
     * @return the speed
     */
    public Double getSpeed()
    {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Double speed)
    {
        this.speed = speed;
    }
}
