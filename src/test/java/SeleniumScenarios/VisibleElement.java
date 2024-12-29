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

public class VisibleElement {
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
        driver.get("https://jqueryui.com/");

    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }
    @Test
    public void verifyElementDisplayed() {
        Assert.assertEquals(driver.getTitle(),"jQuery UI");
        driver.findElement(By.linkText("Show")).click();
        Assert.assertEquals(driver.getTitle(),"Show | jQuery UI");

        WebElement frameName=driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frameName);

        WebElement elementVerify=driver.findElement(By.xpath("//div[@id='effect']/h3"));
        Assert.assertFalse(elementVerify.isDisplayed());
        System.out.println("Element initial state: "+elementVerify.isDisplayed());

        driver.findElement(By.xpath("//button[@id='button']")).click();
        Assert.assertTrue(elementVerify.isDisplayed());
        System.out.println("Element New state: "+elementVerify.isDisplayed());
    }

    @Test
    public void verifyElementEnabled() {
        Assert.assertEquals(driver.getTitle(),"jQuery UI");
        driver.findElement(By.linkText("Spinner")).click();
        Assert.assertEquals(driver.getTitle(),"Spinner | jQuery UI");

        WebElement frameName=driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frameName);

        WebElement TargetElement=driver.findElement(By.id("spinner"));
        WebElement disableBtn=driver.findElement(By.xpath("//button[@id='disable']"));
        Assert.assertTrue(TargetElement.isEnabled());
        System.out.println("Element initial state: "+TargetElement.isEnabled());

        disableBtn.click();
        Assert.assertFalse(TargetElement.isEnabled());
        System.out.println("Element state After 1st Click: "+TargetElement.isEnabled());

        disableBtn.click();
        Assert.assertTrue(TargetElement.isEnabled());
        System.out.println("Element state After 2st Click: "+TargetElement.isEnabled());

    }

}
