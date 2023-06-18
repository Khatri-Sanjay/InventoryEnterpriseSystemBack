package com.sanjay.InventoryEnterpriseSystem.item.Dto;

import java.util.List;

public class ItemListResponseDto {

    private List<ItemResponseDto> items;
    private long total;


    public List<ItemResponseDto> getItems() {
        return items;
    }
    public void setItems(List<ItemResponseDto> items) {
        this.items = items;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }

}
