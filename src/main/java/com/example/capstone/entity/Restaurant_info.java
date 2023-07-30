package com.example.capstone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    private String name;

    private String category;

    private String phonenum;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Lob
    private String naverreview;

    private String naverstar;

    @Lob
    private String googlereview;

    private String googlestar;

    @Lob
    private String mangoreview;

    private String mangostar;


}
