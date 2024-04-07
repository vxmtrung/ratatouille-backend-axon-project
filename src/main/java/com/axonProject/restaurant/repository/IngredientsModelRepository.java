package com.axonProject.restaurant.repository;

import com.axonProject.restaurant.model.IngredientsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsModelRepository extends JpaRepository<IngredientsModel, Long> {
    //Inherit from Framework some method because of my laziness :)
}
