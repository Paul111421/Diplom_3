package burger.register;

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

//Проверка регистрации в системе
//
//Шаги:
//1. Нажать на кнопку входа в аккаунт (в данном тесте через ЛК)
//2. Нажать на кнопку "Зарегистрироваться"
//3. Заполнить поля, имя любое, емейл любой, пароль более 6 символов
//4. Нажать на кнопку "Зарегистрироваться"
//5. Войти в систему

@RunWith(Parameterized.class)
public class RegisterSuccessTest extends RegisterBaseTest {

    private final String name = UserTestValues.nameHank;
    private final String email = UserTestValues.emailHank;
    private final String password;


    public RegisterSuccessTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters (name = "{0}")
    public static Object[][] getRegisterSuccessTestData(){
        return new Object[][]{
                {UserTestValues.passwordHank6symbols},
                {UserTestValues.passwordHank7symbols},
        };
    }

    @Test
    @DisplayName("Проверка возможности создания профиля пользователя")
    @Description("Проверить возможность создания пользователем нового профиль через интерфейс веб-приложения")
    public void registerSuccessTest(){

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
