package com.sanjay.InventoryEnterpriseSystem.prediction.Dto;

import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemResponseDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.entity.Prediction;

import java.util.List;

public class PredictionListResponseDto {
    private List<PredictionResponseDto> prediction;
    private long total;


    public List<PredictionResponseDto> getPrediction() {
        return prediction;
    }
    public void setPrediction(List<PredictionResponseDto> prediction) {
        this.prediction = prediction;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
}
