package SeleniumScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FindBrokenLinks {
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
        driver.get("https://www.google.com/");
    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }
    @Test
    public void findBrokenLinks() throws IOException {

        List<WebElement> allElement= driver.findElements(By.tagName("a"));
        System.out.println("Number of Links "+allElement.size());
        for(WebElement element : allElement) {
            String linkURL=element.getDomAttribute("href");
            VerifyLinkStatus.verifyLink(linkURL);
        }
        VerifyLinkStatus.getInvalidLinkCount();


    }
    }
