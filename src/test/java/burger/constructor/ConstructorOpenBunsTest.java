package burger.constructor;

import burger.testvar.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


//Проверка открытия вкладки "Булки"
//Шаги
//1. Открыть страницу бургерной
//2. Нажать на вкладку "Начинки"
//3. Удостовериться в появлении заголовка "Начинки"
//4. Нажать на вкладку "Булки"
//5. Удостовериться в появлении заголовка "Булки"

public class ConstructorOpenBunsTest extends ConstructorBaseTest{

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    @Description("Проверить переход на вкладку Булки при нажатии на оную с другой вкладки")
    public void constructorOpenBunsTest(){

        HomePage.clickConstructorFillingsButton(driver);
        HomePage.assertConstructorFillingsHeaderVisible(driver);

        HomePage.clickConstructorBunsButton(driver);
        HomePage.assertConstructorBunsHeaderVisible(driver);

    }
}
