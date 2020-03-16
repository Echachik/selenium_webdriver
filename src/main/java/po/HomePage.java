package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final By WRITE_MESSAGE_BUTTON = By.xpath("//span[@class='mail-ComposeButton-Text']");
    private static final By INBOX_FOLDER = By.xpath("//*[contains(text(),'Входящие')]");
    private static final By SENT_FOLDER = By.xpath("//*[contains(text(),'Отправленные')]");
    private static final By DRAFT_FOLDER = By.xpath("//*[contains(text(),'Черновики')]");
    private  static final String URL = "https://yandex.by/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

     public void open(){
        driver.get(URL);

    }
    public WriteMessagePage clickWriteMessageButton () {
        driver.findElement(WRITE_MESSAGE_BUTTON).click();
        return new WriteMessagePage(driver);
    }
    public void clickInboxFolder() {
        driver.findElement(INBOX_FOLDER).click();
    }
    public void clickSentFolder() {
        driver.findElement(SENT_FOLDER).click();
    }

    public void clickDraftFolder() {
        driver.findElement(DRAFT_FOLDER).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.titleIs("Черновики — Яндекс.Почта"));
    }
}