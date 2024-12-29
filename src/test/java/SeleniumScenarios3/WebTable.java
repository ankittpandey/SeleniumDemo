package SeleniumScenarios3;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.chrono.ThaiBuddhistEra;
import java.util.List;

public class WebTable {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://money.rediff.com/");

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void WebTableOperation() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), "BSE: 78,699.07 | NSE: 23,813.40 - Live Stock Market | BSE NSE Share Prices | Mutual Fund India | Stock Market: Stock Market Today | Share Market Today - Rediff MoneyWiz");

        WebElement MoreNSEIndices=driver.findElement(By.linkText("More NSE Indices"));
        Actions actions = new Actions(driver);
        actions.moveToElement(MoreNSEIndices).click().perform();
        WebElement ShowMore=driver.findElement(By.id("showMoreLess"));
        ShowMore.click();

        //Total Number of Rows
        List<WebElement> totalRows=driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
        System.out.println("Total Number of Rows: "+totalRows.size());

        //Total Number of column
        List<WebElement> totalColumns=driver.findElements(By.xpath("//table[@id='dataTable']/thead/tr/th"));
        System.out.println("Total Number of Columns: "+totalColumns.size());

        System.out.println("*****************Fifth Row Data***************");
        //Get Data of specific row
        List<WebElement> fifthRow=driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr[5]/td"));
        for(WebElement rowItem:fifthRow)
        {
            System.out.println(rowItem.getText());
        }
        System.out.println("*****************First Column Data***************");
        //Get Data of Column
        List<WebElement> firstColumn=driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr/td[1]"));
        for(WebElement columnItem:firstColumn)
        {
            System.out.println(columnItem.getText());
        }
        System.out.println("*****************Complete Data***************");
        //Get the CompleteData
        List<WebElement> allrows=driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
        for(WebElement row:allrows)
        {
            System.out.println(row.getText());
        }

        System.out.println("*****************Data From Specific Cell***************");
        String cellValue= driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[5]/td[3]")).getText();
        System.out.println(cellValue);


    }
}
