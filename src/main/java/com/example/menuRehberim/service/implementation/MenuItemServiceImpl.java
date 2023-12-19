package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.MenuItemDto;
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
        MenuItem menuItem=new MenuItem();
        menuItem.setItemName(menuItemDto.getItemName());
        menuItem.setItemDefinition(menuItemDto.getItemName());
        menuItem.setItemPicName(menuItemDto.getItemPicName());
        menuItem.setItemPrice(menuItemDto.getItemPrice());
        menuItem.setMenu(menu);



        menuItemRepository.save(menuItem);
        return menuItemDto;
    }


}
