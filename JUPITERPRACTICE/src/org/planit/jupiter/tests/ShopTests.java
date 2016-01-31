package org.planit.jupiter.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.planit.jupiter.pages.HomePage;
import org.planit.jupiter.pages.ShopPage;

public class ShopTests extends BaseTests {

	@Test
	public void testPriceOfKnownProduct() throws Exception{
		
		//find "fluffy bunny" product
		//get the price
		//verify that the price is 9.99
		
		HomePage homePage = new HomePage(driver);
		ShopPage shopPage = homePage.clickShopMenu();
		double productExpectedPrice = 14.99;
		
		assertEquals(productExpectedPrice, shopPage.getSpecifiedProductPrice("Smiley Bear"), 0.01);
	}

	@Test
	public void testAddProductToCart() throws Exception{
		
		//find particular product specified by the test
		//find the buy button for that product
		//click on buy button
		
		HomePage homePage = new HomePage(driver);
		ShopPage shopPage = homePage.clickShopMenu();
		
		shopPage.addProductToCart("Stuffed Frog");
	}
}		
	
		
	

