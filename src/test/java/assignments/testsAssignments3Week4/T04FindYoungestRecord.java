package assignments.testsAssignments3Week4;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T04FindYoungestRecord extends TestBase {
     /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records using Faker.
    Find the name of the youngest record.
    */

    @Test
    public void T04FindYoungestRecord() throws IOException
    {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");


        WebElement nameElement = driver.findElement(By.id("nameInput"));
        WebElement ageElement = driver.findElement(By.id("ageInput"));
        Select select = new Select(driver.findElement(By.id("countrySelect")));
        WebElement submit = driver.findElement(By.xpath("//button[@onclick='addRecord()']"));

        for (int i=0;i<10;i++){
            nameElement.sendKeys(Faker.instance().name().firstName());
            ageElement.sendKeys(Faker.instance().number().numberBetween(5,50) + "");
            int idx = Faker.instance().number().numberBetween(1,5);
            select.selectByIndex(idx);
            submit.click();
        }

        List<WebElement> elementList =  driver.findElements(By.xpath("//table/tbody/tr"));
        String youngestName = "";
        int minAge = 1000;

        for (int i = 1; i <= elementList.size(); i++) {
          String name =  elementList.get(i-1).findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText();
          int age = Integer.parseInt(elementList.get(i-1).findElement(By.xpath("//table/tbody/tr[" + i +"]/td[2]")).getText());

          if(age < minAge){
              minAge = age;
              youngestName = name;
          }

        }
        System.out.println("Youngest name is: " + youngestName + ", of age = " + minAge);


    }



}