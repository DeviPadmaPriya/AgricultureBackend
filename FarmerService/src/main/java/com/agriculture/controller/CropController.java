package com.agriculture.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.entity.Crop;
import com.agriculture.exception.CropNotFoundException;
import com.agriculture.service.CropService;


@RestController
@RequestMapping("/crop")
@CrossOrigin("*")
public class CropController {
	
	@Autowired
	CropService cropService;
	
	
	 @PostMapping("/add")
	    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
	        Crop addedCrop = cropService.addCrop(crop);
	        return new ResponseEntity<>(addedCrop, HttpStatus.CREATED);
	    }
	  @PutMapping("/update/{id}")
	    public ResponseEntity<Crop> updateCrop(@PathVariable String id, @RequestBody Crop crop) {
	        Crop updatedCrop = cropService.updateCrop(id, crop);
	        if (updatedCrop != null) {
	            return new ResponseEntity<>(updatedCrop, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @PutMapping("/updateQuantity/{id}")
	    public ResponseEntity<Crop> updateCropQuantity(@PathVariable String id,@RequestBody Crop updatedCrop) {
	        Optional<Crop> updatedCropResult = cropService.updateCropQuantity(id, updatedCrop);

	        return updatedCropResult.map(crop -> new ResponseEntity<>(crop, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	  @GetMapping("/getAll")
	    public ResponseEntity<List<Crop>> getAllCrops() {
	        List<Crop> crops = cropService.getAllCrops();
	        return new ResponseEntity<>(crops, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteCrop(@PathVariable String id) {
	        String result = cropService.deleteCrop(id);
	        if ("Crop deleted".equals(result)) {
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        }
	        
	    }
	    
	    @GetMapping("/getbytype")
	    public ResponseEntity<List<Crop>> getCropsList(@RequestParam("Type") String cropType) {
	        List<Crop> allCrops = cropService.getCropByType(cropType);

	        if (allCrops != null && !allCrops.isEmpty()) {
	            return new ResponseEntity<>(allCrops, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
	    
	    @GetMapping("/getbyname")
	    public ResponseEntity<List<Crop>> getCropsByName(@RequestParam("cropName") String cropName) {
	        List<Crop> allCrops = cropService.getCropByName(cropName);

	        if (allCrops != null && !allCrops.isEmpty()) {
	            return new ResponseEntity<>(allCrops, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/getById/{id}")
	    public ResponseEntity<Crop> getCropById(@PathVariable String id) {
	        try {
	            Crop crop = cropService.getCropById(id);
	            return new ResponseEntity<>(crop, HttpStatus.OK);
	        } catch (CropNotFoundException ex) {
	            return new ResponseEntity<Crop>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    
//	@PostMapping("/add")
//	public Crop addCrop(@RequestBody Crop crop) {
//		return cropService.addCrop(crop);
//	}
//	
//	@PutMapping("/update/{id}")
//	public Crop updateCrop(@PathVariable int id,@RequestBody Crop crop) {
//		return cropService.updateCrop(id, crop);
//	}
//	@GetMapping("/getAll")
//	public List<Crop> getAllCrops(){
//		return cropService.getAllCrops();
//	}
//	@DeleteMapping("/delete/{id}")
//	public String deleteCrop(@PathVariable int id) {
//		return cropService.deleteCrop(id);
//		
//	}

}
