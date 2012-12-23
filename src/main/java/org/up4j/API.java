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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.up4j.UserSettings.ActiveAlert;
import org.up4j.UserSettings.BasicInfo;
import org.up4j.UserSettings.PowerNap;
import org.up4j.UserSettings.SmartAlarm;

/**
 * Basic API for accessing your Jawbone UP data and team
 */
public interface API
{

    /**
     * Authenticates with the given credentials
     *
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    AuthenticationResponse login(String email, String password) throws
            IOException;

    /**
     * @return the map of system settings, along with if they are enabled or
     * disabled
     * @throws IOException
     */
    Map<String, Boolean> getFeatures() throws IOException;

    /**
     * @return the currently authenticated users' settings
     * @throws IOException
     */
    UserSettings getUserSettings() throws IOException;

    /**
     * @return the currently authenticated users' friends
     * @throws IOException
     */
    List<User> getFriends() throws IOException;

    /**
     * @param xidUser
     * @return the friends of the user with the given xid
     * @throws IOException
     */
    List<User> getFriends(String xidUser) throws IOException;

    /**
     * @param xidUser
     * @return the mutual friends between the authenticated user and the user
     * with the given xid
     * @throws IOException
     */
    List<User> getMutualFriends(String xidUser) throws IOException;

    /**
     * @return the currently authenticated users' score
     * @throws IOException
     */
    Score getScore() throws IOException;

    /**
     * @param xidUser
     * @return the score of the user with the given xid
     * @throws IOException
     */
    Score getScore(String xidUser) throws IOException;

    /**
     * Sets the {@link PowerNap} settings of the authenticated user
     *
     * @param settings
     * @return
     * @throws IOException
     */
    PowerNap setPowerNap(PowerNap settings) throws IOException;

    /**
     * Sets the {@link BasicInfo} of the authenticated user
     *
     * @param settings
     * @return
     * @throws IOException
     */
    BasicInfo setBasicInfo(BasicInfo settings) throws IOException;

    /**
     * Sets the {@link SmartAlarm} of the authenticated user
     *
     * @param settings
     * @return
     * @throws IOException
     */
    SmartAlarm setSmartAlarm(SmartAlarm settings) throws IOException;

    /**
     * Sets the {@link ActiveAlert} of the authenticated user
     *
     * @param settings
     * @return
     * @throws IOException
     */
    ActiveAlert setActiveAlert(ActiveAlert settings) throws IOException;

    /**
     * @return the timeline of the authenticated user
     * @throws IOException
     */
    Iterator<List<Activity>> getFeed() throws IOException;

    /**
     *
     * @param xidUser xid of the user whose feed is to be retrieved
     * @return the timeline of the user with the given xid
     * @throws IOException
     */
    Iterator<List<Activity>> getFeed(String xidUser) throws IOException;

    /**
     *
     * @return the social feed/timeline of the authenticated user
     * @throws IOException
     */
    Iterator<List<Activity>> getSocialFeed() throws IOException;

    /**
     *
     * @param xidUser xid of the user whose feed is to be retrieved
     * @return the social feed/timeline of the user with the given xid
     * @throws IOException
     */
    Iterator<List<Activity>> getSocialFeed(String xidUser) throws IOException;

    /**
     * Retrieves the {@link Meal}s, paginated by date, in descending order, of
     * the authenticated user
     *
     * @return
     * @throws IOException
     */
    Iterator<List<Meal>> getMeals() throws IOException;

    /**
     * Retrieves the {@link Meal}s, paginated by date, in descending order, of
     * the user with the given xid
     *
     * @param xidUser
     * @return
     * @throws IOException
     */
    Iterator<List<Meal>> getMeals(String xidUser) throws IOException;

    /**
     * Retrieves the {@link Sleep}s, paginated by date, in descending order, of
     * the authenticated user
     *
     * @return
     * @throws IOException
     */
    Iterator<List<Sleep>> getSleeps() throws IOException;

    /**
     * Retrieves the {@link Sleep}s, paginated by date, in descending order, of
     * the user with the given xid
     *
     * @param xidUser
     * @return
     * @throws IOException
     */
    Iterator<List<Sleep>> getSleeps(String xidUser) throws IOException;

    /**
     * Retrieves the {@link Move}s, paginated by date, in descending order, of
     * the authenticated user
     *
     * @return
     * @throws IOException
     */
    Iterator<List<Move>> getMoves() throws IOException;

    /**
     * Retrieves the {@link Move}s, paginated by date, in descending order, of
     * the user with the given xid
     *
     * @param xidUser
     * @return
     * @throws IOException
     */
    Iterator<List<Move>> getMoves(String xidUser) throws IOException;

    /**
     *
     * @param xid
     * @return
     * @throws IOException
     */
    Move getMove(String xid) throws IOException;

    /**
     *
     * @param xid
     * @return
     * @throws IOException
     */
    Meal getMeal(String xid) throws IOException;

    /**
     *
     * @param xid
     * @return
     * @throws IOException
     */
    Sleep getSleep(String xid) throws IOException;

    /**
     *
     * @param xid
     * @return
     * @throws IOException
     */
    List<Tick> getTicks(String xid) throws IOException;

    /**
     *
     * @param xid
     * @return
     */
    List<TimeSlice> getMoveSnapshot(String xid) throws IOException;

    /**
     *
     * @param xid
     * @return
     */
    List<TimeSlice> getSleepSnapshot(String xid) throws IOException;

    /**
     *
     * @return @throws IOException
     */
    Mood getMood() throws IOException;

    /**
     *
     * @param xidUser
     * @return
     * @throws IOException
     */
    Mood getMood(String xidUser) throws IOException;
}
