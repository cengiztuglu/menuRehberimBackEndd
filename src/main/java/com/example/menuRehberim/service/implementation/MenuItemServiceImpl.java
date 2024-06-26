package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.MenuItemDto;
import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.entity.Menu;
import com.example.menuRehberim.entity.MenuItem;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.repository.MenuItemRepository;
import com.example.menuRehberim.repository.MenuRepository;
import com.example.menuRehberim.repository.RestourantRepository;
import com.example.menuRehberim.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RestourantRepository restourantRepository;
    private final MenuRepository menuRepository;


    @Override
    public MenuItem save(MenuItem menuItemDto, String userName) {
        Restourant restourant = restourantRepository.findByUserName(userName);
        Menu menu = menuRepository.findByRestourant(restourant);
        MenuItem menuItem = new MenuItem();
        menuItem.setItemName(menuItemDto.getItemName());
        menuItem.setItemDefinition(menuItemDto.getItemDefinition());
        menuItem.setItemPicName(menuItemDto.getItemPicName());
        menuItem.setItemPrice(menuItemDto.getItemPrice());
        menuItem.setItemCategory(menuItemDto.getItemCategory());
        menuItem.setMenu(menu);


        menuItemRepository.save(menuItem);
        return menuItemDto;
    }

    @Override
    public List<MenuItemDto> getMenuItemsById(Long id) {
        Menu menu = menuRepository.findById(id).orElse(null);
        if (menu == null) {
            return Collections.emptyList();
        }

        List<MenuItem> menuItems = menu.getMenuItems();
        List<MenuItemDto> menuItemDtos = new ArrayList<>();

        for (MenuItem menuItem : menuItems) {
            MenuItemDto menuItemDto = new MenuItemDto();
            menuItemDto.setId(menuItem.getId());
            menuItemDto.setItemName(menuItem.getItemName());
            menuItemDto.setItemDefinition(menuItem.getItemDefinition());
            menuItemDto.setItemPrice(menuItem.getItemPrice());
            menuItemDto.setItemPicName(menuItem.getItemPicName());

            menuItemDtos.add(menuItemDto);
        }

        return menuItemDtos;
    }

    @Override
    public MenuItemDto getMenuItemById(Long menuItemId) {
        Optional<MenuItem> menuItemOptional = menuItemRepository.findById(menuItemId);

        if (menuItemOptional.isPresent()) {
            MenuItem menuItem = menuItemOptional.get();
            MenuItemDto menuItemDto = new MenuItemDto();
            menuItemDto.setId(menuItem.getId());
            menuItemDto.setItemName(menuItem.getItemName());
            menuItemDto.setItemDefinition(menuItem.getItemDefinition());
            menuItemDto.setItemPrice(menuItem.getItemPrice());
            menuItemDto.setItemPicName(menuItem.getItemPicName());
            menuItemDto.setItemCategory(menuItem.getItemCategory());

            return menuItemDto;
        } else {
            // Belirli ID'ye sahip öğe bulunamadı, hata durumu
            return null; // veya hata mesajı döndürebilirsiniz
        }


    }
}


