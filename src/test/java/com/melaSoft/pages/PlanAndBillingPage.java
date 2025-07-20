package com.melaSoft.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlanAndBillingPage extends BasePage{
    @FindBy(xpath = "(//div[text()='Plan & Billing'])[2]")
    public WebElement planAndBillingBtn;

    @FindBy(xpath = "(//div[text()='Plan & Billing'])[2]")
    public WebElement planAndBillingPageTitle;

    @FindBy (xpath = "//div[text()='Upgrade Plan']")
    public WebElement upgradePlanBtn;

    @FindBy(xpath = "//div[text()='Choose your right plan!']")
    public WebElement upgradePlanChangePageTitle;

    @FindBy(xpath = "(//div[text()='UPGRADE'])[2]")
    public WebElement standartUpgradeBtn;

}
