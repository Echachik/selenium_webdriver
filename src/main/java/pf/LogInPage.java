package pf;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@data-statlog,'login.big')]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='passp-field-login']")
    WebElement loginField;

    @FindBy(xpath = "//button[contains(@class,'control button2') and contains(@type,'submit')]")
   WebElement enterButton;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
   WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class,'control button2') and contains(@type,'submit')]")
     WebElement enterButtonLoginPage;

    public LogInPage(WebDriver driver) { super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickLoginButton() {loginButton.click();}
    public void fillInLoginField() {loginField.sendKeys("epam.selenium@yandex.by");}
    public void clickEnterButton() {enterButton.click();}
    public void fillInPasswordField() {passwordField.sendKeys( "selenium123");}
    public void clickEnterButtonLoginPage() {enterButtonLoginPage.click();}
}
