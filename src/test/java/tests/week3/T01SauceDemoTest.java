package tests.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T01SauceDemoTest {
    /*
    Given: Go to https://www.saucedemo.com/
    When: Enter username as "standard user"

    And: Enter password as "secret sauce"

    And: Click login button
    And: Order products by "Price (low to high)"
    Then: Assert last product costs $49.99, first product costs $7.99
     */
    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password =  "secret_sauce";
    By usernameByid = By.id("user-name");
    By passwordByid = By.id("password");
    By loginButtonByid = By.id("login-button");
    By productSortContainerByClass = By.className("product_sort_container");

    @Test
    public void sauceDemoTest() {
        driver.findElement(usernameByid).sendKeys(username);
        driver.findElement(passwordByid).sendKeys(password);
        driver.findElement(loginButtonByid).click();
        driver.findElement(productSortContainerByClass).click();

        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByVisibleText("Price (low to high)");

        List<WebElement> pruductsPriceList = driver.findElements(By.xpath("(//div[@class='inventory_item_price'])"));

        Assertions.assertEquals("$7.99",pruductsPriceList.getFirst().getText());
        Assertions.assertEquals("$49.99",pruductsPriceList.getLast().getText());

    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}