package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    public static String HOME_URL = "https://amazon.com.ru/";
    @FindBy(xpath = "//*[@id=\"catalog_menu\"]/div/div/div/nav/div/ul/li[3]/a")
    WebElement menButton;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/ul[3]/li/a/span")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"title-search-input\"]")
    WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"title-search\"]/div/div/div/button")
    WebElement searchButton;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver,this);
    }
    @Override
    public MainPage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }
    public RunPage openRunPage(){
        menButton.click();
        log.info("MenPage opened");
        return new RunPage(driver);
    }
    public LoginPage openLoginPage(){
        loginButton.click();
        log.info("LoginPage opened");
        return new LoginPage(driver);
    }
    public MainPage inputSearch(String keys){
        searchInput.sendKeys("AEROFLOW LS HZ");
        log.info(keys + " was sent to seacrhInput");
        return this;
    }
    public RunPage startSearch(){
        searchButton.click();
        log.info("SearchButton clicked");
        return new RunPage(driver);
    }
}
