package StepDefination;


import com.microsoft.playwright.Page;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import pages.*;
import utils.WebActions;

public class StepDefinition extends BasePage{


    LoginPage loginPage;
    ItemsPage itemsPage;
    CheckoutPage checkoutPage;
    ElementPage elementPage;

    Page page;

    @Given("^User launched DemoQa application$")
    public void lunchDemoQAURL() {
        try {
            System.out.println("browser::" + WebActions.getProperty("browser"));
            page = createPlaywrightPageInstance(WebActions.getProperty("browser"));
            page.navigate(WebActions.getProperty("url"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("User logged in the app using username {string} and password {string}")
    public void user_logged_in_the_app_using_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("^user should be able to log in$")
    public void logInSuccessful() {
        itemsPage.loginSuccessful();
    }

    @Then("^User should not get logged in$")
    public void logInFailed() {
        loginPage.loginFailed();
    }

    @When("User adds {string} product to the cart")
    public void user_adds_product_to_the_cart(String product) {
        itemsPage.orderProduct(product);
    }

    @When("User enters Checkout details with {string}, {string}, {string}")
    public void user_enters_Checkout_details_with(String FirstName, String LastName, String Zipcode) {
        checkoutPage.fillCheckoutDetails(FirstName, LastName, Zipcode);
    }

    @When("User completes Checkout process")
    public void user_completes_checkout_process() {
        checkoutPage.completeCheckout();
    }

    @Then("User should get the Confirmation of Order")
    public void user_should_get_the_Confirmation_of_Order() {
        checkoutPage.checkoutSuccessful();
    }

    @When("User clicks on element button")
    public void user_clicks_on_element_button() {
        System.out.println("User is on the homepage");
       }


    @After
    public void tearDown(Scenario scenario) {
        if (browser != null) {
            browser.close();
        }
        if (page != null) {
            page.close();
        }
    }
}