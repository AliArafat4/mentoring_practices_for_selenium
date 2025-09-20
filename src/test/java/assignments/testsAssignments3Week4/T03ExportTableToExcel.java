package assignments.testsAssignments3Week4;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class T03ExportTableToExcel extends TestBase {
     /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    @Test
    public void T04ExportTableToExcel() throws IOException {
        driver.get("https://claruswaysda.github.io/webTable.html");
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("Students Grades");
        List<WebElement> table = driver.findElements(By.xpath("//table[@id='t1']//tr"));

        for (WebElement webElement : table) {
            System.out.println(webElement.getText());
            String[] cellData = webElement.getText().split(" ");
            int sheetRow = sheet.getLastRowNum() + 1;
            sheet.createRow(sheetRow).createCell(0).setCellValue(cellData[0]);
            sheet.getRow(sheetRow).createCell(1).setCellValue(cellData[1]);
            sheet.getRow(sheetRow).createCell(2).setCellValue(cellData[2]);
        }

        String pathOf = Path.of(".", "resources", "StudentsGrades.xlsx").toString();
        FileOutputStream fos = new FileOutputStream(pathOf);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

}