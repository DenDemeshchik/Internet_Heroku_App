import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class JavaScriptAlertsTest extends BasePage {

    String alertsLink = "//a[@href='/javascript_alerts']";
    String title = "//div[@class='example']";
    String inputNumber = "//button[contains(text(),'Alert')]";
    String result = "//p[@id='result']";
    String inputPrompt = "//button[contains(text(),'Prompt')]";
    String inputConfirm = "//button[contains(text(),'Confirm')]";

    String EXPECTED_RESULT = "You successfully clicked an alert";
    String SELENIUM = "Selenium";

    @Test
    public void alert() {

        click(alertsLink);

        waitUntilElementAppear(title);

        click(inputNumber);

        acceptAlert();

        Assert.assertEquals(gottenTextFromWebElement(result), EXPECTED_RESULT);
    }

    @Test(dependsOnMethods = "alert")
    public void confirm() {

        click(inputConfirm);

        acceptAlert();

        Assert.assertEquals(gottenTextFromWebElement(result), "You clicked: Ok");
    }

    @Test(dependsOnMethods = "confirm")
    public void prompt() {

        click(inputPrompt);

        sendKeysAlert(SELENIUM);

        Assert.assertEquals(gottenTextFromWebElement(result), "You entered: Selenium");
    }
}
