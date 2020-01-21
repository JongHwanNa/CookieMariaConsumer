package com.monbon.service.dao;

import com.monbon.model.CookieVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class NoCookieDAO {

    @Resource(name="sqlSessionFactoryDreamsearch")
    private SqlSessionTemplate dreamsearchTemplate;

    public String test(CookieVo cookieVo){
        return dreamsearchTemplate.selectOne("kafka.selectAdSite_siteCode", cookieVo);
    }
}
