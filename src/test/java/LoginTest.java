import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.UserCreator;

import java.util.concurrent.TimeUnit;

public class LoginTest extends CommonConditions {

    private String URL = "https://yandex.by/";
    private String fieldLogin = "//input[@id='passp-field-login']";
    private String fieldPassword = "//input[@id='passp-field-passwd']";
    private String buttonEnter = "//button[contains(@class,'control button2') and contains(@type,'submit')]";
    User testUser= UserCreator.withCredentialsFromProperty();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @Test(description = "Test user login")
    public void loginTest() {
        WebElement buttonLogin = driver.findElement(By.xpath("//a[@class='button desk-notif-card__login-enter-expanded button_theme_gray i-bem']"));
        buttonLogin.click();
        WebElement loginField = driver.findElement(By.xpath(fieldLogin));
        loginField.sendKeys(testUser.getUsername());
        WebElement enterButtonLoginPage = driver.findElement(By.xpath(buttonEnter));
        enterButtonLoginPage.click();
        WebElement passwordField = driver.findElement(By.xpath(fieldPassword));
        passwordField.sendKeys(testUser.getPassword());
        WebElement enterButtonPasswordPage = driver.findElement(By.xpath(buttonEnter));
        enterButtonPasswordPage.click();
        WebElement elementMailUsername = driver.findElement(By.xpath("//div[@class='mail-User-Name']"));
        Assert.assertEquals("epam.selenium", elementMailUsername.getText(), "Test user login failed");
    }


}
