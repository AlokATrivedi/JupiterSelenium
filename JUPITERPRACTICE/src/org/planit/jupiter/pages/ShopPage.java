package org.planit.jupiter.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.planit.jupiter.ui.Product;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	public double getSpecifiedProductPrice(String productTitle) throws Exception {
		System.out.println(iterateThroughItemsOnPage(productTitle).price());
		return iterateThroughItemsOnPage(productTitle).price();
	}

	public void addProductToCart(String productTitle) throws Exception{

		iterateThroughItemsOnPage(productTitle).clickBuyButton();
	}

	public Product iterateThroughItemsOnPage(String productTitle) throws Exception{

		List<WebElement> products = driver.findElements(By.className("product"));

		for(WebElement productElement: products){
			Product product = new Product(productElement);
			if(product.title().equals(productTitle)){
				return product;
			}
		} throw new Exception("Product could not be found");
	}
}	



