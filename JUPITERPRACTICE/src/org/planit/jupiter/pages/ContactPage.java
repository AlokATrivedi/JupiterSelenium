package org.planit.jupiter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);

	}

	public void clickSubmitButton(){
		driver.findElement(By.className("btn-primary")).click();
	}

	public String getErrorMessage(By locator){
		List<WebElement> element = driver.findElements(locator);

		if(element.size() != 0){
			return element.get(0).getText();
		}
		return "";
	}

	public String getForenameError(){

		return getErrorMessage(By.id("forename-err"));
	}

	public String getEmailError(){

		return getErrorMessage(By.id("email-err"));
	}

	public String getMessageError(){

		return getErrorMessage(By.id("message-err"));
	}

	public String getTelephoneInvalidError(){

		return getErrorMessage(By.id("telephone-err"));
	}

	public String getSuccessMessage(){
		return driver.findElement(By.className("alert-success")).getText();
	}

	public void setForename(String forename){
		driver.findElement(By.id("forename")).sendKeys(forename);
	}

	public void setEmail(String email){
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.clear();
		emailElement.sendKeys(email);
	}

	public void setMessage(String message){
		driver.findElement(By.id("message")).sendKeys(message);
	}

	public void setTelephone(String telephone){
		WebElement telephoneElement = driver.findElement(By.id("telephone"));
		telephoneElement.clear();
		telephoneElement.sendKeys(telephone);
	}
}
