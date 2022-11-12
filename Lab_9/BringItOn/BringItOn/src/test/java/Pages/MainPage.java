package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private String MainPageUrl="https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id="postform-text")
    private WebElement codeTextArea;

    @FindBy(id="postform-name")
    private WebElement nameTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement selectExpiration;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement requiredExpirationOption;

    @FindBy(id = "select2-postform-format-container")
    private WebElement selectSyntaxHihglights;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement requiredSyntaxHihglights;

    @FindBy(xpath="//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button")
    private WebElement createNewPasteButton;


    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public MainPage OpenPage(){
        driver.get(MainPageUrl);
        return this;
    }
    public void SetName(){
        nameTextArea.sendKeys("how to gain dominance among developers");
    }
    public void SetCode(){
        codeTextArea.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
    }
    public void SetPasteExpiration(){
        selectExpiration.click();
        requiredExpirationOption.click();

    }
    public void SetSyntaxHighlights(){
        selectSyntaxHihglights.click();
        requiredSyntaxHihglights.click();

    }
    public PasteCreationResult ClickCreateNewPasteButton(){
        createNewPasteButton.click();
        return new PasteCreationResult(driver);
    }
}