package runner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends BaseTest{

    Actions actions = new Actions(getDriver());

    public void click(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clickByText(String text) {
        getDriver().findElement(By.linkText(text)).click();
    }

    public void clickById(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public String gottenTextFromWebElement(String xpath) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        return getDriver().findElement(By.xpath(xpath)).getText();
    }

    public void waitUntilElementAppear(String xpath) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitUntilElementBeClickable(WebElement webElement) {
        getWait5().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void findAndSendKeys(String xpath, String key) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(key);
    }

    public void moveElementBy(String xpath, Integer y) {
        int offset = 100; // Replace with the desired value to determine how much you want to move the slider

        WebElement slider = getDriver().findElement(By.xpath(xpath));
        actions.clickAndHold(slider).moveByOffset(offset, y).release().perform();
    }

    public String getAttribute(String xpath, String value) {
        return getDriver().findElement(By.xpath(xpath)).getAttribute(value);
    }

    public void acceptAlert() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void sendKeysAlert(String key) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(key);
        alert.accept();
    }

    protected void contextClick (WebElement webElement) {
        actions.contextClick(webElement)
                .perform();
    }

    protected void drag_and_drop_two_elements(WebElement boxA, WebElement boxB) {
        actions.dragAndDrop(boxA, boxB)
                .perform();
    }

    protected void move_to_element_and_pause(String text) {
        WebElement webElement = getDriver().findElement(By.linkText(text));
        actions.moveToElement(webElement).pause(1000).click().perform();
    }

    protected String get_css_value(String xpath, String value) {
        String cssValue = getDriver().findElement(By.xpath(xpath)).getCssValue(value);
        System.out.println(cssValue);
        return  cssValue;
    }

    protected void move_to_element_and_pause_By_Xpath(String xpath) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        actions.moveToElement(element).pause(10).perform();
    }

    protected void keyDownALT() {
        actions.keyDown(Keys.ALT).pause(3).perform();
    }

    protected void doubleClickWithTime(String xpath) {
        WebElement webElement = getDriver().findElement(By.xpath(xpath));
        actions.moveToElement(webElement).click().pause(1000).click().perform();
    }
}
