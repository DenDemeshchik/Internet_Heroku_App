import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BasePage;

public class ContextMenuTest extends BasePage {

    String checkboxesLink = "//a[@href='/context_menu']";
    String title = "//div[@class='example']";
    String hot_spotXPath = "//div[@id='hot-spot']";

    @Test
    public void clickHot_Spot() {

        click(checkboxesLink);

        waitUntilElementAppear(title);

        WebElement hot_spot = getDriver().findElement(By.xpath(hot_spotXPath));
        contextClick(hot_spot);

        try {
            acceptAlert();
            System.out.println("Context menu has been displayed");
        } catch (Exception e) {
            System.out.println("Context menu has not been displayed");
        }
    }
}
