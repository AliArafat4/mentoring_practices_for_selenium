package assignments.testsAssignments1Week2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01TestAssignment {

    /*
    Task 1: Browser History Exploration
    Setup:
    Use @BeforeEach to launch Chrome and maximize.
    Test 1:
    Navigate to https://www.wikipedia.org/.
    Navigate to https://www.google.com/.
    Navigate back and forward multiple times, asserting the correct title at each step.
    Test 2:
    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
    Teardown:
    Use @AfterEach to close the browser.
        */

    WebDriver driver;
    String wikiUrl = "https://www.wikipedia.org/";
    String googleUrl = "https://www.google.com/";

    @Test
    void ForwardBackTest(){
        driver.navigate().to(wikiUrl);
        driver.navigate().to(googleUrl);

        driver.navigate().back();
        String wikiTitle = driver.getTitle();
        Assertions.assertEquals("Wikipedia", wikiTitle);
        driver.navigate().forward();
        String googleTitle = driver.getTitle();
        Assertions.assertEquals("Google", googleTitle);
        driver.navigate().back();
        wikiTitle = driver.getTitle();
        Assertions.assertEquals("Wikipedia", wikiTitle);
        driver.navigate().forward();
        googleTitle = driver.getTitle();
        Assertions.assertEquals("Google", googleTitle);
    }

    @Test
    void RefreshTest(){
        driver.navigate().refresh();
        String googleTitle = driver.getTitle();
        Assertions.assertTrue(googleTitle.contains("Google"));
    }

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to(googleUrl);
        driver.manage().window().maximize();

    }
    @AfterEach
    void teardown(){
        driver.quit();
    }

}