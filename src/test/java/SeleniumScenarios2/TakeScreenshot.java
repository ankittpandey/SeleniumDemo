package SeleniumScenarios2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v129.page.model.Screenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TakeScreenshot {
    public WebDriver driver = null;
    ChromeOptions cp = null;

    @BeforeMethod
    public void setup() {
        cp = new ChromeOptions();
        cp.setAcceptInsecureCerts(true);
        cp.addArguments("--headless");
        cp.addArguments("--disable-gpu");
        cp.addArguments("--no-sandbox");
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
    public void TakeScreenShotOfPage() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "Log in to Facebook");

        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("dummy@gmail.com");
        takeScreenShot();

        driver.findElement(By.linkText("Privacy Centre")).click();
        Assert.assertEquals(driver.getTitle(), "Meta | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy");

        Thread.sleep(1000);
        WebElement sideBar=driver.findElement(By.xpath("//aside"));
        takeScreenShotSpecificArea(sideBar);

        Thread.sleep(1000);
        WebElement checkUpTab=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/a/div[1]"));
        takeScreenShotSpecificArea(checkUpTab);


    }


    //Visible Page ScreenShot
    public void takeScreenShot() throws IOException {

        String filePath= System.getProperty("user.dir")+"/Screenshot/"+generateFileName();
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(filePath));
    }

    //Generate File Name For ScreenShot
    public String generateFileName(){
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String date=dateFormat.format(new Date());
        return date+".png";
    }

    //Partial ScreenShot
    public void takeScreenShotSpecificArea(WebElement element) throws IOException {

        String filePath= System.getProperty("user.dir")+"/Screenshot/"+generateFileName();
        File screenShotFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(filePath));

    }

}
