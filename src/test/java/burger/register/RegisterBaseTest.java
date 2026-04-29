package burger.register;

import burger.UserApi;
import burger.UserCard;
import burger.UserTestValues;
import burger.WebDriverFactory;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import burger.testvar.HomePage;

public class RegisterBaseTest {

    private UserCard userHank6symbols;
    private UserCard userHank7symbols;
    public WebDriver driver;

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";

        driver = WebDriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(HomePage.getBurgersUrl());

        userHank6symbols = UserTestValues.userHankEmailPass6symbols;
        userHank7symbols = UserTestValues.userHankEmailPass7symbols;
    }

    @After
    public void teardown(){
        driver.quit();
        UserApi.deleteUserInBurgerTest(userHank6symbols);
        UserApi.deleteUserInBurgerTest(userHank7symbols);
    }
}
