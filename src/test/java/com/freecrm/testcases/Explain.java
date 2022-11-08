package com.freecrm.testcases;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Explain
{
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\TOP\\Desktop\\data driven.xlsx");// java
        FileInputStream fis= new FileInputStream(file);  // java
        // Apachi poi
        XSSFWorkbook workbook= new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("contactpagef");
        /*    get information*/
        String family_name = sheet.getRow(1).getCell(2).toString();
        System.out.println(family_name);
        /* dimensions of Excel sheet   */
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        Object data[][]= new Object[rows][columns];
        for (int i=0; i<rows ;i++){
            for (int k =0; k<columns;k++){
                data[i][k] = sheet.getRow(i).getCell(k);

            }
        }
        System.out.println(data[1][1]);


        workbook.close();

    }
}
