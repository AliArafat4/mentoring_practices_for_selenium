package tests.week2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06JunitTets02 {

    /* Go to google homepage
    Do the following tasks by creating 3 different test methods.
    Print "Tests are starting to run" before each test() method
    Print "Tests have finished running" after each test() method
    Test if the title is the same when the page window is maximize and minimize
    Test if the title does not contain "Video" when the page window is fullscreen
    Test if the URL contains "google"
    */

    WebDriver driver;
    String url = "https://www.google.com";

    @Test
    void Test01(){
        String titleMax;
        String titleMin;
        driver.navigate().to(url);
        driver.manage().window().maximize();
        titleMax = driver.getTitle();
        driver.manage().window().minimize();
        titleMin = driver.getTitle();
        Assertions.assertEquals(titleMax, titleMin);

    }
    @Test
    void Test02(){
        driver.manage().window().fullscreen();
        String titleFull = driver.getTitle();
        Assertions.assertFalse(titleFull.contains("Video"));

    }
    @Test
    void Test03(){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("google"));

    }

    @BeforeEach
    void start() {
        driver = new ChromeDriver();
        System.out.println("Tests are starting to run");
        driver.navigate().to(url);
    }

    @AfterEach
    void finish() {
        driver.quit();
        System.out.println("Tests have finished running");
    }

}