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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang.builder.ToStringBuilder;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.up4j.Meal.FoodItem;
import org.up4j.UserSettings.ActiveAlert;
import org.up4j.UserSettings.BasicInfo;
import org.up4j.UserSettings.PowerNap;
import org.up4j.UserSettings.SmartAlarm;
import org.up4j.impl.DefaultAPIImpl;
import org.up4j.impl.JsonResponseListener;

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

    private AuthenticationResponse authenticationResponse;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonResponseHolder jsonResponseHolder;

    static class JsonResponseHolder implements JsonResponseListener
    {

        private JsonNode json;

        public JsonNode getJson()
        {
            return json;
        }

        @Override
        public void onResponse(JsonNode json)
        {
            this.json = json;
        }
    }

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
        jsonResponseHolder = new JsonResponseHolder();
        ((DefaultAPIImpl) api).addJsonResponseListener(jsonResponseHolder);
        authenticationResponse = api.login(email, password);
    }

    /**
     * Test of login method, of class API.
     */
    @Test
    public void testLogin() throws Exception
    {
        System.out.println("login");
        assertNotNull(authenticationResponse);
        assertNotNull(authenticationResponse.getUserSettings());
    }

    /**
     * Test of getUserSettings method, of class API.
     */
    @Test
    public void testGetSettings() throws Exception
    {
        System.out.println("getSettings");
        UserSettings settings2 = api.getUserSettings();
        assertNotNull(settings2);

        JsonNode dataNode = jsonResponseHolder.getJson().get("data");
        System.out.println(dataNode.toString());
        System.out.println(OBJECT_MAPPER.writeValueAsString(settings2));

        assertTrue(dataNode.get("basic_info").equals(OBJECT_MAPPER.convertValue(settings2.
                getBasicInfo(), JsonNode.class)));
        assertTrue(dataNode.get("smart_alarm").equals(OBJECT_MAPPER.convertValue(settings2.
                getSmartAlarm(), JsonNode.class)));
        assertTrue(dataNode.get("up_goals").equals(OBJECT_MAPPER.convertValue(settings2.
                getGoals(), JsonNode.class)));
        assertTrue(dataNode.get("power_nap").equals(OBJECT_MAPPER.convertValue(settings2.
                getPowerNap(), JsonNode.class)));
        assertTrue(dataNode.get("active_alert").equals(OBJECT_MAPPER.
                convertValue(settings2.getActiveAlert(), JsonNode.class)));
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
        List<User> friends = api.getFriends(authenticationResponse.
                getUserSettings().getXid());
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
        Score score = api.getScore(authenticationResponse.getUserSettings().
                getXid());
        assertNotNull(score);
        System.out.println(ToStringBuilder.reflectionToString(score));

    }

    /**
     * Test of getFeed method, of class API.
     */
    @Test
    public void testGetTimeline() throws Exception
    {
        System.out.println("getTimeline");
        Iterator<List<Activity>> timeline = api.getFeed();
        assertNotNull(timeline);
        if (timeline.hasNext())
        {
            List<Activity> page = timeline.next();
            for (Activity activity : page)
            {
                System.out.println(ToStringBuilder.reflectionToString(activity));
            }
        }
    }

    @Test
    public void testGetFeatures() throws Exception
    {
        System.out.println("getFeatures");
        Map<String, Boolean> features = api.getFeatures();
        assertNotNull(features);
        for (Map.Entry<String, Boolean> entry : features.entrySet())
        {
            String feature = entry.getKey();
            Boolean isOn = entry.getValue();
            System.out.println("feature = " + feature);
            System.out.println("isOn = " + isOn);
        }
    }

    private <T> void checkSettings(T current, T updated) throws Exception
    {
        System.out.println(ToStringBuilder.reflectionToString(current));
        System.out.println(ToStringBuilder.reflectionToString(updated));
        assertTrue(OBJECT_MAPPER.convertValue(current, JsonNode.class).equals(
                OBJECT_MAPPER.convertValue(updated, JsonNode.class)));
    }

    @Test
    public void testSetPowerNap() throws Exception
    {
        System.out.println("setPowerNap");
        PowerNap current =
                authenticationResponse.getUserSettings().getPowerNap();
        PowerNap updated = api.setPowerNap(current);
        checkSettings(current, updated);
    }

    @Test
    public void testSetActiveAlert() throws Exception
    {
        System.out.println("setActiveAlert");
        ActiveAlert current = authenticationResponse.getUserSettings().
                getActiveAlert();
        ActiveAlert updated = api.setActiveAlert(current);
        checkSettings(current, updated);
    }

    @Test
    public void testSetBasicInfo() throws Exception
    {
        System.out.println("setBasicInfo");
        BasicInfo current = authenticationResponse.getUserSettings().
                getBasicInfo();
        BasicInfo updated = api.setBasicInfo(current);
        checkSettings(current, updated);
    }

    @Test
    public void testSetSmartAlarm() throws Exception
    {
        System.out.println("setSmartAlarm");
        SmartAlarm current = authenticationResponse.getUserSettings().
                getSmartAlarm();
        SmartAlarm updated = api.setSmartAlarm(current);
        checkSettings(current, updated);
    }

    @Test
    public void testGetMoves() throws Exception
    {
        System.out.println("getMoves");
        Iterator<List<Move>> moves = api.getMoves();
        assertNotNull(moves);
        System.out.println(jsonResponseHolder.getJson().toString());

        if (moves.hasNext())
        {
            List<Move> page = moves.next();
            for (Move move : page)
            {
                System.out.println(ToStringBuilder.reflectionToString(move));
            }
            if (!page.isEmpty())
            {
                Move move = page.get(0);
                Move getById = api.getMove(move.getXid());
                assertNotNull(getById);
                assertEquals(move.getXid(), getById.getXid());

                List<Tick> ticks = api.getTicks(move.getXid());
                assertNotNull(ticks);
                for (Tick tick : ticks)
                {
                    System.out.println(ToStringBuilder.reflectionToString(tick));
                }
                List<TimeSlice> snapshot = api.getMoveSnapshot(move.getXid());
                for (TimeSlice timeSlice : snapshot)
                {
                    System.out.println(ToStringBuilder.reflectionToString(
                            timeSlice));
                }
            }
        }
    }

    @Test
    public void testGetSleeps() throws Exception
    {
        System.out.println("getSleeps");
        Iterator<List<Sleep>> sleeps = api.getSleeps();
        assertNotNull(sleeps);
        System.out.println(jsonResponseHolder.getJson().toString());

        if (sleeps.hasNext())
        {
            List<Sleep> page = sleeps.next();
            for (Sleep sleep : page)
            {
                System.out.println(ToStringBuilder.reflectionToString(sleep));
            }
            if (!page.isEmpty())
            {
                Sleep sleep = page.get(0);
                Sleep getById = api.getSleep(sleep.getXid());
                assertNotNull(getById);
                assertEquals(sleep.getXid(), getById.getXid());

                List<TimeSlice> snapshot = api.getSleepSnapshot(sleep.getXid());
                for (TimeSlice timeSlice : snapshot)
                {
                    System.out.println(ToStringBuilder.reflectionToString(
                            timeSlice));
                }
            }
        }
    }

    @Test
    public void testGetMeals() throws Exception
    {
        System.out.println("getMeals");
        Iterator<List<Meal>> meals = api.getMeals();
        assertNotNull(meals);
        System.out.println(jsonResponseHolder.getJson().toString());

        if (meals.hasNext())
        {
            List<Meal> page = meals.next();
            for (Meal meal : page)
            {
                System.out.println(ToStringBuilder.reflectionToString(meal));
            }
            if (!page.isEmpty())
            {
                Meal meal = page.get(0);
                Meal getById = api.getMeal(meal.getXid());
                assertNotNull(getById);
                assertEquals(meal.getXid(), getById.getXid());
                List<FoodItem> items = getById.getItems();
                if (items != null)
                {
                    for (FoodItem foodItem : items)
                    {
                        System.out.println(ToStringBuilder.reflectionToString(
                                foodItem));
                    }
                }
            }
        }
    }
}
