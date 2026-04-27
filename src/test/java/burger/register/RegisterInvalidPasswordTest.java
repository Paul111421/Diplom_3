package burger.register;


import burger.BurgersBaseTest;
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

//Проверка невозможности зарегистрироваться при пароле меньше 6 символов
//Проверить классы эквивалентности и пограничные значения:
//- меньше 6 - провал (5)
//- 6 - успех (уже проверено в RegisterSuccessTest)
//- больше 6 - успех (уже проверено в RegisterSuccessTest)

//Шаги:
//1. Нажать на кнопку входа в аккаунт (в данном тесте через ЛК)
//2. Нажать на кнопку "Зарегистрироваться"
//3. Заполнить поля, имя любое, емейл любой, пароль на 5 символов
//4. Нажать на кнопку "Зарегистрироваться"
//5. Войти в систему

@RunWith(Parameterized.class)
public class RegisterInvalidPasswordTest extends BurgersBaseTest {
    private final String name;
    private final String email;
    private final String password;


    public RegisterInvalidPasswordTest(String browserName, String name, String email, String password) {
        super(browserName);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters (name = "{0},{3}")
    public static Object[][] getRegisterSuccessTestData(){
        return new Object[][]{
                {"chrome", UserTestValues.nameHank, UserTestValues.emailHank, UserTestValues.invalidPasswordHank5symbols},

                {"yandex-browser", UserTestValues.nameHank, UserTestValues.emailHank, UserTestValues.invalidPasswordHank5symbols}
        };
    }

    @Test
    @DisplayName("Проверка невозможности создания профиля пользователя при пароле меньше 6 символов")
    @Description("Проверить возможность создания пользователем нового профиль через интерфейс веб-приложения")
    public void registerSuccessTest(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HomePage.clickHeaderAccountButton(driver);

        LoginPage.clickLoginPageRegisterButton(driver);

        RegisterPage.fillRegisterPageNameInput(driver, name);
        RegisterPage.fillRegisterPageEmailInput(driver, email);
        RegisterPage.fillRegisterPagePasswordInput(driver, password);
        RegisterPage.clickRegisterPageRegisterButton(driver);
        RegisterPage.checkRegisterPagePasswordErrorAppearance(driver);


    }
}
