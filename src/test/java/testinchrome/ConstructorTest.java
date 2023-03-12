package testinchrome;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import pageobject.AccountProfilePage;
import pageobject.LoginPage;
import pageobject.MainPage;
import apistellarburgers.CreateUser;
import apistellarburgers.DeleteUser;
import apistellarburgers.User;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConstructorTest {
    private WebDriver driver;
    Faker faker = new Faker();
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();
    String randomName = faker.name().username();
    User user = new User(randomEmail, randomPassword, randomName);
    String token = CreateUser.createUser(user).jsonPath().getString("accessToken");

    @Before
    public void setUp() {
        //драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на конструктор")
    public void goToConstructorFromConstructorButtonTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

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

        //клик на кнопку Конструктор
        objAccountProfilePage.clickConstructorButton();

        //Проверка наличия заголовка Соберите бургер
        objMainPage.constructorBurgerHeaderCheck();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип")
    public void goToConstructorFromLogoButtonTest() {
        // перешли на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

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

        //клик на логотип
        objAccountProfilePage.clickLogoButton();

        //Проверка наличия заголовка Соберите бургер
        objMainPage.constructorBurgerHeaderCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
        DeleteUser.deleteUser(token);
    }
}
