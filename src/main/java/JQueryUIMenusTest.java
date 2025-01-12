import org.testng.annotations.Test;
import runner.BasePage;

public class JQueryUIMenusTest extends BasePage {

    String jQueryLink = "//a[@href='/jqueryui/menu']";
    String title = "//div[@class='example']";
    String pdf = "PDF";

    String ENABLED = "Enabled";
    String DOWNLOADS = "Downloads";
    String RIGHT_MESSAGE = "Success! You clicked on PDF menu";
    String WRONG_MESSAGE = "Something went wrong! You didn't find PDF menu";

    @Test
    public void downloadPDF() {

        click(jQueryLink);

        waitUntilElementAppear(title);

        try {

            move_to_element_and_pause(ENABLED);

            move_to_element_and_pause(DOWNLOADS);

            clickByText(pdf);

            System.out.println(RIGHT_MESSAGE);
        } catch (Exception e) {
            System.out.println(WRONG_MESSAGE);
        }
    }
}
