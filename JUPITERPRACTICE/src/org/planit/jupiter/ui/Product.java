package org.planit.jupiter.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
	protected WebElement element;
	public Product(WebElement element){
		this.element = element;
	}
	
	public double price(){
		return Double.parseDouble(element.findElement(By.className("product-price")).getText().replace("$", ""));
		
	}
	
	public String title(){
		
		return element.findElement(By.className("product-title")).getText();
	}
	
	public void clickBuyButton(){
		element.findElement(By.className("btn-success")).click();
	}
}
