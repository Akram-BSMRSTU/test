package pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private final Page page;

    // ==========================
    // Locators
    // ==========================

    private static final String PROCEED_TO_CHECKOUT_BUTTON =
            "//button[text()='PROCEED TO CHECKOUT']";

    private static final String PLACE_ORDER_BUTTON =
            "//button[text()='Place Order']";

    // ==========================
    // Constructor
    // ==========================

    public CartPage(Page page) {
        this.page = page;
    }

    // ==========================
    // Action Methods
    // ==========================

    public void clickProceedToCheckout() {
        page.locator(PROCEED_TO_CHECKOUT_BUTTON).click();
    }

    public void clickPlaceOrder() {
        page.locator(PLACE_ORDER_BUTTON).click();
    }

    // ==========================
    // Verification Methods
    // ==========================

    public boolean isProductVisible(String productName) {

        String productLocator =
                "//p[contains(text(),'" + productName + "')]";

        return page.locator(productLocator).isVisible();
    }

    public boolean isProceedToCheckoutButtonVisible() {
        return page.locator(PROCEED_TO_CHECKOUT_BUTTON).isVisible();
    }

    public boolean isPlaceOrderButtonVisible() {
        return page.locator(PLACE_ORDER_BUTTON).isVisible();
    }
}