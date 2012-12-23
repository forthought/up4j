/*
 * Copyright (C) 2012 forthought, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.up4j.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.up4j.*;
import org.up4j.UserSettings.ActiveAlert;
import org.up4j.UserSettings.BasicInfo;
import org.up4j.UserSettings.PowerNap;
import org.up4j.UserSettings.SmartAlarm;

/**
 *
 */
public class DefaultAPIImpl implements API
{

    private static final Logger log = LoggerFactory.getLogger(
            DefaultAPIImpl.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String SERVICE_NUDGE = "nudge";

    public static final String BASE_URL = "https://jawbone.com/";

    public static final String BASE_API_URL = "https://jawbone.com/nudge/api/";

    private static final String URL_LOGIN =
            String.format("%suser/signin/login", BASE_URL);

    private static final String URL_USERS_BASE =
            String.format("%susers", BASE_API_URL);

    private HttpClient client;

    private String token;

    private final List<JsonResponseListener> jsonResponseListeners = ListUtils.
            synchronizedList(new LinkedList<JsonResponseListener>());

    public void setClient(HttpClient client)
    {
        this.client = client;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return token;
    }

    public void setJsonResponseListeners(
            List<JsonResponseListener> jsonResponseListeners)
    {
        synchronized (this.jsonResponseListeners)
        {
            this.jsonResponseListeners.clear();
            this.jsonResponseListeners.addAll(jsonResponseListeners);
        }
    }

    public void addJsonResponseListener(JsonResponseListener... listeners)
    {
        this.jsonResponseListeners.addAll(Arrays.asList(listeners));
    }

    @Override
    public AuthenticationResponse login(String email, String password) throws
            IOException
    {
        HttpPost post = new HttpPost(URL_LOGIN);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>(3);
        nvps.add(new BasicNameValuePair("email", email));
        nvps.add(new BasicNameValuePair("pwd", password));
        nvps.add(new BasicNameValuePair("service", SERVICE_NUDGE));
        post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        HttpResponse response = client.execute(post);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            AuthenticationResponse authResponse =
                    OBJECT_MAPPER.treeToValue(node, AuthenticationResponse.class);
            setToken(authResponse.getAuthToken());
            return authResponse;
        }
        return null;
    }

    @Override
    public UserSettings getUserSettings() throws IOException
    {
        HttpGet get = new HttpGet(String.format("%s/@me/settings",
                URL_USERS_BASE));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            return OBJECT_MAPPER.treeToValue(node.get("data"),
                    UserSettings.class);
        }
        return null;
    }

    @Override
    public Iterator<List<Activity>> getFeed() throws IOException
    {
        return getFeed("@me");
    }

    @Override
    public Iterator<List<Activity>> getFeed(String xidUser) throws IOException
    {
        return getActivities(xidUser, "feed");
    }

    @Override
    public Iterator<List<Activity>> getSocialFeed() throws IOException
    {
        return getSocialFeed("@me");
    }

    @Override
    public Iterator<List<Activity>> getSocialFeed(String xidUser) throws
            IOException
    {
        return getActivities(xidUser, "social");
    }

    @Override
    public List<User> getFriends() throws IOException
    {
        return getFriends("@me");
    }

    @Override
    public List<User> getFriends(String xidUser) throws IOException
    {
        HttpGet get = new HttpGet(String.format("%s/%s/friends",
                URL_USERS_BASE, xidUser));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            JsonNode dataNode = node.get("data");
            if (dataNode.has("friends"))
            {
                dataNode = dataNode.get("friends");
            }
            if (dataNode.has("items"))
            {
                return OBJECT_MAPPER.readValue(dataNode.get("items").traverse(),
                        new TypeReference<List<User>>()
                        {
                        });
            }
        }
        return null;
    }

    @Override
    public Score getScore() throws IOException
    {
        return getScore("@me");
    }

    @Override
    public Score getScore(String xidUser) throws IOException
    {
        return getSingleDataItem(String.format("%s/%s/score",
                URL_USERS_BASE, xidUser), Score.class);
    }

    @Override
    public Map<String, Boolean> getFeatures() throws IOException
    {
        Map<String, Boolean> features = new HashMap<String, Boolean>();

        HttpGet get = new HttpGet(String.format("%s/features", BASE_API_URL));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            Iterator<JsonNode> it = node.get("data").get("items").iterator();
            while (it.hasNext())
            {
                JsonNode jsonNode = it.next();
                features.put(jsonNode.get("feature").asText(), StringUtils.
                        equalsIgnoreCase("on", jsonNode.get("status").asText()));

            }
        }
        return features;
    }

    public static API newInstance()
    {
        // in lieu of no Spring support, just putting factory method here
        DefaultAPIImpl api = new DefaultAPIImpl();
        api.setClient(new DefaultHttpClient());
        return api;
    }

    private JsonNode jsonResponse(HttpResponse response) throws IOException
    {
        HttpEntity entity = response.getEntity();
        if (response.getStatusLine().getStatusCode() / 100 == 2)
        {
            JsonNode node = OBJECT_MAPPER.readTree(entity.getContent());
            for (JsonResponseListener l : jsonResponseListeners)
            {
                l.onResponse(node);
            }
            return node;
        }
        else
        {
            throw new IOException(String.format("%s --> %s", response.
                    getStatusLine().toString(), EntityUtils.toString(entity)));
        }
    }

    private <T> T updateSettings(String param, T obj, Class<T> clazz) throws
            IOException
    {
        HttpPost post = new HttpPost(String.format("%s/@me/settings",
                URL_USERS_BASE));
        List<NameValuePair> nvps = new ArrayList<NameValuePair>(1);
        nvps.add(new BasicNameValuePair(param, OBJECT_MAPPER.writeValueAsString(
                obj)));
        post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        post.addHeader("x-nudge-token", getToken());

        HttpResponse response = client.execute(post);
        JsonNode node = jsonResponse(response);
        return node != null ? OBJECT_MAPPER.treeToValue(node.get("data").get(
                param), clazz) : null;
    }

    @Override
    public PowerNap setPowerNap(PowerNap settings) throws IOException
    {
        return updateSettings("power_nap", settings, PowerNap.class);
    }

    @Override
    public ActiveAlert setActiveAlert(ActiveAlert settings) throws IOException
    {
        return updateSettings("active_alert", settings, ActiveAlert.class);
    }

    @Override
    public BasicInfo setBasicInfo(BasicInfo settings) throws IOException
    {
        return updateSettings("basic_info", settings, BasicInfo.class);
    }

    @Override
    public SmartAlarm setSmartAlarm(SmartAlarm settings) throws IOException
    {
        return updateSettings("smart_alarm", settings, SmartAlarm.class);
    }

    private <T> T getSingleDataItem(String url, Class<T> clazz) throws
            IOException
    {
        HttpGet get = new HttpGet(url);
        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            return OBJECT_MAPPER.readValue(node.get("data").traverse(), clazz);
        }
        return null;
    }

    @Override
    public Move getMove(String xid) throws IOException
    {
        return getSingleDataItem(String.format("%s/moves/%s", BASE_API_URL, xid),
                Move.class);
    }

    @Override
    public Meal getMeal(String xid) throws IOException
    {
        return getSingleDataItem(String.format("%s/meals/%s", BASE_API_URL, xid),
                Meal.class);
    }

    @Override
    public Sleep getSleep(String xid) throws IOException
    {
        return getSingleDataItem(
                String.format("%s/sleeps/%s", BASE_API_URL, xid), Sleep.class);
    }

    @Override
    public List<Tick> getTicks(String xidActivity) throws IOException
    {
        HttpGet get = new HttpGet(String.format("%s/moves/%s/ticks",
                BASE_API_URL, xidActivity));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            return OBJECT_MAPPER.readValue(node.get("data").traverse(),
                    new TypeReference<List<Tick>>()
                    {
                    });
        }
        return null;
    }

    private Iterator<List<Activity>> getActivities(String xidUser, String type) throws
            IOException
    {
        HttpGet get = new HttpGet(String.format(
                "%s/%s/%s", URL_USERS_BASE, xidUser, type));
        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            return new TimelineIterator(node);
        }
        return null;
    }

    @Override
    public Iterator<List<Meal>> getMeals() throws IOException
    {
        return getMeals("@me");
    }

    @Override
    public Iterator<List<Meal>> getMeals(String xidUser) throws IOException
    {
        return new DateIterator<Meal>(xidUser, "meals", Meal.class);
    }

    @Override
    public Iterator<List<Sleep>> getSleeps() throws IOException
    {
        return getSleeps("@me");
    }

    @Override
    public Iterator<List<Sleep>> getSleeps(String xidUser) throws IOException
    {
        return new DateIterator<Sleep>(xidUser, "sleeps", Sleep.class);
    }

    @Override
    public Iterator<List<Move>> getMoves() throws IOException
    {
        return getMoves("@me");
    }

    @Override
    public Iterator<List<Move>> getMoves(String xidUser) throws IOException
    {
        return new DateIterator<Move>(xidUser, "moves", Move.class);
    }

    public List<TimeSlice> getSnapshot(String url) throws IOException
    {
        HttpGet get = new HttpGet(url);

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        JsonNode node = jsonResponse(response);
        if (node != null)
        {
            List<Number[]> data = OBJECT_MAPPER.readValue(node.get("data").
                    traverse(),
                    new TypeReference<List<Number[]>>()
                    {
                    });
            List<TimeSlice> snapshot = new ArrayList<TimeSlice>();
            for (Number[] d : data)
            {
                TimeSlice s = new TimeSlice();
                s.setDate(new Date(d[0].longValue() * 1000));
                s.setAmount(d[1].doubleValue());
                snapshot.add(s);
            }
            return snapshot;
        }
        return null;
    }

    @Override
    public List<TimeSlice> getMoveSnapshot(String xid) throws IOException
    {
        return getSnapshot(String.format("%s/moves/%s/snapshot",
                BASE_API_URL, xid));
    }

    @Override
    public List<TimeSlice> getSleepSnapshot(String xid) throws IOException
    {
        return getSnapshot(String.format("%s/sleeps/%s/snapshot",
                BASE_API_URL, xid));
    }

    private class DateIterator<T> implements Iterator<List<T>>
    {

        private final int MAX_EMPTY_DAYS = 10;

        private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
                "yyyyMMdd");

        List<T> items;

        private final String xidUser;

        private final String type;

        private final Class<T> clazz;

        private Date date;

        public DateIterator(String xidUser, String type, Class<T> clazz) throws
                IOException
        {
            this.xidUser = xidUser;
            this.type = type;
            this.clazz = clazz;
            this.date = new Date();
        }

        @Override
        public boolean hasNext()
        {
            if (date != null)
            {
                try
                {
                    int emptyDays = 0;
                    while (emptyDays < MAX_EMPTY_DAYS)
                    {

                        String dateStr = DATE_FORMAT.format(date);

                        List<NameValuePair> nvps = new ArrayList<NameValuePair>(
                                1);
                        nvps.add(new BasicNameValuePair("date", dateStr));
                        String params = URLEncodedUtils.format(nvps,
                                Consts.UTF_8);
                        HttpGet get = new HttpGet(String.format("%s/%s/%s?%s",
                                URL_USERS_BASE, xidUser, type, params));
                        get.addHeader("x-nudge-token", getToken());
                        HttpResponse response = client.execute(get);
                        JsonNode node = jsonResponse(response);

                        if (node != null)
                        {
                            JsonNode dataNode = node.get("data");
                            if (dataNode.has("items"))
                            {
                                JsonNode itemsNode = dataNode.get("items");
                                items = new ArrayList<T>(itemsNode.size());
                                Iterator<JsonNode> it = itemsNode.iterator();
                                while (it.hasNext())
                                {
                                    JsonNode jsonNode = it.next();
                                    items.add(OBJECT_MAPPER.treeToValue(jsonNode,
                                            clazz));
                                }
                            }
                            // decrement date by 1 day
                            date = DateUtils.addDays(date, -1);
                            if (!items.isEmpty())
                            {
                                return true;
                            }

                            emptyDays++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                catch (IOException ex)
                {
                    log.error("Error fetching items", ex);
                }
            }
            date = null;
            return false;
        }

        @Override
        public List<T> next()
        {
            List<T> next = items;
            items = null;
            return next != null && !next.isEmpty() ? next : null;
        }

        @Override
        public void remove()
        {
            items = null;
        }
    }

    private class TimelineIterator implements Iterator<List<Activity>>
    {

        private JsonNode node;

        private String nextUrl;

        List<Activity> activities;

        public TimelineIterator(JsonNode node) throws IOException
        {
            this.node = node;
        }

        @Override
        public boolean hasNext()
        {
            if (!StringUtils.isBlank(nextUrl))
            {
                try
                {
                    HttpGet get = new HttpGet(String.format(
                            "%s/%s", BASE_URL, nextUrl));
                    nextUrl = null;
                    get.addHeader("x-nudge-token", getToken());
                    HttpResponse response = client.execute(get);
                    node = jsonResponse(response);
                }
                catch (IOException ex)
                {
                    log.error("Error fetching timeline", ex);
                }
            }

            if (node != null)
            {
                try
                {
                    activities = (List<Activity>) OBJECT_MAPPER.readValue(node.
                            get("data").get("feed").traverse(),
                            new TypeReference<List<Activity>>()
                            {
                            });
                    final JsonNode dataNode = node.get("data");

                    if (dataNode.has("links"))
                    {
                        JsonNode linksNode = dataNode.get("links");
                        if (linksNode.has("next"))
                        {
                            nextUrl = linksNode.get("next").textValue();
                        }
                    }
                    node = null;
                    return !activities.isEmpty();
                }
                catch (Exception ex)
                {
                    node = null;
                }
            }
            return false;
        }

        @Override
        public List<Activity> next()
        {
            List<Activity> next = activities;
            activities = null;
            return next != null && !next.isEmpty() ? next : null;
        }

        @Override
        public void remove()
        {
            activities = null;
        }
    }
}
