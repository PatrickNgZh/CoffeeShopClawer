package com.patrick.informationfetcher;

import com.patrick.informationfetcher.pojo.Address;
import com.patrick.informationfetcher.pojo.GeoInfo;
import com.patrick.informationfetcher.pojo.NumInfo;
import com.patrick.informationfetcher.utils.ExcelUtil;
import com.patrick.informationfetcher.utils.GsonParser;
import com.patrick.informationfetcher.utils.OkhttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class Main {

    private static final String LOCSTION_BASE_URL = "http://restapi.amap.com/v3/geocode/geo?" +
            "key=1218577070fd40391526f8e145352085";
    private static final String CITY_URL = "&city=北京";
    private static final String AROUND_BASE_YRL = "http://restapi.amap.com/v3/place/around?" +
            "key=1218577070fd40391526f8e145352085" + "&location=";
    private static final String RADIUS = "&radius=1000";
    private static final String[] TYPES = {"大学", "地铁", "景点", "咖啡店"};
    private static final String TYPE_BASE = "&keywords=";

    public static void main(String[] args) {
        System.out.println("running...");
        Date startTime = new Date();
        try {
            List<String> shopNameList = new ExcelUtil().importExcel();
            List<Address> addressList = new ArrayList<>();
            for (String string : shopNameList) {
                String response = new OkhttpUtil().sentRequestWithOkhttp(LOCSTION_BASE_URL
                        + "&address=" + string + CITY_URL);
                GeoInfo geoInfo = GsonParser.parseGeoInfo(response);
                if (geoInfo.getAddressList() == null) {
                    addressList.add(new Address());
                } else {
                    addressList.add(geoInfo.getAddressList().get(0));
                }
            }

            List<NumInfo> list = new ArrayList<>();
            for (Address address : addressList) {
                String response = new OkhttpUtil().sentRequestWithOkhttp(AROUND_BASE_YRL
                        + address.getLocation() + TYPE_BASE + TYPES[3] + RADIUS);
                NumInfo info = GsonParser.parseNumInfo(response);
                list.add(info);
            }
            new ExcelUtil().exportExcel(list, 12);


            System.out.println("Total spent time is "
                    + (new Date().getTime() - startTime.getTime()) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
