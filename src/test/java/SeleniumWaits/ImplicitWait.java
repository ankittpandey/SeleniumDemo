package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWait {
    public WebDriver driver = null;
    ChromeOptions cp=null;
    @Test
    public void implicitwait(){
        cp=new ChromeOptions();
        cp.addArguments("--headless");
        cp.addArguments("--disable-gpu");
        cp.addArguments("--no-sandbox");
        driver=new ChromeDriver(cp);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://google.com/");
        WebElement searchBox= driver.findElement(By.xpath(
                "//textarea[@title='Search' and @role='combobox']"));
        searchBox.sendKeys("Selenium Webdriver");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@role='presentation'])[3]")));
        WebElement searchResult= driver.findElement(By.xpath(
                "(//li[@role='presentation'])[3]"));
        searchResult.click();

        driver.quit();

    }
}
