package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyUserCanPlaceOrder() {

        // Test Data
        String email = "akramkhanarafat12@gmail.com";
        String password = "123456789";

        String cardName = "Akram";
        String cardNumber = "123456";
        String cvc = "311";
        String expiryMonth = "12";
        String expiryYear = "2029";

        // Page Objects
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        CartPage cartPage = new CartPage(page);
        CheckoutPage checkoutPage = new CheckoutPage(page);

        // Login
        loginPage.login(email, password);

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed."
        );

        // View Product
        homePage.clickViewProduct();

        // Add To Cart
        homePage.addProductToCart();

        // Open Cart
        homePage.openCart();

        // Proceed To Checkout
        Assert.assertTrue(
                cartPage.isProceedToCheckoutVisible(),
                "Proceed To Checkout button is not visible."
        );

        cartPage.clickProceedToCheckout();

        // Verify Checkout Page
        Assert.assertTrue(
                checkoutPage.isReviewOrderVisible(),
                "Review Your Order section is not displayed."
        );

        checkoutPage.clickPlaceOrder();

        // Payment
        checkoutPage.fillPaymentDetails(
                cardName,
                cardNumber,
                cvc,
                expiryMonth,
                expiryYear
        );

        checkoutPage.clickPayAndConfirmOrder();

        // Verify Order
        Assert.assertTrue(
                checkoutPage.isOrderPlacedVisible(),
                "Order was not placed successfully."
        );

        checkoutPage.clickContinue();
    }
}