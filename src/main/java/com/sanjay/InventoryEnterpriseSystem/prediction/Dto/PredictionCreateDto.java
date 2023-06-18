package com.sanjay.InventoryEnterpriseSystem.prediction.Dto;

import lombok.Data;

@Data
public class PredictionCreateDto {

    public static final long serialVersionUID = 1L;

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
