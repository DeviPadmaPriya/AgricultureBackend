package com.agriculture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agriculture.entity.Crop;

@Repository
public interface CropRepository  extends MongoRepository<Crop,String>{

	
	List<Crop> findByCropType(String cropType);

//	Optional<Crop> findById(String id);

	void deleteById(String id);

	List<Crop> findByCropName(String cropName);

	
	

}
