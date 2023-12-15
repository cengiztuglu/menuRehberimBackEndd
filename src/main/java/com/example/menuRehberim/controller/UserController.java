package com.example.menuRehberim.controller;

import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.Restourant;
import com.example.menuRehberim.entity.User;
import com.example.menuRehberim.service.UserService;
import com.example.menuRehberim.service.RestourantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> loginRestaurant(@RequestBody RestourantDto loginRestaurantRequest) {
        Restourant restaurant = restourantService.findByUserName(loginRestaurantRequest.getUserName());
        if (restaurant != null && restaurant.getPassword().equals(loginRestaurantRequest.getPassword())) {
            Long restaurantID = restaurant.getId(); // Assuming the ID retrieval works fine

            if (restaurantID != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json"); // JSON formatında yanıt
                return ResponseEntity.ok()
                        .headers(headers)
                        .body("{\"restaurantID\": " + restaurantID + "}");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Restoran ID alınamadı.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Giriş başarısız! Lütfen bilgilerinizi kontrol edin."); // Return an error message
        }
    }


}
