package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SingleItemPage extends AbstractPage {
    public static String HOME_URL = "https://amazon.com/";
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div/section/div[6]/a/span")
    WebElement addToCartButton;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div/section/div/div/ul/li[4]/span/span")
    WebElement chooseSize;
    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    public SingleItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30),this);
    }
    public Technics addToCart() {
        addToCartButton.click();
        return new Technics(driver);
    }
    public SingleItemPage choseDestination(){
        chooseSize.click();
        return this;
    }
}
