package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;

    //локатор кнопки Войти
    private By enterButton =  By.xpath(".//a[text() = 'Войти']");

    @Step("Нажать на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public ForgotPassword(WebDriver driver){
        this.driver = driver;
    }
}
