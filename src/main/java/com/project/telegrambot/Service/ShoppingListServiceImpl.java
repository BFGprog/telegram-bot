package com.project.telegrambot.Service;

import com.project.telegrambot.model.ShoppingList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ShoppingListServiceImpl implements ShoppingListService {
/*    private final ShoppingListRepository shoppingListRepository;
//    private final ItemRepository itemRepository;

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository*//*, ItemRepository itemRepository*//*) {
        this.shoppingListRepository = shoppingListRepository;
        //this.itemRepository = itemRepository;
    }*/


    @Override
    public String createdShopList(Long id, String items) {

        ShoppingList shoppingList = new ShoppingList();
        List<String> addItems;
        addItems = new ArrayList<>(List.of(items.split(", ")));
        if (addItems.size() == 1) {
            addItems = new ArrayList<>(List.of(items.split("\n")));
        }
        log.info(items);
        for (int i = 0; i < addItems.size(); i++) {
            String newItem = i + 1 + ". " + addItems.get(i);

            addItems.set(i, newItem);
        }

        items = "";
        for (int i = 0; i < addItems.size(); i++) {
            items = items + addItems.get(i) + "\n";
        }
        for (int i = 0; i < addItems.size(); i++) {
            log.info(String.valueOf(i));
        }

//                shoppingListRepository.save(items);
        shoppingList.setId(id);
        shoppingList.setItem(addItems.toString());
        return items;
    }


}
