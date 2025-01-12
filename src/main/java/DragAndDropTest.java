import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class DragAndDropTest extends BasePage {

    String drag_and_dropLink = "//a[@href='/drag_and_drop']";
    String title = "//div[@class='example']";
    String boxAXPath = "//div[@id='column-a']";
    String boxBXPath = "//div[@id='column-b']";

    @Test
    public void dragA() {

        click(drag_and_dropLink);

        waitUntilElementAppear(title);

        WebElement boxA = getDriver().findElement(By.xpath(boxAXPath));
        WebElement boxB = getDriver().findElement(By.xpath(boxBXPath));
        drag_and_drop_two_elements(boxA, boxB);

        getWait5(); // - to see the difference

        Assert.assertEquals(boxA.getText(), "B");
    }
}
