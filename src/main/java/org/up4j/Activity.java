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

import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity
{

    @JsonProperty("activity_xid")
    private String activityXid;

    @JsonProperty("xid")
    private String xid;

    @JsonProperty("image")
    private String image;

    @JsonProperty("type")
    private String type;

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("is_completed")
    private Integer completed;

    @JsonProperty("steps")
    private Long steps;

    @JsonProperty("duration")
    private Long duration;

    @JsonProperty("awake")
    private Long awake;

    @JsonProperty("reaction")
    private Integer reaction;

    @JsonProperty("time_created")
    private Date created;

    @JsonProperty("time_updated")
    private Date updated;

    @JsonProperty("tz")
    private String timezone;

    @JsonProperty("reached_goal")
    private boolean reachedGoal;

    @JsonProperty("app_generated")
    private boolean appGenerated;

    @JsonProperty("is_private")
    private boolean privateActivity;

    @JsonProperty("quality")
    private Integer quality;

    @JsonProperty("user")
    private User user;

    @JsonProperty("comments")
    private List<Comment> comments;

    /**
     * @return the activityXid
     */
    public String getActivityXid()
    {
        return activityXid;
    }

    /**
     * @param activityXid the activityXid to set
     */
    public void setActivityXid(String activityXid)
    {
        this.activityXid = activityXid;
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
     * @return the subtitle
     */
    public String getSubtitle()
    {
        return subtitle;
    }

    /**
     * @param subtitle the subtitle to set
     */
    public void setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }

    /**
     * @return the completed
     */
    public Integer getCompleted()
    {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Integer completed)
    {
        this.completed = completed;
    }

    /**
     * @return the steps
     */
    public Long getSteps()
    {
        return steps;
    }

    /**
     * @param steps the steps to set
     */
    public void setSteps(Long steps)
    {
        this.steps = steps;
    }

    /**
     * @return the duration
     */
    public Long getDuration()
    {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    /**
     * @return the awake
     */
    public Long getAwake()
    {
        return awake;
    }

    /**
     * @param awake the awake to set
     */
    public void setAwake(Long awake)
    {
        this.awake = awake;
    }

    /**
     * @return the reaction
     */
    public Integer getReaction()
    {
        return reaction;
    }

    /**
     * @param reaction the reaction to set
     */
    public void setReaction(Integer reaction)
    {
        this.reaction = reaction;
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
     * @return the reachedGoal
     */
    public boolean isReachedGoal()
    {
        return reachedGoal;
    }

    /**
     * @param reachedGoal the reachedGoal to set
     */
    public void setReachedGoal(boolean reachedGoal)
    {
        this.reachedGoal = reachedGoal;
    }

    /**
     * @return the appGenerated
     */
    public boolean isAppGenerated()
    {
        return appGenerated;
    }

    /**
     * @param appGenerated the appGenerated to set
     */
    public void setAppGenerated(boolean appGenerated)
    {
        this.appGenerated = appGenerated;
    }

    /**
     * @return the privateActivity
     */
    public boolean isPrivateActivity()
    {
        return privateActivity;
    }

    /**
     * @param privateActivity the privateActivity to set
     */
    public void setPrivateActivity(boolean privateActivity)
    {
        this.privateActivity = privateActivity;
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
}
