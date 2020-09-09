package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishlistPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/a")
    private WebElement firstTopSellingItem;

    @FindBy(className = "page-heading")
    private WebElement myWhishlistHeader;

    @FindBy(id = "name")
    private WebElement newWishlistNameField;

    @FindBy(id = "submitWishlist")
    private WebElement submitNewWishlistButton;

    @FindBy(className = "table")
    private WebElement wishlistTable;

    WishlistPage(WebDriver driver) {
        super(driver);
    }
}

