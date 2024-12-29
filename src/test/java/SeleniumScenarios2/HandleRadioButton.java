package SeleniumScenarios2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandleRadioButton {
    public WebDriver driver = null;
    ChromeOptions cp = null;

    @BeforeMethod
    public void setup() {
        cp = new ChromeOptions();
        cp.setAcceptInsecureCerts(true);
//        cp.addArguments("--headless");
//        cp.addArguments("--disable-gpu");
//        cp.addArguments("--no-sandbox");
        driver = new ChromeDriver(cp);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://www.facebook.com/");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void handleRadioButton() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(),"Log in to Facebook");
        driver.findElement(By.linkText("Sign up for Facebook")).click();
        Assert.assertEquals(driver.getTitle(),"Sign up for Facebook");
        List<WebElement> allRadioBtn = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement radioBtn: allRadioBtn)
        {
            System.out.println("Is Radio Button Selected "+radioBtn.isSelected());
        }
        allRadioBtn.get(1).click();
        for (WebElement radioBtn: allRadioBtn)
        {
            System.out.println("Is Radio Button Selected "+radioBtn.isSelected());
        }

    }

}
