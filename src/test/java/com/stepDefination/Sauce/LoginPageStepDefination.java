package com.stepDefination.Sauce;

import org.openqa.selenium.By;

import com.generics.BaseTest;
import com.generics.Pojo;
import com.pageFactory.common.SAUCE.LoginPage;

import io.cucumber.java.en.Then;

public class LoginPageStepDefination {
	private Pojo objPojo;
	private String testData;
	private LoginPage objLoginPage;
	
	public LoginPageStepDefination(BaseTest pojo) throws Exception {
		objPojo = pojo.initializeWebEnvironment();
		objLoginPage = new LoginPage(objPojo);
	}
	/**
	 * @ScriptName : Method Login user name and password
	 * @Author : Shantanu Mondal
	 **/
	@Then("Fill {string} , {string} and click on {string} button in Sauce Login Page.")
	public void fill_and_click_on_button_in_uti_login_page(String UserName, String Password, String Login) {

		// Set User Name
		testData = objPojo.getObjUtilities().dpString("USERNAME");
		if (!testData.equals("")) {
			objLoginPage.setUsername(testData);

		}

		// Set Password
		testData = objPojo.getObjUtilities().dpString("PASSWORD");
		if (!testData.equals("")) {
			objLoginPage.setPassword(testData);
		}

		// Click Login
		By locator = By.xpath("//input[@id='login-button']");
		objPojo.getObjUtilities().logReporter("Click Login Button to get logged in. ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjWrapperFunctions().waitFor(2);

		// Click OK on popup

		By locator1 = By.xpath("//div[@id='root']");
		objPojo.getObjUtilities().logReporter("Click ok on Pop after Login. ",
				objPojo.getObjWrapperFunctions().click(locator1));
		objPojo.getObjWrapperFunctions().waitFor(2);

	}


}
