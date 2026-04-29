package burger.login;

import burger.UserApi;
import burger.UserCard;
import burger.UserTestValues;
import burger.testvar.HomePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import burger.WebDriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class LoginBaseTest {

    private UserCard userHank;
    public WebDriver driver;

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";

        driver = WebDriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(HomePage.getBurgersUrl());

        userHank = UserTestValues.validUserHank7symbols;

        Response responseCreateHank = UserApi.createUniqueUser(userHank);
        UserApi.createUniqueUser200(responseCreateHank);
    }

    @After
    public void teardown(){
        driver.quit();
        UserApi.deleteUserInBurgerTest(userHank);
    }
}
