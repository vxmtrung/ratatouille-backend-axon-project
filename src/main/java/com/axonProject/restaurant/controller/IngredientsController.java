package com.axonProject.restaurant.controller;

import com.axonProject.restaurant.model.IngredientsModel;
import com.axonProject.restaurant.service.IngredientsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    @Autowired
    IngredientsModelService ingredientsModelService;

    @GetMapping("")
    public ResponseEntity<List<IngredientsModel>> getAllIngredients() {
        try {
            List<IngredientsModel> ingredientsModelList = ingredientsModelService.getAllIngredients();

            return new ResponseEntity<>(ingredientsModelList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<IngredientsModel> createIngredientsItem(@RequestBody IngredientsModel ingredientsModel) {
        try {
            ingredientsModelService.
                    createIngredientsItem(new IngredientsModel(ingredientsModel.getPricePerUnit(), ingredientsModel.getDescription(), ingredientsModel.getQuantity(), ingredientsModel.getName(), ingredientsModel.getImportDate(), ingredientsModel.getExpiredDate(), ingredientsModel.getImage()));

            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientsModel> updateIngredientsItem(@PathVariable long id, @RequestBody IngredientsModel ingredientsModel) {
        Optional<IngredientsModel> _ingredientModelItem = ingredientsModelService.findIngredientsItemById(id);

        if (_ingredientModelItem.isPresent()){
            ingredientsModelService.updateIngredientsItem(id, ingredientsModel);

            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IngredientsModel> deleteIngredientsItem(@PathVariable long id) {
        try {
            ingredientsModelService.deleteIngredientsItem(id);

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
