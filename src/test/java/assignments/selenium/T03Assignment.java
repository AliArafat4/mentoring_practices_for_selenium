package assignments.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03Assignment {
    public static void main(String[] args) {

        //Go to the Amazon URL : https://www.amazon.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");

        //Print the position and size of the page.
        System.out.println("Initial Position: " + driver.manage().window().getPosition());
        System.out.println("Initial Size: " + driver.manage().window().getSize());

        //Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(150, 150));
        driver.manage().window().setSize(new Dimension(1080, 720));

        //Test that the page is in the position and size you want.
        if(driver.manage().window().getPosition().equals(new Point(150, 150)) &&
           driver.manage().window().getSize().equals(new Dimension(1080, 720))) {
            System.out.println("Position and Size adjusted successfully. Test Passed!");
        } else {
            System.out.println("Position and Size adjustment failed. Test Failed!");
        }

        //Close the page.
        driver.quit();
    }
}