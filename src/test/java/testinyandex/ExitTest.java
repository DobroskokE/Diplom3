package testinyandex;

import apistellarburgers.CreateUser;
import apistellarburgers.DeleteUser;
import apistellarburgers.User;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.AccountProfilePage;
import pageobject.ForgotPassword;
import pageobject.LoginPage;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class ExitTest {
    private WebDriver driver;
    Faker faker = new Faker();
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();
    String randomName = faker.name().username();
    User user = new User(randomEmail, randomPassword, randomName);
    String token = CreateUser.createUser(user).jsonPath().getString("accessToken");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome,driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void loginFromRecoverPasswordTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

        //клик на кнопку Восстановить пароль
        objLoginPage.clickRecoverPasswordButton();

        //объект класса перехода на страницу логин
        ForgotPassword objForgotPassword = new ForgotPassword(driver);

        //клик на кнопку Войти
        objForgotPassword.clickEnterButton();

        //заполнить поле email
        objLoginPage.setEmailField(randomEmail);

        //заполнить поле Пароль
        objLoginPage.setPasswordField(randomPassword);

        //Нажать на кнопку Войти
        objLoginPage.clickEnterButton();

        // клик на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу профиля
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);

        // клик на кнопку Выйти
        objAccountProfilePage.expectation();
        objAccountProfilePage.clickExitButton();

        //Проверка наличия заголова Вход
        objLoginPage.enterHeaderCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
        DeleteUser.deleteUser(token);
    }
}
