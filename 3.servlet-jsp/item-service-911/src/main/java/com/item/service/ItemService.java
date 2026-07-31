package com.item.service;

import java.util.List;

import com.item.model.Item;
import com.item.model.ItemDetails;

public interface ItemService {

    boolean addItem(Item item);

    boolean updateItem(Item item);

    Item getItemById(Long id);

    List<Item> getItems();

    boolean removeItemById(Long id);

    // Item Details (One-to-One)
    boolean addItemDetails(ItemDetails details);

    boolean updateItemDetails(ItemDetails details);

    ItemDetails getItemDetailsByItemId(Long itemId);

    boolean removeItemDetailsByItemId(Long itemId);
}
