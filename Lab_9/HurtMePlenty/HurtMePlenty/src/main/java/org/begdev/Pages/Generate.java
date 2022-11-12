package org.begdev.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Generate {
    private static final String HOMEPAGE_URL = "https://yopmail.com/ru/email-generator";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"egen\"]")
    WebElement email;

    public Generate(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public Generate openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public String getEmail(){
        return email.getText();
    }


}