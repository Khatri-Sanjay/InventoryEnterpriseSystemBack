package com.sanjay.InventoryEnterpriseSystem.prediction.controller;

import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionCreateDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionListResponseDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionResponseDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.Dto.PredictionUpdateDto;
import com.sanjay.InventoryEnterpriseSystem.prediction.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/prediction")
public class PredictionController {
    @Autowired
    private PredictionService predictionService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)

    public PredictionResponseDto addPrediction(@RequestBody PredictionCreateDto predictionCreateDto) {
        return predictionService.addPrediction(predictionCreateDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public PredictionListResponseDto getPrediction() {
        return predictionService.getPrediction();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PredictionResponseDto getPredictioById(@PathVariable("id") long id) {
        return predictionService.getPredictionById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PredictionResponseDto updatePrediction(@PathVariable("id") long id, @RequestBody PredictionUpdateDto predictionUpdateDto) {
        return predictionService.updatePrediction(id, predictionUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePredictionById(@PathVariable long id) throws Exception {
        predictionService.deleteByItemId(id);
    }
}
