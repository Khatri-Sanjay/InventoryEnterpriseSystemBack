package com.sanjay.InventoryEnterpriseSystem.prediction.service;

import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionCreateDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionListResponseDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionResponseDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionUpdateDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.entity.Prediction;
import com.sanjay.InventoryEnterpriseSystem.prediction.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PredictionService {

    @Autowired
    private PredictionRepository predictionRepository;

    public PredictionResponseDto addPrediction(PredictionCreateDto predictionCreateDto) {

        Prediction prediction = new Prediction();
        prediction.setItemName(predictionCreateDto.getItemName());
        prediction.setQtyOfRawMaterials(predictionCreateDto.getQtyOfRawMaterials());
        prediction.setPriceOfRawMaterials(predictionCreateDto.getPriceOfRawMaterials());
        prediction.setTotalPriceOfRawMaterials(predictionCreateDto.getTotalPriceOfRawMaterials());
        prediction.setLabourCost(predictionCreateDto.getLabourCost());
        prediction.setMarketingCost(predictionCreateDto.getMarketingCost());
        prediction.setShippingCost(predictionCreateDto.getShippingCost());
        prediction.setPackagingCost(predictionCreateDto.getPackagingCost());
        prediction.setMiscellaneousCost(predictionCreateDto.getMiscellaneousCost());
        prediction.setQtyOfProduct(predictionCreateDto.getQtyOfProduct());
        prediction.setProfitMargin(predictionCreateDto.getProfitMargin());
        Prediction savedPrediction = predictionRepository.save(prediction);
        return getPredictionResponseDto(savedPrediction);
    }

    private PredictionResponseDto getPredictionResponseDto(Prediction prediction) {
        PredictionResponseDto response = new PredictionResponseDto();
        response.setId(prediction.getId());
        response.setItemName(prediction.getItemName());
        response.setQtyOfRawMaterials(prediction.getQtyOfRawMaterials());
        response.setPriceOfRawMaterials(prediction.getPriceOfRawMaterials());
        response.setTotalPriceOfRawMaterials(prediction.getTotalPriceOfRawMaterials());
        response.setLabourCost(prediction.getLabourCost());
        response.setMarketingCost(prediction.getMarketingCost());
        response.setShippingCost(prediction.getShippingCost());
        response.setPackagingCost(prediction.getPackagingCost());
        response.setMiscellaneousCost(prediction.getMiscellaneousCost());
        response.setQtyOfProduct(prediction.getQtyOfProduct());
        response.setProfitMargin(prediction.getProfitMargin());
        return response;
    }

    public PredictionListResponseDto getPrediction() {
        List<PredictionResponseDto> predictionResponseDto = new ArrayList<>();
        List<Prediction> predictions = (List<Prediction>) predictionRepository.findAll();
        for (Prediction prediction : predictions) {
            predictionResponseDto.add(getPredictionResponseDto(prediction));
        }

        PredictionListResponseDto response = new PredictionListResponseDto();
        response.setPrediction(predictionResponseDto);
        response.setTotal((long) predictions.size());
        return response;
    }

    public PredictionResponseDto updatePrediction(long id, PredictionUpdateDto predictionUpdateDto) {
        Optional<Prediction> optionalPrediction = predictionRepository.findById(id);
        if (optionalPrediction.isPresent()) {
            Prediction prediction = optionalPrediction.get();
            prediction.setItemName(predictionUpdateDto.getItemName());
            prediction.setQtyOfRawMaterials(predictionUpdateDto.getQtyOfRawMaterials());
            prediction.setPriceOfRawMaterials(predictionUpdateDto.getPriceOfRawMaterials());
            prediction.setTotalPriceOfRawMaterials(predictionUpdateDto.getTotalPriceOfRawMaterials());
            prediction.setLabourCost(prediction.getLabourCost());
            prediction.setMarketingCost(prediction.getMarketingCost());
            prediction.setShippingCost(prediction.getShippingCost());
            prediction.setPackagingCost(prediction.getPackagingCost());
            prediction.setMiscellaneousCost(prediction.getMiscellaneousCost());
            prediction.setQtyOfProduct(prediction.getQtyOfProduct());
            prediction.setProfitMargin(prediction.getProfitMargin());

            Prediction savedPrediction = predictionRepository.save(prediction);
            return getPredictionResponseDto(savedPrediction);
        }
        return null;
    }

    public PredictionResponseDto getPredictionById(long id) {
        Optional<Prediction> optionalPrediction = predictionRepository.findById(id);
        if (optionalPrediction.isPresent()) {
            return getPredictionResponseDto(optionalPrediction.get());
        }
        return null;
    }

    public void deleteByItemId(long id) throws Exception {

        Optional<Prediction> optionalPrediction = predictionRepository.findById(id);

        if (optionalPrediction.isPresent()) {
            predictionRepository.deleteById(id);
        } else {
            throw new Exception("User having id" + " " + id + " " + "is not available");
        }
    }

}
