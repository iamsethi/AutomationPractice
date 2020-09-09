package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.automationpractice.util.Helper.getAppUrl;

public class BasePage extends HtmlPageObject{

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement login;


    /**
     * Navigate to app
     */
    public void navigateToApp(){

        try {
            driver.navigate().to(new URL(getAppUrl()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to navigate to sign in page
     * @return
     */
    public LoginPage navigateToSignOnPage(){
        isTextPresentOnPage("My Store");
        clickLinkOrBtn(login);
        return new LoginPage(driver);
    }


}
