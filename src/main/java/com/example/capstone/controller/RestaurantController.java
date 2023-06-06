package com.example.capstone.controller;

import com.example.capstone.entity.Restaurant_info;
import com.example.capstone.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/point")
    public ResponseEntity<List<Restaurant_info>> getCoordinates(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {

        return ResponseEntity.ok(restaurantService.find(latitude, longitude));
    }

    @GetMapping("/po")
    public ResponseEntity<List<Restaurant_info>> ge(@RequestParam("latitude") String latitude) {

        return ResponseEntity.ok(restaurantService.findAll(latitude));
    }
}
