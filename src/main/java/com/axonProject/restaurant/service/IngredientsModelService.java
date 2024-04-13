package com.axonProject.restaurant.service;

import com.axonProject.restaurant.model.IngredientsModel;

import java.util.List;
import java.util.Optional;

public interface IngredientsModelService {
    List<IngredientsModel> getAllIngredients();

    void createIngredientsItem(IngredientsModel ingredientsModel);

    Optional<IngredientsModel> findIngredientsItemById(long id);

    void updateIngredientsItem(long id, IngredientsModel ingredientsModel);

    void deleteIngredientsItem(long id);

    List<IngredientsModel> getIngredientsByName(String name);
}
