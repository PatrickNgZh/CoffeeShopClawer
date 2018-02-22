package com.patrick.coffeeshopclawer.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class HtmlFetcher {

    public String fetch(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url).timeout(3000).header("User-Agent","Mozilla/5.0" +
                " (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36").execute();
        return response.statusCode() / 100 == 2 ? response.body() : null;
    }

}
