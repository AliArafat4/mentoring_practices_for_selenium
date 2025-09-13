package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T02ActionClassPractice extends TestBase {
    /*
    Go to https://claruswaysda.github.io/submit-button.html
    Click on submit
    Verify link contains 'actionsClickDrag'
    Drag 'Drag me' to 'Drop here'
    Right-click on 'Right-click' me
    Double-click on 'Double-click me'
    Hover on 'Hover over me'
    Verify all actions' success messages.
    */

    @Test
    public void T02ActionClassPractice() {
        driver.get("https://claruswaysda.github.io/submit-button.html");
        By submitButton = By.id("submitButton");
        driver.findElement(submitButton).click();

        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("actionsClickDrag"));

        By dragMe = By.id("drag1");
        By dropHere = By.id("drop1");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(dragMe), driver.findElement(dropHere)).perform();

        By rightClickMe = By.id("showSuccessButton");
        actions.contextClick(driver.findElement(rightClickMe)).perform();

        By doubleClickMe = By.id("doubleClickButton");
        actions.doubleClick(driver.findElement(doubleClickMe)).perform();

        By hoverOverMe = By.id("hoverButton");
        actions.moveToElement(driver.findElement(hoverOverMe)).perform();

        By dragSuccessMessage = By.id("dragSuccessMessage");
        By rightClickSuccessMessage = By.id("rightClickSuccessMessage");
        By doubleClickSuccessMessage = By.id("doubleClickSuccessMessage");
        By hoverSuccessMessage = By.id("hoverSuccessMessage");
        Assertions.assertTrue(driver.findElement(dragSuccessMessage).isDisplayed());
        Assertions.assertTrue(driver.findElement(rightClickSuccessMessage).isDisplayed());
        Assertions.assertTrue(driver.findElement(doubleClickSuccessMessage).isDisplayed());
        Assertions.assertTrue(driver.findElement(hoverSuccessMessage).isDisplayed());

    }
}