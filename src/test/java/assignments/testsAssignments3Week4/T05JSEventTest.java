package assignments.testsAssignments3Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T05JSEventTest extends TestBase {
    /*
    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    Click all the buttons and verify they are all clicked
    */

    @Test
    public void T05JSEventTest() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        By onBlur = By.id("onblur");
        By onClick = By.id("onclick");
        By onContext = By.id("oncontextmenu");
        By onDoubleClick = By.id("ondoubleclick");
        By onFocus = By.id("onfocus");
        By onKeyDown = By.id("onkeydown");
        By onKeyUp = By.id("onkeyup");
        By onKeyPress = By.id("onkeypress");
        By onMouseOver = By.id("onmouseover");
        By onMouseLeave = By.id("onmouseleave");
        By onMouseDown = By.id("onmousedown");
        By Completed = By.className("challenge-completed-notification");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(onBlur)).click().moveByOffset(150,150).click().perform();
        actions.moveToElement(driver.findElement(onClick)).click().perform();
        actions.moveToElement(driver.findElement(onContext)).contextClick().perform();
        actions.moveToElement(driver.findElement(onDoubleClick)).doubleClick().perform();
        actions.moveToElement(driver.findElement(onFocus)).click().perform();
        actions.moveToElement(driver.findElement(onKeyDown)).click().keyDown(Keys.SPACE).click().perform();
        actions.moveToElement(driver.findElement(onKeyUp)).click().keyUp(Keys.SPACE).click().perform();
        actions.moveToElement(driver.findElement(onKeyPress)).click().sendKeys(Keys.SPACE).click().perform();
        actions.moveToElement(driver.findElement(onMouseOver)).perform();
        actions.moveToElement(driver.findElement(onMouseLeave)).moveToElement(driver.findElement(onMouseDown)).perform();
        actions.moveToElement(driver.findElement(onMouseDown)).click().perform();

        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(Completed).isDisplayed());

    }

}