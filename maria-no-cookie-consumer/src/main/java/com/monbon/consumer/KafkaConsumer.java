package com.monbon.consumer;


import com.monbon.service.NoCookieService;
import com.monbon.model.CookieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    NoCookieService noCookieService;

    @KafkaListener(topics="mobon-cookiestore", containerFactory = "cookieVoKafkaListenerFactory")
    public void consumeJson(CookieVo cookieVo) {

        System.out.println("consumeJson >  " +cookieVo);

        noCookieService.core(cookieVo);

        }
    }
