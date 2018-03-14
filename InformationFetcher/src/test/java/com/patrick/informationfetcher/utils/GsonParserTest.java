package com.patrick.informationfetcher.utils;

import com.patrick.informationfetcher.pojo.GeoInfo;
import org.junit.Test;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class GsonParserTest {

    private static final String BASE_URL = "http://restapi.amap.com/v3/geocode/geo?" +
            "key=7ccbeef8c3c2f79f8f763ba011c9631f";
    private static final String CITY_URL = "&city=北京";


    @Test
    public void testParseResponse() throws Exception {
        String response = new OkhttpUtil().sentRequestWithOkhttp(BASE_URL+"&address=芳野cafe"+CITY_URL);
        GeoInfo geoInfo = GsonParser.parseGeoInfo(response);
        System.out.println(geoInfo.getAddressList().get(0));
    }


} 
