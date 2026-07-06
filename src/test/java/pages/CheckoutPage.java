package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private final Page page;

    // ==========================
    // Locators
    // ==========================

    private static final String COUNTRY_DROPDOWN = "//select";
    private static final String TERMS_CHECKBOX = "//input[@type='checkbox']";
    private static final String PROCEED_BUTTON = "//button[text()='Proceed']";
    private static final String SUCCESS_MESSAGE =
            "//span[contains(text(),'Thank you, your order has been placed successfully')]";

    // ==========================
    // Constructor
    // ==========================

    public CheckoutPage(Page page) {
        this.page = page;
    }

    // ==========================
    // Action Methods
    // ==========================

    public void selectCountry(String country) {
        page.locator(COUNTRY_DROPDOWN).selectOption(country);
    }

    public void acceptTermsAndConditions() {
        page.locator(TERMS_CHECKBOX).check();
    }

    public void clickProceed() {
        page.locator(PROCEED_BUTTON).click();
    }

    // ==========================
    // Verification Methods
    // ==========================

    public boolean isCountryDropdownVisible() {
        return page.locator(COUNTRY_DROPDOWN).isVisible();
    }

    public boolean isProceedButtonVisible() {
        return page.locator(PROCEED_BUTTON).isVisible();
    }

    public boolean isOrderPlacedSuccessfully() {
        return page.locator(SUCCESS_MESSAGE).isVisible();
    }
}