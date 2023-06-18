package com.sanjay.InventoryEnterpriseSystem.prediction.repository;

import com.sanjay.InventoryEnterpriseSystem.prediction.entity.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
}
