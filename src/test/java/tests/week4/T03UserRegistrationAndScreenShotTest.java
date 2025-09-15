package tests.week4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v137.page.model.Screenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T03UserRegistrationAndScreenShotTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/homepage.html
    Register a user
    Sign in with the registered user
    Take all pages' screenshots
    Take 'Celebrate Login' button's screenshot.
    Capture a screenshot of the page with confetti.
    */

    @Test
    void testT03UserRegistrationAndScreenShotTest() throws IOException {
        driver.get("https://claruswaysda.github.io/homepage.html");

        TakesScreenshot ts = (TakesScreenshot) driver;

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));

        File screenShot = ts.getScreenshotAs(OutputType.FILE);
        Path path= Path.of(System.getProperty("user.dir"),"screenShot","lastScreenshot " + timestamp + ".png");
        FileUtils.copyFile(screenShot,path.toFile());

        By userIcon = By.id("userIcon");
        driver.findElement(userIcon).click();
        By register = By.xpath("//a[normalize-space()='Register']");

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

        driver.findElement(register).click();
        driver.findElement(ssnField).sendKeys("123-45-6789");
        driver.findElement(firstNameField).sendKeys("John");
        driver.findElement(lastNameField).sendKeys("Doe");
        driver.findElement(addressField).sendKeys("123 Main St");
        driver.findElement(phoneField).sendKeys("555-123-4567");
        String username = "johndoe";
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys("email@email.com");
        String password = "Password123";
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(registerButton).click();

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        button.click();


        By submitButton = By.xpath("//button[@type='submit']");


        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();

    }
}