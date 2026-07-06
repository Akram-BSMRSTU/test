package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

public class OrderFlowTest extends BaseTest {

    @Test(description = "Verify user can place an order successfully")
    public void verifyProductOrderFlow() throws InterruptedException {

        // Create Page Objects
        HomePage homePage = new HomePage(page);
        CartPage cartPage = new CartPage(page);
        CheckoutPage checkoutPage = new CheckoutPage(page);

        // Search Product
        homePage.searchProduct("Beetroot");

        // Add Product to Cart
        homePage.clickAddToCart();

        // Open Cart
        homePage.openCart();
//
//        // Proceed to Checkout
        cartPage.clickProceedToCheckout();
//
//        // Verify Product Added
//        Assert.assertTrue(
//                cartPage.isProductVisible("Beetroot"),
//                "Product is not displayed in the cart."
//        );
//
//        // Verify Place Order Button
//        Assert.assertTrue(
//                cartPage.isPlaceOrderButtonVisible(),
//                "Place Order button is not visible."
//        );
//
//        // Place Order
        cartPage.clickPlaceOrder();
//
//        // Verify Country Dropdown
//        Assert.assertTrue(
//                checkoutPage.isCountryDropdownVisible(),
//                "Country dropdown is not visible."
//        );
//
//        // Select Country
        checkoutPage.selectCountry("Argentina");
//
//        // Accept Terms
        checkoutPage.acceptTermsAndConditions();
//
//        // Verify Proceed Button
//        Assert.assertTrue(
//                checkoutPage.isProceedButtonVisible(),
//                "Proceed button is not visible."
//        );
//
//        // Complete Order
        checkoutPage.clickProceed();
//
//        // Verify Success Message
        Assert.assertTrue(
                checkoutPage.isOrderPlacedSuccessfully(),
                "cvxv"
        );
    }
}