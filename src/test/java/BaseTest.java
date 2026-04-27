import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testvar.HomePage;

public class BaseTest {

    public WebDriver driver;
    private final String browserName;
    public BaseTest(String browserName){
        this.browserName = browserName;
    }

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        if("yandex-browser".equals(browserName)){
            ChromeOptions yandexOptions = new ChromeOptions();
            yandexOptions.setBinary("/usr/bin/yandex-browser");
            driver = new ChromeDriver(yandexOptions);
        } else if ("chrome".equals(browserName)){
            ChromeOptions chromiumOptions = new ChromeOptions();
            chromiumOptions.setBinary("/usr/bin/google-chrome-stable");
            driver = new ChromeDriver(chromiumOptions);
        }
        driver.manage().window().maximize();
        driver.get(HomePage.getBurgersUrl());

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
