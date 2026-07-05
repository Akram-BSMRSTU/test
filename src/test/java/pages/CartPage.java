package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    // Locators
    private final Locator proceedToCheckoutButton;

    public CartPage(Page page) {
        super(page);

        proceedToCheckoutButton = page.getByText("Proceed To Checkout");
    }

    /**
     * Verify Proceed To Checkout button is visible
     */
    public boolean isProceedToCheckoutVisible() {
        return isVisible(proceedToCheckoutButton);
    }

    /**
     * Click Proceed To Checkout
     */
    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }

}
