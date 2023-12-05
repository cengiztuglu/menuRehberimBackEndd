package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.repository.PlaceRepository;
import com.example.menuRehberim.repository.RestourantRepository;
import com.example.menuRehberim.service.RestourantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RestourantServiceImpl implements RestourantService {
    private final RestourantRepository restourantRepository;

    @Override
    public RestourantDto save(RestourantDto restourantDto) {
        Restourant restourant=new Restourant();
        restourant.setRestourantName(restourantDto.getRestourantName());
        restourant.setRestourantPassword(restourantDto.getRestourantPassword());
        Place place=new Place();
        place.setPlaceAdress(restourantDto.getPlaceAdress());
        place.setPlaceDefinition(restourantDto.getPlaceDefinition());
        place.setPlaceBgPicName(restourantDto.getPlaceBgPicName());
        place.setCategory(restourantDto.getCategory());
        restourant.setPlaceInfo(place);
        place.setRestourant(restourant);
        restourantRepository.save(restourant);





        return restourantDto;
    }

    @Override
    public Restourant findByRestourantName(String restourantName) {
        return restourantRepository.findByRestourantName(restourantName);

    }
}
