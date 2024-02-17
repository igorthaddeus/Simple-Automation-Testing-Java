package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-testid='input-username']")
    WebElement emailLogin;

    @FindBy(css = "input[data-testid='input-password']")
    WebElement passwordLogin;

    @FindBy(css = "input[type='checkbox']")
    WebElement checkboxLogin;

    @FindBy(css = "button[data-testid='button-submit']")
    WebElement submitLogin;

    public void setEmailLogin(String email){
        emailLogin.sendKeys(email);
    }

    public void setPasswordLogin(String password){
        passwordLogin.sendKeys(password);
    }

    public void clickCheckboxLogin(){
        checkboxLogin.click();
    }

    public void clickSubmitLogin(){
        submitLogin.click();
    }



}
