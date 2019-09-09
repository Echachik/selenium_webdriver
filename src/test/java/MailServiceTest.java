import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailServiceTest {

    private WebDriver driver;
    private String URL = "https://yandex.by/";
    private String login = "epam.selenium@yandex.by";
    private String password = "selenium123";
    private String fieldLogin = "//input[@id='passp-field-login']";
    private String fieldPassword = "//input[@id='passp-field-passwd']";
    private String buttonEnter = "//button[contains(@class,'control button2') and contains(@type,'submit')]";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @Test(description = "Test user login")
    public void loginTest() {
        WebElement buttonLogin = driver.findElement(By.xpath("//a[@class='button desk-notif-card__login-enter-expanded button_theme_gray i-bem']"));
        buttonLogin.click();
        WebElement loginField = driver.findElement(By.xpath(fieldLogin));
        loginField.sendKeys(login);
        WebElement enterButtonLoginPage = driver.findElement(By.xpath(buttonEnter));
        enterButtonLoginPage.click();
        WebElement passwordField = driver.findElement(By.xpath(fieldPassword));
        passwordField.sendKeys(password);
        WebElement enterButtonPasswordPage = driver.findElement(By.xpath(buttonEnter));
        enterButtonPasswordPage.click();
        WebElement elementMailUsername = driver.findElement(By.xpath("//div[@class='mail-User-Name']"));
        Assert.assertEquals("epam.selenium", elementMailUsername.getText(), "Test user login failed");
    }


    @Test(description = "Test send mail")
    public void sendMailTest() throws InterruptedException {
        loginTest();
        WebElement buttonWriteMessage = driver.findElement(By.xpath("//span[@class='mail-ComposeButton-Text']"));
        buttonWriteMessage.click();
        WebElement inputFieldWhom = driver.findElement(By.xpath("//div[@name='to']"));
        inputFieldWhom.sendKeys("epam.selenium@yandex.by");

        WebElement inputFieldSubject = driver.findElement(By.xpath("//input[contains(@class,'mail-Compose-Field-Input-Controller')]"));
        inputFieldSubject.sendKeys("Hello!!!");

        WebElement inputFieldBody = driver.findElement(By.xpath("//*[contains(@class,'cke_source cke_reset cke_enable_context_menu cke_editable')]"));
        inputFieldBody.click();
        WebElement bodyTextArea = driver.findElement(By.xpath("//textarea[contains(@class,'enable_context_menu')]"));
        bodyTextArea.sendKeys("Hello from epam.selenium@yandex.by");

        WebElement inboxFolder = driver.findElement(By.xpath("(//span[@class='mail-NestedList-Item-Name'])[1]"));
        inboxFolder.click();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement popWindow = driver.findElement(By.xpath("//button[contains(@class,'action-button') and contains(@data-action, 'save')]"));
        popWindow.click();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        draftFolder();

        Thread.sleep(2000);

        addresseeElement();

        subjectElement();

        bodyElement();

        WebElement draftMail = driver.findElement(By.xpath("//span[contains(text(),'epam.selenium@yandex.by')]"));
        draftMail.click();

        WebElement sendMail = driver.findElement(By.xpath("//button[contains(@class,'send') and contains(@type,'submit')]"));
        sendMail.click();

        draftFolder();

        WebElement disappearedDraftMail= driver.findElement(By.xpath("//div[contains(@class,'ns-view-messages-empty')]"));
        disappearedDraftMail.getText();

        WebElement sendFolder = driver.findElement(By.xpath("(//span[@class='mail-NestedList-Item-Name'])[2]"));
        sendFolder.click();

        addresseeElement();

        subjectElement();

        bodyElement();

        WebElement mailUser = driver.findElement(By.xpath("//span[contains(@class,'mail-User-Avatar')]"));
        mailUser.click();

//        WebElement signOut = driver.findElement(By.cssSelector("#nb-5 > div > div > div:nth-child(7) > a"));
//        signOut.click();

    }

    public void draftFolder(){
        WebElement draft = driver.findElement(By.xpath("(//span[@class='mail-NestedList-Item-Name'])[5]"));
        draft.click();
    }

    public void addresseeElement(){
        WebElement draftAddressee = driver.findElement(By.xpath("//span[contains(@title,'epam.selenium@yandex.by')]"));
        Assert.assertEquals(draftAddressee.getText(),"epam.selenium", "Failed to find epam.selenium addressee");
    }

    public void subjectElement() {
        WebElement draftSubject = driver.findElement(By.xpath("//span[contains(text(),'Hello!!!')]"));
        Assert.assertEquals(draftSubject.getText(), "Hello!!!", "Failed to find Hello!!! subject");
    }

    public void bodyElement() {
        WebElement draftBody = driver.findElement(By.xpath("//span[contains(@title,'Hello from epam.selenium@yandex.by')]"));
        Assert.assertEquals(draftBody.getText(),"Hello from epam.selenium@yandex.by", "Failed to find Hello from epam.selenium@yandex.by body");
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
    }
