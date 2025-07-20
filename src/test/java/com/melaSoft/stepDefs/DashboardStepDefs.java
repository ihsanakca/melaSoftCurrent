package com.melaSoft.stepDefs;

import com.melaSoft.pages.DashboardPage;
import com.melaSoft.utils.BrowserUtils;
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

    @When("The user clicks on the Create Company + located at the top-left corner.")
    public void the_user_clicks_on_the_create_company_located_at_the_top_left_corner() {
        dashboardPage.createCompanyBtnLeft.click();
    }


    @Then("The user verifies that the Create Company page is opened.")
    public void the_user_verifies_that_the_create_company_page_is_opened() {
        WebDriverWait wait =new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.countrySelectionElement));
        Assert.assertTrue(dashboardPage.countrySelectionElement.isDisplayed());
    }

    @When("The user types in {string} to the country select box and press Enter key.")
    public void the_user_types_in_to_the_country_select_box_and_press_enter_key(String countryName) {
        dashboardPage.countryBox.sendKeys(countryName+ Keys.ENTER);
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
        dashboardPage.planAndBillingBtn.click();
    }
    @Then("The user should be able to see Plan And Billing page")
    public void the_user_should_be_able_to_see_plan_and_billing_page() {
       Assert.assertTrue(dashboardPage.planAndBillingPageTitle.isDisplayed());
    }

    @When("The user clicks on Upgrade Plan button")
    public void the_user_clicks_on_upgrade_plan_button() {
       dashboardPage.upgradePlanBtn.click();
    }
    @When("The user clicks on Upgrade button for Standard Package")
    public void the_user_clicks_on_upgrade_button_for_standard_package() {
        dashboardPage.standartUpgradeBtn.click();
    }
    @Then("The user should be able to see Payment page")
    public void the_user_should_be_able_to_see_payment_page() {
        Assert.assertTrue(dashboardPage.payementPageTitle.isDisplayed());
    }
    @When("The user deletes the created company with the confirmation text {string} and verifies the delete operation")
    public void the_user_deletes_the_created_company_with_the_confirmation_text_and_verifies_the_delete_operation(String confirmationText) {
    //   dashboardPage.deleteCompanyAndVerify(confirmationText);
    }

}
