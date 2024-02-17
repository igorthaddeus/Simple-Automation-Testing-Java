package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LandingPage extends AbstractComponent{
    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-testid='menu'] a[href='/login']")
    WebElement buttonLogReg;

    public void goTo(){
        driver.get("https://www.ralali.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public LoginPage goToLoginPage(){
        buttonLogReg.click();
        return new LoginPage(driver);
    }

    public RegisterPage goToRegisterPage(){
        goToLoginPage();
        return new RegisterPage(driver);
    }


}
