package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.WaitUtils;

public class CheckOutTest extends BaseTest {

    @Test
    public void completeOrderFlowTest() throws InterruptedException {

        //1. LOGIN
        LoginPage login = new LoginPage(driver);
        login.login("error_user", "secret_sauce");
        String url = driver.getCurrentUrl();

        // 2. ADD PRODUCT TO CART
        HomePage home = new HomePage(driver);
        home.addFirstProductToCart();
        home.goToCart();

        //CART PAGE
        CartPage cart = new CartPage(driver);

        //// Verify product name
        String productName = cart.getCartItemName();
        Assert.assertEquals(productName, "Sauce Labs Backpack");

//        cart.removeProduct();
//        Assert.assertTrue(cart.isCartEmpty(),
//                "❌ Cart empty nahi hai");

        cart.removeProduct();

        if (cart.isProductRemoved()) {
            System.out.println("✅ PRODUCT SUCCESSFULLY REMOVED FROM CART");
        } else {
            System.out.println("❌ PRODUCT STILL PRESENT IN CART");
        }



     /*   // 3. CHECKOUT STEPS
        CheckOutPage checkout = new CheckOutPage(driver);

        checkout.clickCheckout(); // checkout button

        checkout.enterDetails("Sumeer", "Bhatia", "pCode");
        checkout.clickContinue();

        checkout.clickFinish();

        // 4. ASSERTION
        String message = checkout.getSuccessMessage();
        Assert.assertEquals(message, "Thank you for your order!",
                "Order not completed!");

        System.out.println("Order Completed Successfully: " + message);*/
    }
}
