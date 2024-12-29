package SeleniumScenarios2;

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
import java.util.Iterator;
import java.util.Set;

public class HandleMultipleTabs {
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
    public void MultipleWindowHandle() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "Log in to Facebook");
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("dummy@gmail.com");

        driver.findElement(By.linkText("Meta Pay")).click();
        Thread.sleep(3000);
        Set<String> AllWindowId = driver.getWindowHandles();
        Iterator<String> itr=AllWindowId.iterator();
        String HomePageID =itr.next();
        String MetaPageID =itr.next();

        driver.switchTo().window(MetaPageID);
        Assert.assertEquals(driver.getTitle(), "Meta Pay | Meta");
        driver.findElement(By.xpath("//p[text()='Meta Pay is an easy, secure way to pay on the apps you already use.']")).getText();
        driver.close();
        Thread.sleep(3000);

        driver.switchTo().window(HomePageID);
        Assert.assertEquals(driver.getTitle(), "Log in to Facebook");
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("dummy1@gmail.com");
        Thread.sleep(3000);


    }
   }
