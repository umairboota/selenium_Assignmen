package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import config.ConfigReader;
import pages.PageObjects;

public class task4Test extends ConfigReader {

	public PageObjects task4;

	@BeforeClass
	public void setUpTest() {
		setUp();
		task4 = new PageObjects(getDriver());
		getDriver().get(getBaseUrl2());

	}
	

	@Test(priority = 1)
	public void scenario_one() {
		task4.pauseForView(2000);

		task4.clickManueButton();
		task4.pauseForView(2000);

		String username = getUsername_task4();
		String password = getPassword_task4();

		task4.enterUsername_task4(username);
		task4.enterPassword_task4(password);

		task4.clickLoginButton_task4();

		task4.clickHomeButton_task4();

		task4.clickBrandNameButton_task4();

		String option = "Date New > Old";

		task4.selectOptionFromDropdown(option);

		task4.clickAddtoCart();
		task4.pauseForView(2000);

		task4.gotTocart();
		task4.pauseForView(2000);

	}
	
	@Test (priority = 2)
	public void S1Assertion1 () {
		Assert.assertTrue(task4.isCartItemDisplayed(), "Item is not displayed in the cart");
	}
	
	@Test (priority = 3)
	public void S1Assertion2 () {
		Assert.assertEquals(task4.getCartItemAmount(), "$6.70", "Incorrect amount for the item in the cart");
	}
	
	@Test (priority = 4)
	public void S1Assertion3 () {
		Assert.assertEquals(task4.getCartItemQuantity(), "2", "Incorrect quantity for the item in the cart");
	}
	
	
	@Test (priority = 5)
	public void scenario_two() {
		task4.gotToapparals();
		task4.goToTshirtSection();
		
		String option = "Price Low > High";

		task4.selectOptionFromDropdown(option);
		task4.clickGoAddtoCartShirt();
		task4.clickAddtoCartShirt();
		
////		adding shoes
		task4.gotToapparals();
		task4.clicktoShoes();
		String optionShoes = "Price High > Low";

		task4.selectOptionFromDropdown(optionShoes);
		task4.clickGoToCartshoes();
		task4.enterQuntity();
		task4.clickAddtoCart();
		
		task4.pauseForView(2000);
	}
	
	@Test (priority = 6)
	public void S2Assertion1 () {
		Assert.assertTrue(task4.isCartItemDisplayed(), "Item is not displayed in the cart");
	}
	
	@Test
	public void S2Assertion2 () {
		Assert.assertEquals(task4.getCartItemAmount(), "$6.70", "Incorrect amount for the item in the cart");
	}
	
	@Test (priority = 7)
	public void S2Assertion3 () {
		Assert.assertEquals(task4.getCartItemQuantity(), "2", "Incorrect quantity for the item in the cart");
	}
	
	@AfterClass
	public void done() {
		task4.quitWindow();

	}
}
