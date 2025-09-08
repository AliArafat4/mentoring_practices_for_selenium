package tests.week3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08GoogleSearchTest {
    static WebDriver driver;
    static  String url = "https://www.google.com";

    @BeforeAll
    public static void setUp() throws InterruptedException {
        // TODO: Initialize static WebDriver
        driver = new ChromeDriver();
        // TODO: Navigate to Google
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        Thread.sleep(2000);
    }

    @Test
    public void searchMovies() {
        String[] movies = {"Green Mile","Premonition","The Curious Case of Benjamin Button"};

        for(String movie : movies) {
        // TODO: Find search box
            By searchBoxLocator = By.xpath("//textarea[@class='gLFyf']");
            WebElement searchBox = driver.findElement(searchBoxLocator);
        // TODO: Clear and enter movie name
            searchBox.clear();
            searchBox.sendKeys(movie);
        // TODO: Submit search
            searchBox.submit();
        // TODO: Get and print result count
            By resultStatsLocator = By.id("result-stats");
            WebElement resultStats = driver.findElement(resultStatsLocator);
            System.out.println("Results for " + movie + ": " + resultStats.getText());
        // TODO: Clear search box for next iteration
            searchBox = driver.findElement(searchBoxLocator);
            searchBox.clear();
        }
    }
    @AfterAll
    public static void tearDown() {

// TODO: Close driver
        driver.quit();
    }
}