package com.example.menuRehberim.repository;

import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place findByRestourant(Restourant restourant);

}
