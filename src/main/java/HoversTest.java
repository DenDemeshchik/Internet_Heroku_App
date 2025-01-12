import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import runner.BasePage;
import java.util.ArrayList;
import java.util.List;

public class HoversTest extends BasePage {

    String hoversLink = "//a[@href='/hovers']";
    String imagesXPath = "//div[@class='figure']";
    String initialNameXPath = "//h5";

    String WRONG_MESSAGE = "Something goes wrong!";

    @Test
    public void horizontalSlider() {

        Actions actions = new Actions(getDriver());

        click(hoversLink);

        List<WebElement> images = getDriver().findElements(By.xpath(imagesXPath));

        String initialName;

        List<String> initialNames = new ArrayList<>();

        for (WebElement image : images) {
            actions.moveToElement(image).perform();
            initialName = getDriver().findElement(By.xpath(initialNameXPath)).getText();
            initialNames.add(initialName);
        }
// Не выводит всех остальных юзеров
        try {
            for (int i = 0; i < images.size(); i++) {

                if (initialNames.get(i) != null) {
                    System.out.println(initialNames.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(WRONG_MESSAGE);
        }
    }
}
