package com.techelevator.model;

import javax.persistence.*;

@Entity
@Table(name = "user_recipe")
public class UserRecipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private UserRecipeId id;

    public UserRecipeId getId() {
        return id;
    }

    public void setId(UserRecipeId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}