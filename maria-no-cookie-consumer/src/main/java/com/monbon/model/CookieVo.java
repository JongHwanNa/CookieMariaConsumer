package com.monbon.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CookieVo")
public class CookieVo {


    private String  auId;
    private String  key;
    private String  value;
    private Long    expire;

    private String  freqType;
    private long    expireTime;

    private String  regDate;
    private String  updDate;

    //DOMAIN_FREQ
    private String  domainUrl;
    private String  freqCnt;

    //SHOP_FREQ
    private String  siteCode;
    private String  pCode;

    //KEYWORD_FREQ
    private String  keyword;

    //DSCK
    private String  scriptNo;       //지면코드
    private String  guBun;          //광고구분
    private String  bannerType;     //배너타입
    private Integer serverHostId;   //서버호스트 ID
    private String  abTests;        //AB 테스트타입
    private String  subAdGuBun;     //채우기광고구분
    private String  ergAbt;         //추천시스템구분자
    private String  ergDetail;      //추천시스템상세구분자
    private String  abcSeq;         //abcSeq

    //DSCK_FRM
    private String  frameCode;       //프레임코드
    private Integer frameCycleNum;   //프레임사이클번호
    private Integer frameAlgSeq;     //프레임알고리즘번호
    private String  frameAbType;     //프레임 AB 테스트타입


    private Integer frameNo;         //프레임번호





    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CookieVo{");
        sb.append('}');
        return sb.toString();
    }
}
