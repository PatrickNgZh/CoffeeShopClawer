package com.patrick.informationfetcher.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class OkhttpUtil {

    public static OkHttpClient okHttpClient = new OkHttpClient();

    public String sentRequestWithOkhttp(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();

    }

}
