package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProfilePage extends AbstractPage{
    public static String HOME_URL = "https://amazon.com/";
    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    public ProfilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }

}
