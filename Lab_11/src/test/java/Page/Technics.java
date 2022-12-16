package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Technics extends AbstractPage {
    public static String HOME_URL = "https://amazon.com/";
    @FindBy(xpath = "/html/body/div[3]/main/form/div/table/tbody/tr/td[2]/h4/a")
    WebElement itemName;
    @FindBy(xpath = "/html/body/div[3]/main/div[9]/div[1]/a\n")
    WebElement btnDeleteProduct;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/p/font")
    WebElement textDelete;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/table/tbody/tr/td[9]/div[2]/a")
    WebElement btnRes;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]//a[2]")
    WebElement btnMoveTo;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/form/div/div/div[3]/table/tbody/tr/td[2]/h4/a")
    WebElement checkboxAdded;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/form/div/div/div/input\n")
    WebElement editCountField;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/table/tbody/tr/td[8]/div/div/div/div/div[2]/button")
    WebElement addOneMoreProduct;
    @FindBy(xpath = "//*[@id=\"item_list\"]/div[2]/div[4]/a")
    WebElement removeAndCheck;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/tbody/tr/td[2]/div[2]")
    WebElement productDescription;
    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    public Technics(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
        log.info("BagPage opened");
    }
    public String getItemName(){
        return itemName.getText().toString();
    }
    public Technics onRemoveClick(){
        btnDeleteProduct.click();
        return this;
    }
    public String isRemoved(){
        return textDelete.getText();
    }

    public Technics onPostClick(){
        btnRes.click();
        return this;
    }
    public Technics moveToPostponeButtonClick(){
        btnMoveTo.click();
        return this;
    }
    public String isPostponed(){
        return checkboxAdded.getText();
    }
    public Technics increaseQuantity(){
        addOneMoreProduct.click();
        return this;
    }
    public Technics increaseQuantitySeveralTimes(int count) throws InterruptedException {
        for(int i=0;i<count;i++) {
            addOneMoreProduct.click();
        }
        Thread.sleep(4000);
        return this;
    }
    public String getItemQuantity(){
        return editCountField.getAttribute("value"); }
    public String getProductDescription(){
        return productDescription.getText();
    }

    public CheckoutPage moveToCheckoutPage(){
        removeAndCheck.click();
        return new CheckoutPage(driver);
    }
}
