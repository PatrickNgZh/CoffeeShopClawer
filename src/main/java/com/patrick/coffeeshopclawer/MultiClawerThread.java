package com.patrick.coffeeshopclawer;

import com.patrick.coffeeshopclawer.pojo.WebPage;
import com.patrick.coffeeshopclawer.utils.HtmlParser;

import java.io.IOException;

/**
 * @author peicong
 * @date 2018/2/21 0021
 */
public class MultiClawerThread implements Runnable {

    private final Clawer clawer;
    private final HtmlParser htmlParser = new HtmlParser();

    public MultiClawerThread(Clawer clawer) {
        super();
        this.clawer = clawer;
    }

    @Override
    public void run() {
        WebPage webPage;
        int getUnCrawlPageTimes = 0;
        while (true) {
            webPage = clawer.getUnClawPage();
            if (webPage == null) {
                if (getUnCrawlPageTimes > 10) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getUnCrawlPageTimes++;
                    continue;
                }
            } else {
                getUnCrawlPageTimes = 0;
                try {
                    clawer.saveCoffeeShops(htmlParser.parseWebPage(webPage.getUrl()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
