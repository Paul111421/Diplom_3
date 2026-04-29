package burger.constructor;

import burger.UserApi;
import burger.UserCard;
import burger.UserTestValues;
import burger.WebDriverFactory;
import burger.testvar.HomePage;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConstructorBaseTest {

    public WebDriver driver;


    @Before
    public void setUp(){

        RestAssured.baseURI = "https://stellarburgers.education-services.ru";

        driver = WebDriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(HomePage.getBurgersUrl());
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
