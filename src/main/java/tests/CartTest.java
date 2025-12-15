package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductTest(){
        LoginPage login = new LoginPage(driver);
        login.login("error_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        home.addFirstProductToCart();
        home.goToCart();

        String title = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(title, "Sauce Labs ");
    }
}
