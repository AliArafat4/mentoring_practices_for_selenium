package assignments.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01Assignment {
    //Create a main method
    public static void main(String[] args) {

        //Create a chrome driver
        WebDriver driver = new ChromeDriver();

        //Open google home page: https://www.google.com/
        driver.navigate().to("https://www.google.com/");

        //Get title on page
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        //Get current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL " + currentUrl);

        //Close/Quit the browser
        driver.quit();

    }
}