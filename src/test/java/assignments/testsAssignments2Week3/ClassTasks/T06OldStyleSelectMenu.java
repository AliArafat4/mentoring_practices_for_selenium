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

public class T06OldStyleSelectMenu {
    /*
    Launch browser
    Open https://demoqa.com/select-menu
    Select Old Style Select Menu using element id
    Print all dropdown options
    Select 'Purple' using index
    Select 'Magenta' using visible text
    Select an option using value
    Close browse
    */

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By oldStyleSelectMenu = By.id("oldSelectMenu");

    @Test
    void oldStyleSelectMenuTest(){
        Select oldStyleSelect = new Select(driver.findElement(oldStyleSelectMenu));
        for (int i = 0; i < oldStyleSelect.getOptions().size(); i++) {
            System.out.println(oldStyleSelect.getOptions().get(i).getText());
        }
        oldStyleSelect.selectByIndex(4); // Purple
        Assertions.assertEquals("Purple", oldStyleSelect.getFirstSelectedOption().getText());
        oldStyleSelect.selectByVisibleText("Magenta");
        Assertions.assertEquals("Magenta", oldStyleSelect.getFirstSelectedOption().getText());
        oldStyleSelect.selectByValue("3"); // Yellow
        Assertions.assertEquals("Yellow", oldStyleSelect.getFirstSelectedOption().getText());
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