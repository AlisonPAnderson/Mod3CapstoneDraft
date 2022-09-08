package com.techelevator.repository;

import com.techelevator.model.UserPantry;
import com.techelevator.model.UserPantryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPantryRepository extends JpaRepository<UserPantry, UserPantryId> {

   List<UserPantry> findAllByUserId(Long userId);
}