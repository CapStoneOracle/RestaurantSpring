package com.example.capstone.service;

import com.example.capstone.entity.Restaurant_info;
import com.example.capstone.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // 1km 음식점 추천
    @Transactional(readOnly = true)
    public List<Restaurant_info> find(String latitude, String longitude) {
        BigDecimal decimalLat = new BigDecimal(latitude);
        BigDecimal decimalLon = new BigDecimal(longitude);

        System.out.println(decimalLat+" "+decimalLon);

        return restaurantRepository.find(decimalLat, decimalLon);
    }

    // 검색한 모든 음식점 결과
    @Transactional(readOnly = true)
    public List<Restaurant_info> findAll(String keyword) {
        return restaurantRepository.findByNameContaining(keyword);
    }

    // 선택한 음식점 정보 보여주기
    @Transactional
    public Optional<Restaurant_info> findById(int id){
        return restaurantRepository.findById(id);
    }
}