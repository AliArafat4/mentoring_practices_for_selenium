package tests.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.util.List;

public class T02CalculateTableTotalTest extends TestBase2 {
     /*
    Go to https://claruswaysda.github.io/webTable.html
    Calculate and assert the total price in Table 2.
     */

    @Test
    public void CalculateTableTotalTest() {
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("Clarusway website is opened ..");

        List<WebElement> tablePrices = driver.findElements(By.xpath("//table[@id='t2']//td[3]"));
        int total = 0;
        for (WebElement tablePrice : tablePrices) {

            total += Integer.parseInt(tablePrice.getText().substring(1));
        }

        logger.info("Total is : {}", total);
        Assertions.assertEquals(2275, total);

    }
}