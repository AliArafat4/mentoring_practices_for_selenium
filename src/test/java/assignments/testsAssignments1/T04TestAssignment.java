package assignments.testsAssignments1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04TestAssignment {

    /*
    Task 4: Multiple Navigation and Verification
    Setup:
    Launch Chrome and maximize in @BeforeAll.
    Test 1:
    Navigate Google → YouTube → LinkedIn.
    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
    Test 2:
    Navigate back twice and assert the URL of Google.
    Navigate forward twice and assert URL of LinkedIn.
    Teardown:
    Use @AfterAll to quit the browser.

     */
    static WebDriver driver;
    String googleUrl = "https://www.google.com/";
    String youtubeUrl = "https://www.youtube.com/";
    String linkedinUrl = "https://www.linkedin.com/";

    @Test
    void ANavigationAndTitleTest(){
        driver.navigate().to(googleUrl);
        String googleTitle = driver.getTitle();
        Assertions.assertTrue(googleTitle.contains("Google"));

        driver.navigate().to(youtubeUrl);
        String youtubeTitle = driver.getTitle();
        Assertions.assertTrue(youtubeTitle.contains("YouTube"));

        driver.navigate().to(linkedinUrl);
        String linkedinTitle = driver.getTitle();
        Assertions.assertTrue(linkedinTitle.contains("LinkedIn"));

    }

    @Test
    void BackForwardAndUrlTest(){
        driver.navigate().back();
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(googleUrl, currentUrl);
        driver.navigate().forward();
        driver.navigate().forward();
        currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(linkedinUrl, currentUrl);

    }
    @BeforeAll
    static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown(){
        driver.quit();
    }
}