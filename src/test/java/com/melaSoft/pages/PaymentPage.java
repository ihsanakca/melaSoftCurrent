package com.melaSoft.pages;

import com.melaSoft.utils.ConfigurationReader;
import com.melaSoft.utils.Driver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//div[text()='Payment']")
    public WebElement paymentPageTitle;

    @FindBy(xpath = "//input[contains(@id,'numberInput')]")
    public WebElement cardNumberBox;

    @FindBy(xpath = "//div[contains(text(),'Congratulations!')]")
    public WebElement congratulationsMessage;

    @FindBy(xpath = "//iframe[@title='Secure payment input frame']")
    public WebElement cardPaymentFrame;

    @FindBy(id = "Field-expiryInput")
    public WebElement expirationBox;

    @FindBy(id = "Field-cvcInput")
    public WebElement securityCodeBox;

    @FindBy(xpath = "//button[text()='Pay Now']")
    public WebElement payNowBtn;

    @FindBy(xpath = "//*[text()='Let’s Get Started']")
    public WebElement letsStartBtn;

    public void fillingPaymentPage() {
        Driver.get().switchTo().frame(cardPaymentFrame);
        Actions actions = new Actions(Driver.get());
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'numberInput')]")));

        actions.click(cardNumberBox)
                .sendKeys(ConfigurationReader.get("cardNumber")).perform();
        expirationBox.sendKeys("0629");
        securityCodeBox.sendKeys("666");
        Driver.get().switchTo().parentFrame();
        payNowBtn.click();
    }
}
