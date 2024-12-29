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
import java.util.List;

public class HandleiFrame {
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
    public void handleFrame(){
        Assert.assertEquals(driver.getTitle(),"jQuery UI");
        driver.findElement(By.linkText("Checkboxradio")).click();
        Assert.assertEquals(driver.getTitle(),"Checkboxradio | jQuery UI");
        String PageTitle=driver.findElement(By.cssSelector(".entry-title")).getText();
        Assert.assertEquals(PageTitle,"Checkboxradio");


        WebElement frameName=driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frameName);
        List<WebElement> elementList= driver.findElements(By.xpath("//span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']"));
        elementList.get(1).click();

        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Button")).click();
        Assert.assertEquals(driver.getTitle(),"Button | jQuery UI");
    }

}
