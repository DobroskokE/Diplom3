package testinyandex;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private WebDriver driver;

    Faker faker = new Faker();
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();
    String wrongPassword = "12345";
    String randomName = faker.name().username();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome,driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void successfulRegistrationTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // кликни на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

        //Нажать кнопку "Зарегистрироваться"
        objLoginPage.clickRegistrationButton();

        //объект класса перехода на страницу регистрация
        RegisterPage objRegisterPage = new RegisterPage(driver);

        //заполнить поле Имя
        objRegisterPage.setNameField(randomName);

        //заполнить поле email
        objRegisterPage.setEmailField(randomEmail);

        //заполнить поле Пароль
        objRegisterPage.setPasswordField(randomPassword);

        //Нажать на кнопку "Зарегистрироваться"
        objRegisterPage.clickRegistrationButton();

        // проверь, что заголовок Вход активен
        objLoginPage.enterHeaderCheck();
    }

    @Test
    @DisplayName("Проверка контроля неверного пароля")
    public void wrongPasswordTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

        //Нажать кнопку "Зарегистрироваться"
        objLoginPage.clickRegistrationButton();

        //объект класса перехода на страницу регистрация
        RegisterPage objRegisterPage = new RegisterPage(driver);

        //заполнить поле Имя
        objRegisterPage.setNameField(randomName);

        //заполнить поле email
        objRegisterPage.setEmailField(randomEmail);

        //заполнить поле Пароль
        objRegisterPage.setPasswordField(wrongPassword);

        //Нажать на кнопку "Зарегистрироваться"
        objRegisterPage.clickRegistrationButton();

        // проверь, что заголовок Вход активен
        objRegisterPage.wrongPasswordMessageCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
