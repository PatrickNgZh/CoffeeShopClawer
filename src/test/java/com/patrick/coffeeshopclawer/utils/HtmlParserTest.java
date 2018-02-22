package com.patrick.coffeeshopclawer.utils;

import org.junit.Test;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class HtmlParserTest {

    @Test
    public void testParseWebPage() throws Exception {
        HtmlParser htmlParser = new HtmlParser();
        System.out.println(htmlParser.parseWebPage("http://www.dianping.com/beijing/ch10/g132"));
    }

} 
