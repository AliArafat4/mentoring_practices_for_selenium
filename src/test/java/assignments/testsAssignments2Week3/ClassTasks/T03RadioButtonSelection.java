package assignments.testsAssignments2Week3.ClassTasks;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class T03RadioButtonSelection {
    /*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:

        Attempts to select each radio button (Yes, Impressive, No)
        Prints whether each option is enabled/disabled
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */
    String url = "https://demoqa.com/radio-button";
    WebDriver driver;

    @Test
    void radioButtonTest() {
        // Locate radio buttons by their labels
        By yesRadioButton = By.xpath("//label[@for='yesRadio']");
        By impressiveRadioButton = By.xpath("//label[@for='impressiveRadio']");
        By noRadioButton = By.id("noRadio");
        By selectedMessage = By.className("text-success");

        // Check if "Yes" radio button is enabled and select it
        WebElement yesButton = driver.findElement(yesRadioButton);
        System.out.println(yesButton.isEnabled());
        yesButton.click();
        Assertions.assertEquals("Yes", driver.findElement(selectedMessage).getText());
        // Print confirmation message
        System.out.println("Yes radio button selected successfully.");

        // Check if "Impressive" radio button is enabled and select it
        WebElement impressiveButton = driver.findElement(impressiveRadioButton);
        System.out.println(impressiveButton.isEnabled());
        impressiveButton.click();
        Assertions.assertEquals("Impressive", driver.findElement(selectedMessage).getText());
        // Print confirmation message
        System.out.println("Impressive radio button selected successfully.");

        // Check if "No" radio button is enabled and attempt to select it
        WebElement noButton = driver.findElement(noRadioButton);
        System.out.println(noButton.isEnabled());



    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}