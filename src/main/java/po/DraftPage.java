package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DraftPage extends AbstractPage {

    private static final By DRAFT_ADDRESSEE = By.xpath("//span[contains(@title,'epam.selenium@yandex.by')]");
    private static final By DRAFT_SUBJECT = By.xpath("//span[contains(text(),'Hello!!!')]");
    private static final By DRAFT_BODY = By.xpath("//span[contains(@title,'Hello from epam.selenium@yandex.by')]");
    private String actualText;
    private static final By DRAFT_MAIL = By.xpath("//span[contains(text(),'epam.selenium@yandex.by')]");
    private static final By SEND_MAIL = By.xpath("//button[contains(@class,'send') and contains(@type,'submit')]");
    private static final By DISSAPPEARED_MAIL = By.xpath("//div[contains(text(),'Письмо отправлено.')]");


    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public void checkDraftAddressee() {
        actualText = driver.findElement(DRAFT_ADDRESSEE).getText();
    }
    public void checkDraftSubject() {
        actualText = driver.findElement(DRAFT_SUBJECT).getText();
    }
    public void checkDraftBody() {
        actualText = driver.findElement(DRAFT_BODY).getText();
    }
    public String getActualText() {
        return actualText;
    }
    public void clickDraftMail() {driver.findElement(DRAFT_MAIL).click();}
    public void clickSendMail() {driver.findElement(SEND_MAIL).click();}
    public void checkSentMail() {actualText = driver.findElement(DISSAPPEARED_MAIL).getText();}


}


