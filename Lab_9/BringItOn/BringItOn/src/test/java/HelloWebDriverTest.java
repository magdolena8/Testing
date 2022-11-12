import Pages.MainPage;
import Pages.PasteCreationResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloWebDriverTest {
    PasteCreationResult pasteCreationResultPage;
    WebDriver driver;
    @BeforeMethod
    public void CreateNewPaste() throws InterruptedException {
        driver=new ChromeDriver();
        MainPage page= new MainPage(driver);
        page.OpenPage();
        page.SetCode();
        page.SetSyntaxHighlights();
        page.SetPasteExpiration();
        page.SetName();
        pasteCreationResultPage=page.ClickCreateNewPasteButton();
    }
    @Test
    void CheckHighlights(){
        Assert.assertEquals(pasteCreationResultPage.getSyntaxHighlights(),"Bash");
        System.out.println(pasteCreationResultPage.getTitle());
        Assert.assertEquals(pasteCreationResultPage.getTitle(),"how to gain dominance among developers");
        Assert.assertEquals(pasteCreationResultPage.getCode(),"git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
    }

//    @Test
//    void CheckCode(){
//        Assert.assertEquals(pasteCreationResultPage.getCode(),"git config --global user.name  \"New Sheriff in Town\"\n" +
//                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
//                "git push origin master --force");
//    }
//    @Test
//    void CheckTitle(){
//        System.out.println(pasteCreationResultPage.getTitle());
//        Assert.assertEquals(pasteCreationResultPage.getTitle(),"how to gain dominance among developers");
//    }

    @AfterMethod
    void quitBrowser(){
        driver.quit();
    }
}