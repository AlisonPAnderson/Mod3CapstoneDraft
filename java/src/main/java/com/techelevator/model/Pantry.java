//package com.techelevator.model;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import java.util.List;
//import javax.persistence.*;
//
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name="pantry")
//public class Pantry {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "pantry_id", nullable = false)  // double check column name
//    private Long pantryId;
//
//    @Column(name = "user_id", nullable = false)
//    private Long userId;
//
//    @JsonIgnore
//    private String itemName;
//
////    @JsonIgnore
////    @Transient
////    @JoinTable(name = "ingredient-pantry",
////                joinColumns =
////                @JoinColumn(name = "pantry_id",
////                referencedColumnName = "pantry-id"))
////    private List<Ingredient> pantryList;
//
//    @JsonIgnore
//    @ManyToOne
//    private User user;
//
//
//}
