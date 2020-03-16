package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends AbstractPage{
    private static final By LOGIN_BUTTON = By.xpath("//*[contains(@data-statlog,'login.big')]");
    private static final By LOGIN_FIELD = By.xpath("//input[@id='passp-field-login']");
    private static final By ENTER_BUTTON = By.xpath("//button[contains(@class,'control button2') and contains(@type,'submit')]");
    private static final By PASSWORD_FIELD = By.xpath("//input[@id='passp-field-passwd']");
    private static final By ENTER_BUTTON_LOGIN_PAGE = By.xpath("//button[contains(@class,'control button2') and contains(@type,'submit')]");

    public LogInPage(WebDriver driver) { super(driver); }

    public void clickLoginButton() {driver.findElement(LOGIN_BUTTON).click();}
    public void fillInLoginField() {driver.findElement(LOGIN_FIELD).sendKeys("epam.selenium@yandex.by");}
    public void clickEnterButton() {driver.findElement(ENTER_BUTTON).click();}
    public void fillInPasswordField() {driver.findElement(PASSWORD_FIELD).sendKeys( "selenium123");}
    public void clickEnterButtonLoginPage() {driver.findElement(ENTER_BUTTON_LOGIN_PAGE).click();}
}
