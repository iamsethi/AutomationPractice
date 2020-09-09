package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartHoverPage extends BasePage {
	@FindBy(className = "shopping_cart")
	private WebElement cartHover;

	@FindBy(id = "button_order_cart")
	private WebElement checkOutButton;

	@FindBy(css = ".shopping_cart > a")
	private WebElement enableHoverElement;

	public CartHoverPage(WebDriver driver) {
		super(driver);
	}


}
