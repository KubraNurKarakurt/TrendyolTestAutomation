package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    @Step("E-posta alanı doldurulur")
    public LoginPage fillEmail(String email){
        driver.findElement(By.id("login-email")).sendKeys(email);
        return this;
    }

    @Step("Parola alanı doldurulur")
    public LoginPage fillPassword(String password){
        driver.findElement(By.name("login-password")).sendKeys(password);
        return this;
    }

    @Step("Login alanına tıklanır")
    public LoginPage clickLogin(){
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        return this;
    }

    @Step("Hata mesajı kontrol edilir")
    public LoginPage errorMessageControl(String value){
        String text = driver.findElements(By.cssSelector("[class='message']")).get(0).getText();
        Assert.assertEquals(text, value);
        screenshot();
        return this;
    }
}
