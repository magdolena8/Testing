package org.begdev.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class PricingCalculatorPage {
    private String MainPageUrl="https://cloud.google.com/";
    private WebDriver driver;


    @FindBy(xpath = "//section[@id='gc-wrapper']")
    private WebElement section;

    @FindBy(xpath = "//article[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement parentFrame;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement childFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']/div")
    private WebElement computeEngineFormTab;

    @FindBy(xpath = "//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;
    @FindBy(xpath = "//*[@id=\"select_value_label_85\"]")
    private WebElement series;
    @FindBy(xpath = "//md-option[@id='select_option_201']")
    private WebElement requiredSeries;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineType;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement requiredMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGpuCheckbox;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuType;
    @FindBy(xpath = "//md-option[@id='select_option_474']")
    private WebElement requiredGpuType;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement gpuAmount;
    @FindBy(xpath = "//md-option[@id='select_option_477']")
    private WebElement requiredGpuAmount;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    @FindBy(xpath = "//md-option[@id='select_option_449']")
    private WebElement requiredLocalSSD;
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//md-option[@id='select_option_228']")
    private WebElement requireddateCenterLocation;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsage;
    @FindBy(xpath = "//md-option[@id='select_option_128']")
    private WebElement requiredCommitedUsage;
    @FindBy(xpath = "//button[not(@disabled) and contains(text(),'Add to Estimate')]")
    private WebElement buttonAddToEstimate;
    @FindBy(xpath = "//div[contains(text(), 'Provisioning model:')]")
    private WebElement resultVM;

    @FindBy(xpath = "//div[contains(text(), 'Operating System / Software:')]")
    private WebElement resultOS;

    @FindBy(xpath = "//div[contains(text(), 'Instance type:')]")
    private WebElement resultInstanceType;

    @FindBy(xpath = "//div[contains(text(), 'Region:')]")
    private WebElement resultRegion;

    @FindBy(xpath = "//div[contains(text(), 'Local SSD:')]")
    private WebElement resultLocalSSD;

    @FindBy(xpath = "//div[contains(text(), 'Commitment term:')]")
    private WebElement resultCommitmentTerm;
    @FindBy(xpath = "//button[@id='email_quote']")
    WebElement sendEstimateToEmailButton;

    @FindBy(xpath = "//article[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement emailPopupFrame;


    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement emailInputInSendEstimateToEmailForm;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    WebElement getSendEstimateToEmailPopupButton;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']/descendant::h2[contains(@class,'md-title')]/b")
    WebElement calculatorEstimateCost;

    public PricingCalculatorPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
        driver.switchTo().frame(parentFrame);
        driver.switchTo().frame(childFrame);
    }
    public void SetValues(){
        numberOfInstance.sendKeys("4");
        series.click();
        requiredSeries.click();
        machineType.click();
        requiredMachineType.click();
        addGpuCheckbox.click();
        gpuType.click();
        requiredGpuType.click();
        gpuAmount.click();
        requiredGpuAmount.click();
        localSSD.click();
        requiredLocalSSD.click();
        datacenterLocation.click();
        requireddateCenterLocation.click();
        commitedUsage.click();
        requiredCommitedUsage.click();
        buttonAddToEstimate.click();
        sendEstimateToEmailButton.click();
    }
    public String getResulltCalculatorEstimateCost() {
        return calculatorEstimateCost.getText();
    }
    public void SendEmail(String a) throws IOException, UnsupportedFlavorException {
        driver.switchTo().frame(emailPopupFrame).switchTo().frame(childFrame);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        emailInputInSendEstimateToEmailForm.sendKeys(a);
        getSendEstimateToEmailPopupButton.click();
    }

    public String getResultVM() {
        return resultVM.getText();
    }

    public String getResultInstanceType() {
        return resultInstanceType.getText();
    }

    public String getResultLocalSSD() {
        return resultLocalSSD.getText();
    }

    public String getResultCommitmentTerm() {
        return resultCommitmentTerm.getText();
    }
}