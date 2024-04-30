package com.example.menuRehberim.repository;

import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
