package org.planit.jupiter.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.planit.jupiter.pages.ContactPage;
import org.planit.jupiter.pages.HomePage;

public class ContactTests extends BaseTests {

	//@Test
	public void mandatoryContactFormFieldsRequired(){
		// on home page click contact menu
		// on contact page click the submit button
		// verify the forename error is 'Forename is required'
		// verify the email error is 'Email is required'
		// verify the message error is 'Message is required'
		
		// set the forename to 'Alok'
		// set the email to 'alok@abc.com'
		// set the message to 'Nice Toys'
		
		// verify the forename error is ''
		// verify the email error is ''
		// verify the message error is ''
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactMenu();
		
		contactPage.clickSubmitButton();
		assertEquals("Verify forename is required","Forename is required",contactPage.getForenameError());
		assertEquals("Verify email is required","Email is required", contactPage.getEmailError());
		assertEquals("Verify message is required","Message is required", contactPage.getMessageError());
		
		contactPage.setForename("Alok");
		contactPage.setEmail("alok@abc.com");
		contactPage.setMessage("Nice Toys");
		assertEquals("Verify the forename error is '' ", "", contactPage.getForenameError());
		assertEquals("Verify the email error is '' ", "", contactPage.getEmailError());
		assertEquals("Verify the message error is ''", "", contactPage.getMessageError());
	}
	
	@Test
	public void testDataValidationOfEmailAndTelephoneNumber() {
		
		// on home page click contact menu
		// set the email to 'a121'
		// set the telephone to '15fg1ggf'
		
		// verify the email error is 'Please enter a valid email'
		// verify the telephone error is 'Please enter a valid telephone number'
		
		// set the email to 'alok@abc.com'
		// set the telephone to '0294640615'

		// verify the email error is ''
		// verify the telephone error is ''
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactMenu();
		
		contactPage.setEmail("a121");
		contactPage.setTelephone("15fg1ggf");
    	assertEquals("Verify email invalid error", "Please enter a valid email", contactPage.getEmailError());
		assertEquals("Verify telephone invalid error", "Please enter a valid telephone number", contactPage.getTelephoneInvalidError());
		
		contactPage.setEmail("alok@abc.com");
		contactPage.setTelephone("0294640615");
		assertEquals("Verify the email error is ''", "", contactPage.getEmailError());
		assertEquals("Verify the telephone error is ''", "", contactPage.getTelephoneInvalidError());
	}

	//@Test
	public void testValidFormSubmission() {
		// on home page click contact menu
		
		// set the forename to 'Alok'
		// set the email to 'alok@abc.com'
		// set the message to 'Nice Toys'
		
		// click the submit button
		
		//verify the success message is 'Thanks Alok, we appreciate your feedback.'
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactMenu();

		contactPage.setForename("Alok");
		contactPage.setEmail("alok@abc.com");
		contactPage.setMessage("Nice Toys");
		contactPage.clickSubmitButton();
		assertEquals("Verify success message", "Thanks Alok, we appreciate your feedback.", contactPage.getSuccessMessage());
		
		
	}
}
