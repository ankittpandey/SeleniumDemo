package SeleniumScenarios2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandleDropDownMultiple {
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
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void handleDropDown() throws InterruptedException {
        driver.switchTo().frame("iframeResult");
        WebElement carDropDown=driver.findElement(By.id("cars"));
        Select selectCar=new Select(carDropDown);


        //Verify Dropdown is Multi Select or not
        Assert.assertTrue(selectCar.isMultiple());

        selectCar.selectByValue("volvo");

        selectCar.selectByValue("opel");

        System.out.println("First Option: "+selectCar.getFirstSelectedOption().getText());
        //Verify Select Option
        List<WebElement> optionSelected = selectCar.getAllSelectedOptions();
        for(WebElement select: optionSelected)
        {
            System.out.println("Selected Option: "+select.getText());
        }
        Thread.sleep(2000);
        selectCar.deselectByVisibleText("Volvo");
        Thread.sleep(2000);





    }
}
