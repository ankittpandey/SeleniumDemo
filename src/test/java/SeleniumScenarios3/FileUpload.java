package SeleniumScenarios3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {
    public WebDriver driver = null;
    ChromeOptions cp = null;

    @BeforeMethod
    public void setup() {
        cp = new ChromeOptions();
        cp.setAcceptInsecureCerts(true);
        //cp.addArguments("--headless");
        //cp.addArguments("--disable-gpu");
        //cp.addArguments("--no-sandbox");
        driver = new ChromeDriver(cp);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://the-internet.herokuapp.com/");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void HandleJSTest() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(),"The Internet");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        String fileName="C:\\Users\\2340824\\Downloads\\ExplicitWait.html";
        chooseFile.sendKeys(fileName);
        driver.findElement(By.id("file-submit")).click();
        String successMsg=driver.findElement(By.xpath("//div/h3")).getText();
        Assert.assertEquals(successMsg,"File Uploaded!");
        Thread.sleep(5000);
    }
}