package burger.constructor;

import burger.testvar.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

//Проверка открытия вкладки "Соусы"
//Шаги
//1. Открыть страницу бургерной
//2. Нажать на вкладку "Начинки"
//3. Удостовериться в появлении заголовка "Начинки"
//4. Нажать на вкладку "Соусы"
//5. Удостовериться в появлении заголовка "Соусы"

public class ConstructorOpenSaucesTest extends ConstructorBaseTest{

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    @Description("Проверить переход на вкладку Соусы при нажатии на оную с другой вкладки")
    public void constructorOpenSaucesTest(){

        HomePage.clickConstructorFillingsButton(driver);
        HomePage.assertConstructorFillingsHeaderVisible(driver);

        HomePage.clickConstructorSaucesButton(driver);
        HomePage.assertConstructorSaucesHeaderVisible(driver);

    }
}

