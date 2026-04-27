package testvar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final static By REGISTER_PAGE_NAME_INPUT = By.xpath(".//label[text()='Имя']/parent::div");
    private final static By REGISTER_PAGE_EMAIL_INPUT = By.xpath(".//label[text()='Email']/parent::div");
    private final static By REGISTER_PAGE_PASSWORD_INPUT = By.xpath(".//label[text()='Пароль']/parent::div");

    private final static By REGISTER_PAGE_REGISTER_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final static By REGISTER_PAGE_LOGIN_BUTTON = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public static void fillRegisterPageNameInput(WebDriver driver, String name){
        driver.findElement(REGISTER_PAGE_NAME_INPUT).sendKeys(name);
    }

    public static void fillRegisterPageEmailInput(WebDriver driver, String email){
        driver.findElement(REGISTER_PAGE_EMAIL_INPUT).sendKeys(email);
    }

    public static void fillRegisterPagePasswordInput(WebDriver driver, String password){
        driver.findElement(REGISTER_PAGE_PASSWORD_INPUT).sendKeys(password);
    }

    public static void clickRegisterPageRegisterButton(WebDriver driver){
        driver.findElement(REGISTER_PAGE_REGISTER_BUTTON).click();
    }

    public static void clickRegisterPageLoginButton(WebDriver driver){
        driver.findElement(REGISTER_PAGE_LOGIN_BUTTON).click();
    }

}
