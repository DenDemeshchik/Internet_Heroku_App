import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import runner.BasePage;
import java.util.ArrayList;
import java.util.List;

public class DisappearingElementsTest extends BasePage {

    String checkboxesLink = "//a[@href='/disappearing_elements']";
    String title = "//div[@class='example']";
    
    @Test
    public void clickButton() {

        Actions actions = new Actions(getDriver());

        click(checkboxesLink);

        waitUntilElementAppear(title);

        List<WebElement> buttons = getDriver().findElements(By.xpath("//li/a"));

        int initialWidth;
        int initialHeight;
        List<Integer> initialWidths = new ArrayList<>();
        List<Integer> initialHeights = new ArrayList<>();

        for (WebElement button : buttons) {
            actions.moveToElement(button).perform();
            initialWidth = button.getSize().getWidth();
            initialHeight = button.getSize().getHeight();
            initialWidths.add(initialWidth);
            initialHeights.add(initialHeight);
        }

        for (int i = 0; i < buttons.size(); i++) {
            int newWidth = buttons.get(i).getSize().getWidth();
            int newHeight = buttons.get(i).getSize().getHeight();

            if (newWidth != initialWidths.get(i) || newHeight != initialHeights.get(i)) {
                System.out.println("Размер кнопки " + i + " изменился: " +
                        "было (" + initialWidths.get(i) + ", " + initialHeights.get(i) + "), " +
                        "стало (" + newWidth + ", " + newHeight + ")");
            }
        }
    }
}
