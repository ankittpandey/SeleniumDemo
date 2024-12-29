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

public class HandleJavaScriptExecutor {
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

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void HandleJSTest() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;

        //open Website
        js.executeScript("window.location='https://www.rediff.com/'");

        //Verify Title
        String pageTitle= (String) js.executeScript("return document.title");
        Assert.assertEquals(pageTitle,"Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");

        //Click Operation
        WebElement SignInBtn=driver.findElement(By.linkText("Sign in"));
        js.executeScript("arguments[0].click();",SignInBtn);

        //Perform Type
        WebElement userInput=driver.findElement(By.id("login1"));
        js.executeScript("arguments[0].value='ankit@gmail.com';",userInput);
        Thread.sleep(5000);

        //Scroll
        js.executeScript("window.scrollBy(0,1000)");

        //Scroll to Element
        WebElement termUse=driver.findElement(By.linkText("Terms of use"));
        js.executeScript("arguments[0].scrollIntoView(true)",termUse);



    }
}
