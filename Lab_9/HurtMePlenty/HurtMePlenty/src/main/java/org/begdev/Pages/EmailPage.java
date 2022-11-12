package org.begdev.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
    private static final String HOMEPAGE_URL = "https://yopmail.com/ru/wm";
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"refreshbut\"]/button")
    WebElement checkMail;

    public EmailPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public EmailPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public CheckPrice goToMail(){
        checkMail.click();
        return new CheckPrice(driver);
    }

}