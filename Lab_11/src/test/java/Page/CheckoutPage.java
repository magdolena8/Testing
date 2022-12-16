package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutPage extends AbstractPage{
    public static String HOME_URL = "https://amazon.com/";
    @FindBy(xpath = "//*[@id=\"bx-soa-total\"]/div[2]/div[1]/span[2]")
    WebElement allProductsPrice;

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    public CheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }
    public String getAllProductsPrice(){
        log.info("Returned " + allProductsPrice.getText() + " from CheckoutPage");
        return allProductsPrice.getText();
    }
}
