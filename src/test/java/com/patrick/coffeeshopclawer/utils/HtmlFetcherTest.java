package com.patrick.coffeeshopclawer.utils;

import org.junit.Test;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class HtmlFetcherTest {

    @Test
    public void testFetch() throws Exception {
        HtmlFetcher htmlFetcher = new HtmlFetcher();
        System.out.println(htmlFetcher.fetch("http://www.dianping.com/beijing/ch10/g132"));
    }
} 
