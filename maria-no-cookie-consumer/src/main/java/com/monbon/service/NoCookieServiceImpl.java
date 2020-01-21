package com.monbon.service;


import com.monbon.model.CookieVo;
import com.monbon.service.dao.CookieToMariaDBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


@Service
public class NoCookieServiceImpl implements NoCookieService {

    @Autowired
    CookieToMariaDBDao cookieToMariaDBDao;

    //key method
    public void core(CookieVo cookieVo){
        String key = cookieVo.getKey();

        if ("fBRm".equals(key) || "fBUm".equals(key) || "fBHu".equals(key) || "fBAu".equals(key) || "fSHu".equals(key)
           || "fSRm".equals(key) || "fSRr".equals(key) || "fSUm".equals(key) || "fIHu".equals(key) || "fIRm".equals(key)
           || "fIRr".equals(key) || "fIUm".equals(key)) {

            domainFreqParsing(cookieVo);
        } else if ("fBCw".equals(key) || "fBSr".equals(key) || "fBRc".equals(key) || "fBSp".equals(key) || "fBPr".equals(key)
                || "ulFBCw".equals(key) || "ulFBSr".equals(key) || "fSCw".equals(key) || "fSSr".equals(key) || "fSRc".equals(key)
                || "fSSp".equals(key) || "fICw".equals(key) || "fISr".equals(key) || "fIRc".equals(key) || "fISp".equals(key)) {

            shopFreqParsing(cookieVo);
        } else if ("fBKl".equals(key) || "fSKl".equals(key) || "fIKl".equals(key)){

            keywordFreqParsing(cookieVo);
        } else if ("fBAt".equals(key)){

            appPkgFreqPasing(cookieVo);
        } else if ("dsck".equals(key) || "dsck_frame".equals(key) || "dsck_frame_nfm".equals(key)){


        } else if ("reffer_domain".equals(key)) {


        } else if ("cat".equals(key)) {


        } else if ("native_rm_keyword".equals(key)) {


        }
     }

    public void domainFreqParsing(CookieVo cookieVo){

        String auid = cookieVo.getAuId();
        long expireTime = cookieVo.getExpire();
        String value = cookieVo.getValue();
        String freqType = cookieVo.getKey();

        List<CookieVo> domainFreqList = new ArrayList<>();
        String[] domainUrlValue = value.split("#");

        for(int i = 0; i < domainUrlValue.length; i++) {

            CookieVo mariaVo = new CookieVo();

            final String FreqValue = domainUrlValue[i];
            String[] domainFreqUrl = altStringTokenizer(getStringTokenizerStrict(FreqValue, "^", true), 41);
            String domainUrl = domainFreqUrl[0];
            String freqCnt = domainFreqUrl[1];

            mariaVo.setAuId(auid);
            mariaVo.setFreqType(freqType);
            mariaVo.setExpireTime(expireTime);
            mariaVo.setFreqCnt(freqCnt);
            mariaVo.setDomainUrl(domainUrl);

            domainFreqList.add(mariaVo);
        }

        cookieToMariaDBDao.insertDomainFreq(domainFreqList);
    }

    public void shopFreqParsing(CookieVo cookieVo){

        String auid = cookieVo.getAuId();
        long expireTime = cookieVo.getExpire();
        String value = cookieVo.getValue();
        String freqType = cookieVo.getKey();

        List<CookieVo> shopFreqList = new ArrayList<>();
        String[] shopFreqValue = value.split("#");

        for(int i = 0; i < shopFreqValue.length; i++) {

            CookieVo mariaVo = new CookieVo();

            final String FreqValue = shopFreqValue[i];
            String[] shopFreqSiteCode = altStringTokenizer(getStringTokenizerStrict(FreqValue, "^", true), 41);
            String siteCode = shopFreqSiteCode[0];
            String pCode = shopFreqSiteCode[1];
            String ShopCnt = shopFreqSiteCode[2];

            mariaVo.setAuId(auid);
            mariaVo.setKey(freqType);
            mariaVo.setExpire(expireTime);
            mariaVo.setSiteCode(siteCode);
            mariaVo.setPCode(pCode);
            mariaVo.setFreqCnt(ShopCnt);

            shopFreqList.add(mariaVo);
        }

        cookieToMariaDBDao.insertShopFreq(shopFreqList);
    }

    public void keywordFreqParsing(CookieVo cookieVo){

        String auid = cookieVo.getAuId();
        long expireTime = cookieVo.getExpire();
        String value = cookieVo.getValue();
        String freqType = cookieVo.getKey();

        List<CookieVo> keywordFreqList = new ArrayList<>();
        String[] keywordFreqValue = value.split("#");

        for(int i = 0; i < keywordFreqValue.length; i++) {

            CookieVo mariaVo = new CookieVo();

            final String FreqValue = keywordFreqValue[i];
            String[] keywordFreq = altStringTokenizer(getStringTokenizerStrict(FreqValue, "^", true), 41);
            String keyword = keywordFreq[0];
            String keywordCnt = keywordFreq[1];

            mariaVo.setAuId(auid);
            mariaVo.setKey(freqType);
            mariaVo.setExpire(expireTime);
            mariaVo.setKeyword(keyword);
            mariaVo.setFreqCnt(keywordCnt);

            keywordFreqList.add(mariaVo);
        }

        cookieToMariaDBDao.insertKeywordFreq(keywordFreqList);
    }

    public void appPkgFreqPasing(CookieVo cookieVo){

        String auid = cookieVo.getAuId();
        long expireTime = cookieVo.getExpire();
        String value = cookieVo.getValue();
        String freqType = cookieVo.getKey();

        List<CookieVo> appPkgFreqList = new ArrayList<>();
        String[] appPkgFreqValue = value.split("#");

        for(int i = 0; i < appPkgFreqValue.length; i++) {

            CookieVo mariaVo = new CookieVo();

            final String FreqValue = appPkgFreqValue[i];
            String[] appTgtFreq = altStringTokenizer(getStringTokenizerStrict(FreqValue, "^", true), 41);
            String siteCode = appTgtFreq[0];
            String appPkgCnt = appTgtFreq[1];

            mariaVo.setAuId(auid);
            mariaVo.setKey(freqType);
            mariaVo.setExpire(expireTime);
            mariaVo.setSiteCode(siteCode);
            mariaVo.setFreqCnt(appPkgCnt);

            appPkgFreqList.add(mariaVo);
        }

        cookieToMariaDBDao.insertAppPkgFreq(appPkgFreqList);
    }
















    public static String[] altStringTokenizer(StringTokenizer st, int splitSize) {
        String[] tempArr = new String[splitSize];
        int index = 0;
        while (st.hasMoreTokens()) {
            tempArr[index++] = st.nextToken();
        }
        return tempArr;
    }

    public static StringTokenizer getStringTokenizerStrict(String src, String delim, boolean b) {
        StringTokenizer st = new StringTokenizer(src, delim, b);
        StringBuffer sb = new StringBuffer();

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(delim)) {
                sb.append(" ").append(delim);
            } else {
                sb.append(s).append(delim);
                if (st.hasMoreTokens())
                    st.nextToken();
            }
        }
        return (new StringTokenizer(sb.toString(), delim));
    }

}