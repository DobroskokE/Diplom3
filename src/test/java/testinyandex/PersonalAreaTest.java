package testinyandex;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class PersonalAreaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome,driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void goToPersonalAreaTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

        //Проверка заголовка Вход
        objLoginPage.enterHeaderCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}