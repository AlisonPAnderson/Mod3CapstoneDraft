package com.techelevator.model;


import javax.persistence.*;

@Entity
@Table(name = "meal_recipe")
public class MealRecipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private MealRecipeId id;

    public MealRecipeId getId() {
        return id;
    }

    public void setId(MealRecipeId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}