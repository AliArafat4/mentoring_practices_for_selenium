package tests.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T01DownloadTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on download
    Verify that 'QAProgram.png' file is downloaded
    */

    @Test
    public void T01DownloadTest() throws IOException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        By downloadButton = By.className("download-btn");
        driver.findElement(downloadButton).click();
        Thread.sleep(2000);

        Path filePath = Path.of(System.getProperty("user.home"),"Downloads","QAProgram.png");
        Assertions.assertTrue(Files.exists(filePath));
        Files.deleteIfExists(filePath);
    }

}