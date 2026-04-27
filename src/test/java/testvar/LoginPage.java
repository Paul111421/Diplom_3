package testvar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final By LOGIN_PAGE_EMAIL_INPUT = By.xpath(".//input[@type='text']");
    private static final By LOGIN_PAGE_PASSWORD_INPUT = By.xpath(".//input[@type='password']");

    private static final By LOGIN_PAGE_LOGIN_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private static final By LOGIN_PAGE_REGISTER_BUTTON = By.xpath(".//a[@href='/register']");
    private static final By LOGIN_PAGE_RECOVER_PASSWORD_BUTTON = By.xpath(".//a[@href='/forgot-password']");

    public static void fillLoginPageEmailInput(WebDriver driver, String email){
        driver.findElement(LOGIN_PAGE_EMAIL_INPUT).sendKeys(email);
    }

    public static void fillLoginPagePasswordInput(WebDriver driver, String password){
        driver.findElement(LOGIN_PAGE_PASSWORD_INPUT).sendKeys(password);
    }

    public static void clickLoginPageLoginButton(WebDriver driver){
        driver.findElement(LOGIN_PAGE_LOGIN_BUTTON).click();
    }

    public static void clickLoginPageRegisterButton(WebDriver driver){
        driver.findElement(LOGIN_PAGE_REGISTER_BUTTON).click();
    }

    public static void clickLoginPageRecoverPasswordButton(WebDriver driver){
        driver.findElement(LOGIN_PAGE_RECOVER_PASSWORD_BUTTON).click();
    }

}
