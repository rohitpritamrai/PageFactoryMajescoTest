package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AboutMajescoPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='breadcrumb_last']")
    WebElement aboutMajescoLabel;

    @FindBy(xpath = "//*[@class='gLFyf gsfi']")
    WebElement searchBox;

    @FindBy(css = "body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'About Majesco')]")
    WebElement aboutMajescolink;

    public AboutMajescoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchText(String text){
        searchBox.sendKeys(text);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public void verifyAboutMajescoLink(){
        Assert.assertTrue(aboutMajescolink.isDisplayed(), "About Majesco link is not present");
    }

    public void clickAboutMajescoLink(){
        aboutMajescolink.click();
    }

    public void verifyAboutMajescoLabel(){
        String labelText = aboutMajescoLabel.getText();
        Assert.assertEquals("About Majesco", labelText);
    }



}
