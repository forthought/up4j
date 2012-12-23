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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public final class JsonUtils
{

    public static class ISO8601DateSerializer extends JsonSerializer<Date>
    {

        @Override
        public void serialize(Date d, JsonGenerator jg, SerializerProvider sp) throws
                IOException, JsonProcessingException
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = formatter.format(d);
            jg.writeString(formattedDate);
        }
    }

    public static class ISO8601DateDeserializer extends JsonDeserializer<Date>
    {

        @Override
        public Date deserialize(JsonParser jp, DeserializationContext dc) throws
                IOException, JsonProcessingException
        {
            try
            {
                String value = jp.getText();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.parse(value);
            }
            catch (ParseException ex)
            {
                return null;
            }
        }
    }

    public static class EpochSecondsDateDeserializer extends JsonDeserializer<Date>
    {

        @Override
        public Date deserialize(JsonParser jp, DeserializationContext dc) throws
                IOException, JsonProcessingException
        {
            return new Date(jp.getLongValue() * 1000);
        }
    }

    public static class BooleanAsIntegerSerializer extends JsonSerializer<Boolean>
    {

        @Override
        public void serialize(Boolean b, JsonGenerator jg, SerializerProvider sp) throws
                IOException, JsonProcessingException
        {
            jg.writeNumber(b != null && b ? 1 : 0);
        }
    }

    private JsonUtils()
    {
    }
}
