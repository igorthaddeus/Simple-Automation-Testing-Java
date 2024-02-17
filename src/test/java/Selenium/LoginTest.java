package Selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() throws InterruptedException {
        landingPage.goTo();
        LoginPage lp = landingPage.goToLoginPage();
        lp.setEmailLogin(email);
        Thread.sleep(2000);
        lp.setPasswordLogin(password);
        lp.clickSubmitLogin();
        Thread.sleep(2000);

        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/a/div/div")).getText(), "Igor");
    }

    @Test
    public void invalidEmailLogin(){
        landingPage.goTo();
        LoginPage lp = landingPage.goToLoginPage();
        lp.setEmailLogin(invalidEmail);

        Assert.assertEquals(
                driver.findElement(By.xpath(" //p[normalize-space()='Format Email atau Nomor Ponsel salah']")).getText(),
                "Format Email atau Nomor Ponsel salah");
    }

    @Test
    public void invalidPasswordLogin() throws InterruptedException {
        landingPage.goTo();
        LoginPage lp = landingPage.goToLoginPage();
        lp.setEmailLogin(email);
        Thread.sleep(2000);
        lp.setPasswordLogin(invalidPassword);
        Assert.assertEquals(driver.findElement(By.xpath("//p[normalize-space()='Kata sandi kurang dari 6 karakter']")).getText(),
                "Kata sandi kurang dari 6 karakter");
        Boolean button = driver.findElement(By.cssSelector("button[data-testid='button-submit']")).isEnabled();
        Assert.assertFalse(button);
    }

    @Test
    public void wrongPasswordLogin() throws InterruptedException{
        landingPage.goTo();
        LoginPage lp = landingPage.goToLoginPage();
        lp.setEmailLogin(email);
        Thread.sleep(2000);
        lp.setPasswordLogin(wrongPassword);
        lp.clickSubmitLogin();
        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/form/div[1]/div[3]/div[2]")).getText(),
                        "Email atau kata sandi yang Anda masukkan salah.");
    }

}