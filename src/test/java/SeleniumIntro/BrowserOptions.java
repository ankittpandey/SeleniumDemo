package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class BrowserOptions {
    @Test
    public void chromeBrowserProfiling() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        //options.setBinary("path/to/chrome/binary");
        options.addArguments("--start-maximized");
        options.addArguments("--user-data-dir=C:\\Users\\2340824\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        Thread.sleep(10000);
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.facebook.com/");

    }

    @Test
    public void firefoxBrowserProfiling() throws InterruptedException {
        FirefoxOptions options=new FirefoxOptions();
        ProfilesIni profiles=new ProfilesIni();
        //String ProfilePath="C:\\Users\\2340824\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\n6nf52yf.TestUser";
        FirefoxProfile ffprofile=profiles.getProfile("TestUser");
        options.setProfile(ffprofile);
        Thread.sleep(10000);
        WebDriver driver=new FirefoxDriver(options);
        driver.get("https://www.facebook.com/");

    }
}
