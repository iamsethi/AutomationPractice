package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "customer_firstname")
    private WebElement txt_customerFirstname;

    @FindBy(id = "customer_lastname")
    private WebElement txt_customerLastname;

    @FindBy(id = "passwd")
    private WebElement txt_password;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "firstname")
    private WebElement firstname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "address1")
    private WebElement address_line2;

    @FindBy(id = "address2")
    private WebElement address_line1;

    @FindBy(id = "city")
    private WebElement txt_city;

    @FindBy(id = "id_state")
    private WebElement drpdwn_state;

    @FindBy(id = "postcode")
    private WebElement txt_postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(id = "id_country")
    private WebElement id_country;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;


    /**
     * @param customerFirstname
     * @param customerLastname
     * @param password
     * @return
     */
    public RegistrationPage addNewUserInformation(String customerFirstname, String customerLastname, String password) {

        isTextPresentOnPage("YOUR PERSONAL INFORMATION");
        enterTextIntoTextBox(txt_customerFirstname, customerFirstname);
        enterTextIntoTextBox(txt_customerLastname, customerLastname);
        enterTextIntoTextBox(txt_password, password);
        return this;
    }


    /**
     * Method to enter account info
     *
     * @param firstName
     * @param lastName
     * @param phone
     * @param addr1
     * @param addr2
     * @param city
     * @param state
     * @param zip
     * @return
     */
    public RegistrationPage addAccountInformation(String firstName,
                                                  String lastName,
                                                  String phone,
                                                  String addr1,
                                                  String addr2,
                                                  String city,
                                                  String state,
                                                  String zip) {

        isTextPresentOnPage("Account Information");

        enterTextIntoTextBox(firstname, firstName);
        enterTextIntoTextBox(lastname, lastName);
        enterTextIntoTextBox(address_line1, addr1);
        enterTextIntoTextBox(address_line2, addr2);
        enterTextIntoTextBox(txt_city, city);
        selectByVisibleText(drpdwn_state, state);
        enterTextIntoTextBox(txt_postcode, zip);
        enterTextIntoTextBox(phone_mobile, phone);
        return this;
    }


    /**
     * Saving Account Info
     *
     * @return
     */
    public ItemPage clickSaveAccountInformation() {
        clickLinkOrBtn(submitAccount);
        return new ItemPage(driver);
    }


}