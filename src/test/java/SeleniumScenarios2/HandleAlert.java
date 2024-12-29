package SeleniumScenarios2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class HandleAlert {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://www.rediff.com/");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void HandleAlertTest() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");
        driver.findElement(By.linkText("Sign in")).click();
        Assert.assertEquals(driver.getTitle(), "Rediffmail - Free Email for Login with Secure Access");
        driver.findElement(By.id("login1")).sendKeys("Ankit");
        driver.findElement(By.className("signinbtn")).click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Please enter your password");
        alert.accept();
        driver.findElement(By.id("login1")).clear();
        driver.findElement(By.className("signinbtn")).click();
        Alert alert1=driver.switchTo().alert();
        Assert.assertEquals(alert1.getText(),"Please enter a valid user name");
        alert1.accept();





    }
}
