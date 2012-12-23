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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This needs reworking - it is not accurate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Score
{

    private Move move;

    private Sleep sleep;

    private Meals meals;

    private Map<String, List<Insight>> insights;

    /**
     * @return the move
     */
    public Move getMove()
    {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(Move move)
    {
        this.move = move;
    }

    /**
     * @return the sleep
     */
    public Sleep getSleep()
    {
        return sleep;
    }

    /**
     * @param sleep the sleep to set
     */
    public void setSleep(Sleep sleep)
    {
        this.sleep = sleep;
    }

    /**
     * @return the meals
     */
    public Meals getMeals()
    {
        return meals;
    }

    /**
     * @param meals the meals to set
     */
    public void setMeals(Meals meals)
    {
        this.meals = meals;
    }

    /**
     * @return the insights
     */
    public Map<String, List<Insight>> getInsights()
    {
        return insights;
    }

    /**
     * @param insights the insights to set
     */
    public void setInsights(Map<String, List<Insight>> insights)
    {
        this.insights = insights;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Insight
    {

        private String category;

        private String xid;

        private String head;

        private String title;

        private Date timestamp;

        @JsonProperty("source_url")
        private String sourceUrl;

        @JsonProperty("action_url")
        private String actionUrl;

        private String text;

        private String group;

        public Insight()
        {
        }

        /**
         * @return the category
         */
        public String getCategory()
        {
            return category;
        }

        /**
         * @param category the category to set
         */
        public void setCategory(String category)
        {
            this.category = category;
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
         * @return the head
         */
        public String getHead()
        {
            return head;
        }

        /**
         * @param head the head to set
         */
        public void setHead(String head)
        {
            this.head = head;
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
         * @return the timestamp
         */
        public Date getTimestamp()
        {
            return timestamp;
        }

        /**
         * @param timestamp the timestamp to set
         */
        public void setTimestamp(Date timestamp)
        {
            this.timestamp = timestamp;
        }

        /**
         * @return the sourceUrl
         */
        public String getSourceUrl()
        {
            return sourceUrl;
        }

        /**
         * @param sourceUrl the sourceUrl to set
         */
        public void setSourceUrl(String sourceUrl)
        {
            this.sourceUrl = sourceUrl;
        }

        /**
         * @return the actionUrl
         */
        public String getActionUrl()
        {
            return actionUrl;
        }

        /**
         * @param actionUrl the actionUrl to set
         */
        public void setActionUrl(String actionUrl)
        {
            this.actionUrl = actionUrl;
        }

        /**
         * @return the text
         */
        public String getText()
        {
            return text;
        }

        /**
         * @param text the text to set
         */
        public void setText(String text)
        {
            this.text = text;
        }

        /**
         * @return the group
         */
        public String getGroup()
        {
            return group;
        }

        /**
         * @param group the group to set
         */
        public void setGroup(String group)
        {
            this.group = group;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meals
    {

        @JsonProperty("num_meals")
        private Integer mealCount;

        private Integer calories;

        @JsonProperty("num_drinks")
        private Integer drinkCount;

        @JsonProperty("num_foods")
        private Integer foodCount;

        private boolean hidden;

        public Meals()
        {
        }

        /**
         * @return the mealCount
         */
        public Integer getMealCount()
        {
            return mealCount;
        }

        /**
         * @param mealCount the mealCount to set
         */
        public void setMealCount(Integer mealCount)
        {
            this.mealCount = mealCount;
        }

        /**
         * @return the calories
         */
        public Integer getCalories()
        {
            return calories;
        }

        /**
         * @param calories the calories to set
         */
        public void setCalories(Integer calories)
        {
            this.calories = calories;
        }

        /**
         * @return the drinkCount
         */
        public Integer getDrinkCount()
        {
            return drinkCount;
        }

        /**
         * @param drinkCount the drinkCount to set
         */
        public void setDrinkCount(Integer drinkCount)
        {
            this.drinkCount = drinkCount;
        }

        /**
         * @return the foodCount
         */
        public Integer getFoodCount()
        {
            return foodCount;
        }

        /**
         * @param foodCount the foodCount to set
         */
        public void setFoodCount(Integer foodCount)
        {
            this.foodCount = foodCount;
        }

        /**
         * @return the hidden
         */
        public boolean isHidden()
        {
            return hidden;
        }

        /**
         * @param hidden the hidden to set
         */
        public void setHidden(boolean hidden)
        {
            this.hidden = hidden;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Move
    {

        @JsonProperty("active_time")
        private Double activeTime;

        @JsonProperty("longest_idle")
        private Double longestIdle;

        @JsonProperty("longest_active")
        private Double longestActive;

        private Double calories;

        @JsonProperty("bmr_calories_day")
        private Double bmrCaloriesDay;

        @JsonProperty("bmr_calories")
        private Double bmrCalories;

        @JsonProperty("bg_steps")
        private Double bgSteps;

        private Double distance;

        private boolean hidden;

        public Move()
        {
        }

        /**
         * @return the activeTime
         */
        public Double getActiveTime()
        {
            return activeTime;
        }

        /**
         * @param activeTime the activeTime to set
         */
        public void setActiveTime(Double activeTime)
        {
            this.activeTime = activeTime;
        }

        /**
         * @return the longestIdle
         */
        public Double getLongestIdle()
        {
            return longestIdle;
        }

        /**
         * @param longestIdle the longestIdle to set
         */
        public void setLongestIdle(Double longestIdle)
        {
            this.longestIdle = longestIdle;
        }

        /**
         * @return the longestActive
         */
        public Double getLongestActive()
        {
            return longestActive;
        }

        /**
         * @param longestActive the longestActive to set
         */
        public void setLongestActive(Double longestActive)
        {
            this.longestActive = longestActive;
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
         * @return the bmrCaloriesDay
         */
        public Double getBmrCaloriesDay()
        {
            return bmrCaloriesDay;
        }

        /**
         * @param bmrCaloriesDay the bmrCaloriesDay to set
         */
        public void setBmrCaloriesDay(Double bmrCaloriesDay)
        {
            this.bmrCaloriesDay = bmrCaloriesDay;
        }

        /**
         * @return the bmrCalories
         */
        public Double getBmrCalories()
        {
            return bmrCalories;
        }

        /**
         * @param bmrCalories the bmrCalories to set
         */
        public void setBmrCalories(Double bmrCalories)
        {
            this.bmrCalories = bmrCalories;
        }

        /**
         * @return the bgSteps
         */
        public Double getBgSteps()
        {
            return bgSteps;
        }

        /**
         * @param bgSteps the bgSteps to set
         */
        public void setBgSteps(Double bgSteps)
        {
            this.bgSteps = bgSteps;
        }

        /**
         * @return the distance
         */
        public Double getDistance()
        {
            return distance;
        }

        /**
         * @param distance the distance to set
         */
        public void setDistance(Double distance)
        {
            this.distance = distance;
        }

        /**
         * @return the hidden
         */
        public boolean isHidden()
        {
            return hidden;
        }

        /**
         * @param hidden the hidden to set
         */
        public void setHidden(boolean hidden)
        {
            this.hidden = hidden;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sleep
    {

        private Integer awakenings;

        private Double light;

        private Double awake;

        @JsonProperty("time_to_sleep")
        private Integer timeToSleep;

        private List<Integer> qualities;

        private boolean hidden;

        public Sleep()
        {
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
        public Double getLight()
        {
            return light;
        }

        /**
         * @param light the light to set
         */
        public void setLight(Double light)
        {
            this.light = light;
        }

        /**
         * @return the awake
         */
        public Double getAwake()
        {
            return awake;
        }

        /**
         * @param awake the awake to set
         */
        public void setAwake(Double awake)
        {
            this.awake = awake;
        }

        /**
         * @return the timeToSleep
         */
        public Integer getTimeToSleep()
        {
            return timeToSleep;
        }

        /**
         * @param timeToSleep the timeToSleep to set
         */
        public void setTimeToSleep(Integer timeToSleep)
        {
            this.timeToSleep = timeToSleep;
        }

        /**
         * @return the qualities
         */
        public List<Integer> getQualities()
        {
            return qualities;
        }

        /**
         * @param qualities the qualities to set
         */
        public void setQualities(List<Integer> qualities)
        {
            this.qualities = qualities;
        }

        /**
         * @return the hidden
         */
        public boolean isHidden()
        {
            return hidden;
        }

        /**
         * @param hidden the hidden to set
         */
        public void setHidden(boolean hidden)
        {
            this.hidden = hidden;
        }
    }
}
