package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class T05FormHandlingWithJSExecutor extends TestBase {
    /*
    Go to https://claruswaysda.github.io/form.html
    Create a method to flash the elements you are working on and use it.
    Register a user
    Login
    Celebrate the login!
    */

    @Test
    public void T05FormHandlingWithJSExecutor() {
        driver.get("https://claruswaysda.github.io/form.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By ssnField = By.id("ssn");
        By firstNameField = By.id("first-name");
        By lastNameField = By.id("last-name");
        By addressField = By.id("address");
        By phoneField = By.id("phone");
        By emailField = By.id("email");
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By confirmPasswordField = By.id("confirm-password");
        By registerButton = By.className("button");
        By loginButton = By.className("login-button");


        flashElement(js, driver.findElement(ssnField));
        driver.findElement(ssnField).sendKeys("123-45-6789");
        flashElement(js, driver.findElement(firstNameField));
        driver.findElement(firstNameField).sendKeys("John");
        flashElement(js, driver.findElement(lastNameField));
        driver.findElement(lastNameField).sendKeys("Doe");
        flashElement(js, driver.findElement(addressField));
        driver.findElement(addressField).sendKeys("123 Main St");
        flashElement(js, driver.findElement(phoneField));
        driver.findElement(phoneField).sendKeys("555-123-4567");
        flashElement(js, driver.findElement(usernameField));
        driver.findElement(usernameField).sendKeys("johndoe");
        flashElement(js, driver.findElement(emailField));
        driver.findElement(emailField).sendKeys("email@email.com");
        flashElement(js, driver.findElement(passwordField));
        driver.findElement(passwordField).sendKeys("Password123");
        flashElement(js, driver.findElement(confirmPasswordField));
        driver.findElement(confirmPasswordField).sendKeys("Password123");
        flashElement(js, driver.findElement(registerButton));
        driver.findElement(registerButton).click();

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        flashElement(js, driver.findElement(loginButton));
        button.click();
    }

    private void flashElement(JavascriptExecutor js, WebElement element) {
        String originalColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 5; i++) {
            changeColor(js,"yellow", element);
            changeColor(js,originalColor, element);
        }
    }
    public static void changeColor(JavascriptExecutor js, String color, WebElement element) {
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

}