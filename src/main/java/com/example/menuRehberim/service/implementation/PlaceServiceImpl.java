package com.example.menuRehberim.service.implementation;


import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.repository.PlaceRepository;
import com.example.menuRehberim.repository.RestourantRepository;
import com.example.menuRehberim.service.PlaceService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final RestourantRepository restourantRepository;

    @Override
    public PlaceDto save(PlaceDto placeDto) {

        Place place = new Place();
        place.setRestourantName(placeDto.getRestourantName());
        place.setPlaceDefinition(placeDto.getPlaceDefinition());
        place.setPlaceAdress(placeDto.getPlaceDefinition());
        place.setPlaceBgPicName(placeDto.getPlaceBgPicName());
        place.setCategory(placeDto.getCategory());
        placeRepository.save(place);
        return placeDto;
    }

    @Override
    public Place update(Place placeDto, String userName) {
        Restourant restourant = restourantRepository.findByUserName(userName);
        Place place = placeRepository.findByRestourant(restourant);
        place.setRestourantName(placeDto.getRestourantName());
        place.setPlaceDefinition(placeDto.getPlaceDefinition());
        place.setPlaceAdress(placeDto.getPlaceAdress());
        place.setCategory(placeDto.getCategory());
        place.setPlaceBgPicName(placeDto.getPlaceBgPicName());
        placeRepository.save(place);
        return placeDto;

    }

    @Override
    public List<PlaceDto> getAll() {
        List<Place> places = placeRepository.findAll();
        List<PlaceDto> placeDtos = new ArrayList<>();
        places.forEach(it -> {
            PlaceDto placeDto = new PlaceDto();
            placeDto.setId(it.getId());
            placeDto.setRestourantName(it.getRestourantName());
            placeDto.setPlaceDefinition(it.getPlaceDefinition());
            placeDto.setPlaceAdress(it.getPlaceAdress());
            placeDto.setCategory(it.getCategory());
            placeDto.setPlaceBgPicName(it.getPlaceBgPicName());
            placeDto.setId(it.getId());
            placeDtos.add(placeDto);

        });
        return placeDtos;
    }
}
