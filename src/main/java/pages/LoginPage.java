package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public void enterUsername(String user){
        driver.findElement(username).sendKeys("standard_user");
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys("secret_sauce");
    }



    public void clickLogin(){
        WaitUtils.waitForElementClickable(driver, loginBtn);
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass){
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

}
