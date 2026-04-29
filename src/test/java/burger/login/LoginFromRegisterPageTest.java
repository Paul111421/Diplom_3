package burger.login;

import burger.UserTestValues;
import burger.testvar.AccountPage;
import burger.testvar.HomePage;
import burger.testvar.LoginPage;
import burger.testvar.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

//Проверка логина через кнопку со страницы регистрации
//
//Предусловия
//- создать профиль до запуска теста (прописано в базовом тесте)
//Шаги:
//1. Нажать на кнопку входа в аккаунт в шапке профиля ("Личный кабинет")
//2. Нажать на "Зарегистрироваться"
//3. На странице регистрации нажать "Войти"
//4. Ввести данные в поля Email и Пароль
//5. Войти в личный кабинет
//6. Сверить показываемый в ЛК Email и введённый

public class LoginFromRegisterPageTest extends LoginBaseTest {

    private final String email = UserTestValues.emailHank;
    private final String password = UserTestValues.passwordHank7symbols;

    @Test
    @DisplayName("Проверка возможности логина пользователя через кнопку Войти в аккаунт на странице Регистрации")
    @Description("Проверить возможность логина пользователя через кнопку Войти, расположенную под кнопкой Зарегистрироваться на странице Регистрации")
    public void loginFromRegisterPageTest(){

        HomePage.clickHeaderAccountButton(driver);
        LoginPage.clickLoginPageRegisterButton(driver);
        RegisterPage.clickRegisterPageLoginButton(driver);

        //Вводим данные существующего пользователя
        LoginPage.clickLoginPageEmailInput(driver);
        LoginPage.fillLoginPageEmailInput(driver, email);
        LoginPage.fillLoginPagePasswordInput(driver, password);
        LoginPage.clickLoginPageLoginButton(driver);

        HomePage.clickHeaderAccountButton(driver);
        AccountPage.assertUserLoggedInByEmail(driver, email);

    }
}

