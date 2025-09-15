package assignments.testsAssignments3Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T04RobotClassNavigationFormSubmissionTest extends TestBase {
     /*
 * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
 * Click into the username field.
 * Type the username using sendKeys.
 * Use the Robot class to:
 * Press Tab → go to password field.
 * Type the password using sendKeys.
 * Press Enter → submit the form.
 * Verify login success or error message.
      */

    @Test
    public void submissionTest() throws AWTException, InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");
        By userNameField = By.xpath("//input[@id='username']");
        driver.findElement(userNameField).sendKeys("tomsmith");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);

        WebElement passwordField = driver.switchTo().activeElement();
        passwordField.sendKeys("SuperSecretPassword!");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(500);

        By msg = By.id("flash");

        Assertions.assertTrue(driver.findElement(msg).isDisplayed());

    }

}