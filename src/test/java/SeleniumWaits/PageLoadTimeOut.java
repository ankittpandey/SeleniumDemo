package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageLoadTimeOut {
    @Test
    public void pageLoadTest() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        driver.get("https://edition.cnn.com/");
        Assert.assertEquals(driver.getTitle(),"Breaking News, Latest News and Videos | CNN");
        driver.quit();

    }
}
