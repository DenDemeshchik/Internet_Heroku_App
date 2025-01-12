import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import runner.BasePage;

public class DropdownTest extends BasePage {

    String checkboxesLink = "//a[@href='/dropdown']";
    String title = "//div[@class='example']";

    String dropdownElementId = "dropdown";

    @Test
    public void selectOption1() {

        click(checkboxesLink);

        waitUntilElementAppear(title);

        WebElement dropdownElement = getDriver().findElement(By.id("dropdown"));

        Select dropdown = new Select(dropdownElement);

        clickById(dropdownElementId);

        try {
            dropdown.selectByValue("1");
            System.out.println("We have chosen the 1st option");
        } catch (Exception e) {
            System.out.println("We have not chosen the 1st option");
        }
    }
}
