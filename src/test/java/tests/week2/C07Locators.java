package tests.week2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {

    static WebDriver driver;
    static String email = "test@gmail.com";
    static String password = "test@gmail.com";
    @BeforeAll
    public static void setUp() {
        // TODO: Initialize WebDriver

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // TODO: Navigate to LinkedIn
    driver.get("https://www.linkedin.com/login");
    }
    @Test
    public void testNavigateToLinkedIn() {
        // TODO: Navigate to LinkedIn
//    driver.get("https://www.linkedin.com/");
    }
    @Test
    public void testLoginElements() {
    // TODO: Locate email field using By.id
          By emailField = By.id("username") ;
    // TODO: Locate password field using By.name
          By passwordField = By.id("password") ;
    // TODO: Locate sign-in button using By.xpath
           By signInButton = By.xpath("//button[@type='submit']") ;
    // TODO: Enter test credentials
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
        WebElement passwordElement =   driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    // TODO: Verify elements are displayed

        Assertions.assertTrue(emailElement.isDisplayed());
        Assertions.assertTrue(passwordElement.isDisplayed());
        driver.findElement(signInButton).click();

    }
    @AfterAll
    public static void tearDown() {
// TODO: Close driver
        driver.quit();
    }

}