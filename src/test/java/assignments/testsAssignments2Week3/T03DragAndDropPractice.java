package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T03DragAndDropPractice extends TestBase {
    /*
    Go to https://claruswaysda.github.io/dragAndDrop.html
    Drag the items in their right places
    Assert the success message
    */

    @Test
    public void T03DragAndDropPractice() {
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");
        By box1 = By.id("piece1");
        By box2 = By.id("piece2");
        By box3 = By.id("piece3");
        By slot = By.id("slot1");
        By slot2 = By.id("slot2");
        By slot3 = By.id("slot3");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(box1), driver.findElement(slot)).perform();
        actions.dragAndDrop(driver.findElement(box2), driver.findElement(slot2)).perform();
        actions.dragAndDrop(driver.findElement(box3), driver.findElement(slot3)).perform();

        By successMessage = By.id("celebrate");
        Assertions.assertTrue(driver.findElement(successMessage).isDisplayed());


    }

}