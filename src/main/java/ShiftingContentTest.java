import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class ShiftingContentTest extends BasePage {

    String shiftPageLink = "//a[@href='/shifting_content']";
    String title = "//div[@class='example']";
    String menuElementPage = "//a[@href='/shifting_content/menu']";
    String homePageButton = "//a[@href='/']";

    @Test
    public void compare_color() {

        click(shiftPageLink);

        waitUntilElementAppear(title);

        click(menuElementPage);

        String baseColor = get_css_value(homePageButton, "color");

        move_to_element_and_pause_By_Xpath(homePageButton);

        String changedColor = get_css_value(homePageButton, "color");

        Assert.assertNotEquals(baseColor, changedColor);
    }

    @Test
    public void compare_size() {

        click(shiftPageLink);

        waitUntilElementAppear(title);

        click(menuElementPage);

        String baseColor = get_css_value(homePageButton, "font-size");

        move_to_element_and_pause_By_Xpath(homePageButton);

        String changedColor = get_css_value(homePageButton, "font-size");

        Assert.assertNotEquals(baseColor, changedColor);
    }
}

