package tests.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T01JSExecutorTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/signIn.html
    enter username 'admin'
    enter password '123'
    Click on Sign In
    Assert the 'Employee Table' is visible
    Create a method to change border color and style of web elements.
    Use the method on each element you interact with.
    */
    @Test
    void jsExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://claruswaysda.github.io/signIn.html");
        By userNameId = By.id("username");
        By passwordId = By.id("password");
        By signInButton = By.cssSelector("input[type='submit']");

        WebElement userNameElement = driver.findElement(userNameId);
        changeColor(js,userNameElement);
        userNameElement.sendKeys("admin");

        WebElement passwordElement = driver.findElement(passwordId);
        changeColor(js,passwordElement);
        passwordElement.sendKeys("123");

        WebElement signInButtonElement = driver.findElement(signInButton);
        changeColor(js,signInButtonElement);
        signInButtonElement.click();

        By tableId = By.id("employeeTable");
        Assertions.assertTrue(driver.findElement(tableId).isDisplayed());

    }
    void changeColor(JavascriptExecutor js, WebElement element ){
        js.executeScript("arguments[0].style.backgroundColor = 'red';", element);

    }
}