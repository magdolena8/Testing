package org.begdev.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckPrice {
    @FindBy(xpath = "//div[@id='mail']/descendant::h3[2]")
    WebElement emailText;
    @FindBy(xpath = "//button[@id='refresh']")
    WebElement refreshEmailsButton;

    @FindBy(xpath = "//iframe[@id='ifinbox']")
    WebElement inboxFrame;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    WebElement emailFrame;

    @FindBy(xpath = "//div[@id='mail']/descendant::h3[2]")
    WebElement estimateEmailCost;
    private WebDriver driver;
    public CheckPrice(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }
    public String getPriceEmail(){
        driver.switchTo().frame(emailFrame);
        return estimateEmailCost.getText();
    }
    public void openEmail() {
        while (!inboxFrame.isDisplayed()) {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(refreshEmailsButton));
            refreshEmailsButton.click();
        }
    }

    public String getEstimateEmailCost() {
        driver.switchTo().frame(emailFrame);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(estimateEmailCost));
        return estimateEmailCost.getText();
    }
}