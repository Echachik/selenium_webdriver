package pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentPage extends AbstractPage {
   private String actualText;

    @FindBy(xpath = "//span[contains(@title,'epam.selenium@yandex.by')]")
    private WebElement sentAddressee;

    @FindBy(xpath = "//span[contains(text(),'Hello!!!')]")
    WebElement sentSubject;

    @FindBy(xpath = "//span[contains(@title,'Hello from epam.selenium@yandex.by')]")
    WebElement sentBody;

    public SentPage(WebDriver driver) { super(driver);
        PageFactory.initElements(this.driver,this);
    }
    public void checkSentAddressee() {
        actualText = sentAddressee.getText();
    }
    public void checkSentSubject() {
        actualText = sentSubject.getText();
    }
    public void checkSentBody() {
        actualText = sentBody.getText();
    }
    public String getActualText() { return actualText; }
}
