package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import pages.AboutMajescoPage;

import java.util.concurrent.TimeUnit;

public class Test {

    AboutMajescoPage aboutMajescoPage;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @org.testng.annotations.Test
    public void navigate_to_majesco_page_and_verify_text(){
        aboutMajescoPage = new AboutMajescoPage(driver);
        aboutMajescoPage.searchText("Majesco");
        aboutMajescoPage.clickSearch();
        aboutMajescoPage.verifyAboutMajescoLink();
        aboutMajescoPage.clickAboutMajescoLink();
        aboutMajescoPage.verifyAboutMajescoLabel();
    }

    @AfterSuite
    public void exitSetup(){
        driver.quit();
    }

}
