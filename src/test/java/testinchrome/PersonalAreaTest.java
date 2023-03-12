package testinchrome;

import apistellarburgers.DeleteUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import pageobject.LoginPage;
import pageobject.MainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PersonalAreaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        //драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
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