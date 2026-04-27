package burger.testvar;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final static By LOGIN_PAGE_EMAIL_INPUT = By.xpath(".//div/input[@type='text']");
    private final static By LOGIN_PAGE_PASSWORD_INPUT = By.xpath(".//input[@type='password']");

    private final static By LOGIN_PAGE_LOGIN_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private final static By LOGIN_PAGE_REGISTER_BUTTON = By.xpath(".//a[@href='/register']");
    private final static By LOGIN_PAGE_RECOVER_PASSWORD_BUTTON = By.xpath(".//a[@href='/forgot-password']");

    @Step("Удостовериться в появлении поля ввода почты нажатием")
    public static void clickLoginPageEmailInput(WebDriver driver){
        //Заметил странную вещь - Селениум моментально прям кликает по странице, не ожидая перехода. Намеренная заглушка для гарантии перехода на нужную страницу
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.education-services.ru/login"));
        driver.findElement(LOGIN_PAGE_EMAIL_INPUT).click();
    }

    @Step("Заполнить поле Почта на странице логина")
    public static void fillLoginPageEmailInput(WebDriver driver, String email){
        driver.findElement(LOGIN_PAGE_EMAIL_INPUT).click();
        driver.findElement(LOGIN_PAGE_EMAIL_INPUT).sendKeys(email);
    }

    @Step("Заполнить поле Пароль на странице логина")
    public static void fillLoginPagePasswordInput(WebDriver driver, String password){
        driver.findElement(LOGIN_PAGE_PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Нажать на кнопку авторизации на странице логина")
    public static void clickLoginPageLoginButton(WebDriver driver){
        driver.findElement(LOGIN_PAGE_LOGIN_BUTTON).click();
    }

    @Step("Нажать на кнопку регистрации на странице логина")
    public static void clickLoginPageRegisterButton(WebDriver driver){
        driver.findElement(LOGIN_PAGE_REGISTER_BUTTON).click();
    }

    @Step("Нажать на кнопку восстановления пароля на странице логина")
    public static void clickLoginPageRecoverPasswordButton(WebDriver driver){
        driver.findElement(LOGIN_PAGE_RECOVER_PASSWORD_BUTTON).click();
    }

}
