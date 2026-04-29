package burger.login;

import burger.UserTestValues;
import burger.testvar.AccountPage;
import burger.testvar.HomePage;
import burger.testvar.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

//Проверка логина через кнопку в Конструкторе\Домашней странице
//
//Предусловия
//- создать профиль до запуска теста (прописано в базовом тесте)
//Шаги:
//1. Нажать на кнопку входа в аккаунт в Конструкторе\Домашней странице
//2. Ввести данные в поля Email и Пароль
//3. Войти в личный кабинет
//4. Сверить показываемый в ЛК Email и введённый

public class LoginFromHomePageButtonTest extends LoginBaseTest{

    private final String email = UserTestValues.emailHank;
    private final String password = UserTestValues.passwordHank7symbols;

    @Test
    @DisplayName("Проверка возможности логина пользователя через кнопку Войти в аккаунт в Конструкторе")
    @Description("Проверить возможность логина пользователя в систему через кнопку Войти в аккаунт в Конструкторе")
    public void loginFromHomePageButtonTest(){

        HomePage.clickConstructorLoginButton(driver);

        //Вводим данные существующего пользователя
        LoginPage.clickLoginPageEmailInput(driver);
        LoginPage.fillLoginPageEmailInput(driver, email);
        LoginPage.fillLoginPagePasswordInput(driver, password);
        LoginPage.clickLoginPageLoginButton(driver);

        HomePage.clickHeaderAccountButton(driver);
        AccountPage.assertUserLoggedInByEmail(driver, email);

    }
}
