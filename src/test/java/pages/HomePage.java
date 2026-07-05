package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    // Locators
    private final Locator logoutButton;
    private final Locator viewProductButton;
    private final Locator addToCartButton;
    private final Locator viewCartButton;

    public HomePage(Page page) {
        super(page);
        logoutButton = page.locator("//a[normalize-space()='Logout']");
        viewProductButton = page.locator("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");

        addToCartButton = page.locator("//button[normalize-space()='Add to cart']");

        viewCartButton = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName("View Cart")
        );
    }

    public void clickViewProduct() {
        click(viewProductButton);
    }

    public void addProductToCart() {
        click(addToCartButton);
    }

    public void openCart() {
        click(viewCartButton);
    }
    public void logout() {
        click(logoutButton);
    }
}
