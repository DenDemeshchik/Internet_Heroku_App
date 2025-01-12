import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BasePage;

public class CheckboxesTest extends BasePage {

    String checkboxesLink = "//a[@href='/checkboxes']";

    @Test
    public void highlightCheckboxes() {

        click(checkboxesLink);

        final WebElement checkbox = getDriver().findElement(By.xpath("//input[@type='checkbox']"));

        try {
            if (checkbox.isSelected()) {
                System.out.println("Checkbox is already selected.");
            } else {
                System.out.println("Checkbox is not selected. Selected it!");
                checkbox.click();
            }

            if (checkbox.isSelected()) {
                System.out.println("Теперь checkbox отмечен.");
            } else {
                System.out.println("Checkbox по-прежнему не отмечен.");
            }
        } catch (Exception e) {
            System.out.println("Error! Something went wrong!");
        }
    }
}
