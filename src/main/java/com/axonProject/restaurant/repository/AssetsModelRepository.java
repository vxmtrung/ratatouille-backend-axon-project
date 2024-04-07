package com.axonProject.restaurant.repository;

import com.axonProject.restaurant.model.AssetsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetsModelRepository extends JpaRepository<AssetsModel, Long> {
    //After inheriting, we have all method provided by JpaRepository
}
