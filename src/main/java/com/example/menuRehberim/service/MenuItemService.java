package com.example.menuRehberim.service;

import com.example.menuRehberim.dto.MenuItemDto;
import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.entity.Menu;
import com.example.menuRehberim.entity.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem save(MenuItem menuItemDto, String userName);
    List<MenuItemDto> getMenuItemsById(Long id);

    MenuItemDto getMenuItemById(Long menuItemId); // Yeni metodu burada tanımlayın


}
