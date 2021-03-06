package com.patrick.coffeeshopclawer.utils;

import com.patrick.coffeeshopclawer.pojo.CoffeeShop;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class HtmlParser {

    private static final HtmlFetcher HTML_FETCHER = new HtmlFetcher();

    public List<CoffeeShop> parseWebPage(String url) throws IOException {

        Elements shops = Jsoup.parse(HTML_FETCHER.fetch(url)).select("#shop-all-list ul li");
        return shops.stream()
                .map(e -> new CoffeeShop(e.select(".addr").text(),
                        e.select("h4").text(),
                        e.select(".tag").text().split(" ")[1],
                        e.select(".review-num b").text(),
                        e.select(".comment-list span b").text().equals("") ? "-" : e.select(".comment-list span b").text().split(" ")[0],//problem of String index out of range: -1
                        e.select(".comment-list span b").text().equals("") ? "-" : e.select(".comment-list span b").text().split(" ")[1],//because == compare with address
                        e.select(".comment-list span b").text().equals("") ? "-" : e.select(".comment-list span b").text().split(" ")[2],//and equals() compare with values
                        e.select(".mean-price b").text().equals("") ? "-" : e.select(".mean-price b").text().substring(1)))
                .collect(Collectors.toList());

    }
}
