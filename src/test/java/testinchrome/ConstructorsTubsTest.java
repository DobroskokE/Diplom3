package testinchrome;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import pageobject.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static property.Property.*;

public class ConstructorsTubsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome,driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    public void bunsTubTest() {
        // перешли на страницу тестового приложения
        driver.get(url);

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
        driver.get(url);

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
        driver.get(url);

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