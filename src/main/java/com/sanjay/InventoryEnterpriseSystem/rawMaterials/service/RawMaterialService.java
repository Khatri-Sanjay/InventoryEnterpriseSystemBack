package com.sanjay.InventoryEnterpriseSystem.rawMaterials.service;

import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialCreateDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialListResponseDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialResponseDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialUpdateDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.entity.RawMaterial;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    public RawMaterialResponseDto addRawMaterial(RawMaterialCreateDto rawMaterialCreateDto) {

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setRawMaterialName(rawMaterialCreateDto.getRawMaterialName());
        rawMaterial.setRawMaterialQuantity(rawMaterialCreateDto.getRawMaterialQuantity());
        rawMaterial.setRawMaterialPrice(rawMaterialCreateDto.getRawMaterialPrice());
        rawMaterial.setTotalPriceOfRawMaterials(rawMaterialCreateDto.getTotalPriceOfRawMaterials());
        RawMaterial savedRawMaterial = rawMaterialRepository.save(rawMaterial);
        return getRawMaterialResponseDto(savedRawMaterial);
    }

    private RawMaterialResponseDto getRawMaterialResponseDto(RawMaterial rawMaterial) {
        RawMaterialResponseDto response = new RawMaterialResponseDto();
        response.setId(rawMaterial.getId());
        response.setRawMaterialName(rawMaterial.getRawMaterialName());
        response.setRawMaterialQuantity(rawMaterial.getRawMaterialQuantity());
        response.setRawMaterialPrice(rawMaterial.getRawMaterialPrice());
        response.setTotalPriceOfRawMaterials(rawMaterial.getTotalPriceOfRawMaterials());
        return response;
    }

    public RawMaterialListResponseDto getRawMaterials() {
        List<RawMaterialResponseDto> rawMaterialResponseDto = new ArrayList<>();
        List<RawMaterial> rawMaterials = (List<RawMaterial>) rawMaterialRepository.findAll();
        for (RawMaterial rawMaterial : rawMaterials) {
            rawMaterialResponseDto.add(getRawMaterialResponseDto(rawMaterial));
        }

        RawMaterialListResponseDto response = new RawMaterialListResponseDto();
        response.setRawMaterials(rawMaterialResponseDto);
        response.setTotal((long) rawMaterialResponseDto.size());
        return response;
    }

    public RawMaterialResponseDto updateRawMaterials(long id, RawMaterialUpdateDto rawMaterialUpdateDto) {
        Optional<RawMaterial> optionalRawMaterial = rawMaterialRepository.findById(id);
        if (optionalRawMaterial.isPresent()) {
            RawMaterial rawMaterial = optionalRawMaterial.get();
            rawMaterial.setRawMaterialName(rawMaterialUpdateDto.getRawMaterialName());
            rawMaterial.setRawMaterialQuantity(rawMaterialUpdateDto.getRawMaterialQuantity());
            rawMaterial.setRawMaterialPrice(rawMaterialUpdateDto.getRawMaterialPrice());
            rawMaterial.setTotalPriceOfRawMaterials(rawMaterialUpdateDto.getTotalPriceOfRawMaterials());

            RawMaterial savedRawMaterials = rawMaterialRepository.save(rawMaterial);
            return getRawMaterialResponseDto(savedRawMaterials);
        }
        return null;
    }

    public RawMaterialResponseDto getByRawMaterialId(long id) {
        Optional<RawMaterial> optionalRawMaterial = rawMaterialRepository.findById(id);
        if (optionalRawMaterial.isPresent()) {
            return getRawMaterialResponseDto(optionalRawMaterial.get());
        }
        return null;
    }

    public void deleteByRawMaterialId(long id) throws Exception {

        Optional<RawMaterial> optionalRawMaterial = rawMaterialRepository.findById(id);

        if (optionalRawMaterial.isPresent()) {
//			Items item = optionalItems.get();
            rawMaterialRepository.deleteById(id);
        } else {
            throw new Exception("User having id" + " " + id + " " + "is not available");
        }
    }

}
