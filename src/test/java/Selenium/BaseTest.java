package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    public LandingPage landingPage;

    String fullname = "Igor Thaddeus Sampoerna";
    String email = "igorthaddeus@yahoo.com";
    String password = "Igorkeren123@";

    String invalidEmail = "igorthaddeus.com";
    String invalidPassword = "123";
    String wrongPassword = "Igorkeren123";

    @BeforeMethod
    public LandingPage initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
