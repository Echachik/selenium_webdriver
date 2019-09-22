package pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final String URL = "https://yandex.by/";

    @FindBy(xpath = "//div[@class='mail-User-Name']")
    WebElement elementMailUsername ;

    @FindBy(xpath = "//span[@class='mail-ComposeButton-Text']")
    WebElement writeMessageButton;

    @FindBy(xpath = "//*[contains(text(),'Входящие')]")
    WebElement inboxFolder;

    @FindBy(xpath = "//*[contains(text(),'Отправленные')]")
    WebElement sentFolder;

    @FindBy(xpath = "//*[contains(text(),'Черновики')]")
    WebElement draftFolder;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void open() {
        driver.get(URL);

    }

    public WriteMessagePage clickWriteMessageButton() {
        writeMessageButton.click();
        return new WriteMessagePage(driver);
    }

    public void clickInboxFolder() {
        inboxFolder.click();
    }

    public void clickSentFolder() {
        sentFolder.click();
    }

    public void clickDraftFolder() {
        draftFolder.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.titleIs("Черновики — Яндекс.Почта"));
    }

    public WebElement getElementMailUsername() {
        return elementMailUsername;
    }
}
