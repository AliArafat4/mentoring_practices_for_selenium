package tests.week2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C05JunitTests01 {

    /* Go to YouTube homepage
    Do the following tasks by creating 4 different test methods.
    Print "Test is running" before each test() method
    Print "Test finished" after each test() method
    Test if the currentURL contains "youtube"
    Test if the title does not contain "Video".
    Test if the URL contains "youtube".
    Test if the sourcePage contains "youtube".
    */

   static WebDriver driver ;
    @Test
    void urlTest01() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.youtube.com/", currentUrl);
    }

    @Test
    void titleTest01() {
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"));

    }

    @Test
    void urlTest02() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("youtube"));

    }
    @Test
    void pageSourceTest01() {
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("youtube"));

    }

    @BeforeAll
    static void start() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");
        System.out.println("Test is running");
    }
    @AfterAll
    static void finish() {
        driver.quit();
        System.out.println("Test finished");
    }
}