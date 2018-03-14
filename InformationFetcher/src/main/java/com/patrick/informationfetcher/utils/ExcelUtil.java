package com.patrick.informationfetcher.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class ExcelUtil {
    private static final String FILE_NAME = "data.xls";
    private static FileInputStream fileInputStream = null;
    private static FileOutputStream fileOutputStream = null;


    public List<String> importExcel() throws IOException {
        fileInputStream = new FileInputStream(FILE_NAME);
        List<String> shopNameList = new ArrayList<>();
        Workbook workbook=new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet= (HSSFSheet) workbook.getSheetAt(0);
        for(int i=0;i<=sheet.getLastRowNum();++i) {
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(1);
            shopNameList.add(cell.getStringCellValue());
        }
        workbook.close();
        fileInputStream.close();
        return shopNameList;
    }

    public void exportExcel(List list,int column) throws IOException {
        fileInputStream = new FileInputStream(FILE_NAME);
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
        Row row = null;
        Cell cell = null;
        for(int i=0;i<=sheet.getLastRowNum();++i){
            row = sheet.getRow(i);
            cell = row.createCell(column - 1);
            cell.setCellValue(list.get(i).toString());
        }
        try {
            fileInputStream.close();
            fileOutputStream = new FileOutputStream(FILE_NAME);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
