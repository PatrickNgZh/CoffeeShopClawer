package com.patrick.coffeeshopclawer.utils;

import com.patrick.coffeeshopclawer.pojo.CoffeeShop;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peicong
 * @date 2018/2/24 0024
 */
public class ExcelUtilTest {

    @Test
    public void testExportExcel() throws Exception {
        ExcelUtil excelUtil = new ExcelUtil();
        List<CoffeeShop> coffeeShops = new ArrayList<>();
        coffeeShops.add(new CoffeeShop("this is a test", "test", "test",
                "test", "test", "test", "test", "test"));
        coffeeShops.add(new CoffeeShop("this is second", "second", "second",
                "second", "second", "second", "second", "second"));
        excelUtil.exportExcel(coffeeShops);
    }
} 
