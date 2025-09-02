package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04Assignment {
    public static void main(String[] args) throws InterruptedException {
        //Open URL: https://www.google.come/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");

        //Maximize the window
        driver.manage().window().maximize();

        //print the position and size of the page
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        //Minimize the window
        driver.manage().window().minimize();

        //Wait for 5 seconds in the icon state and maximize the page

        Thread.sleep(5000);
        driver.manage().window().maximize();


        //print the position and dimension of the page in maximized state
        System.out.println("Position after maximizing: " + driver.manage().window().getPosition());
        System.out.println("Size after maximizing: " + driver.manage().window().getSize());

        //Make the page fullscreen
        driver.manage().window().fullscreen();

        //Close the browser
        driver.quit();
    }
}