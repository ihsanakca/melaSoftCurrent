package com.melaSoft.pages;

import com.melaSoft.utils.BrowserUtils;
import com.melaSoft.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanySettingsPage extends BasePage{

    @FindBy(xpath = "(//div[text()='Company Settings'])[1]")
    public WebElement companySettingsPageTitle;

    @FindBy(xpath = "(//div[text()='Company Users'])[1]")
    public WebElement companyUsersTab;

    @FindBy(xpath = "//div[text()='New User']")
    public WebElement newUserBtn;

    @FindBy(xpath = "(//div[text()='New User'])[2]")
    public WebElement newUserFormTitle;

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    public WebElement newUserEmailBox;

    @FindBy(xpath = "(//div[text()='Administrator']/../../div)[1]")
    public WebElement administratorCheckBox;

    @FindBy(xpath = "(//span[text()='Terms of Service']/../../div/div)[1]")
    public WebElement termsCheckBox;

    @FindBy(xpath = "(//div[text()='Add User'])[2]")
    public WebElement addUserBtn;

    @FindBy(xpath = "(//div[text()='New User'])[2]")
    public WebElement addedNewUserMessage;

    @FindBy(xpath = "(//div[text()='Delete Company'])[2]")
    public WebElement deleteCompanyBtn;

    @FindBy(css = "[autocapitalize='sentences']")
    public WebElement deleteConfirmationBar;

    @FindBy(xpath = "(//div[text()='Delete Company'])[4]")
    public WebElement deleteCompanyConfirmBtn;


    DashboardPage dashboardPage = new DashboardPage();
    public void deleteCompanyAndVerify(String confirmationText){
//        dashboardPage.dashboardSettingsBtn.click();
//        dashboardPage.dashboardCompanySettingsBtn.click();
        Driver.get().navigate().refresh();
        BrowserUtils.scrollToElement(dashboardPage.deleteCompanyBtn);
        deleteCompanyBtn.click();
        deleteConfirmationBar.sendKeys(confirmationText);
        deleteCompanyConfirmBtn.click();
        Assert.assertTrue(dashboardPage.createCompanyBtnLeft.isDisplayed());

    }
}
