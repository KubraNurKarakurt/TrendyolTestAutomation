import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    @Test(description = "Başarılı Kullanıcı Giriş Testi")
    public void basariligiris() {

        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);

        mainPage.accountControl();
    }

    @Test(description = "Başarısız Kullanıcı Giriş Testi")
    public void basarisizgiris() {

        loginPage.fillEmail(email)
                .fillPassword("124")
                .clickLogin();
        sleep(3000);

        loginPage.errorMessageControl("E-posta adresiniz ve/veya şifreniz hatalı.");
    }
}
