package com.example.menuRehberim.repository;

import com.example.menuRehberim.dto.MenuItemDto;
import com.example.menuRehberim.entity.MenuItem;
import com.example.menuRehberim.entity.Place;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {

    Optional<MenuItem> findById(Long id);

}
