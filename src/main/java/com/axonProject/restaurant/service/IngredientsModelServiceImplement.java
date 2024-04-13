package com.axonProject.restaurant.service;

import com.axonProject.restaurant.model.IngredientsModel;
import com.axonProject.restaurant.repository.IngredientsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class IngredientsModelServiceImplement implements IngredientsModelService{
    @Autowired
    IngredientsModelRepository ingredientsModelRepository;

    public List<IngredientsModel> getAllIngredients(){
        List<IngredientsModel> _ingredientsList = new ArrayList<IngredientsModel>();

        ingredientsModelRepository.findAll().forEach(_ingredientsList::add);

        return _ingredientsList;
    }

    @Override
    public void createIngredientsItem(IngredientsModel ingredientsModel) {
        IngredientsModel _ingredientsModel = new IngredientsModel(ingredientsModel.getPricePerUnit(), ingredientsModel.getDescription(), ingredientsModel.getQuantity(), ingredientsModel.getName(), ingredientsModel.getImportDate(), ingredientsModel.getExpiredDate(), ingredientsModel.getImage());

        ingredientsModelRepository.save(_ingredientsModel);
    }

    @Override
    public Optional<IngredientsModel> findIngredientsItemById(long id) {
        return ingredientsModelRepository.findById(id);
    }

    @Override
    public void updateIngredientsItem(long id, IngredientsModel ingredientsModel) {
        IngredientsModel _ingredientsModel = ingredientsModelRepository.findById(id).get();

        _ingredientsModel.setPricePerUnit(ingredientsModel.getPricePerUnit());
        _ingredientsModel.setDescription(ingredientsModel.getDescription());
        _ingredientsModel.setQuantity(ingredientsModel.getQuantity());
        _ingredientsModel.setName(ingredientsModel.getName());
        _ingredientsModel.setImportDate(ingredientsModel.getImportDate());
        _ingredientsModel.setExpiredDate(ingredientsModel.getExpiredDate());
        _ingredientsModel.setName(ingredientsModel.getName());

        ingredientsModelRepository.save(_ingredientsModel);
    }



    @Override
    public void deleteIngredientsItem(long id) {
        ingredientsModelRepository.deleteById(id);
    }
    
    @Override
    public List<IngredientsModel> getIngredientsByName(String name)
    {
        List<IngredientsModel> res = new ArrayList<IngredientsModel>();

        for (IngredientsModel ism : getAllIngredients())
        {
            if (ism.getName().contains(name))
                res.add(ism);
        }

        return res;
    }


}
