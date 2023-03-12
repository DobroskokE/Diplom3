package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //локатор поля "Email"
    private By emailField =  By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]//descendant::input[@class='text input__textfield text_type_main-default']");

    //локатор поля "Пароль"
    private By passwordField =  By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@class='text input__textfield text_type_main-default']");

    //локатор кнопки "Войти"
    private By enterButton =  By.xpath(".//button[text() = 'Войти']");

    //локатор кнопки "Зарегистрироваться"
    private By registrationButton =  By.xpath(".//a[text() = 'Зарегистрироваться']");

    //локатор кнопки Восстановить пароль
    private By recoverPasswordButton =  By.xpath(".//a[text() = 'Восстановить пароль']");

    //локатор заголовка Вход
    private By enterHeader =  By.xpath(".//*[@id=\"root\"]/div/main/div/h2");

    @Step("Заполнить поле Email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажать на кнопку Восстановить пароль")
    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }

    @Step("Проверить наличие заголовка Вход")
    public void enterHeaderCheck() {
        Assert.assertTrue(driver.findElement(enterHeader).isEnabled());
    }

    //конструктор класса page object
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
}
