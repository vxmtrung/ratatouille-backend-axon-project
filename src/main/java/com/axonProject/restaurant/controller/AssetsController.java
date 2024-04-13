package com.axonProject.restaurant.controller;

import com.axonProject.restaurant.model.AssetsModel;
import com.axonProject.restaurant.service.AssetsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private AssetsModelService assetsModelService;

    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<List<AssetsModel>> getAllAssets() {
        try {
            List<AssetsModel> assetsModelList = assetsModelService.getAllAssets();

            return new ResponseEntity<>(assetsModelList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<AssetsModel> createAssetsItem(@RequestBody AssetsModel assetsModel) {
        try {
            assetsModelService.
                    createAssetsItem(new AssetsModel(assetsModel.getQuantity(), assetsModel.getMaterial(), assetsModel.getPricePerUnit(), assetsModel.getDescription(), assetsModel.getName(), assetsModel.getImage()));

            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<AssetsModel> updateAssetsItem(@PathVariable long id, @RequestBody AssetsModel assetsModel) {
        Optional<AssetsModel> _assetModelItem = assetsModelService.findAssetsItemById(id);

        if (_assetModelItem.isPresent()) {
            assetsModelService.updateAssetsItem(id, assetsModel);

            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<AssetsModel> deleteAssetsItem(@PathVariable long id) {
        try {
            assetsModelService.deleteAssetsItem(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{name}")
    @CrossOrigin
    public ResponseEntity<List<AssetsModel>> filterByName(@PathVariable String name)
    {
        try 
        {
            List<AssetsModel> res = assetsModelService.getAssetsByName(name);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
