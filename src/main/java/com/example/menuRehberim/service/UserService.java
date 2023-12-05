package com.example.menuRehberim.service;

import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.User;

public interface UserService {
    UserDto save(UserDto userDto);
    User findByUserName(String userName);

}
