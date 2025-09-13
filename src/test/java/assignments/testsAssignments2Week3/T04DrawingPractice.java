package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T04DrawingPractice extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Draw.html
    Draw a triangle
    Reset
    */

    @Test
    public void t04DrawingPractice() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/Draw.html");
        By canvas = By.id("myCanvas");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(canvas), 0, 0)
                .clickAndHold()
                .moveByOffset(100, 0)
                .moveByOffset(-50, -85)
                .moveByOffset(-50, 85)
                .release()
                .perform();
        Thread.sleep(2000);

        By resetButton = By.id("resetButton");
        driver.findElement(resetButton).click();

    }
}