package assignments.testsAssignments2Week3.ClassTasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T07MultiSelectOperations {
    /*
    Launch browser
    open https://demoqa.com/select-menu
    Select Standard Multi-Select using element id
    Verify element is multi-select
    Select 'Opel' using index, then deselect using index
    Select 'Saab' using value, then deselect using value
    Deselect all options
    Close browser
    */

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By multiSelectById = By.id("cars");

    @Test
    void multiSelect() {
        Select select = new Select(driver.findElement(multiSelectById));
        boolean isMultiSelect = select.isMultiple();
        Assertions.assertTrue(isMultiSelect);
        select.selectByIndex(2); // Opel
        Assertions.assertEquals("Opel", select.getFirstSelectedOption().getText());
        select.deselectByIndex(2);
        select.selectByValue("saab"); // Saab
        Assertions.assertEquals("Saab", select.getFirstSelectedOption().getText());
        select.deselectByValue("saab");
        select.deselectAll();
    }



    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}