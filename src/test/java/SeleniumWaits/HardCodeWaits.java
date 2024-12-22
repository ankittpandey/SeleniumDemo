package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardCodeWaits {

    @Test
    public void googleSearch() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        WebElement searchBox= driver.findElement(By.xpath(
                "//textarea[@title='Search' and @role='combobox']"));
        searchBox.sendKeys("Selenium Webdriver");
        Thread.sleep(3000);

        WebElement searchResult= driver.findElement(By.xpath(
                "(//li[@role='presentation'])[3]"));
        searchResult.click();
        Thread.sleep(3000);

        driver.quit();

    }
}
