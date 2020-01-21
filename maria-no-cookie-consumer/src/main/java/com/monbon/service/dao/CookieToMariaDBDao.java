package com.monbon.service.dao;

import com.monbon.model.CookieVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CookieToMariaDBDao {

    @Resource(name="sqlSessionFactoryDreamsearch")
    private SqlSessionTemplate dreamsearchTemplate;

    public int insertDomainFreq(List<CookieVo> cookieDomainFreqList) {
        return dreamsearchTemplate.insert("noCookie.insertDomainFreq", cookieDomainFreqList);
    }

    public int insertShopFreq(List<CookieVo> cookieShopFreqList) {
        return dreamsearchTemplate.insert("noCookie.insertShopFreq", cookieShopFreqList);
    }

    public int insertKeywordFreq(List<CookieVo> cookieShopFreqList) {
        return dreamsearchTemplate.insert("noCookie.insertShopFreq", cookieShopFreqList);
    }

    public int insertAppPkgFreq(List<CookieVo> cookieShopFreqList) {
        return dreamsearchTemplate.insert("noCookie.insertShopFreq", cookieShopFreqList);
    }




}