package pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteMessagePage extends AbstractPage {

    @FindBy(xpath = "//div[@name='to']")
    private WebElement fieldWhom;

    @FindBy(xpath = "//input[contains(@class,'mail-Compose-Field-Input-Controller')]")
    WebElement fieldSubject;

    @FindBy(xpath = "//*[contains(@class,'cke_source cke_reset cke_enable_context_menu cke_editable')]")
    WebElement fieldBody;

    @FindBy(xpath = "//textarea[contains(@class,'enable_context_menu')]")
    WebElement bodyArea;

    @FindBy(xpath = "//button[contains(@class,'action-button') and contains(@data-action, 'save')]")
    WebElement saveDraft;

    public WriteMessagePage(WebDriver driver) { super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void fillInWhomField() {
        fieldWhom.sendKeys("epam.selenium@yandex.by");
    }
    public void fillInSubjectField() {
        fieldSubject.sendKeys("Hello!!!");
    }
    public void clickFieldBody() {
        fieldBody.click();
    }
    public void fillInBodyArea() {
        bodyArea.sendKeys("Hello from epam.selenium@yandex.by");
    }
    public void clickSaveDraft() {
        saveDraft.click();
    }
}
