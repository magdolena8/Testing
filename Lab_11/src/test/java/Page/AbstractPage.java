package Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected Logger log = LogManager.getRootLogger();

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
