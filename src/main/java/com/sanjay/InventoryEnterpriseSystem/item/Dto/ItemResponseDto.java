package com.sanjay.InventoryEnterpriseSystem.item.Dto;

import lombok.Data;

@Data
public class ItemResponseDto {

    private Long id;
    private String itemName;
    private Long itemQuantity;
    private String itemPrice;
    private String itemCategory;
}
