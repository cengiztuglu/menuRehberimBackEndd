package com.example.menuRehberim.dto;

import lombok.Data;

@Data
public class MenuItemDto {
    private long id;
    private String itemName;
    private String itemDefinition;
    private  byte[] itemPicName;
    private String itemPrice;
    private  String itemCategory;
}
