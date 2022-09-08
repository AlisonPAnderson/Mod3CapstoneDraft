package com.techelevator.model;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientId;
//    @Id
//    @Column(name = "ingredient_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_ingredient_id")
//    private Long ingredientId;

    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Column(name = "category")
    private String ingredientCategory;





}
