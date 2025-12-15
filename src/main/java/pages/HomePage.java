package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    By firstProduct = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public void addFirstProductToCart(){
        driver.findElement(firstProduct).click();
    }

    public void goToCart(){
        driver.findElement(cartIcon).click();
    }
}
