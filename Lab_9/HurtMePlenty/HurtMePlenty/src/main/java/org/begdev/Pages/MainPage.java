package org.begdev.Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.security.PrivilegedAction;

public class MainPage {
    private String MainPageUrl="https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search")
    private WebElement search;
    @FindBy(xpath = "//div[contains(@class,'devsite-searchbox')]/input")
    private WebElement searchInput;
    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }

    public MainPage OpenPage(){
        driver.get(MainPageUrl);
        return this;
    }
    public void OpenSearch(){
        search.click();
    }
    public void InputSearchText(){
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
    }
    public SeatchResultPage StartSearch(){
        searchInput.sendKeys(Keys.RETURN);
        return new SeatchResultPage(driver);
    }

}