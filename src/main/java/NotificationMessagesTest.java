import org.testng.annotations.Test;
import runner.BasePage;
public class NotificationMessagesTest extends BasePage {

    String notificationMessagesLink = "//a[@href='/notification_message']";
    String title = "//div[@class='example']";
    String click_here_String = "//a[@href='/notification_message']";
    String notificationMessage = "//div[@class = 'flash notice'])";

    String MESSAGE = "The notification message is ";
    String WRONG_MESSAGE = "Error! Something went wrong!";

    @Test
    public void getMessage() {

        click(notificationMessagesLink);

        waitUntilElementAppear(title);

        click(click_here_String);

        waitUntilElementAppear(title);

        try {
            System.out.println(MESSAGE + gottenTextFromWebElement(notificationMessage));
        } catch (Exception e) {
            System.out.println(WRONG_MESSAGE);
        }
    }
}
