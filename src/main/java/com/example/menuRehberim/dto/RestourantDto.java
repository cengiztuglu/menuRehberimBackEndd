package com.example.menuRehberim.dto;

import lombok.Data;

@Data
public class RestourantDto {
    private long id;
    private String restourantName;
    private String restourantPassword;
    private String placeDefinition;
    private String placeAdress;
    private String placeBgPicName;
    private String category;
}
