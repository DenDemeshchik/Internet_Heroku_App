import org.testng.annotations.Test;
import runner.BasePage;

public class KeyPressesTest extends BasePage {

    String keyPressLink = "//a[@href='/key_presses']";
    String title = "//div[@class='example']";
    String input = "//input[@id='target']";
    String result = "//p[@id='result']";

    String WRONG_TEXT = "Something went wrong!";

    @Test
    public void keyPressEnter() {

        click(keyPressLink);

        waitUntilElementAppear(title);

        try {
            click(input);
            keyDownALT();

            System.out.println(gottenTextFromWebElement(result));
        } catch (Exception e) {
            System.out.println(WRONG_TEXT);
        }
    }
}
