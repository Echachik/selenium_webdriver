import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pf.*;

import java.util.concurrent.TimeUnit;

public class MailTest {
    private WebDriver driver;

    @BeforeMethod(description = "Start browser")
    private void initBrowser() {
        driver = DriverSingleton.getDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test (description = "User Login")
    public  void precondition()
    {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickLoginButton();
        logInPage.fillInLoginField();
        logInPage.clickEnterButton();
        logInPage.fillInPasswordField();
        logInPage.clickEnterButtonLoginPage();

    }

    @Test(description = "Test send mail")
    public void sendMailTest() throws InterruptedException {
        precondition();
        HomePage homePage = new HomePage(driver);
        WebElement elementMailUsername = homePage.getElementMailUsername();
        Assert.assertEquals("epam.selenium", elementMailUsername.getText(), "Test user login failed");
        homePage.clickWriteMessageButton();
        WriteMessagePage writeMessagePage = new WriteMessagePage(driver);
        writeMessagePage.fillInWhomField();
        writeMessagePage.fillInSubjectField();
        writeMessagePage.clickFieldBody();
        writeMessagePage.fillInBodyArea();
        homePage.clickInboxFolder();
        writeMessagePage.clickSaveDraft();
        homePage.clickDraftFolder();
        DraftPage draftPage = new DraftPage(driver);
        draftPage.checkDraftAddressee();
        Assert.assertEquals(draftPage.getActualText(), "epam.selenium","Failed to find epam.selenium addressee");
        draftPage.checkDraftSubject();
        Assert.assertEquals(draftPage.getActualText(), "Hello!!!","Failed to find Hello!!! subject");
        draftPage.checkDraftBody();
        Assert.assertEquals(draftPage.getActualText(), "Hello from epam.selenium@yandex.by","Failed to find Hello from epam.selenium@yandex.by body");
        draftPage.clickDraftMail();
        draftPage.clickSendMail();
        draftPage.checkSentMail();
        Assert.assertEquals(draftPage.getActualText(), "Письмо отправлено.");
        homePage.clickSentFolder();
        SentPage sentPage = new SentPage(driver);
        sentPage.checkSentAddressee();
        Assert.assertEquals(sentPage.getActualText(), "epam.selenium","Failed to find epam.selenium addressee");
        sentPage.checkSentSubject();
        Assert.assertEquals(sentPage.getActualText(), "Hello!!!","Failed to find Hello!!! subject");
        sentPage.checkSentBody();
        Assert.assertEquals(sentPage.getActualText(), "Hello from epam.selenium@yandex.by","Failed to find Hello from epam.selenium@yandex.by body");

    }


    @AfterClass(description = "close browser")
    public void kill(){
        DriverSingleton.closeDriver();

    }

}
