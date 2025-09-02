package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


public class C03PageTitle {

    /*
    TC – 03


    // Expected Title
    // Set Path of the Chrome driver
    // Launch Chrome browser
    // Open URL of Website
    // Maximize Window
    // Get Title of current Page
    // Validate/Compare Page Title
    // Close Browser
*/

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String expectedTitle = "Google";
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is matching. Test Passed!");
        } else {
            System.out.println("Title is not matching. Test Failed!");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }

        driver.quit();
    }


}