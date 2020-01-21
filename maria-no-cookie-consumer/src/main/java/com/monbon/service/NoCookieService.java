package com.monbon.service;


import com.monbon.model.CookieVo;
import org.springframework.stereotype.Service;

@Service
public interface NoCookieService {

    void core(CookieVo cookieVo);

}