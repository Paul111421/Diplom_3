package burger.register;

import burger.UserTestValues;
import burger.testvar.HomePage;
import burger.testvar.LoginPage;
import burger.testvar.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

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


public class RegisterInvalidPasswordTest extends RegisterBaseTest {
    private final String name = UserTestValues.nameHank;
    private final String email = UserTestValues.emailHank;
    private final String password = UserTestValues.invalidPasswordHank5symbols;

    @Test
    @DisplayName("Проверка невозможности создания профиля пользователя при пароле меньше 6 символов")
    @Description("Проверить возможность создания пользователем нового профиль через интерфейс веб-приложения")
    public void registerSuccessTest(){

        HomePage.clickHeaderAccountButton(driver);

        LoginPage.clickLoginPageRegisterButton(driver);

        RegisterPage.fillRegisterPageNameInput(driver, name);
        RegisterPage.fillRegisterPageEmailInput(driver, email);
        RegisterPage.fillRegisterPagePasswordInput(driver, password);
        RegisterPage.clickRegisterPageRegisterButton(driver);
        RegisterPage.checkRegisterPagePasswordErrorAppearance(driver);


    }
}
