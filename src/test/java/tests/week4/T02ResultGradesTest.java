package tests.week4;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T02ResultGradesTest  {

    /*
    Given: Save StudentScores.xlsx file into your project
    When: In the grade column, write the letter grades (A, B, C, D, F) based on the score ranges:
    A: 90-100
    B: 80-89
    C: 70-79
    D: 60-69
    F: below 60
    Then: Assert that the grade of "Alice" is "A
     */
    @Test
    public void test01() throws IOException {
        String pathOf = Path.of(".", "resources", "TestData02.xlsx").toString();
        FileInputStream path = new FileInputStream(pathOf);
        Workbook workbook = WorkbookFactory.create(path);
        Sheet sheet = workbook.getSheetAt(0);


        for(int i=1; i<= sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            int  score = (int) row.getCell(1).getNumericCellValue();

            if(score >=90 && score <=100){
                row.createCell(2).setCellValue("A");

            }else if (score >=80 && score <=89){
                row.createCell(2).setCellValue("B");

            }else if (score >=70 && score <=79){
                row.createCell(2).setCellValue("C");

            }else if (score >=60 && score <=69){
                row.createCell(2).setCellValue("D");

            }else {
                row.createCell(2).setCellValue("F");
            }
        }

        FileOutputStream fos = new FileOutputStream(pathOf);
        workbook.write(fos);
        fos.close();
        Assertions.assertEquals("A", sheet.getRow(3).getCell(2).getStringCellValue() );

        workbook.close();

    }
}