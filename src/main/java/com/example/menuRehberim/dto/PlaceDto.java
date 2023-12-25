package com.example.menuRehberim.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@Data
public class PlaceDto {

    private long id;
    private  String restourantName;
    private String placeDefinition;
    private String placeAdress;
    private byte[] placeBgPicName;
    private  String category;
}
