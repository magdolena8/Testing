package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private String MainPageUrl="https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id="postform-text")
    private WebElement codeTextArea;

    @FindBy(id="postform-name")
    private WebElement nameTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement selectExpiration;

    @FindAll({ @FindBy(xpath = "//li[text()='10 Minutes']") })
    private WebElement requiredOption;

    @FindBy(xpath="//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button")
    private WebElement createNewPasteButton;

    public MainPage(WebDriver driver){
        this.driver=driver;
//        new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public MainPage OpenPage(){
        driver.get(MainPageUrl);
//        new WebDriverWait(driver,10).until()
        return this;
    }
    public void SetName(){
        nameTextArea.sendKeys("helloweb");
    }
    public void SetCode(){
        codeTextArea.sendKeys("Hello from WebDriver");
    }
    public void ClickCreateNewPasteButton(){
        createNewPasteButton.click();
    }
    public void SetPasteExpiration(){
        selectExpiration.click();
        requiredOption.click();

    }
}