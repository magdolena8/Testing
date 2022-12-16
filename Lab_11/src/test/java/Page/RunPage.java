package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RunPage extends AbstractPage {
    public static String HOME_URL = "https://amazon.com/";
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div/section/div/div/div[2]/div[2]/div/div[1]/div/article[1]/div/figure/a/img")
    WebElement singleItem;
    @FindBy(xpath = " /html/body/div[3]/main/div[2]/div/div/section/div/div/div[2]/div[2]/div/div[1]/div/article[2]/div/figure/a/img")
    WebElement singleItemShorts;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div/section/div/div/div/div[2]/div/div/div/article/div/div/div[2]/a")
    WebElement singleItemName;
    @FindBy(xpath = "//*[@id=\"SFilter\"]/div[2]/form/div[1]/div[1]/button/span[1]/span")
    WebElement filterByPrice;
    @FindBy(xpath = "//*[@id=\"arrFilter_P1_MAX\"]")
    WebElement maxPriceInput;

    @FindBy(xpath = "//*[@id=\"bx_3966226736_83138_price\"]")
    WebElement firstItemPrice;
    public RunPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver,this);
    }
    @Override
    protected RunPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }
    public SingleItemPage openSingleItemPage(){
        singleItem.click();
        log.info("SingleItemPage opened");
        return new SingleItemPage(driver);
    }
    public String getSingleItemName(){
        log.info("Returned " + singleItemName.getText() + " from CheckoutPage");
        return singleItemName.getText();
    }
    public RunPage openPriceFilter(){
        filterByPrice.click();
        log.info("PriceFilter opened");
        return this;
    }
    public RunPage inputMaxPrice(){
        maxPriceInput.sendKeys("5000");
        log.info("5000 was sent to maxPriceInput");
        return this;
    }
    public SingleItemPage openSingleShortsPage(){
        singleItemShorts.click();
        log.info("SingleItemPage opened");
        return new SingleItemPage(driver);
    }
    public String getFirstItemPrice(){
        log.info("Returned " + firstItemPrice.getText() + " from CheckoutPage");
        return firstItemPrice.getText();
    }
}
