package com.sanjay.InventoryEnterpriseSystem.item.service;

import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemCreatDto;
import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemListResponseDto;
import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemResponseDto;
import com.sanjay.InventoryEnterpriseSystem.item.Dto.ItemUpdateDto;
import com.sanjay.InventoryEnterpriseSystem.item.entity.Items;
import com.sanjay.InventoryEnterpriseSystem.item.reprository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemResponseDto addItems(ItemCreatDto itemCreatDto) {

        Items items = new Items();
        items.setItemName(itemCreatDto.getItemName());
        items.setItemCategory(itemCreatDto.getItemCategory());
        items.setItemPrice(itemCreatDto.getItemPrice());
        items.setItemQuantity(itemCreatDto.getItemQuantity());
        Items savedItems = itemRepository.save(items);
        return getItemResponseDto(savedItems);
    }

    private ItemResponseDto getItemResponseDto(Items items) {
        ItemResponseDto response = new ItemResponseDto();
        response.setId(items.getId());
        response.setItemName(items.getItemName());
        response.setItemCategory(items.getItemCategory());
        response.setItemQuantity(items.getItemQuantity());
        response.setItemPrice(items.getItemPrice());
        return response;
    }

    public ItemListResponseDto getItems() {
        List<ItemResponseDto> itemResponseDto = new ArrayList<>();
        List<Items> item = (List<Items>) itemRepository.findAll();
        for (Items items : item) {
            itemResponseDto.add(getItemResponseDto(items));
        }

        ItemListResponseDto response = new ItemListResponseDto();
        response.setItems(itemResponseDto);
        response.setTotal((long) itemResponseDto.size());
        return response;
    }

    public ItemResponseDto updateItem(long id, ItemUpdateDto itemUpdateDto) {
        Optional<Items> optionalItems = itemRepository.findById(id);
        if (optionalItems.isPresent()) {
            Items items = optionalItems.get();
            items.setItemName(itemUpdateDto.getItemName());
            items.setItemPrice(itemUpdateDto.getItemPrice());
            items.setItemCategory(itemUpdateDto.getItemCategory());
            items.setItemQuantity(itemUpdateDto.getItemQuantity());

            Items savedItems = itemRepository.save(items);
            return getItemResponseDto(savedItems);
        }
        return null;
    }

    public ItemResponseDto getItemById(long id) {
        Optional<Items> optionalItems = itemRepository.findById(id);
        if (optionalItems.isPresent()) {
            return getItemResponseDto(optionalItems.get());
        }
        return null;
    }

    public void deleteByItemId(long id) throws Exception {

        Optional<Items> optionalItems = itemRepository.findById(id);

        if (optionalItems.isPresent()) {
//			Items item = optionalItems.get();
            itemRepository.deleteById(id);
        } else {
            throw new Exception("User having id" + " " + id + " " + "is not available");
        }
    }

}
