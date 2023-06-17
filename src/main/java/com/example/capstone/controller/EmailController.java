package com.example.capstone.controller;

import com.example.capstone.dto.MailDTO;
import com.example.capstone.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService mailService;


    @PostMapping("/mail")
    public void MailSend(MailDTO mailVo){
        mailService.CreateMail(mailVo);
    }

}
