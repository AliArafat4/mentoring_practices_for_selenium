package tests.week1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04SizePosition {
    public static void main(String[] args) {

        /*
        TC - 04

    Go to the w3school URL : https://www.w3schools.com/
    Print the position and size of the page.
    Adjust the position and size of the page as desired.
    Test that the page is in the position and size you want.
    Close the page.
             */
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/");
        System.out.println("Initial Position: " + driver.manage().window().getPosition());
        System.out.println("Initial Size: " + driver.manage().window().getSize());
        driver.manage().window().setPosition(new Point(50, 50));
        driver.manage().window().setSize(new Dimension(600, 600));
        if(driver.manage().window().getPosition().equals(new Point(50, 50)) &&
           driver.manage().window().getSize().equals(new Dimension(600, 600))) {
            System.out.println("Position and Size adjusted successfully. Test Passed!");
        } else {
            System.out.println("Position and Size adjustment failed. Test Failed!");
        }
//        System.out.println("Adjusted Position: " + driver.manage().window().getPosition());
//        System.out.println("Adjusted Size: " + driver.manage().window().getSize());
        driver.quit();

    }
}