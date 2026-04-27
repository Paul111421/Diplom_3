package burger.testvar;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    private final static By ACCOUNT_EMAIL_DIV = By.xpath(".//label[text()='Логин']/parent::div/input");

    @Step("Проверить введённый при регистрации емейл с отображаемым в ЛК")
    public static void assertUserLoggedInByEmail(WebDriver driver, String email){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_EMAIL_DIV));
        String accountEmailOnAccountPage = driver.findElement(ACCOUNT_EMAIL_DIV).getAttribute("value");

        Assert.assertEquals(email, accountEmailOnAccountPage);
    }

}
