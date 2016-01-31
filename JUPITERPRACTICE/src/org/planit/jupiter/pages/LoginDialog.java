package org.planit.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDialog {
	
	protected WebDriver driver;
	
	public LoginDialog(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickLoginButton(){
		driver.findElement(By.className("btn-primary")).click();
	}
	
	public String getLoginFieldsRequireErrorMessage(){
		return driver.findElement(By.id("login-error")).getText();
	
	}
	
	public void setLoginName(String username){
		driver.findElement(By.id("loginUserName")).sendKeys(username);
	}
	
	public void setPassword(String password){
		driver.findElement(By.id("loginPassword")).sendKeys(password);
	}
	
	public void clickCancelButton(){
		driver.findElement(By.className("btn-cancel")).click();
	}
	

}
