package com.example.menuRehberim.repository;

import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.entity.Restourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestourantRepository extends JpaRepository<Restourant,Long> {
    Restourant findByRestourantName(String RestourantName);

}
