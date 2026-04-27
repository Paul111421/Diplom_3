package testvar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    private final static By RECOVER_PASSWORD_PAGE_RETURN_TO_LOGIN_BUTTON = By.xpath(".//a[@href='/login']");

    public static void clickRecoverPasswordPageReturnToLoginButton(WebDriver driver){
        driver.findElement(RECOVER_PASSWORD_PAGE_RETURN_TO_LOGIN_BUTTON).click();
    }

}
