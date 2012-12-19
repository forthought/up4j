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

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang.builder.ToStringBuilder;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.up4j.impl.DefaultAPIImpl;

/**
 */
public class APITest
{

    public APITest()
    {
    }

    // provide your email here
    private String email = "";

    // provide your password here
    private String password = "";

    private API api;

    private Settings settings;

    @Before
    public void setUp() throws IOException
    {
        Properties properties = System.getProperties();
        if (properties.contains("test.email"))
        {
            email = properties.getProperty("test.email");
        }
        if (properties.contains("test.password"))
        {
            password = properties.getProperty("test.password");
        }

        api = DefaultAPIImpl.newInstance();
        settings = api.login(email, password);
    }

    /**
     * Test of login method, of class API.
     */
    @Test
    public void testLogin() throws Exception
    {
        System.out.println("login");
        assertNotNull(settings);
    }

    /**
     * Test of getSettings method, of class API.
     */
    @Test
    public void testGetSettings() throws Exception
    {
        System.out.println("getSettings");
        Settings settings2 = api.getSettings();
        assertNotNull(settings2);
    }

    /**
     * Test of getFriends method, of class API.
     */
    @Test
    public void testGetFriends_0args() throws Exception
    {
        System.out.println("getFriends");
        List<User> friends = api.getFriends();
        assertNotNull(friends);
        for (User user : friends)
        {
            System.out.println(ToStringBuilder.reflectionToString(user));
        }
    }

    /**
     * Test of getFriends method, of class API.
     */
    @Test
    public void testGetFriends_String() throws Exception
    {
        System.out.println("getFriends");
        List<User> friends = api.getFriends(settings.getXid());
        assertNotNull(friends);
        for (User user : friends)
        {
            System.out.println(ToStringBuilder.reflectionToString(user));
        }
    }

    /**
     * Test of getScore method, of class API.
     */
    @Test
    public void testGetScore_0args() throws Exception
    {
        System.out.println("getScore");
        Score score = api.getScore();
        assertNotNull(score);
        System.out.println(ToStringBuilder.reflectionToString(score));
    }

    /**
     * Test of getScore method, of class API.
     */
    @Test
    public void testGetScore_String() throws Exception
    {
        System.out.println("getScore");
        Score score = api.getScore(settings.getXid());
        assertNotNull(score);
        System.out.println(ToStringBuilder.reflectionToString(score));

    }

    /**
     * Test of getTimeline method, of class API.
     */
    @Test
    public void testGetTimeline() throws Exception
    {
        System.out.println("getTimeline");
        List<Activity> timeline = api.getTimeline(20);
        assertNotNull(timeline);
        for (Activity activity : timeline)
        {
            System.out.println(ToStringBuilder.reflectionToString(activity));
        }
    }
}
