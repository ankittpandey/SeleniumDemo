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

public class ExtractWebPagePart {
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
        driver.get("https://edition.cnn.com/");

    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }
    @Test
    public void ExtractElementTest(){

        WebElement moreTopStories=driver.findElement(By.xpath("//div[@class='container container_lead-plus-headlines  lazy'  and @data-collapsed-text='More top stories']"));
        Assert.assertTrue(moreTopStories.isDisplayed());
        System.out.println("Top Stories News state: "+moreTopStories.isDisplayed());

        List<WebElement> topStory = moreTopStories.findElements(By.tagName("a"));
        System.out.println("Total Top Stories "+topStory.size());

        for(WebElement story: topStory)
        {
            if(!story.getText().isEmpty()){
                System.out.println("Link Text- "+story.getText());
            }
        }

    }
}
