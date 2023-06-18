package com.sanjay.InventoryEnterpriseSystem.rawMaterials.controller;

import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialCreateDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialListResponseDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialResponseDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.Dto.RawMaterialUpdateDto;
import com.sanjay.InventoryEnterpriseSystem.rawMaterials.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rawMaterials")
public class RawMaterialController {

    @Autowired
    private RawMaterialService rawMaterialService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)

    public RawMaterialResponseDto addRawMaterials(@RequestBody RawMaterialCreateDto rawMaterialCreateDto) {
        return rawMaterialService.addRawMaterial(rawMaterialCreateDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public RawMaterialListResponseDto getRawMaterials() {
        return rawMaterialService.getRawMaterials();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public RawMaterialResponseDto getByRawMaterialId(@PathVariable("id") long id) {
        return rawMaterialService.getByRawMaterialId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public RawMaterialResponseDto updateRawMaterial(@PathVariable("id") long id, @RequestBody RawMaterialUpdateDto rawMaterialUpdateDto) {
        return rawMaterialService.updateRawMaterials(id, rawMaterialUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteByRawMaterialId(@PathVariable long id) throws Exception {
        rawMaterialService.deleteByRawMaterialId(id);
    }

}
