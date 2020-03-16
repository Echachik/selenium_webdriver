package pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DraftPage extends AbstractPage {

    private String actualText;

    @FindBy(xpath = "//span[contains(@title,'epam.selenium@yandex.by')]")
    private WebElement drafrtAddressee;

    @FindBy(xpath = "//span[contains(text(),'Hello!!!')]")
    WebElement draftSubject;

    @FindBy(xpath = "//span[contains(@title,'Hello from epam.selenium@yandex.by')]")
    WebElement draftBody;

    @FindBy(xpath = "//span[contains(text(),'epam.selenium@yandex.by')]")
    WebElement draftMail;

    @FindBy(xpath = "//button[contains(@class,'send') and contains(@type,'submit')]")
    WebElement sentMail;

    @FindBy(xpath = "//div[contains(text(),'Письмо отправлено.')]")
    WebElement dissappearedMail;

    public DraftPage(WebDriver driver) { super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void checkDraftAddressee() {
        actualText = drafrtAddressee.getText();
    }
    public void checkDraftSubject() {
        actualText = draftSubject.getText();
    }
    public void checkDraftBody() {
        actualText = draftBody.getText();
    }
    public String getActualText() {
        return actualText;
    }
    public void clickDraftMail() {draftMail.click();}
    public void clickSendMail() {sentMail.click();}
    public void checkSentMail() {actualText = dissappearedMail.getText();}


}


