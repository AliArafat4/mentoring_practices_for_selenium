package tests.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T02IFrameAlertTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/iframe.html
    Type your name in input
    Click on 'Bold' button
    Assert the alert message
    */

    By field = By.xpath("//input[@type='text']");
    By button = By.xpath("//button[@aria-label='Bold']");

    @Test
    void test02() {
     driver.get("https://claruswaysda.github.io/iframe.html");
     driver.switchTo().frame("mce_0_ifr");
     driver.findElement(field).sendKeys("John Doe");
     driver.switchTo().defaultContent();
     driver.findElement(button).click();
     Alert alert = driver.switchTo().alert();
     String alertText = alert.getText();
     alert.accept();
     driver.switchTo().defaultContent();

     String expectedAlertText = "Bold button clicked";
     System.out.println("Alert text: " + alertText);
     Assertions.assertEquals( expectedAlertText, alertText);
    }
}