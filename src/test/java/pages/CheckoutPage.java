package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    // Locators
    private final Locator reviewYourOrderText;
    private final Locator placeOrderButton;

    private final Locator nameOnCardTextbox;
    private final Locator cardNumberTextbox;
    private final Locator cvcTextbox;
    private final Locator expiryMonthTextbox;
    private final Locator expiryYearTextbox;

    private final Locator payAndConfirmOrderButton;
    private final Locator orderPlacedText;
    private final Locator continueButton;

    public CheckoutPage(Page page) {
        super(page);

        reviewYourOrderText = page.getByText("Review Your Order");

        placeOrderButton = page.getByRole(
                com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Place Order")
        );

        nameOnCardTextbox = page.locator("input[name='name_on_card']");
        cardNumberTextbox = page.locator("input[name='card_number']");
        cvcTextbox = page.locator("input[name='cvc']");
        expiryMonthTextbox = page.locator("input[name='expiry_month']");
        expiryYearTextbox = page.locator("input[name='expiry_year']");

        payAndConfirmOrderButton = page.getByRole(
                com.microsoft.playwright.options.AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Pay and Confirm Order")
        );

        orderPlacedText = page.getByText("Order Placed!");
        continueButton = page.getByRole(
                com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Continue")
        );
    }

    public boolean isReviewOrderVisible() {
        return isVisible(reviewYourOrderText);
    }

    public void clickPlaceOrder() {
        click(placeOrderButton);
    }

    public void enterCardName(String name) {
        fill(nameOnCardTextbox, name);
    }

    public void enterCardNumber(String cardNumber) {
        fill(cardNumberTextbox, cardNumber);
    }

    public void enterCVC(String cvc) {
        fill(cvcTextbox, cvc);
    }

    public void enterExpiryMonth(String month) {
        fill(expiryMonthTextbox, month);
    }

    public void enterExpiryYear(String year) {
        fill(expiryYearTextbox, year);
    }

    public void fillPaymentDetails(String name,
                                   String cardNumber,
                                   String cvc,
                                   String month,
                                   String year) {

        enterCardName(name);
        enterCardNumber(cardNumber);
        enterCVC(cvc);
        enterExpiryMonth(month);
        enterExpiryYear(year);
    }

    public void clickPayAndConfirmOrder() {
        click(payAndConfirmOrderButton);
    }

    public boolean isOrderPlacedVisible() {
        return isVisible(orderPlacedText);
    }

    public void clickContinue() {
        click(continueButton);
    }

}