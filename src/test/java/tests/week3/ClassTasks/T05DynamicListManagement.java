package tests.week3.ClassTasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public class T05DynamicListManagement {
    /*
    Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
    Uses Faker to generate 5 random task names
    Adds all tasks to the todo list
    Marks every other task as completed (strikethrough)
    Deletes all completed tasks
    Verifies only incomplete tasks remain
     */
    String url = "http://webdriveruniversity.com/To-Do-List/index.html";
    WebDriver driver;

    @Test
    void dynamicListManagementTest() {
        // Initialize Faker for generating random task names
        Faker faker = new Faker();

        // Locate the task input field
        By taskInputLocator = By.xpath("//input[@type='text']");

        // Find the task input element
        WebElement taskInput = driver.findElement(taskInputLocator);

        // List to store generated task names
        List<String> taskName = new ArrayList<>();
        // Generate and add 5 random tasks
        for (int i = 0; i < 5; i++) {
             taskName.add(faker.lorem().word());
            taskInput.sendKeys(taskName.get(i));
            taskInput.sendKeys(Keys.ENTER);
        }

        // Locate all tasks in the list
        By allTasksLocator = By.xpath("//li");
        // Mark every other task as completed
        List<WebElement> getOtherTask = driver.findElements(allTasksLocator);
        for (WebElement webElement : getOtherTask) {
            if (!taskName.contains(webElement.getText())) {
                webElement.click();
            }
        }

        // Delete all completed tasks
        By completedTasksLocator = By.xpath("//li[@class='completed']");
        List<WebElement> completedTasks = driver.findElements(completedTasksLocator);
        for (WebElement completedTask : completedTasks) {
            completedTask.click();
            By deleteButtonLocator = By.xpath("//i[@class='fa fa-trash']");
            driver.findElement(deleteButtonLocator).click();
        }

        // Verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(allTasksLocator);
        for (WebElement remainingTask : remainingTasks) {
            Assertions.assertFalse(remainingTask.getAttribute("class").contains("completed"));
        }
        System.out.println("Test passed");
    }

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}