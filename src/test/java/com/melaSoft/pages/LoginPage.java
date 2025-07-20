package com.melaSoft.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//input[@placeholder='Email Address*']")
    public WebElement emailBox;

    @FindBy (xpath = "//input[@placeholder='Password*']")
    public WebElement passwordBox;

    @FindBy (xpath = "//*[text()='Log In']")
    public WebElement loginButton;


    public void login(String email, String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password+ Keys.ENTER);
    }

}
