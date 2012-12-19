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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.up4j.*;

/**
 *
 */
public class DefaultAPIImpl implements API
{

    private static final int DEFAULT_LIMIT = 30;

    private static final Logger log = LoggerFactory.getLogger(
            DefaultAPIImpl.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String SERVICE_NUDGE = "nudge";

    public static final String BASE_URL = "https://jawbone.com/";

    private static final String URL_LOGIN =
            String.format("%suser/signin/login", BASE_URL);

    private static final String URL_USERS_BASE =
            String.format("%snudge/api/users", BASE_URL);

    private HttpClient client;

    private String token;

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

    @Override
    public Settings login(String email, String password) throws IOException
    {
        HttpPost post = new HttpPost(URL_LOGIN);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>(3);
        nvps.add(new BasicNameValuePair("email", email));
        nvps.add(new BasicNameValuePair("pwd", password));
        nvps.add(new BasicNameValuePair("service", SERVICE_NUDGE));
        post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();

        if (response.getStatusLine().getStatusCode() / 100 == 2)
        {
            JsonNode node = OBJECT_MAPPER.readTree(entity.getContent());
            log.debug(node.toString());
            setToken(node.get("token").getTextValue());
            return OBJECT_MAPPER.treeToValue(node.get("user"), Settings.class);
        }
        else
        {
            EntityUtils.consume(entity);
        }
        return null;
    }

    @Override
    public Settings getSettings() throws IOException
    {
        HttpGet get = new HttpGet(String.format("%s/@me/settings",
                URL_USERS_BASE));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();

        if (response.getStatusLine().getStatusCode() / 100 == 2)
        {
            JsonNode node = OBJECT_MAPPER.readTree(entity.getContent());
            log.debug(node.toString());
            return OBJECT_MAPPER.treeToValue(node.get("data"), Settings.class);
        }
        else
        {
            EntityUtils.consume(entity);
        }
        return null;
    }

    @Override
    public List<Activity> getTimeline(Integer limit) throws IOException
    {
        HttpGet get = new HttpGet(String.format(
                "%s/@me/social", URL_USERS_BASE));

        limit = (limit != null && limit > 0) ? limit : DEFAULT_LIMIT;

        get.addHeader("x-nudge-token", getToken());
        get.getParams().setParameter("limit", limit);

        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();

        if (response.getStatusLine().getStatusCode() / 100 == 2)
        {
            JsonNode node = OBJECT_MAPPER.readTree(entity.getContent());
            log.debug(node.toString());
            final JsonNode feedNode = node.get("data").get("feed");
            return OBJECT_MAPPER.readValue(feedNode,
                    new TypeReference<List<Activity>>()
                    {
                    });
        }
        else
        {
            EntityUtils.consume(entity);
        }

//        parameters.add("after", null);
        return null;
    }

    @Override
    public List<User> getFriends() throws IOException
    {
        return getFriends(null);
    }

    @Override
    public List<User> getFriends(String xidUser) throws IOException
    {
        if (StringUtils.isBlank(xidUser))
        {
            xidUser = "@me";
        }
        HttpGet get = new HttpGet(String.format("%s/%s/friends",
                URL_USERS_BASE, xidUser));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();

        if (response.getStatusLine().getStatusCode() / 100 == 2)
        {
            JsonNode node = OBJECT_MAPPER.readTree(entity.getContent());
            log.debug(node.toString());
            JsonNode dataNode = node.get("data");
            if (dataNode.has("friends"))
            {
                dataNode = dataNode.get("friends");
            }
            if (dataNode.has("items"))
            {
                return OBJECT_MAPPER.readValue(dataNode.get("items"),
                        new TypeReference<List<User>>()
                        {
                        });
            }
        }
        else
        {
            EntityUtils.consume(entity);
        }
        return null;
    }

    @Override
    public Score getScore() throws IOException
    {
        return getScore(null);
    }

    @Override
    public Score getScore(String xidUser) throws IOException
    {
        if (StringUtils.isBlank(xidUser))
        {
            xidUser = "@me";
        }
        HttpGet get = new HttpGet(String.format("%s/%s/score",
                URL_USERS_BASE, xidUser));

        get.addHeader("x-nudge-token", getToken());
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();

        if (response.getStatusLine().getStatusCode() / 100 == 2)
        {
            JsonNode node = OBJECT_MAPPER.readTree(entity.getContent());
            log.debug(node.toString());
            JsonNode dataNode = node.get("data");
            return OBJECT_MAPPER.readValue(dataNode, Score.class);
        }
        else
        {
            EntityUtils.consume(entity);
        }
        return null;
    }

    public static API newInstance()
    {
        // in lieu of no Spring support, just putting factory method here
        DefaultAPIImpl api = new DefaultAPIImpl();
        api.setClient(new DefaultHttpClient());
        return api;
    }
}
