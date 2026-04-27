package testvar;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final static String BURGERS_URL = "https://stellarburgers.education-services.ru/";

    //Кнопки шапки
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//a[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']");
    private final static By HEADER_ORDER_QUEUE_BUTTON = By.xpath(".//li[@class='undefined ml-2']/a[@class='AppHeader_header__link__3D_hX']");
    private final static By HEADER_HOMEPAGE_BUTTON = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final static By HEADER_ACCOUNT_BUTTON = By.xpath(".//nav[@class='AppHeader_header__nav__g5hnF']/a[@class='AppHeader_header__link__3D_hX']");

    //Кнопки Конструктора - он открывается как домашняя страница

    //Кнопки разделов Конструктора
    private final static By CONSTRUCTOR_BUNS_BUTTON = By.xpath(".//span[text()='Булки']");
    private final static By CONSTRUCTOR_SAUCES_BUTTON = By.xpath(".//span[text()='Соусы']");
    private final static By CONSTRUCTOR_FILLINGS_BUTTON = By.xpath(".//span[text()='Начинки']");

    //Кнопка входа в аккаунт на странице Конструктора\главной
    private final static By CONSTRUCTOR_LOGIN_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    public static String getBurgersUrl(){
        return BURGERS_URL;
    }

    public static void clickHeaderConstructerButton(WebDriver driver){
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
    }

    public static void clickHeaderOrderQueueButton(WebDriver driver){
        driver.findElement(HEADER_ORDER_QUEUE_BUTTON).click();
    }

    public static void clickHeaderHomePageButton(WebDriver driver){
        driver.findElement(HEADER_HOMEPAGE_BUTTON).click();
    }

    public static void clickHeaderAccountButton(WebDriver driver){
        driver.findElement(HEADER_ACCOUNT_BUTTON).click();
    }

    public static void clickConstructorBunsButton(WebDriver driver){
        driver.findElement(CONSTRUCTOR_BUNS_BUTTON).click();
    }

    public static void clickConstructorSaucesButton(WebDriver driver){
        driver.findElement(CONSTRUCTOR_SAUCES_BUTTON).click();
    }

    public static void clickConstructorFillingsButton(WebDriver driver){
        driver.findElement(CONSTRUCTOR_FILLINGS_BUTTON).click();
    }

    public static void clickConstructorLoginButton(WebDriver driver){
        driver.findElement(CONSTRUCTOR_LOGIN_BUTTON).click();
    }




}

