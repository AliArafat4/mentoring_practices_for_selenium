package tests.week3;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class T04FakerTest {
        /*
        Task: Go to "https://demoqa.com/text-box"
            . Use Java Faker to:

            Generate and enter a fake full name
            Generate and enter a fake email address
            Generate and enter a fake current address
            Generate and enter a fake permanent address
            Submit the form and verify the output contains the entered data
        */
        WebDriver driver;
        String url = "https://demoqa.com/text-box";

        @Test
        void fakerTest() {
            driver.get(url);
            Faker faker = new Faker();
            //Generate and enter a fake full name
            String fullName = faker.name().fullName();

            //Generate and enter a fake email address
            String email = faker.internet().emailAddress();

            //Generate and enter a fake current address
            String currentAddress = faker.address().streetAddress();

            //Generate and enter a fake permanent address
            String permanentAddress = faker.address().secondaryAddress();


            //Submit the form and verify the output contains the entered data
        }

        @BeforeEach
        void setUp() {
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

}