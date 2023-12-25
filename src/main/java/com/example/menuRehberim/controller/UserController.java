package com.example.menuRehberim.controller;

import com.example.menuRehberim.dto.MenuItemDto;
import com.example.menuRehberim.dto.PlaceDto;
import com.example.menuRehberim.dto.RestourantDto;
import com.example.menuRehberim.dto.UserDto;
import com.example.menuRehberim.entity.*;
import com.example.menuRehberim.service.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private  final UserService userService;
    private  final RestourantService restourantService;
    private  final PlaceService placeService;
    private  final MenuItemService menuItemService;




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

@Transactional
    @PostMapping(value ="/api/placeAdd/{userName}" )
    public ResponseEntity<Place> addPlace(
            @PathVariable String userName,
            @RequestParam("file") MultipartFile file,
            @ModelAttribute Place placeDto

    ) {
        // Dosya yükleme işlemleri
        if (!file.isEmpty()) {
            String filePath = "C:/Users/Cengiz/Desktop/Ders_Notları_Ara_Sınava_Kadar_Olan_Kısım/menuRehberimBackEndd/src/main/java/Assets/"+userName+".jpg" ;

            try {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(file.getBytes());
                stream.close();

                byte[] imageData = file.getBytes();
                System.out.println(imageData.toString());

                placeDto.setPlaceBgPicName(imageData);
                placeDto.setRestourantName(placeDto.getRestourantName());
                placeDto.setPlaceAdress(placeDto.getPlaceAdress());
                placeDto.setPlaceDefinition(placeDto.getPlaceDefinition());
                placeDto.setCategory(placeDto.getCategory());
                placeDto.setRestourant(placeDto.getRestourant());
            } catch (IOException e) {
                // Dosya içeriğini alırken bir hata oluştu
                e.printStackTrace();
            }
        }

        // Diğer parametrelerle ilgili işlemler...

        return ResponseEntity.ok( placeService.update(placeDto, userName));
    }



    @GetMapping("api/getPlace")
    public ResponseEntity<List<PlaceDto>> gerekliOlanlarıListele() {
        return ResponseEntity.ok(placeService.getAll());
    }

    @GetMapping("/api/getMenuItemsById/{id}")
    public ResponseEntity<List<MenuItemDto>> getMenuItemsById(@PathVariable Long id) {
        List<MenuItemDto> menuItemList = menuItemService.getMenuItemsById(id);
        return ResponseEntity.ok(menuItemList);
    }





    @Transactional
    @PostMapping(value ="/api/menuItemsAdd/{userName}" )
    public ResponseEntity<MenuItem> addMenuItem(
            @PathVariable String userName,
            @RequestParam("file") MultipartFile file1,
            @ModelAttribute MenuItem menuItemDto


    ) {
        // Dosya yükleme işlemleri
        if (!file1.isEmpty()) {
            String filePath = "C:/Users/Cengiz/Desktop/Ders_Notları_Ara_Sınava_Kadar_Olan_Kısım/menuRehberimBackEndd/src/main/java/Assets/"+userName+".jpg" ;

            try {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(file1.getBytes());
                stream.close();

                byte[] imageData = file1.getBytes();
                System.out.println(imageData.toString());

                menuItemDto.setItemPicName(imageData);

            } catch (IOException e) {
                // Dosya içeriğini alırken bir hata oluştu
                e.printStackTrace();
            }
        }

        // Diğer parametrelerle ilgili işlemler...

        return ResponseEntity.ok( menuItemService.save(menuItemDto, userName));
    }

}


