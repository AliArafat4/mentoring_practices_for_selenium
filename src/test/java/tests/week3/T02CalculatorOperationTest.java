package tests.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class T02CalculatorOperationTest {
    /*
    Go to https://testpages.eviltester.com/styled/calculator
    Type any number in first and second input
    Click Calculate for each operation
    Get and verify results for all operations
     */
    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    By firstInput = By.id("number1");
    By secondInput = By.id("number2");
    By calculateButton = By.id("calculate");
    By result = By.id("answer");
    By functionDropdown = By.id("function");
    String[] operations = {"plus", "minus", "times", "divide"};
    int num1 = 7;
    int num2 = 2;

    @Test
    void calculatorTest() {
        for (String operation : operations) {
            // Type any number in first and second input
            driver.findElement(firstInput).clear();
            driver.findElement(firstInput).sendKeys(num1 + "");
            driver.findElement(secondInput).clear();
            driver.findElement(secondInput).sendKeys(num2 + "");

            // Select operation from dropdown
            Select select = new Select(driver.findElement(functionDropdown));
            select.selectByVisibleText(operation);

            // Click Calculate
            driver.findElement(calculateButton).click();

            // Get and verify results for all operations
            String resultText = driver.findElement(result).getText();

            String expected = switch (operation) {
                case "plus" -> (num1 + num2) + "";
                case "minus" ->  (num1 - num2) + "";
                case "times" -> (num1 * num2) + "";
                case "divide" -> (num1 / Double.parseDouble(String.valueOf(num2))) + "";
                default -> "";
            };

            Assertions.assertEquals(expected, resultText);
            System.out.println("Operation: " + operation + ", Expected: " + expected + ", Actual: " + resultText);
        }
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