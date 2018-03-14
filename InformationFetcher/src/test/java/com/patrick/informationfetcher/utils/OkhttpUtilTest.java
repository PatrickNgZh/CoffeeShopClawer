package com.patrick.informationfetcher.utils;

import org.junit.Test;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class OkhttpUtilTest {

    private static final String URL="http://apis.map.qq.com/ws/place/v1/search?keyword=%E5%A4%A7%E5%AD%A6" +
            "&boundary=nearby(39.87484,116.46799,1000)&orderby=_distance&key=OOLBZ-EVFWF-RI5JA-NZKQJ-JR6Z3-EBFTU";

    @Test
    public void testRentRequestWithOkhttp() throws Exception {
        System.out.println(new OkhttpUtil().sentRequestWithOkhttp(URL));
    }


} 
