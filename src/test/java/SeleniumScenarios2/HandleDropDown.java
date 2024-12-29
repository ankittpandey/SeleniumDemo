package SeleniumScenarios2;

import SeleniumIntro.SeleniumFirstDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandleDropDown {
    public WebDriver driver = null;
    ChromeOptions cp=null;
    @BeforeMethod
    public void setup(){
        cp=new ChromeOptions();
        cp.setAcceptInsecureCerts(true);
//        cp.addArguments("--headless");
//        cp.addArguments("--disable-gpu");
//        cp.addArguments("--no-sandbox");
        driver=new ChromeDriver(cp);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://www.facebook.com/");

    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }
    @Test
    public void handleDropDown() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(),"Log in to Facebook");
        driver.findElement(By.linkText("Sign up for Facebook")).click();
        Assert.assertEquals(driver.getTitle(),"Sign up for Facebook");

        //Month DropDown
        WebElement monthDropDown=driver.findElement(By.id("month"));
        Select selectmonth=new Select(monthDropDown);
        selectmonth.selectByIndex(1);
        Thread.sleep(5000);
        selectmonth.selectByValue("5");
        Thread.sleep(5000);
        selectmonth.selectByVisibleText("Aug");
        Thread.sleep(5000);

        List<WebElement> monthOptions= selectmonth.getOptions();
        for (WebElement month: monthOptions)
        {

            month.click();
            System.out.println("Months "+month.getText());
            Thread.sleep(2000);
        }
    }

}
