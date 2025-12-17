package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    By firstProduct = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public void addFirstProductToCart(){
        WaitUtils.waitForElementClickable(driver, firstProduct);
        driver.findElement(firstProduct).click();
    }

    public void goToCart(){
        WaitUtils.waitForElementClickable(driver, cartIcon);
        driver.findElement(cartIcon).click();
    }
}
