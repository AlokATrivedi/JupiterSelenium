package org.planit.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver){
		this.driver = driver;
	}

	public LoginDialog clickLoginMenu(){

		driver.findElement(By.cssSelector("#nav-login a")).click();
		return new LoginDialog(driver);
	}

	public ContactPage clickContactMenu(){
		driver.findElement(By.cssSelector("#nav-contact a")).click();
		return new ContactPage(driver);
	}

	public ShopPage clickShopMenu(){
		driver.findElement(By.cssSelector("#nav-shop a")).click();
		return new ShopPage(driver);
	}

	public String getLoggedInUserName(){

		WebElement element = driver.findElement(By.cssSelector("#nav-user a"));

		if((element.isDisplayed())){

			return element.getText();
		}  	

		return "";

	}

	public void clickLogoutButton(){


		driver.findElement(By.cssSelector("#nav-logout a")).click();

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));

		driver.findElement(By.linkText("Logout")).click();


	} 
}
