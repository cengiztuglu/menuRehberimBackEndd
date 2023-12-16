package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.repository.PlaceRepository;
import com.example.menuRehberim.repository.RestourantRepository;
import com.example.menuRehberim.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final RestourantRepository restourantRepository;
    @Override
    public PlaceDto save(PlaceDto placeDto) {
        Place place=new Place();
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
        Restourant restourant =restourantRepository.findByUserName(userName);
        Place place= placeRepository.findByRestourant(restourant);

        place.setRestourantName(placeDto.getRestourantName());
        place.setPlaceDefinition(placeDto.getPlaceDefinition());
        place.setPlaceAdress(placeDto.getPlaceAdress());
        place.setPlaceBgPicName(placeDto.getPlaceBgPicName());
        place.setCategory(placeDto.getCategory());
        placeRepository.save(place);
        return placeDto;

    }
}
