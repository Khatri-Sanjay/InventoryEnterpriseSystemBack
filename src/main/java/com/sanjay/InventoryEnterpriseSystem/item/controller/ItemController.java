package com.sanjay.InventoryEnterpriseSystem.item.controller;


import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemCreatDto;
import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemListResponseDto;
import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemResponseDto;
import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemUpdateDto;
import com.sanjay.InventoryEnterpriseSystem.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)

    public ItemResponseDto addItems(@RequestBody ItemCreatDto itemCreatDto) {
        return itemService.addItems(itemCreatDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ItemListResponseDto getItems() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ItemResponseDto getItemById(@PathVariable("id") long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ItemResponseDto updateItem(@PathVariable("id") long id, @RequestBody ItemUpdateDto itemUpdateDto) {
        return itemService.updateItem(id, itemUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteByItemId(@PathVariable long id) throws Exception {
        itemService.deleteByItemId(id);
    }

//    public static String uploadDirectory = System.getProperty("item.dir") + "/src/resources/static/images"

}
