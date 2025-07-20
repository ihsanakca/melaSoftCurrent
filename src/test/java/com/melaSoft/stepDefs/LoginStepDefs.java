package com.melaSoft.stepDefs;

import com.melaSoft.pages.DashboardPage;
import com.melaSoft.pages.LoginPage;
import com.melaSoft.utils.ConfigurationReader;
import com.melaSoft.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("The user goes to login page and verifies that login page is opened")
    public void the_user_goes_to_login_page_and_verifies_that_login_page_is_opened() {
        Driver.get().get(ConfigurationReader.get("url"));
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @When("The user enters valid email: {string} and password: {string}")
    public void the_user_enters_valid_email_and_password(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("The user should be on the dashboard page")
    public void the_user_should_be_on_the_dashboard_page() {
        Assert.assertTrue(dashboardPage.dashboardPageTitle.isDisplayed());

    }
}
