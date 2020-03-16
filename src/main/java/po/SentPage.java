package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentPage extends AbstractPage {
    private static final By SENT_ADDRESSEE = By.xpath("//span[contains(@title,'epam.selenium@yandex.by')]");
    private static final By SENT_SUBJECT = By.xpath("//span[contains(text(),'Hello!!!')]");
    private static final By SENT_BODY = By.xpath("//span[contains(@title,'Hello from epam.selenium@yandex.by')]");
    private String actualText;

    public SentPage(WebDriver driver) {
        super(driver);
    }
    public void checkSentAddressee() {
        actualText = driver.findElement(SENT_ADDRESSEE).getText();
    }
    public void checkSentSubject() {
        actualText = driver.findElement(SENT_SUBJECT).getText();
    }
    public void checkSentBody() {
        actualText = driver.findElement(SENT_BODY).getText();
    }
    public String getActualText() { return actualText; }
}
