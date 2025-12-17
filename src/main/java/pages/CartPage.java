package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartItemName = By.className("inventory_item_name");
    By checkoutBtn = By.id("checkout");
    By removeBtn = By.id("remove-sauce-labs-backpack");
    By cartBadge = By.className("shopping_cart_badge");
 //   By removeBtn2 = By.id("remove-sauce-labs-fleece-jacket");

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    // Click checkout button
    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    // Optional: remove product from cart
    public void removeProduct(){
        driver.findElement(removeBtn).click();
    }
    public boolean isProductRemoved() {
        return driver.findElements(cartItemName).size() == 0;
    }

}
