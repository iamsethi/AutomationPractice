package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
    @FindBy(css = "[href*='order&step=1']")
    private WebElement proceedToStep2;

    @FindBy(css = "[name='processAddress']")
    private WebElement proceedToStep4;

    @FindBy(css = "[name='processCarrier']")
    private WebElement proceedToStep5;

    @FindBy(className = "checker")
    private WebElement termsOfServiceCheckobx;

    @FindBy(className = "bankwire")
    private WebElement payBankWire;

    @FindBy(css = "#cart_navigation > button")
    private WebElement completeOrder;

    @FindBy(css = "#center_column > div")
    private WebElement successMessage;

    @FindBy(id = "summary_products_quantity")
    private WebElement itemsInCart;

    @FindBy(id = "cart_summary")
    private WebElement cartTable;

    @FindBy(css = "[class*='alert-warning']")
    private WebElement emptyCart;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

}
