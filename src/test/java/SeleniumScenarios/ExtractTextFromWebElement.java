package SeleniumScenarios;

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

public class ExtractTextFromWebElement {
    public WebDriver driver = null;
    ChromeOptions cp=null;
    @BeforeMethod
    public void setup(){
        cp=new ChromeOptions();
//        cp.addArguments("--headless");
//        cp.addArguments("--disable-gpu");
//        cp.addArguments("--no-sandbox");
        driver=new ChromeDriver(cp);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.facebook.com/");
    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }
    @Test
    public void ExtractText(){
        WebElement linkText= driver.findElement(By.xpath("//*[@id='login_link']/a[1]"));
        Assert.assertEquals(linkText.getText(),"Forgotten account?");

        WebElement placeHolderText=driver.findElement(By.id("email"));
        Assert.assertEquals(placeHolderText.getDomAttribute("aria-label"),"Email address or phone number");
    }

}
