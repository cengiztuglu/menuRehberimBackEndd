package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.User;
import com.example.menuRehberim.repository.UserRepository;
import com.example.menuRehberim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurName(userDto.getSurName());
        user.setUserName(userDto.getUserName());
        user.setEMail(userDto.getEMail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return userDto;


    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);

    }
}
