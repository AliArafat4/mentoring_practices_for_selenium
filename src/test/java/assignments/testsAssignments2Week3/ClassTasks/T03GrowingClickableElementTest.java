package assignments.testsAssignments2Week3.ClassTasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class T03GrowingClickableElementTest {
    /*
    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    Click "click me" button
    Verify "Event Triggered" appears
     */

    String url = "https://testpages.herokuapp.com/styled/challenges/growing-clickable.html";
    WebDriver driver;;
    By waitButtonToGrow = By.xpath("//button[@class='styled-click-button showgrow grown']");
    By eventTriggeredMessage = By.id("growbuttonstatus");

    @Test
    void growingClickableElementTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(waitButtonToGrow)).click();
//        wait.until( t-> t.findElement(waitButtonToGrow)).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(eventTriggeredMessage));
        Assertions.assertEquals("Event Triggered",driver.findElement(eventTriggeredMessage).getText());


    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}