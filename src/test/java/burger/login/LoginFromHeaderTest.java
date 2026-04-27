package burger.login;

import burger.UserTestValues;
import burger.testvar.AccountPage;
import burger.testvar.HomePage;
import burger.testvar.LoginPage;
import burger.testvar.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

//Проверка логина через кнопку в шапке сайта
//
//Предусловия
//- создать профиль до запуска теста (прописано в базовом тесте)
//Шаги:
//1. Нажать на кнопку входа в аккаунт в шапке профиля ("Личный кабинет")
//2. Ввести данные в поля Email и Пароль
//3.

@RunWith(Parameterized.class)
public class LoginFromHeaderTest extends LoginBaseTest{

    private final String name;
    private final String email;
    private final String password;


    public LoginFromHeaderTest(String browserName, String name, String email, String password) {
        super(browserName);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters (name = "{0}")
    public static Object[][] getRegisterSuccessTestData(){
        return new Object[][]{
                {"chrome", UserTestValues.nameHank, UserTestValues.emailHank, UserTestValues.passwordHank7symbols},
                {"yandex-browser", UserTestValues.nameHank, UserTestValues.emailHank, UserTestValues.passwordHank7symbols}
        };
    }

    @Test
    @DisplayName("Проверка возможности создания профиля пользователя")
    @Description("Проверить возможность создания пользователем нового профиль через интерфейс веб-приложения")
    public void registerSuccessTest(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HomePage.clickHeaderAccountButton(driver);

        LoginPage.clickLoginPageRegisterButton(driver);

        RegisterPage.fillRegisterPageNameInput(driver, name);
        RegisterPage.fillRegisterPageEmailInput(driver, email);
        RegisterPage.fillRegisterPagePasswordInput(driver, password);
        RegisterPage.clickRegisterPageRegisterButton(driver);

        LoginPage.clickLoginPageEmailInput(driver);
        LoginPage.fillLoginPageEmailInput(driver, email);
        LoginPage.fillLoginPagePasswordInput(driver, password);
        LoginPage.clickLoginPageLoginButton(driver);

        HomePage.clickHeaderAccountButton(driver);
        AccountPage.assertUserLoggedInByEmail(driver, email);

    }
}
