package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    // ==========================
    // Locators
    // ==========================

    private static final String SEARCH_BOX = "//input[@type='search']";
    private static final String ADD_TO_CART_BUTTON = "//button[text()='ADD TO CART']";
    private static final String CART_ICON = "//img[@alt='Cart']";

    // ==========================
    // Constructor
    // ==========================

    public HomePage(Page page) {
        this.page = page;
    }

    // ==========================
    // Action Methods
    // ==========================

    public void searchProduct(String product) {
        page.locator(SEARCH_BOX).fill(product);
        page.locator(SEARCH_BOX).press("Enter");
    }

    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(5000);
        page.locator(ADD_TO_CART_BUTTON).click();
    }

    public void openCart() {
        page.locator(CART_ICON).click();
    }

    public void akram() {
//        a+b
    }

    // ==========================
    // Verification Methods
    // ==========================

    public boolean isSearchBoxVisible() {
        return page.locator(SEARCH_BOX).isVisible();
    }

    public boolean isCartVisible() {
        return page.locator(CART_ICON).isVisible();
    }
}
