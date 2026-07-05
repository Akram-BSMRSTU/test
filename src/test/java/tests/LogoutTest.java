package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyUserCanLogout() {

        // Test Data
        String email = "akramkhanarafat12@gmail.com";
        String password = "123456789";

        // Page Objects
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        // Login
        loginPage.login(email, password);

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed."
        );

        // Logout
        homePage.logout();

        // Verify user is back on the login page
        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Signup / Login link is not displayed after logout."
        );
    }
}