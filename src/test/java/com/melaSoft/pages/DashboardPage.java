package com.melaSoft.pages;

import com.melaSoft.utils.ConfigurationReader;
import com.melaSoft.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement dashboardPageTitle;

    @FindBy(xpath = "(//div[text()='Create Company'])[2]")
    public WebElement createCompanyBtnLeft;

    @FindBy(xpath = "//div[text()='Country Selection']")
    public WebElement countrySelectionElement;


    @FindBy(css = ".ant-select-selection-search-input")
    public WebElement countryBox;

    @FindBy(id = "vatId")
    public WebElement vatIdBox;

    @FindBy(xpath = "//div[text()='Company Information']")
    public WebElement companyInformationFormTitle;

    @FindBy(xpath = "//*[text()='Anatolia supermarkt']")
    public WebElement createdCompanyName;

    public void fillingCompanyInformationForm() {
        Actions action = new Actions(Driver.get());
        action.click(vatIdBox)
                .sendKeys(ConfigurationReader.get("vatid")+ Keys.TAB)
                .sendKeys(ConfigurationReader.get("taxNumber")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("companyName")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("address")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("postalCode")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("city")+Keys.TAB+Keys.TAB)
                .sendKeys(ConfigurationReader.get("ibanName")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("ibanOrAccountNumber")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("accountHolder")+Keys.TAB)
                .sendKeys(ConfigurationReader.get("bic")+Keys.TAB+Keys.TAB+Keys.ENTER)
                .perform();
    }


}
