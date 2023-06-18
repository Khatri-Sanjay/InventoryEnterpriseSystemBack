package com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto;

import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemResponseDto;

import java.util.List;

public class RawMaterialListResponseDto {

    private List<RawMaterialResponseDto> rawMaterials;
    private long total;


    public List<RawMaterialResponseDto> getRawMaterials() {
        return rawMaterials;
    }
    public void setRawMaterials(List<RawMaterialResponseDto> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
}
