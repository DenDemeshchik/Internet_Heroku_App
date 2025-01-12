import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class HorizontalSliderTest extends BasePage {

    String moveHorizontalSliderLink = "//a[@href='/horizontal_slider']";
    String title = "//div[@class='example']";
    String slider = "//input[@type='range']";
    String countId = "range";

    @Test
    public void moveHorizontalSlider() {

        click(moveHorizontalSliderLink);

        waitUntilElementAppear(title);

        moveElementBy(slider, 0);

        String count = getDriver().findElement(By.id(countId)).getText();

        Assert.assertEquals(count, "5");
    }
}
