package com.axonProject.restaurant.service;

import com.axonProject.restaurant.model.AssetsModel;
import com.axonProject.restaurant.repository.AssetsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssetsModelServiceImplement implements AssetsModelService{
    @Autowired
    AssetsModelRepository assetsModelRepository;

    @Override
    public List<AssetsModel> getAllAssets(){
        List<AssetsModel> _assetsList = new ArrayList<AssetsModel>();

        assetsModelRepository.findAll().forEach(_assetsList::add);

        return  _assetsList;
    }

    @Override
    public void createAssetsItem(AssetsModel assetsModel){
        AssetsModel _assetsModel = new AssetsModel(assetsModel.getQuantity(), assetsModel.getMaterial(), assetsModel.getPricePerUnit(), assetsModel.getDescription(), assetsModel.getName(), assetsModel.getImage());
//        System.out.println("Ya hallooooo");
        assetsModelRepository.save(_assetsModel);
    }

    @Override
    public Optional<AssetsModel> findAssetsItemById(long id){
        return assetsModelRepository.findById(id);
    }

    @Override
    public void updateAssetsItem(long id, AssetsModel assetsModel){
        AssetsModel _assetsModelItem = assetsModelRepository.findById(id).get();

        _assetsModelItem.setQuantity(assetsModel.getQuantity());
        _assetsModelItem.setMaterial(assetsModel.getMaterial());
        _assetsModelItem.setPricePerUnit(assetsModel.getPricePerUnit());
        _assetsModelItem.setDescription(assetsModel.getDescription());
        _assetsModelItem.setName(assetsModel.getName());
        _assetsModelItem.setImage(assetsModel.getImage());

        assetsModelRepository.save(_assetsModelItem);
    }

    @Override
    public void deleteAssetsItem(long id) {
        assetsModelRepository.deleteById(id);
    }

    @Override
    public List<AssetsModel> getAssetsByName(String name)
    {
        List<AssetsModel> res = new ArrayList<AssetsModel>();

        for (AssetsModel asm : getAllAssets())
        {
            if (asm.getName().contains(name))
                res.add(asm);
        }

        return res;
    }
}
