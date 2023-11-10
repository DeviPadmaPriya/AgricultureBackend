package com.agriculture;



import com.agriculture.controller.CropController;

import com.agriculture.entity.Crop;
import com.agriculture.exception.CropNotFoundException;
import com.agriculture.service.CropService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CropControllerTest {

    @Mock
    private CropService cropService;

    @InjectMocks
    private CropController cropController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    } 
    
    
    @Test
    void addCrop() {
        Crop cropToAdd = new Crop();
        when(cropService.addCrop(cropToAdd)).thenReturn(cropToAdd);

        ResponseEntity<Crop> responseEntity = cropController.addCrop(cropToAdd);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(cropToAdd, responseEntity.getBody());
    }

    @Test
    void updateCrop() {
        String cropId = "1";
        Crop updatedCrop = new Crop();
        when(cropService.updateCrop(cropId, updatedCrop)).thenReturn(updatedCrop);

        ResponseEntity<Crop> responseEntity = cropController.updateCrop(cropId, updatedCrop);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedCrop, responseEntity.getBody());
    }

    @Test
    void getAllCrops() {
        List<Crop> crops = Arrays.asList(new Crop(), new Crop());
        when(cropService.getAllCrops()).thenReturn(crops);

        ResponseEntity<List<Crop>> responseEntity = cropController.getAllCrops();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(crops, responseEntity.getBody());
    }

    @Test
    void deleteCrop() {
        String cropId = "1";
        String resultMessage = "Crop deleted";
        when(cropService.deleteCrop(cropId)).thenReturn(resultMessage);

        ResponseEntity<String> responseEntity = cropController.deleteCrop(cropId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(resultMessage, responseEntity.getBody());
    }

    @Test
    void getCropsList() {
        String cropType = "Vegetable";
        List<Crop> crops = Arrays.asList(new Crop(), new Crop());
        when(cropService.getCropByType(cropType)).thenReturn(crops);

        ResponseEntity<List<Crop>> responseEntity = cropController.getCropsList(cropType);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(crops, responseEntity.getBody());
    }

    @Test
    void getCropById() {
        String cropId = "1";
        Crop crop = new Crop();
        when(cropService.getCropById(cropId)).thenReturn(crop);

        ResponseEntity<Crop> responseEntity = cropController.getCropById(cropId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(crop, responseEntity.getBody());
    }

    @Test
    void getCropByIdNotFound() {
        String cropId = "invalidId";
        doThrow(new CropNotFoundException("Crop not found")).when(cropService).getCropById(cropId);

        ResponseEntity<Crop> responseEntity = cropController.getCropById(cropId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
