package Selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void validRegister() throws InterruptedException {
        landingPage.goTo();
        RegisterPage rp = landingPage.goToRegisterPage();
        rp.goToRegisterPage();
        rp.clickCardRegister();
        rp.setFullnameRegister(fullname);
        rp.setEmailRegister(email);
        Thread.sleep(2000);
        rp.setPasswordRegister(password);
        rp.setConfirmPasswordRegister(password);
        rp.clickCheckboxRegister();
        rp.clickButtonDaftar();

        Assert.assertEquals(
                driver.findElement(By.xpath("//h2[contains(text(), 'Pilih Metode Verifikasi')]")).getText(),
                "Pilih Metode Verifikasi");
    }

    @Test
    public void blankFormRegister(){
        RegisterPage rp = landingPage.goToRegisterPage();
        rp.goToRegisterPage();
        Boolean button = driver.findElement(By.cssSelector("button[data-testid='button-submit']")).isEnabled();
        Assert.assertFalse(button);
    }

    @Test
    public void invalidEmail(){
        landingPage.goTo();
        RegisterPage rp = landingPage.goToRegisterPage();
        rp.goToRegisterPage();
        rp.clickCardRegister();
        rp.setFullnameRegister(fullname);
        rp.setEmailRegister(invalidEmail);
        rp.clickCheckboxRegister();

        Assert.assertEquals(
                driver.findElement(By.xpath("//p[normalize-space()='Format Email atau Nomor Ponsel salah']")).getText(),
                "Format Email atau Nomor Ponsel salah"
        );
        Boolean button = driver.findElement(By.cssSelector("button[data-testid='button-submit']")).isEnabled();
        Assert.assertFalse(button);
    }

    @Test
    public void invalidPassword() throws InterruptedException {
        landingPage.goTo();
        RegisterPage rp = landingPage.goToRegisterPage();
        rp.goToRegisterPage();
        rp.clickCardRegister();
        rp.setFullnameRegister(fullname);
        rp.setEmailRegister(email);
        Thread.sleep(2000);
        rp.setPasswordRegister(invalidPassword);
        rp.clickCheckboxRegister();

        Assert.assertEquals(
                driver.findElement(By.xpath("//p[contains(text(),'Min. 8 - 50 karakter terdiri dari huruf kecil besa')]")).getText(),
                "Min. 8 - 50 karakter terdiri dari huruf kecil besar, angka, dan simbol"
        );
        Boolean button = driver.findElement(By.cssSelector("button[data-testid='button-submit']")).isEnabled();
        Assert.assertFalse(button);
    }

    @Test
    public void passwordNotMatch() throws InterruptedException {
        landingPage.goTo();
        RegisterPage rp = landingPage.goToRegisterPage();
        rp.goToRegisterPage();
        rp.clickCardRegister();
        rp.setFullnameRegister(fullname);
        rp.setEmailRegister(email);
        Thread.sleep(2000);
        rp.setPasswordRegister(password);
        rp.setConfirmPasswordRegister("password");
        rp.clickCheckboxRegister();

        Assert.assertEquals(
                driver.findElement(By.xpath("//p[normalize-space()='Kolom ulangi kata sandi tidak sesuai']")).getText(),
                "Kolom ulangi kata sandi tidak sesuai"
        );
        Boolean button = driver.findElement(By.cssSelector("button[data-testid='button-submit']")).isEnabled();
        Assert.assertFalse(button);
    }
}
