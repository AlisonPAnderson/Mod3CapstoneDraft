package com.techelevator.model;


import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealRecipeId implements Serializable {
    private static final long serialVersionUID = -8904103918280415754L;
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

    @Column(name = "meal_id", nullable = false)
    private Integer mealId;

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MealRecipeId entity = (MealRecipeId) o;
        return Objects.equals(this.mealId, entity.mealId) &&
                Objects.equals(this.recipeId, entity.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, recipeId);
    }

}