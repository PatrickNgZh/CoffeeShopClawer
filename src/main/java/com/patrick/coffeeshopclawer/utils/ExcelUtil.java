package com.patrick.coffeeshopclawer.utils;

import com.patrick.coffeeshopclawer.pojo.CoffeeShop;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author peicong
 * @date 2018/2/24 0024
 */
public class ExcelUtil {

    private static final String FILE_NAME="data.xls";
    private static FileOutputStream fileOutputStream = null;

    static {
        try {
            fileOutputStream = new FileOutputStream(FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportExcel(List<CoffeeShop> coffeeShops) {
        Workbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = (HSSFSheet) workbook.createSheet("data");
        Row row = null;
        Cell cell = null;
        CoffeeShop coffeeShop = null;
        for (int i = 0; i < coffeeShops.size(); i++) {
            coffeeShop = coffeeShops.get(i);
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(coffeeShop.getName());

            cell = row.createCell(1);
            cell.setCellValue(coffeeShop.getAddress());

            cell = row.createCell(2);
            cell.setCellValue(coffeeShop.getTag());

            cell = row.createCell(3);
            cell.setCellValue(coffeeShop.getConsume());

            cell = row.createCell(4);
            cell.setCellValue(coffeeShop.getComment());

            cell = row.createCell(5);
            cell.setCellValue(coffeeShop.getTaste());

            cell = row.createCell(6);
            cell.setCellValue(coffeeShop.getEnvironment());

            cell = row.createCell(7);
            cell.setCellValue(coffeeShop.getService());
        }
        try {
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
