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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSettings
{
    private Integer uid;

    private String xid;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String first;

    private String last;

    private String name;

    private String image;

    private Integer type;

    @JsonProperty("band_name")
    private String bandName;

    @JsonProperty("share_move")
    private boolean shareMove;

    @JsonProperty("share_sleep")
    private boolean shareSleep;

    @JsonProperty("share_eat")
    private boolean shareEat;

    @JsonProperty("share_mood")
    private boolean shareMood;

    @JsonProperty("birth_day")
    private Integer birthDay;

    @JsonProperty("birth_month")
    private Integer birthMonth;

    @JsonProperty("birth_year")
    private Integer birthYear;

    private String email;

    private String gender;

    @JsonProperty("profile_privacy")
    private String profilePrivacy;

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    @JsonProperty("time_created")
    private Date created;

    @JsonProperty("data_1")
    private Integer data1;

    @JsonProperty("data_2")
    private Integer data2;

    @JsonProperty("flags")
    private Integer flags;

    @JsonProperty("text_1")
    private String text1;

    @JsonProperty("up_goals")
    private Goals goals;

    @JsonProperty("active_alert")
    private ActiveAlert activeAlert;

    @JsonProperty("basic_info")
    private BasicInfo basicInfo;

    @JsonProperty("smart_alarm")
    private SmartAlarm smartAlarm;

    @JsonProperty("power_nap")
    private PowerNap powerNap;

    /**
     * @return the uid
     */
    public Integer getUid()
    {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Integer uid)
    {
        this.uid = uid;
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
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the first
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first)
    {
        this.first = first;
    }

    /**
     * @return the last
     */
    public String getLast()
    {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(String last)
    {
        this.last = last;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the image
     */
    public String getImage()
    {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image)
    {
        this.image = image;
    }

    /**
     * @return the type
     */
    public Integer getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type)
    {
        this.type = type;
    }

    /**
     * @return the bandName
     */
    public String getBandName()
    {
        return bandName;
    }

    /**
     * @param bandName the bandName to set
     */
    public void setBandName(String bandName)
    {
        this.bandName = bandName;
    }

    /**
     * @return the shareMove
     */
    public boolean isShareMove()
    {
        return shareMove;
    }

    /**
     * @param shareMove the shareMove to set
     */
    public void setShareMove(boolean shareMove)
    {
        this.shareMove = shareMove;
    }

    /**
     * @return the shareSleep
     */
    public boolean isShareSleep()
    {
        return shareSleep;
    }

    /**
     * @param shareSleep the shareSleep to set
     */
    public void setShareSleep(boolean shareSleep)
    {
        this.shareSleep = shareSleep;
    }

    /**
     * @return the shareEat
     */
    public boolean isShareEat()
    {
        return shareEat;
    }

    /**
     * @param shareEat the shareEat to set
     */
    public void setShareEat(boolean shareEat)
    {
        this.shareEat = shareEat;
    }

    /**
     * @return the shareMood
     */
    public boolean isShareMood()
    {
        return shareMood;
    }

    /**
     * @param shareMood the shareMood to set
     */
    public void setShareMood(boolean shareMood)
    {
        this.shareMood = shareMood;
    }

    /**
     * @return the birthDay
     */
    public Integer getBirthDay()
    {
        return birthDay;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(Integer birthDay)
    {
        this.birthDay = birthDay;
    }

    /**
     * @return the birthMonth
     */
    public Integer getBirthMonth()
    {
        return birthMonth;
    }

    /**
     * @param birthMonth the birthMonth to set
     */
    public void setBirthMonth(Integer birthMonth)
    {
        this.birthMonth = birthMonth;
    }

    /**
     * @return the birthYear
     */
    public Integer getBirthYear()
    {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(Integer birthYear)
    {
        this.birthYear = birthYear;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * @return the profilePrivacy
     */
    public String getProfilePrivacy()
    {
        return profilePrivacy;
    }

    /**
     * @param profilePrivacy the profilePrivacy to set
     */
    public void setProfilePrivacy(String profilePrivacy)
    {
        this.profilePrivacy = profilePrivacy;
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
     * @return the data1
     */
    public Integer getData1()
    {
        return data1;
    }

    /**
     * @param data1 the data1 to set
     */
    public void setData1(Integer data1)
    {
        this.data1 = data1;
    }

    /**
     * @return the data2
     */
    public Integer getData2()
    {
        return data2;
    }

    /**
     * @param data2 the data2 to set
     */
    public void setData2(Integer data2)
    {
        this.data2 = data2;
    }

    /**
     * @return the flags
     */
    public Integer getFlags()
    {
        return flags;
    }

    /**
     * @param flags the flags to set
     */
    public void setFlags(Integer flags)
    {
        this.flags = flags;
    }

    /**
     * @return the text1
     */
    public String getText1()
    {
        return text1;
    }

    /**
     * @param text1 the text1 to set
     */
    public void setText1(String text1)
    {
        this.text1 = text1;
    }

    /**
     * @return the goals
     */
    public Goals getGoals()
    {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(Goals goals)
    {
        this.goals = goals;
    }

    /**
     * @return the activeAlert
     */
    public ActiveAlert getActiveAlert()
    {
        return activeAlert;
    }

    /**
     * @param activeAlert the activeAlert to set
     */
    public void setActiveAlert(ActiveAlert activeAlert)
    {
        this.activeAlert = activeAlert;
    }

    /**
     * @return the basicInfo
     */
    public BasicInfo getBasicInfo()
    {
        return basicInfo;
    }

    /**
     * @param basicInfo the basicInfo to set
     */
    public void setBasicInfo(BasicInfo basicInfo)
    {
        this.basicInfo = basicInfo;
    }

    /**
     * @return the smartAlarm
     */
    public SmartAlarm getSmartAlarm()
    {
        return smartAlarm;
    }

    /**
     * @param smartAlarm the smartAlarm to set
     */
    public void setSmartAlarm(SmartAlarm smartAlarm)
    {
        this.smartAlarm = smartAlarm;
    }

    /**
     * @return the powerNap
     */
    public PowerNap getPowerNap()
    {
        return powerNap;
    }

    /**
     * @param powerNap the powerNap to set
     */
    public void setPowerNap(PowerNap powerNap)
    {
        this.powerNap = powerNap;
    }

    public static class BasicInfo
    {

        private Double weight;

        @JsonProperty("dob")
        @JsonSerialize(using = JsonUtils.ISO8601DateSerializer.class)
        @JsonDeserialize(using = JsonUtils.ISO8601DateDeserializer.class)
        private Date birthDate;

        private Gender gender = Gender.Female;

        @JsonSerialize(using = JsonUtils.BooleanAsIntegerSerializer.class)
        private boolean metric;

        private Double height;

        private String locale;

        /**
         * @see {@link BasicInfo#setWeight(java.lang.Double) }
         * @return the weight
         */
        public Double getWeight()
        {
            return weight;
        }

        /**
         * @param weight the weight to set, in kg
         */
        public void setWeight(Double weight)
        {
            this.weight = weight;
        }

        /**
         * @return the birthDate
         */
        public Date getBirthDate()
        {
            return birthDate;
        }

        /**
         * @param birthDate the birthDate to set
         */
        public void setBirthDate(Date birthDate)
        {
            this.birthDate = birthDate;
        }

        /**
         * @return the gender
         */
        public Gender getGender()
        {
            return gender;
        }

        /**
         * @param gender the gender to set
         */
        public void setGender(Gender gender)
        {
            this.gender = gender;
        }

        /**
         * @return the height
         */
        public Double getHeight()
        {
            return height;
        }

        /**
         * @param height the height to set
         */
        public void setHeight(Double height)
        {
            this.height = height;
        }

        /**
         * @return the locale
         */
        public String getLocale()
        {
            return locale;
        }

        /**
         * @param locale the locale to set
         */
        public void setLocale(String locale)
        {
            this.locale = locale;
        }

        /**
         * @return the metric
         */
        public boolean isMetric()
        {
            return metric;
        }

        /**
         * @param metric the metric to set
         */
        public void setMetric(boolean metric)
        {
            this.metric = metric;
        }

        public static enum Gender
        {

            Male, Female
        }
    }

    public static class ActiveAlert
    {

        private Integer stopTimeMinsPastMidnight;

        private Integer threshold;

        private Integer durationMins;

        private Integer type;

        private Integer startTimeMinsPastMidnight;

        /**
         * @return the stopTimeMinsPastMidnight
         */
        public Integer getStopTimeMinsPastMidnight()
        {
            return stopTimeMinsPastMidnight;
        }

        /**
         * @param stopTimeMinsPastMidnight the stopTimeMinsPastMidnight to set
         */
        public void setStopTimeMinsPastMidnight(Integer stopTimeMinsPastMidnight)
        {
            this.stopTimeMinsPastMidnight = stopTimeMinsPastMidnight;
        }

        /**
         * @return the threshold
         */
        public Integer getThreshold()
        {
            return threshold;
        }

        /**
         * @param threshold the threshold to set
         */
        public void setThreshold(Integer threshold)
        {
            this.threshold = threshold;
        }

        /**
         * @return the durationMins
         */
        public Integer getDurationMins()
        {
            return durationMins;
        }

        /**
         * @param durationMins the durationMins to set
         */
        public void setDurationMins(Integer durationMins)
        {
            this.durationMins = durationMins;
        }

        /**
         * @return the type
         */
        public Integer getType()
        {
            return type;
        }

        /**
         * @param type the type to set
         */
        public void setType(Integer type)
        {
            this.type = type;
        }

        /**
         * @return the startTimeMinsPastMidnight
         */
        public Integer getStartTimeMinsPastMidnight()
        {
            return startTimeMinsPastMidnight;
        }

        /**
         * @param startTimeMinsPastMidnight the startTimeMinsPastMidnight to set
         */
        public void setStartTimeMinsPastMidnight(
                Integer startTimeMinsPastMidnight)
        {
            this.startTimeMinsPastMidnight = startTimeMinsPastMidnight;
        }
    }

    public static class SmartAlarm
    {

        private Integer stopTimeMinsPastMidnight;

        private Integer dayMask;

        private Integer startTimeMinsPastMidnight;

        /**
         * @return the stopTimeMinsPastMidnight
         */
        public Integer getStopTimeMinsPastMidnight()
        {
            return stopTimeMinsPastMidnight;
        }

        /**
         * @param stopTimeMinsPastMidnight the stopTimeMinsPastMidnight to set
         */
        public void setStopTimeMinsPastMidnight(Integer stopTimeMinsPastMidnight)
        {
            this.stopTimeMinsPastMidnight = stopTimeMinsPastMidnight;
        }

        /**
         * @return the dayMask
         */
        public Integer getDayMask()
        {
            return dayMask;
        }

        /**
         * @param dayMask the dayMask to set
         */
        public void setDayMask(Integer dayMask)
        {
            this.dayMask = dayMask;
        }

        /**
         * @return the startTimeMinsPastMidnight
         */
        public Integer getStartTimeMinsPastMidnight()
        {
            return startTimeMinsPastMidnight;
        }

        /**
         * @param startTimeMinsPastMidnight the startTimeMinsPastMidnight to set
         */
        public void setStartTimeMinsPastMidnight(
                Integer startTimeMinsPastMidnight)
        {
            this.startTimeMinsPastMidnight = startTimeMinsPastMidnight;
        }
    }

    public static class PowerNap
    {
        //TODO could be a boolean

        @JsonProperty("use_optimal_duration")
        private Integer useOptimalDuration;

        @JsonProperty("custom_duration")
        private Integer customDuration;

        @JsonProperty("maximum_duration")
        private Integer maxDuration;

        /**
         * @return the useOptimalDuration
         */
        public Integer getUseOptimalDuration()
        {
            return useOptimalDuration;
        }

        /**
         * @param useOptimalDuration the useOptimalDuration to set
         */
        public void setUseOptimalDuration(Integer useOptimalDuration)
        {
            this.useOptimalDuration = useOptimalDuration;
        }

        /**
         * @return the customDuration
         */
        public Integer getCustomDuration()
        {
            return customDuration;
        }

        /**
         * @param customDuration the customDuration to set
         */
        public void setCustomDuration(Integer customDuration)
        {
            this.customDuration = customDuration;
        }

        /**
         * @return the maxDuration
         */
        public Integer getMaxDuration()
        {
            return maxDuration;
        }

        /**
         * @param maxDuration the maxDuration to set
         */
        public void setMaxDuration(Integer maxDuration)
        {
            this.maxDuration = maxDuration;
        }
    }
}
