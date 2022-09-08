package com.techelevator.model;

import javax.persistence.*;

@Entity
@Table(name = "meal_plan_meal")
public class MealPlanMeal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private MealPlanMealId id;

    public MealPlanMealId getId() {
        return id;
    }

    public void setId(MealPlanMealId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}