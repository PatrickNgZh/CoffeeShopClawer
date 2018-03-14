package com.patrick.informationfetcher.utils;

import com.google.gson.Gson;
import com.patrick.informationfetcher.pojo.GeoInfo;
import com.patrick.informationfetcher.pojo.NumInfo;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class GsonParser {

    public static GeoInfo parseGeoInfo(String response){
        return new Gson().fromJson(response, GeoInfo.class);
    }

    public static NumInfo parseNumInfo(String response){
        return new Gson().fromJson(response,NumInfo.class);
    }


}
