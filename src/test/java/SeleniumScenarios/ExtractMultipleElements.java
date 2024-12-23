package SeleniumScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExtractMultipleElements {
    public WebDriver driver = null;
    ChromeOptions cp=null;
    @BeforeMethod
    public void setup(){
        cp=new ChromeOptions();
//        cp.addArguments("--headless");
//        cp.addArguments("--disable-gpu");
//        cp.addArguments("--no-sandbox");
        driver=new ChromeDriver(cp);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://edition.cnn.com/");
    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }
    @Test
    public void findNumberOfLinkPresent(){

        //Total no of Link
        List<WebElement> allElement= driver.findElements(By.tagName("a"));
        System.out.println("Number of Links "+allElement.size());

        //Extract text and URL of the Specific link - 6
        WebElement sixthLink= allElement.get(6);
        System.out.println("Text of 6th Element "+sixthLink.getText());
        System.out.println("URL of 6th Element "+sixthLink.getDomAttribute("href"));

        System.out.println("***************************");
        int counter=1;
        for(WebElement element : allElement)
        {
            if(element.isDisplayed()) {
                System.out.println(counter + " Link Text is " + element.getText() + "** Link URL is " + element.getDomAttribute("href"));
                counter++;
            }
        }
    }
}
