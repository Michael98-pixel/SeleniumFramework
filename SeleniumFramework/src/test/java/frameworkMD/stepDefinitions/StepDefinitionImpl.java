package frameworkMD.stepDefinitions;

import java.io.IOException;
import org.testng.Assert;

import frameworkMD.TestComponents.BaseTest;
import frameworkMD.pageObjects.CartPage;
import frameworkMD.pageObjects.CheckoutPage;
import frameworkMD.pageObjects.ConfirmationPage;
import frameworkMD.pageObjects.LandingPage;
import frameworkMD.pageObjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")
	public void i_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with (.+) and (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);

	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) {
		//List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+)  and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);

		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Romania");
		confirmationPage = checkoutPage.submitOrder();
	}
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String message) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
		driver.close();
	}
	@Then ("{string} message is displayed")
	public void  some_message_is_displayed(String message) {
		Assert.assertEquals(message, landingPage.getErrorMessage());
		driver.close();
	}
}