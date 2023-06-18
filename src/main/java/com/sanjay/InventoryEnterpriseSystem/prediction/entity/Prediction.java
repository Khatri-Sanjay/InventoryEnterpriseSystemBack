package com.sanjay.InventoryEnterpriseSystem.prediction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private Long qtyOfRawMaterials;
    private Float priceOfRawMaterials;
    private Float totalPriceOfRawMaterials;
    private Float labourCost;
    private Float marketingCost;
    private Float shippingCost;
    private Float packagingCost;
    private Float miscellaneousCost;
    private Float qtyOfProduct;
    private Long profitMargin;

}
