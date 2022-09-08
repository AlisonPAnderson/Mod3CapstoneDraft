package com.techelevator.model;

import javax.persistence.*;

@Entity
@Table(name = "user_meal_plan")
public class UserMealPlan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private UserMealPlanId id;

    public UserMealPlanId getId() {
        return id;
    }

    public void setId(UserMealPlanId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}