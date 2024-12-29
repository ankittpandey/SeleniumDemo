package SeleniumScenarios2;

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

public class DragandDrop {
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
        driver.get("https://jqueryui.com/");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void DragandDropTestByPixel() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        driver.findElement(By.linkText("Draggable")).click();
        Assert.assertEquals(driver.getTitle(), "Draggable | jQuery UI");
        WebElement frame=driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement dragable=driver.findElement(By.id("draggable"));
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(dragable,100,100).build().perform();
        Thread.sleep(5000);

    }
    @Test
    public void DragandDropTesttoElement() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        driver.findElement(By.linkText("Droppable")).click();
        Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
        WebElement frame=driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement draggable=driver.findElement(By.id("draggable"));
        WebElement droppable=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).build().perform();
        Thread.sleep(5000);

    }
    @Test
    public void DragandDropElementHard() throws IOException, InterruptedException {
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        driver.findElement(By.linkText("Droppable")).click();
        Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
        WebElement frame=driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement draggable=driver.findElement(By.id("draggable"));
        WebElement droppable=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        Thread.sleep(5000);

    }
}
