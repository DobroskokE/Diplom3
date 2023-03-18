package testinchrome;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import pageobject.*;
import apistellarburgers.CreateUser;
import apistellarburgers.DeleteUser;
import apistellarburgers.User;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static property.Property.driverPath;
import static property.Property.url;

public class LoginTest {
    private WebDriver driver;
    Faker faker = new Faker();
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();
    String randomName = faker.name().username();
    User user = new User(randomEmail, randomPassword, randomName);
    String token = CreateUser.createUser(user).jsonPath().getString("accessToken");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome,driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void loginToAccountButtonLoginTest() {
        // перешли на страницу тестового приложения
        driver.get(url);

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик на кнопку Войти в аккаунт
        objMainPage.clickLoginToAccountButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

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

        // проверь, что текст активен
        objAccountProfilePage.textCheck();
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void personalAreaButtonLoginTest() {
        // перешли на страницу тестового приложения
        driver.get(url);

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

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

        // проверь, что текст активен
        objAccountProfilePage.textCheck();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void loginFromRegistrationTest() {
        // перешли на страницу тестового приложения
        driver.get(url);

        //объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик на кнопку Личный кабинет
        objMainPage.clickPersonalAreaButton();

        //объект класса перехода на страницу регистрация
        RegisterPage objRegisterPage = new RegisterPage(driver);

        //клик на кнопку Войти
        objRegisterPage.clickEnterButton();

        //объект класса перехода на страницу логин
        LoginPage objLoginPage = new LoginPage(driver);

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

        // проверь, что текст активен
        objAccountProfilePage.textCheck();
    }
    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void loginFromRecoverPasswordTest() {
        // перешли на страницу тестового приложения
        driver.get(url);

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

        // проверь, что текст активен
        objAccountProfilePage.textCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
        DeleteUser.deleteUser(token);
    }
}
