package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;

    //локатор кнопки "Личный кабинет"
    private By personalAreaButton =  By.xpath(".//p[text() = 'Личный Кабинет']");

    //локатор кнопки "Войти в аккаунт"
    private By loginToAccountButton =  By.xpath(".//button[text() = 'Войти в аккаунт']");

    //локатор заголовка Соберите бургер
    private By constructorBurgerHeaderButton =  By.xpath(".//h1[text() = 'Соберите бургер']");

    //локатор вкладки Булки
    private By bunsTab =  By.xpath(".//span[text() = 'Булки']");

    //локатор заголовка Булки
    private By bunsHeader =  By.xpath(".//h2[text() = 'Булки']");

    //локатор вкладки Соусы
    private By saucesTab =  By.xpath(".//span[text() = 'Соусы']");

    //локатор заголовка Соусы
    private By saucesHeader =  By.xpath(".//h2[text() = 'Соусы']");

    //локатор вкладки Начинки
    private By fillingsTab =  By.xpath(".//span[text() = 'Начинки']");

    //локатор заголовка Начинки
    private By fillingsHeader =  By.xpath(".//h2[text() = 'Начинки']");

    @Step("Нажать на кнопку Личный кабинет")
    public void clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    @Step("Нажать на вкладку Булки")
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Нажать на вкладку Соусы")
    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Нажать на вкладку Начинки")
    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    //ожидание
    public void expectation(By locator) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(locator);
    }

    @Step("скроллить до начинки")
    public void scrollToFillings() {
        WebElement element = driver.findElement(fillingsHeader);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Проверить наличие заголовка Соберите бургер")
    public void constructorBurgerHeaderCheck() {
        Assert.assertTrue(driver.findElement(constructorBurgerHeaderButton).isEnabled());
    }

    @Step("Проверить наличие заголовка Булки")
    public void bunsHeaderCheck() {
        expectation(bunsHeader);
        Assert.assertTrue(driver.findElement(bunsHeader).isEnabled());
    }

    @Step("Проверить наличие заголовка Соусы")
    public void saucesHeaderCheck() {
        expectation(saucesHeader);
        Assert.assertTrue(driver.findElement(saucesHeader).isEnabled());
    }

    @Step("Проверить наличие заголовка Начинки")
    public void fillingsHeaderCheck() {
        expectation(fillingsHeader);
        Assert.assertTrue(driver.findElement(fillingsHeader).isEnabled());
    }

    //конструктор класса page object
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
}
