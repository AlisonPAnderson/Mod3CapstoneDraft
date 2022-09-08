package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "user_pantry")
public class UserPantry {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private UserPantryId userPantryId;

    @Column(name="user_id", insertable = false, updatable = false)
    Long userId;

    @Column(name="ingredient_id", insertable = false, updatable = false)
    Long ingredientId;

    @JsonIgnore
    @Transient
    //List<Ingredient> pantryStock = new ArrayList<>();
    Map<Long, Ingredient> pantryStock;


//TODO ingredient name, qty database?

}