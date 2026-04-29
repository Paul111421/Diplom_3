package burger;

import burger.testvar.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private final static String BROWSER = System.getProperty("browser", "chrome");

    public static WebDriver createDriver(){
        WebDriver driver;

        switch (BROWSER.toLowerCase()){
            case "yandex-browser":
                driver = createYandexBrowser();
                break;
            case "chrome":
                driver = createChromeBrowser();
                break;
            default:
                throw new IllegalArgumentException("Не указан нужный браузер: chrome или yandex-browser");
        }
        driver.manage().window().maximize();
        driver.get(HomePage.getBurgersUrl());
        return driver;
    }

    private static WebDriver createYandexBrowser(){

        System.setProperty("webdriver.chrome.driver","/home/vdwv/WebDriver/bin/chromedriver144.0.7559.1088-linux64/chromedriver");

        ChromeOptions yandexOptions = new ChromeOptions();
        yandexOptions.setBinary("/usr/bin/yandex-browser");

        return new ChromeDriver(yandexOptions);

    }

    private static WebDriver createChromeBrowser(){

        System.setProperty("webdriver.chrome.driver","/home/vdwv/WebDriver/bin/chromedriver148.0.7778.56-linux64/chromedriver");

        ChromeOptions yandexOptions = new ChromeOptions();
        yandexOptions.setBinary("/home/vdwv/WebDriver/chrome/chrome148.0.7778.56-linux64/chrome");

        return new ChromeDriver(yandexOptions);

    }
}
