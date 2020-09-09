package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    @FindBy(className = "primary_block")
    private WebElement itemSection;

    @FindBy(id = "layer_cart")
    private WebElement cartFrame;

    @FindBy(css = "#add_to_cart > button > span")
    private WebElement addToCartButton;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(name = "qty")
    private WebElement quantityField;

    @FindBy(id = "group_1")
    private WebElement sizesDropdown;

    @FindBy(id = "color_to_pick_list")
    private WebElement colorOptions;

    @FindBy(id = "our_price_display")
    private WebElement price;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement quantityInCartFrame;

    @FindBy(id = "layer_cart_product_attributes")
    private WebElement sizeAndColorInCartFrame;

    @FindBy(id = "layer_cart_product_price")
    private WebElement priceInCartFrame;

    @FindBy(id = "wishlist_button")
    private WebElement addToWishlist;

    @FindBy(className = "fancybox-error")
    private WebElement fancyBox;

    @FindBy(className = "cross")
    private WebElement closeCartFrame;


    public ItemPage(WebDriver driver) {
        super(driver);
    }

}
