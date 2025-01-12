import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;


public class DynamicLoadingTest extends BasePage {

    String dynamicLoadingLink = "//a[@href='/dynamic_loading']";
    String title = "//div[@class='example']";
    String hiddenElementLinkXPath = "//a[@href='/dynamic_loading/1']";
    String hiddenElementXPath = "//div[@id='finish']/h4";

    @Test
    public void findHiddenText() {

        click(dynamicLoadingLink);

        waitUntilElementAppear(title);

        click(hiddenElementLinkXPath);

        waitUntilElementAppear(title);

        String hiddenElement = getDriver().findElement(By.xpath(hiddenElementXPath)).getTagName();

        Assert.assertEquals(hiddenElement, "h4");
    }
}
