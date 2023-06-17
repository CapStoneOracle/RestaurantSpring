package com.example.capstone.repository;

import com.example.capstone.entity.Restaurant_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant_info, Integer> {
    @Query(value = "SELECT *," +
            " (6371*acos(cos(radians(:latitude))*cos(radians(r.latitude))*cos(radians(r.longitude) " +
            " - radians(:longitude))+sin(radians(:latitude))*sin(radians(r.latitude)))) " +
            "  AS distance " +
            "  FROM restaurant_info r" +
            "  HAVING distance <= 1" +
            "  ORDER BY distance", nativeQuery = true)
    List<Restaurant_info> find(@Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude);


    List<Restaurant_info> findByNameContaining(String keyword);
}
