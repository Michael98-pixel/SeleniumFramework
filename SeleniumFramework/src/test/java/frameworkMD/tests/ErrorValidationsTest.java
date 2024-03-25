package frameworkMD.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworkMD.TestComponents.BaseTest;
import frameworkMD.TestComponents.Retry;
import frameworkMD.pageObjects.CartPage;
import frameworkMD.pageObjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	@Test(groups= {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException {
		landingPage.loginApplication("mihail.durnea@gmail.com", "MihaiDurnea98");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	@Test
	public void ProductErrorValidation() throws IOException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("mihail.durnea98@gmail.com", "MihailDurnea98");
		// List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
}