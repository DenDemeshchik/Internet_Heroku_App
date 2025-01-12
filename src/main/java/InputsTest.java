import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class InputsTest extends BasePage {

    String inputsLink = "//a[@href='/inputs']";
    String title = "//div[@class='example']";
    String inputNumberXPATH = "//input[@type='number']";

    String KEY = "123";

    @Test
    public void input() {

        click(inputsLink);

        waitUntilElementAppear(title);

        findAndSendKeys(inputNumberXPATH, KEY);

        Assert.assertEquals(getAttribute(inputNumberXPATH, "value"), "123");
    }
}
