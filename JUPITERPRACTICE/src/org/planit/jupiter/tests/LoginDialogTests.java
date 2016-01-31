package org.planit.jupiter.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.planit.jupiter.pages.HomePage;
import org.planit.jupiter.pages.LoginDialog;

public class LoginDialogTests extends BaseTests {

	@Test
	public void verifyLoginDetailsRequired(){
		
		HomePage homePage = new HomePage(driver);
		LoginDialog loginDialog = homePage.clickLoginMenu();
		loginDialog.clickLoginButton();
		
		assertEquals("Your login details are incorrect",loginDialog.getLoginFieldsRequireErrorMessage());
		
	}
	
	@Test
	public void verifyLoginSuccessful(){
		HomePage homePage = new HomePage(driver);
		LoginDialog loginDialog = homePage.clickLoginMenu();
		
		loginDialog.setLoginName("Alok");
		loginDialog.setPassword("letmein");
		loginDialog.clickLoginButton();
		assertEquals("Alok", homePage.getLoggedInUserName());
	}
		
		
		
	@Test
	public void verifyLogoutSuccessful(){
		
		HomePage homePage = new HomePage(driver);
		LoginDialog loginDialog = homePage.clickLoginMenu();
		
		loginDialog.setLoginName("Alok");
		loginDialog.setPassword("letmein");
		loginDialog.clickLoginButton();
		
		homePage.clickLogoutButton();
		//assertEquals("Verify Logout successful","", homePage.getLoggedInUserName());
	}

}
