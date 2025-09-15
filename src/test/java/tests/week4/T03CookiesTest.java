package tests.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T03CookiesTest extends TestBase {

    /*
    Go to https://claruswaysda.github.io/CookiesWait.html
    Accept the alert if it is present
    Print the cookies
    Delete all cookies and assert
    */
    @Test
    public void T03CookiesTest(){
        driver.get("https://claruswaysda.github.io/CookiesWait.html");

        Wait<WebDriver> wait =new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10) ).pollingEvery(Duration.ofMillis(500));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();

        driver.switchTo().defaultContent();
        System.out.println(driver.manage().getCookies());
        driver.manage().deleteAllCookies();
        Assertions.assertTrue(driver.manage().getCookies().isEmpty());

    }
}