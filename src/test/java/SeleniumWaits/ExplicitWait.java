package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class ExplicitWait {
    public WebDriver driver = null;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("file:///C:/Users/2340824/Downloads/ExplicitWait.html");
    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }

    @Test
    public void verifyAlert(){
        WebElement alertBtn = driver.findElement(By.id("alert"));
        alertBtn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test
    public void verifyTextPresent(){
        WebElement txtBtn = driver.findElement(By.id("populate-text"));
        WebElement targetTxt = driver.findElement(By.className("target-text"));
        txtBtn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
        wait.until(ExpectedConditions.textToBePresentInElement(targetTxt,"Selenium Webdriver"));

    }
    @Test
    public void verifyBtnVisible(){
        WebElement Btn = driver.findElement(By.id("display-other-button"));
        WebElement clickBtn = driver.findElement(By.id("hidden"));
        Btn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(clickBtn));

    }

    @Test
    public void verifyBtnEnabled(){
        WebElement Btn = driver.findElement(By.id("enable-button"));
        WebElement enableBtn = driver.findElement(By.id("disable"));
        Btn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(enableBtn));
        enableBtn.click();
    }

    @Test
    public void verifyBtnSelected(){
        WebElement Btn = driver.findElement(By.id("checkbox"));
        WebElement checkbox = driver.findElement(By.id("ch"));
        Btn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));

    }


}
