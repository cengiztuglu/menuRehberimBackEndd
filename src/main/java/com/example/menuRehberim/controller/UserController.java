package com.example.menuRehberim.controller;

import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.entity.User;
import com.example.menuRehberim.service.UserService;
import com.example.menuRehberim.service.RestourantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private  final UserService userService;
    private  final RestourantService restourantService;


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

            return "Giriş başarısız! Lütfen bilgilerinizi kontrol .";
        }
    }
    @PostMapping("api/restourantAdd")
    public ResponseEntity<RestourantDto> addRestourant(@RequestBody RestourantDto restourantDto){
        return  ResponseEntity.ok(restourantService.save(restourantDto));
    }
    @PostMapping("api/rlogin")
    public  String LoginRestourant(@RequestBody RestourantDto loginRestourantRequest)
    {
        Restourant restourant = restourantService.findByRestourantName(loginRestourantRequest.getRestourantName());
        if (restourant != null && restourant.getRestourantPassword().equals(loginRestourantRequest.getRestourantPassword())) {
            return "Giriş başarılı!";

        } else {
            System.out.println(restourant.getRestourantName());

            return "Giriş başarısız! Lütfen bilgilerinizi kontrol .";
        }
    }
}
