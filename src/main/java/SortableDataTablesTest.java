import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class SortableDataTablesTest extends BasePage {

    String dataTablesLink = "//a[@href='/tables']";
    String title = "//div[@class='example']";
    String dueColumn = "//span[text()='Due']";
    String biggestSumText = "//td[text()='$100.00']";

    @Test
    public void checkTheRichestPerson() {

        click(dataTablesLink);

        waitUntilElementAppear(title);

        doubleClickWithTime(dueColumn);

        Assert.assertEquals(gottenTextFromWebElement(biggestSumText), "$100.00");
    }
}
