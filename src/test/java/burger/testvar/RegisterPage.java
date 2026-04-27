package burger.testvar;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private final static By REGISTER_PAGE_NAME_INPUT = By.xpath(".//label[text()='Имя']/parent::div/input");
    private final static By REGISTER_PAGE_EMAIL_INPUT = By.xpath(".//label[text()='Email']/parent::div/input");
    private final static By REGISTER_PAGE_PASSWORD_INPUT = By.xpath(".//input[@type='password']");

    private final static By REGISTER_PAGE_PASSWORD_ERROR = By.xpath(".//p[@class='input__error text_type_main-default']");

    private final static By REGISTER_PAGE_REGISTER_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final static By REGISTER_PAGE_LOGIN_BUTTON = By.xpath(".//a[@class='Auth_link__1fOlj']");


    @Step("Заполнить поле \"Имя\" на странице регистрации")
    public static void fillRegisterPageNameInput(WebDriver driver, String name){
        driver.findElement(REGISTER_PAGE_NAME_INPUT).sendKeys(name);
    }

    @Step("Заполнить поле \"Email\" на странице регистрации")
    public static void fillRegisterPageEmailInput(WebDriver driver, String email){
        driver.findElement(REGISTER_PAGE_EMAIL_INPUT).sendKeys(email);
    }

    @Step("Заполнить поле \"Пароль\" на странице регистрации")
    public static void fillRegisterPagePasswordInput(WebDriver driver, String password){
        driver.findElement(REGISTER_PAGE_PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Нажать на кнопку регистрации на странице регистрации")
    public static void clickRegisterPageRegisterButton(WebDriver driver){
        driver.findElement(REGISTER_PAGE_REGISTER_BUTTON).click();
    }

    @Step("Проверить появление сообщения об ошибке при неправильном пароле")
    public static void checkRegisterPagePasswordErrorAppearance(WebDriver driver){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(REGISTER_PAGE_PASSWORD_ERROR));
    }

    @Step("Нажать на кнопку возврата к странице логина \"Войти\" под кнопкой \"Зарегистрироваться\"")
    public static void clickRegisterPageLoginButton(WebDriver driver){
        driver.findElement(REGISTER_PAGE_LOGIN_BUTTON).click();
    }

}
