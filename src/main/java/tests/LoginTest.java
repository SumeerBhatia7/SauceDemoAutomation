package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){

        LoginPage login= new LoginPage(driver);
        login.login("error_user", "secret_sauce");

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("inventory"), "Login failed");
    }
}
