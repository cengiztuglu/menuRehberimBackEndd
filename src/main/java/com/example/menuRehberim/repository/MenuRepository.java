package com.example.menuRehberim.repository;

import com.example.menuRehberim.entity.Menu;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    Menu findByRestourant(Restourant restourant);


}
