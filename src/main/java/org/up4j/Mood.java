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
public class Mood
{

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    @JsonProperty("time_created")
    private Date created;

    @JsonDeserialize(using = JsonUtils.EpochSecondsDateDeserializer.class)
    @JsonProperty("time_updated")
    private Date updated;

    private String xid;

    private String title;

    @JsonProperty("app_generated")
    private boolean appGenerated;

    private String date;

    private boolean shared;

    private String type;

    @JsonProperty("sub_type")
    private Integer subType;

    private User user;

    public Mood()
    {
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
     * @return the subType
     */
    public Integer getSubType()
    {
        return subType;
    }

    /**
     * @param subType the subType to set
     */
    public void setSubType(Integer subType)
    {
        this.subType = subType;
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
}
