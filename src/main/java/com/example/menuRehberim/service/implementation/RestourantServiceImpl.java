package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.entity.Menu;
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
        restourant.setName(restourantDto.getName());
        restourant.setSurName(restourantDto.getSurName());
        restourant.setUserName(restourantDto.getUserName());
        restourant.setEMail(restourantDto.getEMail());
        restourant.setPassword(restourantDto.getPassword());
        Place place=new Place();
        Menu menu=new Menu();
        restourant.setMenuInfo(menu);
        restourant.setPlaceInfo(place);
        menu.setRestourant(restourant);
        place.setRestourant(restourant);
        restourantRepository.save(restourant);





        return restourantDto;
    }

    @Override
    public Restourant findByUserName(String userName) {
        return restourantRepository.findByUserName(userName);

    }
}
