package test;

import Driver.DriverSingleton;
import Util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    public WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();

    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
