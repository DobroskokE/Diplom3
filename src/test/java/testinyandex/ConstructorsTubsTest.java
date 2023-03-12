package testinyandex;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorsTubsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome,driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    public void bunsTubTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        //Сролл до Начинки
        objMainPage.scrollToFillings();

        //Нажать на вкладку Булки
        objMainPage.clickBunsTab();

        //Проверка наличия заголовка Булки
        objMainPage.bunsHeaderCheck();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void saucesTubTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        //Нажать на вкладку Начинки
        objMainPage.clickSaucesTab();

        //Проверка наличия заголовка Булки
        objMainPage.saucesHeaderCheck();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    public void fillingsTubTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        //Нажать на вкладку Начинки
        objMainPage.clickFillingsTab();

        //Проверка наличия заголовка Булки
        objMainPage.fillingsHeaderCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}