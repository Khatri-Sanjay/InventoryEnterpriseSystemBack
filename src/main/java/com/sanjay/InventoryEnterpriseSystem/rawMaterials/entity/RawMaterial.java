package com.sanjay.InventoryEnterpriseSystem.rawMaterials.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rawMaterialName;
    private Long rawMaterialQuantity;
    private Float rawMaterialPrice;
    private Float totalPriceOfRawMaterials;

}
