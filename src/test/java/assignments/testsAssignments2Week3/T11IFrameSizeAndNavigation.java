package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T11IFrameSizeAndNavigation extends TestBase {
 /*
 Go to URL: http://demo.guru99.com/test/guru99home/
 1. Find the number of iframes on the page
 2. Switch to the third iframe (JMeter Made Easy)
 3. Click the link (https://www.guru99.com/live-selenium-project.html)
 4. Exit the iframe and return to the main page
 */
    @Test
    public void T11IFrameSizeAndNavigation() {
        driver.get("http://demo.guru99.com/test/guru99home/");

        int numberOfIFrames = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iframes on the page: " + numberOfIFrames);
        //Switch to the third iframe (JMeter Made Easy)
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
        //Exit the iframe and return to the main page
        driver.switchTo().defaultContent();

    }
}