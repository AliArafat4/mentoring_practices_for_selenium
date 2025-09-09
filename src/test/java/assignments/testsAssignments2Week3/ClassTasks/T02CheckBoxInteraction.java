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

public class T02CheckBoxInteraction {

    /*
    Go to "https://the-internet.herokuapp.com/checkboxes". Write a method that:
    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console
     */
    String url = "https://the-internet.herokuapp.com/checkboxes";
    WebDriver driver;
    By checkBox1 = By.xpath("(//input[@type='checkbox'])[1]");
    By checkBox2 = By.xpath("(//input[@type='checkbox'])[2]");

    @Test
    void checkBoxTest() {
        WebElement checkBox1Element = driver.findElement(checkBox1);
        WebElement checkBox2Element = driver.findElement(checkBox2);
        // Check the current state of both checkboxes
        boolean checkBox1Value = checkBox1Element.isSelected();
        boolean checkBox2Value = checkBox2Element.isSelected();
        System.out.println("Checkbox 1 is selected: " + checkBox1Value);
        System.out.println("Checkbox 2 is selected: " + checkBox2Value);
        if(!checkBox1Value){
            checkBox1Element.click();
        }
        if(!checkBox2Value){
            checkBox2Element.click();
        }
        // Verify both checkboxes are checked after the operations
        checkBox1Value = checkBox1Element.isSelected();
        checkBox2Value = checkBox2Element.isSelected();
        Assertions.assertTrue(checkBox1Value);
        Assertions.assertTrue(checkBox2Value);
        System.out.println("Checkbox 1 is selected after operation: " + checkBox1Element.isSelected());
        System.out.println("Checkbox 2 is selected after operation: " + checkBox2Element.isSelected());

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}