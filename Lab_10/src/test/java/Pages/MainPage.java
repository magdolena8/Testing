
package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    String mainPage = "https://amazon.com.ru/";

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"catalog_menu\"]/div/div/div/nav/div/ul/li[2]")
    WebElement menButton;

    @FindBy(xpath = "//*[@id=/html/body/div[5]/div/div[2]/ul/li[2]/a")
    WebElement accessoriesLink;

    @FindBy(xpath = "//*[@id='min_price']")
    WebElement firestPrice;

    @FindBy(xpath = "//*[@id='max_price']")
    WebElement secondPrice;

    @FindBy(xpath = "//*[@id=/html/body/div[5]/div/div[2]/ul/li[2]/a")
    WebElement productGrid;

    @FindBy(xpath = "//*[@id=/html/body/div[5]/div/div[2]/ul/li[2]/a")
    WebElement LamaboxesLink;
    @FindBy(xpath = "//h1")
    WebElement header;

    public void clickElememt(SelenideElement element){
        element.click();
    }
    public void setValueOnInput(SelenideElement inputElement,String Value){
        inputElement.setValue(Value);
    }
    public void PressTabOnElement(SelenideElement element){
        element.pressTab();
    }
    public void hoverOnElement(SelenideElement element) {
        element.hover();
    }
    public void enterPricesToSort() throws InterruptedException {
        setValueOnInput(firestPrice,"0");
        setValueOnInput(secondPrice,"0");
        PressTabOnElement(secondPrice);
    }
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
