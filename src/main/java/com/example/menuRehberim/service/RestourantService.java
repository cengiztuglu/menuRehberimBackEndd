package com.example.menuRehberim.service;

import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.entity.Restourant;

public interface RestourantService {
    RestourantDto save(RestourantDto restourantDto);
    Restourant findByRestourantName(String restourantName);

}
