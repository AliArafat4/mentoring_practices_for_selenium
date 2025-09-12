package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T10IFrameEmojiAssignment extends TestBase {
    /*
    Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    1. Maximize the website
    2. Click on the second emoji
    3. Click on all second emoji items
    4. Return to the parent iframe
    5. Fill out the form and press the apply button
    */

    @Test
    public void T10IFrameEmojiAssignment() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //Switch to the iframe that contains the emojis
        driver.switchTo().frame("emoojis");

        //Get the second emoji tab location
        By secondEmojiTab = By.xpath("/html[1]/body[1]/div[1]/div[1]/a[2]/span[2]");

        //explicit wait for the second emoji tab to be clickable
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(secondEmojiTab));
        tab.click();

        //Click on all second emoji items
        By allSecondEmojiItems = By.xpath("//div[@id='nature']//img[@class='emoji']");
        driver.findElements(allSecondEmojiItems).forEach(t -> t.click());

        //Return to the parent iframe
        driver.switchTo().defaultContent();
        //Fill out the form and press the apply button
        By textField = By.id("text");
        driver.findElement(textField).sendKeys("Hello");
        By textField2 = By.id("smiles");
        driver.findElement(textField2).sendKeys("This");
        By textField3 = By.id("nature");
        driver.findElement(textField3).sendKeys("is");
        By textField4 = By.id("food");
        driver.findElement(textField4).sendKeys("my");
        By textField5 = By.id("activities");
        driver.findElement(textField5).sendKeys("Test");
        By textField6 = By.id("places");
        driver.findElement(textField6).sendKeys("Case");
        By textField7 = By.id("objects");
        driver.findElement(textField7).sendKeys("for");
        By textField8 = By.id("symbols");
        driver.findElement(textField8).sendKeys("IFrame");
        By textField9 = By.id("flags");
        driver.findElement(textField9).sendKeys("Emojis");
        By textField10 = By.id("hide");
        driver.findElement(textField10).sendKeys("Assignment");
        By textField11 = By.id("active");
        driver.findElement(textField11).sendKeys("Done");
        By applyButton = By.id("send");
        driver.findElement(applyButton).click();
    }
}