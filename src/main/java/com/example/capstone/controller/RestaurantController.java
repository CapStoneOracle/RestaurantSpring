package com.example.capstone.controller;

import com.example.capstone.entity.Restaurant_info;
import com.example.capstone.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 현재 좌표 1km 반경 음식점 추천
    @GetMapping("/point")
    public ResponseEntity<List<Restaurant_info>> getCoordinates(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {

        return ResponseEntity.ok(restaurantService.find(latitude, longitude));
    }

    // 음식점 검색 결과
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant_info>> search(@RequestParam("keyword") String keyword) {

        return ResponseEntity.ok(restaurantService.findAll(keyword));
    }

    // 음식점 정보 보여주기
    @GetMapping("/restaurant")
    public ResponseEntity<Optional<Restaurant_info>> findById(@RequestParam("id") int id){
        return ResponseEntity.ok(restaurantService.findById(id));
    }

}
