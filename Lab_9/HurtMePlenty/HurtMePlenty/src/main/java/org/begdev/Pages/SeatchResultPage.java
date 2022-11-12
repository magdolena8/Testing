package org.begdev.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeatchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Google Cloud Pricing Calculator']/parent::a")
    private WebElement calculator;
    public SeatchResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }
    public PricingCalculatorPage GoToCalculator() throws InterruptedException {
        calculator.click();
        return new PricingCalculatorPage(driver);
    }
}
