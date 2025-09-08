package tests.week3.ClassTasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class T01ChromeOptionsConfigurationTest {
    /*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */

    WebDriver driver;

    @Test
    void chromeOptionsTest() {
        String title = driver.getTitle();
        String expectedTitle = "Example Domain";
        Assertions.assertEquals(expectedTitle, title);

    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.example.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}