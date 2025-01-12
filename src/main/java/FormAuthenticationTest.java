import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BasePage;

public class FormAuthenticationTest extends BasePage {

    //XPath

    String formAuthenticationLink = "//a[@href='/login']";
    String title = "//div[@class='example']";
    String usernameInput = "//input[@id='username']";
    String passwordInput = "//input[@id='password']";
    String loginButton = "//button[@class='radius']";
    String logoutButton = "//a[@href='/logout']";
    String flash = "//div[@id='flash']";
    String subHeader = "//h4[@class='subheader']";

    //Messages

    String TOM_SMITH = "tomsmith";
    String SUPER_SECRET_PASSWORD = "SuperSecretPassword!";
    String EXPECTED_TEXT = "Welcome to the Secure Area. When you are done click logout below.";
    String DEN = "Den";
    String LALALA = "Lalala";
    String CORRECT_MESSAGE = "Ok!";
    String INCORRECT_MESSAGE = "Incorrect username or password";

    @Test
    public void correctLoginPage() {

        click(formAuthenticationLink);

        waitUntilElementAppear(title);

        findAndSendKeys(usernameInput, TOM_SMITH);

        findAndSendKeys(passwordInput, SUPER_SECRET_PASSWORD);

        click(loginButton);

        waitUntilElementAppear(flash);

        String flash_Success_text = getDriver().findElement(By.xpath(subHeader)).getText();

        Assert.assertEquals(flash_Success_text, EXPECTED_TEXT);
    }



    @Test
    public void incorrectLoginPage() {

        click(formAuthenticationLink);

        waitUntilElementAppear(title);

        findAndSendKeys(usernameInput, DEN);

        findAndSendKeys(passwordInput, LALALA);

        try {
            click(loginButton);
            waitUntilElementAppear(flash);
            click(logoutButton);
            System.out.println(CORRECT_MESSAGE);

        } catch (NoSuchElementException e) {
            System.out.println(INCORRECT_MESSAGE);
        }
    }
}
