package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumFirstDemo {
    WebDriver driver=null;

    @Parameters("browser")
    @BeforeMethod
    public void LaunchBrowser(String browser){
        if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();

            ProfilesIni profiles = new ProfilesIni();
            FirefoxProfile ffprofile = profiles.getProfile("TestUser");
            ffprofile.setPreference("dom.webnotifications.enabled", false);
            ffprofile.setAcceptUntrustedCertificates(true);
            ffprofile.setAssumeUntrustedCertificateIssuer(false);


            // Use proxy
			/*
			ffprofile.setPreference("network.proxy.type", 1);
			ffprofile.setPreference("network.proxy.socks", "proxy.example.com");
			ffprofile.setPreference("network.proxy.socks_port", 8080);
			*/

            options.setProfile(ffprofile);
            driver = new FirefoxDriver(options);
            driver = new FirefoxDriver();
        }
        else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-infobars");
            options.addArguments("--disable-extensions");

            // Use proxy
			/*
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("proxy.example.com:8080");
			options.setCapability("proxy", proxy);
			*/

            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("ignore-certificate-errors");
            driver = new ChromeDriver(options);
        }
        }


    @Test
    public void openFacebook() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title,"Log in to Facebook");
    }

    @Test
    public void openToolsQA() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://toolsqa.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title,"Tools QA");
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
