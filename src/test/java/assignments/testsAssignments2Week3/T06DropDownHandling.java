package assignments.testsAssignments2Week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T06DropDownHandling extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Dropdowns.html
    In 1. Traditional Dropdown select 'Ford'
    In 2. Multi-Select Dropdown select 'Mercedes'
    In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
    In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
    In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
    */
    @Test
    public  void T06DropDownHandlingWithJSExecutor(){
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

        By traditionalDropdown = By.id("carSelect");
        By multiSelectDropdown = By.id("multiCarSelect");
        By customDropdown = By.id("customDropdown");
        By staticAutoSuggestDropdown = By.id("staticInput");
        By dynamicAutoSuggestDropdown = By.id("dynamicInput");

        Select select = new Select(driver.findElement(traditionalDropdown));
        select.selectByValue("Ford");

        Select select1 = new Select(driver.findElement(multiSelectDropdown));
        select1.selectByValue("Mercedes");

        driver.findElement(customDropdown).click();
        driver.findElement(By.xpath("//div[normalize-space()='BMW']")).click();

        driver.findElement(staticAutoSuggestDropdown).sendKeys("Tesla Model 3");
        driver.findElement(By.xpath("//div[@class='suggestion-item']")).click();

        driver.findElement(dynamicAutoSuggestDropdown).sendKeys("Toyota");
        driver.findElement(By.xpath("//div[@class='suggestion-item'][normalize-space()='Toyota']")).click();

    }
}