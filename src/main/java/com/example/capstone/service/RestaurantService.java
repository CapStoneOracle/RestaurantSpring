package com.example.capstone.service;

import com.example.capstone.entity.Restaurant_info;
import com.example.capstone.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional(readOnly = true)
    public List<Restaurant_info> find(String latitude, String longitude) {
        BigDecimal decimalLat = new BigDecimal(latitude);
        BigDecimal decimalLon = new BigDecimal(longitude);

        System.out.println(decimalLat+" "+decimalLon);

        return restaurantRepository.find(decimalLat, decimalLon);
    }

    @Transactional(readOnly = true)
    public List<Restaurant_info> findAll(String keyword) {
        return restaurantRepository.findByNameContaining(keyword);
    }
}