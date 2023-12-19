package com.example.menuRehberim.service;

import com.example.menuRehberim.dto.MenuItemDto;
import com.example.menuRehberim.entity.MenuItem;

public interface MenuItemService {
    MenuItem save(MenuItem menuItemDto, String userName);
}
