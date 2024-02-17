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
}
