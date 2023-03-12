package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    //локатор поля "Имя"
    private By nameField =  By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]//descendant::input[@class='text input__textfield text_type_main-default']");

    //локатор поля "Email"
    private By emailField =  By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]//descendant::input[@class='text input__textfield text_type_main-default']");

    //локатор поля "Пароль"
    private By passwordField =  By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@class='text input__textfield text_type_main-default']");

    //локатор кнопки "Войти"
    public static final By enterButton =  By.xpath(".//button[text() = 'Войти']");

    //локатор кнопки "Зарегистрироваться"
    private By registrationButton =  By.xpath(".//button[text() = 'Зарегистрироваться']");

    //локатор контроля Неверный пароль
    private By wrongPasswordMessage =  By.xpath(".//p[text() = 'Некорректный пароль']");

    @Step("Заполнить поле Имя")
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнить поле Email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажать на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Проверить наличие контроля Неверный пароль")
    public void wrongPasswordMessageCheck() {
        Assert.assertTrue(driver.findElement(wrongPasswordMessage).isEnabled());
    }

    //конструктор класса page object
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
}
