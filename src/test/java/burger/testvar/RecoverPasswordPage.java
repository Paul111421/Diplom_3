package burger.testvar;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    private final static By RECOVER_PASSWORD_PAGE_RETURN_TO_LOGIN_BUTTON = By.xpath(".//a[@href='/burger.login']");

    @Step("Нажать на кнопку входа через \"Войти\" под кнопкой \"Восстановить\" на странице восстановления пароля")
    public static void clickRecoverPasswordPageReturnToLoginButton(WebDriver driver){
        driver.findElement(RECOVER_PASSWORD_PAGE_RETURN_TO_LOGIN_BUTTON).click();
    }

}
