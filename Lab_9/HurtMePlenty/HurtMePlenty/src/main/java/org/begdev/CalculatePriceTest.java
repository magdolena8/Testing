package org.begdev;
import org.begdev.Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatePriceTest {
    SeatchResultPage searchResultPage;
    PricingCalculatorPage pricingCalculatorPage;
    String vmResult;
    String resultIT;
    String ssdResult;
    String ctResult;
    WebDriver driver;
    String priceFromPage;
    String priceFromEmail;
    ArrayList<String> tabs;
    @BeforeMethod
    public void main() throws InterruptedException, IOException, UnsupportedFlavorException {
        String email;
        driver=new ChromeDriver();
        MainPage page=new MainPage(driver);
        page.OpenPage();
        page.OpenSearch();
        page.InputSearchText();
        searchResultPage=page.StartSearch();
        pricingCalculatorPage=searchResultPage.GoToCalculator();
        pricingCalculatorPage.SetValues();
        priceFromPage=pricingCalculatorPage.getResulltCalculatorEstimateCost();
        vmResult=pricingCalculatorPage.getResultVM();
        resultIT=pricingCalculatorPage.getResultInstanceType();
        ssdResult=pricingCalculatorPage.getResultLocalSSD();
        ctResult=pricingCalculatorPage.getResultCommitmentTerm();
        System.out.println(priceFromPage);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Generate gen=new Generate(driver);
        gen.openPage();
        email=gen.getEmail();
        System.out.println(email);
        driver.switchTo().window(tabs.get(0));
        pricingCalculatorPage.SendEmail(email);
        EmailPage emailPage=new EmailPage(driver);
        emailPage.openPage();
        CheckPrice price=emailPage.goToMail();
        priceFromEmail=price.getPriceEmail();
        System.out.println(priceFromPage);
        priceFromPage=priceFromPage.substring(22,34);
        System.out.println(email);
        System.out.println(priceFromEmail);
        System.out.println(priceFromPage);
    }
    @Test
    void Test(){
        Assert.assertEquals(priceFromEmail,priceFromPage);
        Assert.assertEquals("USD 1,840.40",priceFromPage);
        Assert.assertEquals(vmResult,"Provisioning model: Regular");
        Assert.assertEquals(resultIT,"Instance type: n1-standard-8\n" +
                "Committed Use Discount applied");
        Assert.assertEquals(ssdResult,"Local SSD: 2x375 GiB\n" +
                "Committed Use Discount applied");
        Assert.assertEquals(ctResult,"Commitment term: 1 Year");
    }

}