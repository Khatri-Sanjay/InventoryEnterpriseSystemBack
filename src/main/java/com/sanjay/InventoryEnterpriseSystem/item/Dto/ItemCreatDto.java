package com.sanjay.InventoryEnterpriseSystem.item.Dto;

import lombok.Data;

@Data
public class ItemCreatDto {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String itemName;
    private Long itemQuantity;
    private String itemPrice;
    private String itemCategory;
}
