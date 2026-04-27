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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginBaseTest {

    private UserCard userHank;
    public WebDriver driver;
    private final String browserName;
    public LoginBaseTest(String browserName){
        this.browserName = browserName;
    }

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
        if("yandex-browser".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","/home/vdwv/WebDriver/bin/chromedriver144.0.7559.1088-linux64/chromedriver");
            ChromeOptions yandexOptions = new ChromeOptions();
            yandexOptions.setBinary("/usr/bin/yandex-browser");
            driver = new ChromeDriver(yandexOptions);
        } else if ("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","/home/vdwv/WebDriver/bin/chromedriver148.0.7778.56-linux64/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("/home/vdwv/WebDriver/chrome/chrome148.0.7778.56-linux64/chrome");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(HomePage.getBurgersUrl());
        userHank = UserTestValues.userHankEmailPass7symbols;

        Response responseCreateHank = UserApi.createUniqueUser(userHank);
        UserApi.createUniqueUser200(responseCreateHank);
    }

    @After
    public void teardown(){
        UserApi.deleteUserInBurgerTest(userHank);
        driver.quit();
    }
}
