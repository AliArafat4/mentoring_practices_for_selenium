package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Assertions;
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

public class T01WindowHandlePractice extends TestBase {
    /*
    Go to https://claruswaysda.github.io/
    Click on Window Handle
    Click on 'Open Index Page'
    Verify the link 'https://claruswaysda.github.io/index.html'
    */

    @Test
    public void T01WindowHandlePractice() {
        driver.get("https://claruswaysda.github.io/");
        By windowHandleLink = By.xpath("//a[.='Window Handle']");
        driver.findElement(windowHandleLink).click();

        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        By openIndexPageLink = By.xpath("//a[.='Open Index Page']");
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(openIndexPageLink));
        button.click();

        String indexPageHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle) && !handle.equals(indexPageHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://claruswaysda.github.io/index.html",actualUrl);


    }
}