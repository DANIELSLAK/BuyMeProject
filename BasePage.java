import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private CharSequence text;

    public void clickElement(By locator) throws Exception {
        getWebElement (locator).click();
    }

    public void sendKeysToElement(By locator, String s) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    private WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}