package com.melaSoft.stepDefs;

import com.melaSoft.pages.CompanySettingsPage;
import com.melaSoft.pages.DashboardPage;
import com.melaSoft.pages.PaymentPage;
import com.melaSoft.pages.PlanAndBillingPage;
import com.melaSoft.utils.BrowserUtils;
import com.melaSoft.utils.ConfigurationReader;
import com.melaSoft.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    PlanAndBillingPage planAndBillingPage = new PlanAndBillingPage();
    PaymentPage paymentPage = new PaymentPage();

    CompanySettingsPage companySettingsPage = new CompanySettingsPage();

    @When("The user clicks on the Create Company + located at the top-left corner.")
    public void the_user_clicks_on_the_create_company_located_at_the_top_left_corner() {
        dashboardPage.createCompanyBtnLeft.click();
    }


    @Then("The user verifies that the Create Company page is opened.")
    public void the_user_verifies_that_the_create_company_page_is_opened() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.countrySelectionElement));
        Assert.assertTrue(dashboardPage.countrySelectionElement.isDisplayed());
    }

    @When("The user types in {string} to the country select box and press Enter key.")
    public void the_user_types_in_to_the_country_select_box_and_press_enter_key(String countryName) {
        dashboardPage.countryBox.sendKeys(countryName + Keys.ENTER);
    }

    @Then("The user should be able to see Company Information Form.")
    public void the_user_should_be_able_to_see_company_ınformation_form() {
        Assert.assertTrue(dashboardPage.companyInformationFormTitle.isDisplayed());
    }

    @When("The user fills the form with valid data.")
    public void the_user_fills_the_form_with_valid_data() {
        dashboardPage.fillingCompanyInformationForm();
    }

    @Then("The user should be able to see the created company name on the left top")
    public void the_user_should_be_able_to_see_the_created_company_name_on_the_left_top() {
        Assert.assertTrue(dashboardPage.createdCompanyName.isDisplayed());
    }

    @When("The user clicks on Settings button")
    public void the_user_clicks_on_settings_button() {
        dashboardPage.dashboardSettingsBtn.click();
    }

    @When("The user clicks on Plan And Billing button")
    public void the_user_clicks_on_plan_and_billing_button() {
        planAndBillingPage.planAndBillingBtn.click();
    }

    @Then("The user should be able to see Plan And Billing page")
    public void the_user_should_be_able_to_see_plan_and_billing_page() {
        Assert.assertTrue(planAndBillingPage.planAndBillingPageTitle.isDisplayed());
    }

    @When("The user clicks on Upgrade Plan button")
    public void the_user_clicks_on_upgrade_plan_button() {
        planAndBillingPage.upgradePlanBtn.click();
    }

    @When("The user clicks on Upgrade button for Standard Package")
    public void the_user_clicks_on_upgrade_button_for_standard_package() {
        planAndBillingPage.standartUpgradeBtn.click();
    }

    @Then("The user should be able to see Payment page")
    public void the_user_should_be_able_to_see_payment_page() {
        Assert.assertTrue(paymentPage.paymentPageTitle.isDisplayed());
    }

    @When("The user enters the valid credit card credentials and click Pay Now button")
    public void the_user_enters_the_valid_credit_card_credentials_and_click_pay_now_button() {
        paymentPage.fillingPaymentPage();
    }

    @Then("The user verifies the valid payment")
    public void the_user_verifies_the_valid_payment() {
        Assert.assertTrue(paymentPage.congratulationsMessage.isDisplayed());
        paymentPage.letsStartBtn.click();
    }

    @When("The user clicks on Company Settings button")
    public void the_user_clicks_on_company_settings_button() {
        dashboardPage.dashboardCompanySettingsBtn.click();
    }

    @Then("The user should be able to see Company Settings page")
    public void the_user_should_be_able_to_see_company_settings_page() {
        Assert.assertTrue(companySettingsPage.companySettingsPageTitle.isDisplayed());
    }

    @When("The user clicks on Company Users tab")
    public void the_user_clicks_on_company_users_tab() {
        BrowserUtils.clickWithJS(companySettingsPage.companyUsersTab);
    }

    @When("The user clicks on New User button")
    public void the_user_clicks_on_new_user_button() {
        companySettingsPage.newUserBtn.click();
    }

    @Then("The user verifies that New User page is displayed")
    public void the_user_verifies_that_new_user_page_is_displayed() {
        Assert.assertTrue(companySettingsPage.newUserFormTitle.isDisplayed());
    }

    @When("The user enters the valid email to the related box")
    public void the_user_enters_the_valid_email_to_the_related_box() {
        companySettingsPage.newUserEmailBox.sendKeys(ConfigurationReader.get("email"));
    }

    @When("The user selects the administrator check box")
    public void the_user_selects_the_administrator_check_box() {
        companySettingsPage.administratorCheckBox.click();
    }

    @When("The user selects Terms and Conditions check box")
    public void the_user_selects_terms_and_conditions_check_box() {
        companySettingsPage.termsCheckBox.click();
    }

    @When("The user clicks on Add User button")
    public void the_user_clicks_on_add_user_button() {
        BrowserUtils.scrollToElement(companySettingsPage.addUserBtn);
        companySettingsPage.addUserBtn.click();
    }

    @Then("The user should verify the new user added message")
    public void the_user_should_verify_the_new_user_added_message() {
        Assert.assertTrue(companySettingsPage.addedNewUserMessage.isDisplayed());
    }

    @When("The user deletes the created company with the confirmation text {string} and verifies the delete operation")
    public void the_user_deletes_the_created_company_with_the_confirmation_text_and_verifies_the_delete_operation(String confirmationText) {
        companySettingsPage.deleteCompanyAndVerify(confirmationText);
    }

}
