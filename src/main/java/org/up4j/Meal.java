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
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.up4j.JsonUtils.EpochSecondsDateDeserializer;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meal
{

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String xid;

    @JsonDeserialize(using = EpochSecondsDateDeserializer.class)
    @JsonProperty("time_completed")
    private Date completed;

    @JsonDeserialize(using = EpochSecondsDateDeserializer.class)
    @JsonProperty("time_created")
    private Date created;

    @JsonDeserialize(using = EpochSecondsDateDeserializer.class)
    @JsonProperty("time_updated")
    private Date updated;

    //private Integer reaction;
    @JsonProperty("place_lon")
    private Double placeLon;

    @JsonProperty("place_lat")
    private Double placeLat;

    @JsonProperty("place_name")
    private String placeName;

    private String title;

    private String photo;

    private String note;

    private String date;

    private Integer type;

    @JsonProperty("sub_type")
    private Integer subType;

    private User user;

    private Details details;

    @JsonDeserialize(using = MealItemsDeserializer.class)
    private List<FoodItem> items;

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
     * @return the completed
     */
    public Date getCompleted()
    {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Date completed)
    {
        this.completed = completed;
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
     * @return the placeLon
     */
    public Double getPlaceLon()
    {
        return placeLon;
    }

    /**
     * @param placeLon the placeLon to set
     */
    public void setPlaceLon(Double placeLon)
    {
        this.placeLon = placeLon;
    }

    /**
     * @return the placeLat
     */
    public Double getPlaceLat()
    {
        return placeLat;
    }

    /**
     * @param placeLat the placeLat to set
     */
    public void setPlaceLat(Double placeLat)
    {
        this.placeLat = placeLat;
    }

    /**
     * @return the placeName
     */
    public String getPlaceName()
    {
        return placeName;
    }

    /**
     * @param placeName the placeName to set
     */
    public void setPlaceName(String placeName)
    {
        this.placeName = placeName;
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
     * @return the photo
     */
    public String getPhoto()
    {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    /**
     * @return the note
     */
    public String getNote()
    {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note)
    {
        this.note = note;
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

    /**
     * @return the details
     */
    public Details getDetails()
    {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(Details details)
    {
        this.details = details;
    }

    /**
     * @return the items
     */
    public List<FoodItem> getItems()
    {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<FoodItem> items)
    {
        this.items = items;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Details
    {

        @JsonProperty("num_drinks")
        private Integer numDrinks;

        private Integer fiber;

        @JsonProperty("tz")
        private String timezone;

        private Integer sodium;

        @JsonProperty("vitamin_c")
        private Integer vitaminC;

        private Integer potassium;

        @JsonProperty("vitamin_a")
        private Integer vitaminA;

        private Integer calories;

        @JsonProperty("unsaturated_fat")
        private Integer unsaturatedFat;

        private Integer fat;

        private Integer sugar;

        private Integer carbohydrate;

        private Integer calcium;

        @JsonProperty("num_food")
        private Integer numFood;

        private Integer iron;

        private Integer cholesterol;

        @JsonProperty("saturated_fat")
        private Integer saturatedFat;

        private Integer protein;

        @JsonProperty("polyunsaturated_fat")
        private Integer polyunsaturatedFat;

        @JsonProperty("monounsaturated_fat")
        private Integer monounsaturatedFat;

        private Integer accuracy;

        /**
         * @return the numDrinks
         */
        public Integer getNumDrinks()
        {
            return numDrinks;
        }

        /**
         * @param numDrinks the numDrinks to set
         */
        public void setNumDrinks(Integer numDrinks)
        {
            this.numDrinks = numDrinks;
        }

        /**
         * @return the fiber
         */
        public Integer getFiber()
        {
            return fiber;
        }

        /**
         * @param fiber the fiber to set
         */
        public void setFiber(Integer fiber)
        {
            this.fiber = fiber;
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
         * @return the sodium
         */
        public Integer getSodium()
        {
            return sodium;
        }

        /**
         * @param sodium the sodium to set
         */
        public void setSodium(Integer sodium)
        {
            this.sodium = sodium;
        }

        /**
         * @return the vitaminC
         */
        public Integer getVitaminC()
        {
            return vitaminC;
        }

        /**
         * @param vitaminC the vitaminC to set
         */
        public void setVitaminC(Integer vitaminC)
        {
            this.vitaminC = vitaminC;
        }

        /**
         * @return the potassium
         */
        public Integer getPotassium()
        {
            return potassium;
        }

        /**
         * @param potassium the potassium to set
         */
        public void setPotassium(Integer potassium)
        {
            this.potassium = potassium;
        }

        /**
         * @return the vitaminA
         */
        public Integer getVitaminA()
        {
            return vitaminA;
        }

        /**
         * @param vitaminA the vitaminA to set
         */
        public void setVitaminA(Integer vitaminA)
        {
            this.vitaminA = vitaminA;
        }

        /**
         * @return the calories
         */
        public Integer getCalories()
        {
            return calories;
        }

        /**
         * @param calories the calories to set
         */
        public void setCalories(Integer calories)
        {
            this.calories = calories;
        }

        /**
         * @return the unsaturatedFat
         */
        public Integer getUnsaturatedFat()
        {
            return unsaturatedFat;
        }

        /**
         * @param unsaturatedFat the unsaturatedFat to set
         */
        public void setUnsaturatedFat(Integer unsaturatedFat)
        {
            this.unsaturatedFat = unsaturatedFat;
        }

        /**
         * @return the fat
         */
        public Integer getFat()
        {
            return fat;
        }

        /**
         * @param fat the fat to set
         */
        public void setFat(Integer fat)
        {
            this.fat = fat;
        }

        /**
         * @return the sugar
         */
        public Integer getSugar()
        {
            return sugar;
        }

        /**
         * @param sugar the sugar to set
         */
        public void setSugar(Integer sugar)
        {
            this.sugar = sugar;
        }

        /**
         * @return the carbohydrate
         */
        public Integer getCarbohydrate()
        {
            return carbohydrate;
        }

        /**
         * @param carbohydrate the carbohydrate to set
         */
        public void setCarbohydrate(Integer carbohydrate)
        {
            this.carbohydrate = carbohydrate;
        }

        /**
         * @return the calcium
         */
        public Integer getCalcium()
        {
            return calcium;
        }

        /**
         * @param calcium the calcium to set
         */
        public void setCalcium(Integer calcium)
        {
            this.calcium = calcium;
        }

        /**
         * @return the numFood
         */
        public Integer getNumFood()
        {
            return numFood;
        }

        /**
         * @param numFood the numFood to set
         */
        public void setNumFood(Integer numFood)
        {
            this.numFood = numFood;
        }

        /**
         * @return the iron
         */
        public Integer getIron()
        {
            return iron;
        }

        /**
         * @param iron the iron to set
         */
        public void setIron(Integer iron)
        {
            this.iron = iron;
        }

        /**
         * @return the cholesterol
         */
        public Integer getCholesterol()
        {
            return cholesterol;
        }

        /**
         * @param cholesterol the cholesterol to set
         */
        public void setCholesterol(Integer cholesterol)
        {
            this.cholesterol = cholesterol;
        }

        /**
         * @return the saturatedFat
         */
        public Integer getSaturatedFat()
        {
            return saturatedFat;
        }

        /**
         * @param saturatedFat the saturatedFat to set
         */
        public void setSaturatedFat(Integer saturatedFat)
        {
            this.saturatedFat = saturatedFat;
        }

        /**
         * @return the protein
         */
        public Integer getProtein()
        {
            return protein;
        }

        /**
         * @param protein the protein to set
         */
        public void setProtein(Integer protein)
        {
            this.protein = protein;
        }

        /**
         * @return the polyunsaturatedFat
         */
        public Integer getPolyunsaturatedFat()
        {
            return polyunsaturatedFat;
        }

        /**
         * @param polyunsaturatedFat the polyunsaturatedFat to set
         */
        public void setPolyunsaturatedFat(Integer polyunsaturatedFat)
        {
            this.polyunsaturatedFat = polyunsaturatedFat;
        }

        /**
         * @return the monounsaturatedFat
         */
        public Integer getMonounsaturatedFat()
        {
            return monounsaturatedFat;
        }

        /**
         * @param monounsaturatedFat the monounsaturatedFat to set
         */
        public void setMonounsaturatedFat(Integer monounsaturatedFat)
        {
            this.monounsaturatedFat = monounsaturatedFat;
        }

        /**
         * @return the accuracy
         */
        public Integer getAccuracy()
        {
            return accuracy;
        }

        /**
         * @param accuracy the accuracy to set
         */
        public void setAccuracy(Integer accuracy)
        {
            this.accuracy = accuracy;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class FoodItem
    {

        @JsonProperty("multiplier_min")
        private Double multiplierMin;

        @JsonProperty("multiplier_max")
        private Integer multiplierMax;

        private Integer carbohydrate;

        @JsonProperty("trans_fat")
        private Integer transFat;

        private String measurement;

        @JsonProperty("saturated_fat")
        private Integer saturatedFat;

        private Integer protein;

        private String xid;

        private Integer sodium;

        @JsonProperty("vitamin_c")
        private Integer vitaminC;

        @JsonProperty("vitamin_a")
        private Integer vitaminA;

        @JsonProperty("unsaturated_fat")
        private Integer unsaturatedFat;

        private Integer sugar;

        private String type;

        private Integer fiber;

        private String description;

        private Integer potassium;

        private Integer fat;

        @JsonProperty("serving_xid")
        private String servingXid;

        @JsonProperty("monounsaturated_fat")
        private Integer monounsaturatedFat;

        private String name;

        private Integer calories;

        @JsonProperty("polyunsaturated_fat")
        private Integer polyunsaturatedFat;

        private Integer calcium;

        private Integer amount;

        private Integer iron;

        private Integer cholesterol;

        @JsonProperty("food_xid")
        private String foodXid;

        /**
         * @return the multiplierMin
         */
        public Double getMultiplierMin()
        {
            return multiplierMin;
        }

        /**
         * @param multiplierMin the multiplierMin to set
         */
        public void setMultiplierMin(Double multiplierMin)
        {
            this.multiplierMin = multiplierMin;
        }

        /**
         * @return the multiplierMax
         */
        public Integer getMultiplierMax()
        {
            return multiplierMax;
        }

        /**
         * @param multiplierMax the multiplierMax to set
         */
        public void setMultiplierMax(Integer multiplierMax)
        {
            this.multiplierMax = multiplierMax;
        }

        /**
         * @return the carbohydrate
         */
        public Integer getCarbohydrate()
        {
            return carbohydrate;
        }

        /**
         * @param carbohydrate the carbohydrate to set
         */
        public void setCarbohydrate(Integer carbohydrate)
        {
            this.carbohydrate = carbohydrate;
        }

        /**
         * @return the transFat
         */
        public Integer getTransFat()
        {
            return transFat;
        }

        /**
         * @param transFat the transFat to set
         */
        public void setTransFat(Integer transFat)
        {
            this.transFat = transFat;
        }

        /**
         * @return the measurement
         */
        public String getMeasurement()
        {
            return measurement;
        }

        /**
         * @param measurement the measurement to set
         */
        public void setMeasurement(String measurement)
        {
            this.measurement = measurement;
        }

        /**
         * @return the saturatedFat
         */
        public Integer getSaturatedFat()
        {
            return saturatedFat;
        }

        /**
         * @param saturatedFat the saturatedFat to set
         */
        public void setSaturatedFat(Integer saturatedFat)
        {
            this.saturatedFat = saturatedFat;
        }

        /**
         * @return the protein
         */
        public Integer getProtein()
        {
            return protein;
        }

        /**
         * @param protein the protein to set
         */
        public void setProtein(Integer protein)
        {
            this.protein = protein;
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
         * @return the sodium
         */
        public Integer getSodium()
        {
            return sodium;
        }

        /**
         * @param sodium the sodium to set
         */
        public void setSodium(Integer sodium)
        {
            this.sodium = sodium;
        }

        /**
         * @return the vitaminC
         */
        public Integer getVitaminC()
        {
            return vitaminC;
        }

        /**
         * @param vitaminC the vitaminC to set
         */
        public void setVitaminC(Integer vitaminC)
        {
            this.vitaminC = vitaminC;
        }

        /**
         * @return the vitaminA
         */
        public Integer getVitaminA()
        {
            return vitaminA;
        }

        /**
         * @param vitaminA the vitaminA to set
         */
        public void setVitaminA(Integer vitaminA)
        {
            this.vitaminA = vitaminA;
        }

        /**
         * @return the unsaturatedFat
         */
        public Integer getUnsaturatedFat()
        {
            return unsaturatedFat;
        }

        /**
         * @param unsaturatedFat the unsaturatedFat to set
         */
        public void setUnsaturatedFat(Integer unsaturatedFat)
        {
            this.unsaturatedFat = unsaturatedFat;
        }

        /**
         * @return the sugar
         */
        public Integer getSugar()
        {
            return sugar;
        }

        /**
         * @param sugar the sugar to set
         */
        public void setSugar(Integer sugar)
        {
            this.sugar = sugar;
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
         * @return the fiber
         */
        public Integer getFiber()
        {
            return fiber;
        }

        /**
         * @param fiber the fiber to set
         */
        public void setFiber(Integer fiber)
        {
            this.fiber = fiber;
        }

        /**
         * @return the description
         */
        public String getDescription()
        {
            return description;
        }

        /**
         * @param description the description to set
         */
        public void setDescription(String description)
        {
            this.description = description;
        }

        /**
         * @return the potassium
         */
        public Integer getPotassium()
        {
            return potassium;
        }

        /**
         * @param potassium the potassium to set
         */
        public void setPotassium(Integer potassium)
        {
            this.potassium = potassium;
        }

        /**
         * @return the fat
         */
        public Integer getFat()
        {
            return fat;
        }

        /**
         * @param fat the fat to set
         */
        public void setFat(Integer fat)
        {
            this.fat = fat;
        }

        /**
         * @return the servingXid
         */
        public String getServingXid()
        {
            return servingXid;
        }

        /**
         * @param servingXid the servingXid to set
         */
        public void setServingXid(String servingXid)
        {
            this.servingXid = servingXid;
        }

        /**
         * @return the monounsaturatedFat
         */
        public Integer getMonounsaturatedFat()
        {
            return monounsaturatedFat;
        }

        /**
         * @param monounsaturatedFat the monounsaturatedFat to set
         */
        public void setMonounsaturatedFat(Integer monounsaturatedFat)
        {
            this.monounsaturatedFat = monounsaturatedFat;
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
         * @return the calories
         */
        public Integer getCalories()
        {
            return calories;
        }

        /**
         * @param calories the calories to set
         */
        public void setCalories(Integer calories)
        {
            this.calories = calories;
        }

        /**
         * @return the polyunsaturatedFat
         */
        public Integer getPolyunsaturatedFat()
        {
            return polyunsaturatedFat;
        }

        /**
         * @param polyunsaturatedFat the polyunsaturatedFat to set
         */
        public void setPolyunsaturatedFat(Integer polyunsaturatedFat)
        {
            this.polyunsaturatedFat = polyunsaturatedFat;
        }

        /**
         * @return the calcium
         */
        public Integer getCalcium()
        {
            return calcium;
        }

        /**
         * @param calcium the calcium to set
         */
        public void setCalcium(Integer calcium)
        {
            this.calcium = calcium;
        }

        /**
         * @return the amount
         */
        public Integer getAmount()
        {
            return amount;
        }

        /**
         * @param amount the amount to set
         */
        public void setAmount(Integer amount)
        {
            this.amount = amount;
        }

        /**
         * @return the iron
         */
        public Integer getIron()
        {
            return iron;
        }

        /**
         * @param iron the iron to set
         */
        public void setIron(Integer iron)
        {
            this.iron = iron;
        }

        /**
         * @return the cholesterol
         */
        public Integer getCholesterol()
        {
            return cholesterol;
        }

        /**
         * @param cholesterol the cholesterol to set
         */
        public void setCholesterol(Integer cholesterol)
        {
            this.cholesterol = cholesterol;
        }

        /**
         * @return the foodXid
         */
        public String getFoodXid()
        {
            return foodXid;
        }

        /**
         * @param foodXid the foodXid to set
         */
        public void setFoodXid(String foodXid)
        {
            this.foodXid = foodXid;
        }
    }

    public static class MealItemsDeserializer extends JsonDeserializer<List<FoodItem>>
    {

        @Override
        public List<FoodItem> deserialize(JsonParser jp,
                DeserializationContext dc) throws
                IOException, JsonProcessingException
        {
            JsonNode node = OBJECT_MAPPER.readValue(jp, JsonNode.class);
            if (node.has("items"))
            {
                return OBJECT_MAPPER.readValue(node.get("items").traverse(),
                        new TypeReference<List<FoodItem>>()
                        {
                        });
            }
            return null;
        }
    }
}
