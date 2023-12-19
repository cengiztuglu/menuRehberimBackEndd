package com.example.menuRehberim.service;


import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;

import java.util.List;

public interface PlaceService {
    PlaceDto save(PlaceDto placeDto);
    Place update(Place placeDto, String userName);
    List<PlaceDto> getAll();


}
