package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends AbstractPage {
    public static String HOME_URL = "https://amazon.com/";
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/div/div/div[1]/form/div[1]/input")
    WebElement loginInput;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/div/div/div[1]/form/div[2]/input")
    WebElement passwordInput;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/div/div/div[1]/form/div[4]/button")
    WebElement loginButton;
    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }
    public LoginPage inputLogin(String login){
        loginInput.sendKeys(login);
        log.info(login + " was sent to loginInput");
        return this;
    }
    public LoginPage inputPassword(String password){
        passwordInput.sendKeys(password);
        log.info(password + " was sent to passwordInput");
        return this;
    }
    public ProfilePage loginButtonClick(){
        loginButton.click();
        log.info("Clicked login button");
        return new ProfilePage(driver);
    }

}
