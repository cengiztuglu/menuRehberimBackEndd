package com.example.menuRehberim.controller;

import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.User;
import com.example.menuRehberim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private  final UserService userService;

    @PostMapping("api/user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        return  ResponseEntity.ok(userService.save(userDto));
    }
    @PostMapping("api/login")
    public  String LoginUser(@RequestBody UserDto loginRequest)
    {
        User user = userService.findByUserName(loginRequest.getUserName());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Giriş başarılı!";

        } else {
            System.out.println(user.getUserName());

            return "Giriş başarısız! Lütfen bilgilerinizi kontrol edindsds.";
        }
    }
}
