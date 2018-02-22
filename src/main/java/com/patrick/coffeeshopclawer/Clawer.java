package com.patrick.coffeeshopclawer;

import com.patrick.coffeeshopclawer.pojo.CoffeeShop;
import com.patrick.coffeeshopclawer.pojo.WebPage;

import java.util.List;

/**
 * @author peicong
 * @date 2018/2/21 0021
 */
public interface Clawer {

    void initClawerLists();

    WebPage getUnClawPage();

    void addToClawerList();


    void saveCoffeeShops(List<CoffeeShop> coffeeShops);

    List<CoffeeShop> getCoffeeShops();

    void run();

    void save(CoffeeShop coffeeShop);

}
