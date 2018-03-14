package com.patrick.informationfetcher.utils;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class ExcelUtilTest {

    @Test
    public void testImportExcel() throws Exception {
        List<String> shopNameList=new ExcelUtil().importExcel();
        for (String shopName:shopNameList){
            System.out.println(shopName);
        }
    }

    @Test
    public void testExportExcel() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        new ExcelUtil().exportExcel(list,9);
    }

} 
