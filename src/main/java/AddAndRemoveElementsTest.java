import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class AddAndRemoveElementsTest extends BasePage {

    String addAndRemoveElementLink = "//a[@href='/add_remove_elements/']";
    String baseButton = "//div[@class='example']/button";
    String addElementLink = "//a[@href='/add_remove_elements/']";
    String deletedButton = "//button[@class='added-manually']";

    @Test
    public void addElement() {

        click(addAndRemoveElementLink);

        click(baseButton);

        Assert.assertEquals(gottenTextFromWebElement(deletedButton),
                            "Delete");
    }

    @Test
    public void addElementAndRemove() {

        click(addElementLink);

        click(baseButton);

        waitUntilElementAppear(deletedButton);

        try {
            click(deletedButton);
            getWait5();
            click(deletedButton);
            System.out.println("Button is not displayed");
        } catch (Exception e) {
            System.out.println("Button is displayed");
        }
    }
}
