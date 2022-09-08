package com.techelevator.model;


import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealPlanMealId implements Serializable {
    private static final long serialVersionUID = -1041736253361122230L;
    @Column(name = "meal_id", nullable = false)
    private Long mealId;

    @Column(name = "meal_plan_id", nullable = false)
    private Long mealPlanId;

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(Long mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MealPlanMealId entity = (MealPlanMealId) o;
        return Objects.equals(this.mealId, entity.mealId) &&
                Objects.equals(this.mealPlanId, entity.mealPlanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, mealPlanId);
    }

}

