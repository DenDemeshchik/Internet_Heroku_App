import org.openqa.selenium.*;
import org.testng.annotations.Test;
import runner.BasePage;

public class FileUploadTest extends BasePage {

    String fileUploadLink = "//a[@href='/upload']";
    String title = "//div[@class='example']";

    @Test
    public void clickRedSquare() {

        click(fileUploadLink);

        waitUntilElementAppear(title);

        try {
            WebElement chooseFileButton = getDriver().findElement(By.xpath("//input[@id='file-upload']"));
            chooseFileButton.sendKeys("D:\\Кремовый_и_Зеленый_Творческий_Резюме_1.pdf");
            System.out.println("File has successfully uploaded");
        } catch (Exception e) {
            System.out.println("File has not uploaded");
        }
    }
}
