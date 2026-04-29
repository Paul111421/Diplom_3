package burger.login;


import burger.UserTestValues;
import burger.testvar.AccountPage;
import burger.testvar.HomePage;
import burger.testvar.LoginPage;
import burger.testvar.RecoverPasswordPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

//Проверка логина через кнопку со страницы восстановления пароля
//
//Предусловия
//- создать профиль до запуска теста (прописано в базовом тесте)
//Шаги:
//1. Нажать на кнопку входа в аккаунт в шапке профиля ("Личный кабинет")
//2. Нажать на "Восстановить пароль"
//3. На странице восстановления пароля нажать "Войти"
//4. Ввести данные в поля Email и Пароль
//5. Войти в личный кабинет
//6. Сверить показываемый в ЛК Email и введённый

public class LoginFromRecoverPasswordPageTest extends LoginBaseTest{

    private final String email = UserTestValues.emailHank;
    private final String password = UserTestValues.passwordHank7symbols;

    @Test
    @DisplayName("Проверка возможности логина пользователя через кнопку Войти на странице Восстановление пароля")
    @Description("Проверить возможность логина пользователя через кнопку Войти под кнопкой Восстановить на странице Восстановление пароля")
    public void loginFromRecoverPasswordPageTest(){

        HomePage.clickHeaderAccountButton(driver);
        LoginPage.clickLoginPageRecoverPasswordButton(driver);
        RecoverPasswordPage.clickRecoverPasswordPageReturnToLoginButton(driver);

        //Вводим данные существующего пользователя
        LoginPage.clickLoginPageEmailInput(driver);
        LoginPage.fillLoginPageEmailInput(driver, email);
        LoginPage.fillLoginPagePasswordInput(driver, password);
        LoginPage.clickLoginPageLoginButton(driver);

        HomePage.clickHeaderAccountButton(driver);
        AccountPage.assertUserLoggedInByEmail(driver, email);

    }
}

