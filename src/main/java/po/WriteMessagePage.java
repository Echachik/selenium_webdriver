package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WriteMessagePage extends AbstractPage {

    private static final By FIELD_WHOM = By.xpath("//div[@name='to']");
    private static final By FIELD_SUBJECT = By.xpath("//input[contains(@class,'mail-Compose-Field-Input-Controller')]");
    private static final By FIELD_BODY = By.xpath("//*[contains(@class,'cke_source cke_reset cke_enable_context_menu cke_editable')]");
    private static final By BODY_AREA = By.xpath("//textarea[contains(@class,'enable_context_menu')]");
    private static final By SAVE_DRAFT = By.xpath("//button[contains(@class,'action-button') and contains(@data-action, 'save')]");

    public WriteMessagePage(WebDriver driver) {
        super(driver);
    }

    public void fillInWhomField() {
        driver.findElement(FIELD_WHOM).sendKeys("epam.selenium@yandex.by");
    }
    public void fillInSubjectField() {
        driver.findElement(FIELD_SUBJECT).sendKeys("Hello!!!");
    }
    public void clickFieldBody() {
        driver.findElement(FIELD_BODY).click();
    }
    public void fillInBodyArea() {
        driver.findElement(BODY_AREA).sendKeys("Hello from epam.selenium@yandex.by");
    }
    public void clickSaveDraft() {
        driver.findElement(SAVE_DRAFT).click();
    }
}
