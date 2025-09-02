package assignments;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T02Assignment {
    public static void main(String[] args) {

        //Invoke Firefox Driver
        WebDriver driver = new FirefoxDriver();

        //Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        //Verify the page title contains the word video
        String title = driver.getTitle();
        if (title.contains("video")) {
            System.out.println("Title contains 'video'. Test Passed!");
        } else {
            System.out.println("Title does not contain 'video'. Test Failed!");
            System.out.println("Actual Title: " + title);
        }
        //Close the driver
        driver.quit();
    }
}