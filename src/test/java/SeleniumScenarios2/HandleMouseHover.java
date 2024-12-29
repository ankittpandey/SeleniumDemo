package SeleniumScenarios2;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HandleMouseHover {
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
        driver.get("https://www.americangolf.eu/");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void HandleMouseHoverTest() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "American Golf · Europe's Largest Golf Retailer · Online & Instore");
        List<WebElement> menu=driver.findElements(By.xpath("//*[@class='a-level-1']"));
/*        int counter=0;
        for(WebElement ele:menu)
        {
            System.out.println("Counter "+counter+" Element "+ele.getText());
            counter++;
        }*/
        WebElement btnAccept= driver.findElement(By.xpath("//button[@data-tid='banner-accept']"));
        if(btnAccept.isDisplayed())
        {
            btnAccept.click();
            //Thread.sleep(2000);
        }
         WebElement golfClub=menu.get(3);
         WebElement golfClothes=menu.get(4);
         Actions action=new Actions(driver);
         action.moveToElement(golfClub).build().perform();

         driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[4]/ul/li[1]/a")).click();
         Assert.assertEquals(driver.getTitle(),"TaylorMade Golf Clubs | TaylorMade Clubs | American Golf");



    }
}
