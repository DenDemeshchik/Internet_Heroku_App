import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class DynamicControlsTest extends BasePage {

    String checkboxesLink = "//a[@href='/dynamic_controls']";
    String title = "//div[@class='example']";
    String removeButtonXPath = "//form[@id='checkbox-example']/button";
    String addButtonXPath = "//form[@id='checkbox-example']/button";

    @Test
    public void removeElement() {

        click(checkboxesLink);

        waitUntilElementAppear(title);

        click(removeButtonXPath);

        final WebElement removeButton = getDriver().findElement(By.xpath("//form[@id='checkbox-example']/button"));
        waitUntilElementBeClickable(removeButton);

        String p = getDriver().findElement(By.id("message")).getText();
        Assert.assertEquals(p, "It's gone!");
    }

    @Test (dependsOnMethods = "removeElement")
    public void addElement() {

        click(addButtonXPath);

        final WebElement addButton = getDriver().findElement(By.xpath("//form[@id='checkbox-example']/button"));
        getWait5().until(ExpectedConditions.elementToBeClickable(addButton));

        String backMessage = getDriver().findElement(By.id("message")).getText();

        Assert.assertEquals(backMessage, "It's back!");
    }
}
