package assignments.testsAssignments1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02TestAssignment {

    /*
        Task 2: Page Source Validation
        Setup:
        Use @BeforeEach to open Chrome and maximize.
        Test 1:
        Navigate to https://www.selenium.dev/.
        Verify that the page source contains the word "WebDriver".
        Test 2:
        Navigate to https://www.python.org/.
        Assert the page source contains "Python".
        Teardown:
        Close the browser with @AfterEach.

     */
    WebDriver driver;
    String googleUrl = "https://www.google.com/";

    @Test
    void SeleniumPageSourceTest(){
        driver.navigate().to("https://www.selenium.dev/");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("WebDriver"));
    }

    @Test
    void PythonPageSourceTest(){
        driver.navigate().to("https://www.python.org/");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Python"));
    }

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(googleUrl);
    }
    @AfterEach
    void teardown(){
        driver.quit();
    }
}