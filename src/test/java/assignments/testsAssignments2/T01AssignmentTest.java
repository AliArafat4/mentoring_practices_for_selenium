package assignments.testsAssignments2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class T01AssignmentTest {
    String   url = "https://testpages.herokuapp.com/styled/index.html";
    WebDriver driver;
// TODO: Navigate to test pages
// TODO: Click on "Locators - Find By Playground Test Page"
// TODO: Print current URL
// TODO: Navigate back
// TODO: Print URL after going back
// TODO: Click on "WebDriver Example Page"
// TODO: Print current URL
// TODO: Enter value 20 in number input
// TODO: Verify 'two, zero' message appears

    @Test
    void navigateTest(){
        // find "Locators - Find By Playground Test Page" by id and click it
        By locatorsById = By.id("findbytest");
        WebElement locatorsElement = driver.findElement(locatorsById);
        locatorsElement.click();

        // print current URL
        System.out.println("Current URL after clicking Locators link: " + driver.getCurrentUrl());

        // navigate back
        driver.navigate().back();
        System.out.println("Current URL after navigating back: " + driver.getCurrentUrl());

        // find "WebDriver Example Page" by id and click it
        By webdriverLink = By.id("webdriverexamplepage");
        WebElement webdriverElement = driver.findElement(webdriverLink);
        webdriverElement.click();
        System.out.println("Current URL after clicking WebDriver Example link: " + driver.getCurrentUrl());

        // find number input by xpath and enter value 20 and press enter
        By numberInputXPath =  By.xpath("//input[@id='numentry']");
        WebElement numberInputElement = driver.findElement(numberInputXPath);
        numberInputElement.sendKeys("20", Keys.ENTER);

        // find result message by xpath and verify it contains 'two, zero'
        By resultMessage = By.xpath("//P[@id='message']");
        WebElement resultMessageElement = driver.findElement(resultMessage);
        String expectedMessage = "two, zero";
        Assertions.assertTrue(expectedMessage.contains(resultMessageElement.getText()));
        System.out.println("Test passed");

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
         driver.quit();
    }
}