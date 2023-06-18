package com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto;


import lombok.Data;

@Data
public class RawMaterialCreateDto {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String rawMaterialName;
    private Long rawMaterialQuantity;
    private Float rawMaterialPrice;
    private Float totalPriceOfRawMaterials;
}
