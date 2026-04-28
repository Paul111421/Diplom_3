package burger.register;

import burger.UserApi;
import burger.UserCard;
import burger.UserTestValues;
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
    private final String browserName;
    public RegisterBaseTest(String browserName){
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
