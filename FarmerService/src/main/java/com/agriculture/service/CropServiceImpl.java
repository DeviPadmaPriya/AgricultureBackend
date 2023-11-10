package com.agriculture.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriculture.entity.Crop;
import com.agriculture.exception.CropNotFoundException;
import com.agriculture.repository.CropRepository;

@Service
public class CropServiceImpl implements CropService{
	
	
	@Autowired
	 CropRepository cropRepo;

	@Override
	public Crop addCrop(Crop crop) {

		return cropRepo.save(crop);
	}


	
	@Override
	public List<Crop> getAllCrops(){
		List<Crop> crops=cropRepo.findAll();
		System.out.println("Getting data from"+crops);
		return crops;
	}
	
	@Override
	public List<Crop> getCropByType(String cropType) {
	    List<Crop> allCrops = cropRepo.findByCropType(cropType);

	    if (allCrops != null && !allCrops.isEmpty()) {
	        return allCrops;
	    } else {
	        return Collections.emptyList(); 
	    }
	}

	@Override
	public List<Crop> getCropByName(String cropName) {
	    List<Crop> allCrops = cropRepo.findByCropName(cropName);

	    if (allCrops != null && !allCrops.isEmpty()) {
	        return allCrops;
	    } else {
	        return Collections.emptyList(); 
	    }
	}

	@Override
	public Crop updateCrop(String id, Crop crop) {

		Optional<Crop> c1 = cropRepo.findById(id);
		if(c1.isPresent()) {
			Crop updatecrop = c1.get();
			updatecrop.setCropName(crop.getCropName());
			updatecrop.setCropType(crop.getCropType());
			updatecrop.setQuantity(crop.getQuantity());
			updatecrop.setPrice(crop.getPrice());
			updatecrop.setCropLocation(crop.getCropLocation());
			cropRepo.save(updatecrop);
			return updatecrop;
		}
		
		return null;
	}

	@Override
	public String deleteCrop(String id) {
		Optional<Crop> crop = cropRepo.findById(id);
		if(crop.isPresent()) {
			cropRepo.deleteById(id);
			return "Crop deleted";
		}
		
		return "crop not found";
	}



	@Override
	public Crop getCropById(String id) {
		Optional<Crop> c2=cropRepo.findById(id);
		if(c2.isPresent()) {
			return c2.get();
		}
		else {
			throw new CropNotFoundException("Crop with "+id+" not found");
		}
		
	}





	 @Override
	    public Optional<Crop> updateCropQuantity(String id, Crop updatedCrop) {
	        Optional<Crop> optionalCrop = cropRepo.findById(id);

	        if (optionalCrop.isPresent()) {
	            Crop existingCrop = optionalCrop.get();
	            existingCrop.setQuantity(updatedCrop.getQuantity());
	            cropRepo.save(existingCrop);
	            return Optional.of(existingCrop);
	        } else {
	            return Optional.empty();
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	@Override
//	public List<Crop> getAllCrops() {
//		List<Crop> crops = (List<Crop>) cropRepo.findAll();
//		return crops;
//	}





	
	
	

}
