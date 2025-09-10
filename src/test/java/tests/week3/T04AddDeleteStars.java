package tests.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T04AddDeleteStars  extends TestBase {
    /*
    Go to https://claruswaysda.github.io/addDeleteStar.html
    Create a method to add given number of stars
    Create a method to delete given numbers of stars
    Create a method to verify the given number of stars deleted
     */

    By addButton = By.id("push-button");
    By deleteButton = By.id("delete-button");
    int addStarsNum = 10;
    int deleteStarsNum = 5;
    By stars = By.className("star");

    @Test
    void test04() {
        driver.get("https://claruswaysda.github.io/addDeleteStar.html");
        addStars(addStarsNum);
        deleteStars(deleteStarsNum);
        int remainingStars = driver.findElements(stars).size();
        Assertions.assertEquals(addStarsNum-deleteStarsNum,remainingStars, "Not all stars were deleted. Remaining stars: " + remainingStars);
    }
    void addStars(int numberOfStars){
        for(int i = 0 ; i < numberOfStars; i++){
            driver.findElement(addButton).click();
        }
    }
    void deleteStars(int numberOfStars){
        for(int i = 0 ; i < numberOfStars; i++){
            driver.findElement(deleteButton).click();
        }
    }

}