package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AccountProfilePage {
    private WebDriver driver;

    //локатор кнопки Выход
    private By exitButton =  By.xpath(".//button[text() = 'Выход']");

    //локатор кнопки Конструктор
    private By constructorButton =  By.xpath(".//p[text() = 'Конструктор']");

    //локатор логотипа
    private By logoButton =  By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    private By text =  By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");

    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на кнопку Выход")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Нажать на логотип")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    //ожидание
    public void expectation() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(text);
    }
    @Step("Проверить наличие текста в Профиле")
    public void textCheck() {
        expectation();
        Assert.assertTrue(driver.findElement(text).isEnabled());
    }

    //конструктор класса page object
    public AccountProfilePage(WebDriver driver){
        this.driver = driver;
    }
}
