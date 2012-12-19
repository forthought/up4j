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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 */
public class Goals
{

    @JsonProperty("move")
    private MoveGoals moveGoals;

    @JsonProperty("sleep")
    private SleepGoals sleepGoals;

    @JsonProperty("meals")
    private MealGoals mealGoals;

    /**
     * @return the moveGoals
     */
    public MoveGoals getMoveGoals()
    {
        return moveGoals;
    }

    /**
     * @param moveGoals the moveGoals to set
     */
    public void setMoveGoals(MoveGoals moveGoals)
    {
        this.moveGoals = moveGoals;
    }

    /**
     * @return the sleepGoals
     */
    public SleepGoals getSleepGoals()
    {
        return sleepGoals;
    }

    /**
     * @param sleepGoals the sleepGoals to set
     */
    public void setSleepGoals(SleepGoals sleepGoals)
    {
        this.sleepGoals = sleepGoals;
    }

    /**
     * @return the mealGoals
     */
    public MealGoals getMealGoals()
    {
        return mealGoals;
    }

    /**
     * @param mealGoals the mealGoals to set
     */
    public void setMealGoals(MealGoals mealGoals)
    {
        this.mealGoals = mealGoals;
    }

    public static class MealGoals
    {

        private Integer calcium;

        private Integer sodium;

        private Integer carbs;

        private Integer fiber;

        @JsonProperty("unsat_fat")
        private Integer unsaturatedFat;

        private Integer cholesterol;

        private Integer protein;

        private Integer sugar;

        @JsonProperty("sat_fat")
        private Integer saturated_fat;

        public MealGoals()
        {
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
         * @return the carbs
         */
        public Integer getCarbs()
        {
            return carbs;
        }

        /**
         * @param carbs the carbs to set
         */
        public void setCarbs(Integer carbs)
        {
            this.carbs = carbs;
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
         * @return the saturated_fat
         */
        public Integer getSaturated_fat()
        {
            return saturated_fat;
        }

        /**
         * @param saturated_fat the saturated_fat to set
         */
        public void setSaturated_fat(Integer saturated_fat)
        {
            this.saturated_fat = saturated_fat;
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
    }

    public static class MoveGoals
    {

        private Long steps;

        @JsonProperty("workout_time")
        private Long workoutTime;

        public MoveGoals()
        {
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
         * @return the workoutTime
         */
        public Long getWorkoutTime()
        {
            return workoutTime;
        }

        /**
         * @param workoutTime the workoutTime to set
         */
        public void setWorkoutTime(Long workoutTime)
        {
            this.workoutTime = workoutTime;
        }
    }

    public static class SleepGoals
    {

        private Long total;

        private Long bedtime;

        private Long deep;

        public SleepGoals()
        {
        }

        /**
         * @return the total
         */
        public Long getTotal()
        {
            return total;
        }

        /**
         * @param total the total to set
         */
        public void setTotal(Long total)
        {
            this.total = total;
        }

        /**
         * @return the bedtime
         */
        public Long getBedtime()
        {
            return bedtime;
        }

        /**
         * @param bedtime the bedtime to set
         */
        public void setBedtime(Long bedtime)
        {
            this.bedtime = bedtime;
        }

        /**
         * @return the deep
         */
        public Long getDeep()
        {
            return deep;
        }

        /**
         * @param deep the deep to set
         */
        public void setDeep(Long deep)
        {
            this.deep = deep;
        }
    }
}
