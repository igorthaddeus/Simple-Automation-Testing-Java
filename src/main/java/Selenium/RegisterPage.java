package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage{
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/signup']")
    WebElement buttonSignUp;

    @FindBy(css = "div[data-testid='card-Individu']")
    WebElement cardIndividu;

    @FindBy(id = "fullname")
    WebElement fullnameRegister;

    @FindBy(id = "username")
    WebElement emailRegister;

    @FindBy(css = "span[data-testid='checkbox-agreement']")
    WebElement checkboxRegister;

    @FindBy(css = "input[data-testid='input-password']")
    WebElement passwordRegister;

    @FindBy(css = "input[data-testid='input-password-confirmation']")
    WebElement confirmPasswordRegister;

    @FindBy(css = "button[type='submit']")
    WebElement buttonSubmit;

    public void goToRegisterPage(){
        buttonSignUp.click();
    }

    public void clickCardRegister(){
        cardIndividu.click();
    }

    public void setFullnameRegister(String fullname){
        fullnameRegister.sendKeys(fullname);
    }

    public void setEmailRegister(String email){
        emailRegister.sendKeys(email);
    }

    public void setPasswordRegister(String password){
        passwordRegister.sendKeys(password);
    }

    public void setConfirmPasswordRegister(String password){
        confirmPasswordRegister.sendKeys(password);
    }

    public void clickCheckboxRegister(){
        checkboxRegister.click();
    }

    public void clickButtonDaftar(){
        buttonSubmit.click();
    }


}
