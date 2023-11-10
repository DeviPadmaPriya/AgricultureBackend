package com.agriculture.service;

import java.util.List;
import java.util.Optional;

import com.agriculture.entity.Crop;

public interface CropService {
	
	public Crop addCrop(Crop crop);
	public Crop updateCrop(String id,Crop crop);
	public String deleteCrop(String cropId);
	public List<Crop> getAllCrops();
	public List<Crop> getCropByType(String cropType);
	public List<Crop> getCropByName(String cropName);
	public Crop getCropById(String id);
	public Optional<Crop> updateCropQuantity(String id, Crop updatedCrop);

}
