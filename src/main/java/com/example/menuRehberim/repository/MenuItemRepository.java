package com.example.menuRehberim.repository;

import com.example.menuRehberim.entity.MenuItem;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {

}
