package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {

    // Locators
    private final Locator signupLoginLink;
    private final Locator emailTextbox;
    private final Locator passwordTextbox;
    private final Locator loginButton;
    private final Locator loggedInUser;

    public LoginPage(Page page) {
        super(page);

        signupLoginLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Signup / Login")
        );

        emailTextbox = page.locator("form")
                .filter(new Locator.FilterOptions().setHasText("Login"))
                .getByPlaceholder("Email Address");

        passwordTextbox = page.getByPlaceholder("Password");

        loginButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login")
        );

        loggedInUser = page.locator("a:has-text('Logged in as')");
    }

    public void openLoginPage() {
        click(signupLoginLink);
    }

    public void enterEmail(String email) {
        fill(emailTextbox, email);
    }

    public void enterPassword(String password) {
        fill(passwordTextbox, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String email, String password) {
        openLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoginSuccessful() {
        return isVisible(loggedInUser);
    }

    public boolean isLoginPageDisplayed() {
        return isVisible(signupLoginLink);
    }
}