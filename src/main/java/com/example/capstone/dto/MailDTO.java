package com.example.capstone.dto;

import lombok.Data;

@Data
public class MailDTO {
    private String receiver;
    private String title;
    private String content;
}
