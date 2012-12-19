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

/**
 * Basic API for accessing your Jawbone UP data and team
 */
public interface API
{

    Settings login(String email, String password) throws IOException;

    Settings getSettings() throws IOException;

    List<User> getFriends() throws IOException;

    List<User> getFriends(String xidUser) throws IOException;

    Score getScore() throws IOException;

    Score getScore(String xidUser) throws IOException;

    List<Activity> getTimeline(Integer limit) throws IOException;
}
