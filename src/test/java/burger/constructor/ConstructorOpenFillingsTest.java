package burger.constructor;

import burger.testvar.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


//Проверка открытия вкладки "Начинки"
//Шаги
//1. Открыть страницу бургерной
//2. Нажать на вкладку "Начинки"
//3. Удостовериться в появлении заголовка "Начинки"

@RunWith(Parameterized.class)
public class ConstructorOpenFillingsTest extends ConstructorBaseTest{

    public ConstructorOpenFillingsTest(String browserName){
        super(browserName);
    }

    @Parameterized.Parameters (name = "{0}")
    public static Object[][] getConstructorOpenFillingsTestData(){
        return new Object[][]{
                {"chrome"},
                {"yandex-browser"},
        };
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    @Description("Проверить переход на вкладку Начинки при нажатии на оную с другой вкладки")
    public void constructorOpenFillingsTest(){

        HomePage.clickConstructorFillingsButton(driver);
        HomePage.assertConstructorFillingsHeaderVisible(driver);

    }
}

