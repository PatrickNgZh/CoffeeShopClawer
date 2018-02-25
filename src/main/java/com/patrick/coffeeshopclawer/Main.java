package com.patrick.coffeeshopclawer;

import com.patrick.coffeeshopclawer.pojo.CoffeeShop;
import com.patrick.coffeeshopclawer.pojo.WebPage;
import com.patrick.coffeeshopclawer.utils.ExcelUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author peicong
 * @date 2018/2/21 0021
 */
public class Main implements Clawer {

    private static List<WebPage> webPagesLists;
    private static List<CoffeeShop> coffeeShops = new Vector<>();
    private static final Integer MAX_THREADS = 20;
    private static final String BASE_URL = "http://www.dianping.com/beijing/ch10/g132";
    //    private static BufferedWriter bufferedWriter=null;
    private static final ExcelUtil excelUtil = new ExcelUtil();

//    static {
//        try {
//            bufferedWriter = new BufferedWriter(new FileWriter("data.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void initClawerLists() {
        webPagesLists = new ArrayList<>();
        webPagesLists.add(new WebPage(BASE_URL
                , 1, WebPage.Status.unclawed));

    }

    @Override
    public synchronized WebPage getUnClawPage() {
        if (webPagesLists.isEmpty()) {
            return null;
        } else {
            return webPagesLists.remove(0);
        }
    }

    @Override
    public void addToClawerList() {
        for (int i = 2; i <= 50; i++) {
            String url = BASE_URL + "p" + i;
            webPagesLists.add(new WebPage(url, i, WebPage.Status.unclawed));
        }
    }

    @Override
    public void saveCoffeeShops(List<CoffeeShop> coffeeShops) {
        this.coffeeShops.addAll(coffeeShops);
    }

    @Override
    public List<CoffeeShop> getCoffeeShops() {
        return coffeeShops;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);
        for (int i = 0; i < MAX_THREADS; i++) {
            executorService.execute(new MultiClawerThread(this));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(List<CoffeeShop> coffeeShops) {
//        try {
//            bufferedWriter.write(coffeeShop.getName());
//            bufferedWriter.newLine();
//            bufferedWriter.write(coffeeShop.getAddress());
//            bufferedWriter.newLine();
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        excelUtil.exportExcel(coffeeShops);
    }

    public static void main(String[] args) {
        System.out.println("running...");
        Date startTime = new Date();
        Clawer clawer = new Main();
        clawer.initClawerLists();
        clawer.addToClawerList();
        clawer.run();
        System.out.println(coffeeShops.size()+" items");
        clawer.save(coffeeShops);
        System.out.println("Total spent time is "
                + (new Date().getTime() - startTime.getTime()) + " ms");
    }
}
