package assignments.testsAssignments2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T02AssignmentTest {
    // Navigate to: https://opensource-demo.orangehrmlive.com/
    String url = "https://opensource-demo.orangehrmlive.com/";

    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]"; // Fill absolute path

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//*[.='Username : Admin']"; // or "//p[.='Username : Admin']", Fill relative path

    // TODO: Locate password using both methods
    String absolutePasswordXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]"; // Fill absolute path
    String relativePasswordXPath = "//p[.='Password : admin123']"; // or "//*[.='Username : Admin']", Fill relative path

    // TODO: Locate login button using both methods
    String absoluteLoginButtonXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"; // Fill absolute path
    String relativeLoginButtonXPath = "//button[@type='submit']"; // Fill relative path

    WebDriver driver;

    By usernameByName = By.name("username");
    By passwordByName = By.name("password");
    WebElement usernameElementByName;
    WebElement passwordElementByName;
    String expectedUrlAfterLogin = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    // TODO: Test both approaches work

    @Test
    void relativeXpathTest() throws InterruptedException {
        // Locate elements using relative XPath
        By usernameByRelative = By.xpath(relativeUsernameXPath);
        By passwordByRelative = By.xpath(relativePasswordXPath);
        By loginButtonByRelative = By.xpath(relativeLoginButtonXPath);

        // Extract credentials
        WebElement usernameElement = driver.findElement(usernameByRelative);
        WebElement passwordElement = driver.findElement(passwordByRelative);
        WebElement loginButtonElement = driver.findElement(loginButtonByRelative);

        // Enter credentials and click login
        usernameElementByName.sendKeys(usernameElement.getText().split(":")[1].trim());
        passwordElementByName.sendKeys(passwordElement.getText().split(":")[1].trim());
        loginButtonElement.click();

        //Test that you logged in successfully by checking the URL
        Thread.sleep(2000);
        String actualUrlAfterLogin = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlAfterLogin ,actualUrlAfterLogin);
        System.out.println("Test passed");

    }

    @Test
    void absoluteXpathTest() throws InterruptedException {
        // Locate elements using absolute XPath
        By usernameByAbsolute = By.xpath(absoluteUsernameXPath);
        By passwordByAbsolute = By.xpath(absolutePasswordXPath);
        By loginButtonByAbsolute = By.xpath(absoluteLoginButtonXPath);

        // Extract credentials
        WebElement usernameElement = driver.findElement(usernameByAbsolute);
        WebElement passwordElement = driver.findElement(passwordByAbsolute);
        WebElement loginButtonElement = driver.findElement(loginButtonByAbsolute);

        // Enter credentials and click login
        usernameElementByName.sendKeys(usernameElement.getText().split(":")[1].trim());
        passwordElementByName.sendKeys(passwordElement.getText().split(":")[1].trim());
        loginButtonElement.click();

        //Test that you logged in successfully by checking the URL
        Thread.sleep(2000);
        String actualUrlAfterLogin = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlAfterLogin ,actualUrlAfterLogin);
        System.out.println("Test passed");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        usernameElementByName = driver.findElement(usernameByName);
        passwordElementByName = driver.findElement(passwordByName);
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}