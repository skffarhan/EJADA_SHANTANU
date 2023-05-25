package com.stepDefination.Sauce;

import org.openqa.selenium.By;

import com.generics.BaseTest;
import com.generics.Pojo;
import com.pageFactory.common.SAUCE.DashbordPage;

import io.cucumber.java.en.Then;

public class DashboardStepDefination {

	private Pojo objPojo;
	private DashbordPage objDashbordPage;
	private String testData;

	public DashboardStepDefination(BaseTest pojo) throws Exception {
		objPojo = pojo.initializeWebEnvironment();
		objDashbordPage = new DashbordPage(objPojo);

	}
	/**
	 * @ScriptName : Select Dropdown method
	 * @Author : Shantanu Mondal
	 **/

	@Then("Select DropDown For Filtering {string}")
	public void select_drop_down_for_filtering(String Dropdown) {
		By locator2 = By.xpath("//select[@class='product_sort_container']");
		objPojo.getObjWrapperFunctions().selectDropDownOption(locator2, Dropdown);
		objPojo.getObjWrapperFunctions().waitFor(2);
	}
	
	/**
	 * @ScriptName : Add any two expensive products method
	 * @Author : Shantanu Mondal
	 **/
	@Then("Add the most expensive products to your cart {string} and {string}")
	public void add_the_most_expensive_products_to_your_cart(String ProductName1, String ProductName2) {
		if (!ProductName1.equals("") && !ProductName2.equals("")) {
			objDashbordPage.selectProduct(ProductName1, ProductName2);
		}

	}
	/**
	 * @ScriptName : Click on the cart button method
	 * @Author : Shantanu Mondal
	 **/

	@Then("Click on the cart button")
	public void click_on_the_cart_button() {
		objDashbordPage.ClickCart();
	}
	
	/**
	 * @ScriptName : Verify selected products are displayed at the page method
	 * @Author : Shantanu Mondal
	 **/

	@Then("Verify that selected products are displayed at the page")
	public void verify_that_selected_products_are_displayed_at_the_page() {
		objDashbordPage.verifyProducts();
	}
	
	/**
	 * @ScriptName : Click on the Checkout button method
	 * @Author : Shantanu Mondal
	 **/

	@Then("Click on the Checkout button")
	public void click_on_the_checkout_button() {
		objDashbordPage.CheckOut();
	}
	
	/**
	 * @ScriptName : Fill the details dynamically method
	 * @Author : Shantanu Mondal
	 **/
	
	@Then("Fill all the details displayed with {string} , {string} and {string}")
	public void fill_all_the_details_displayed_with_and(String string, String string2, String string3) {
		testData = objPojo.getObjUtilities().dpString("FIRST-NAME");
		if (!testData.equals("")) {
			String FirstName = objPojo.getObjUtilities().getRandomFirstNameGenerator();
			objDashbordPage.setFirstnameInformation(FirstName);
		}
		testData = objPojo.getObjUtilities().dpString("LAST-NAME");
		if (!testData.equals("")) {
			String LastName = objPojo.getObjUtilities().getRandomLastNameGenerator();
			objDashbordPage.setLastnameInformation(LastName);
		}
		testData = objPojo.getObjUtilities().dpString("ZIP-CODE");
		if (!testData.equals("")) {
			String ZipCode = objPojo.getObjUtilities().getRandomString(6);
			objDashbordPage.setZipCodeInformation(ZipCode);
		}
	}
	
	/**
	 * @ScriptName :Click on the Continue button method
	 * @Author : Shantanu Mondal
	 **/

	@Then("Click on the Continue button")
	public void click_on_the_continue_button() {
		objDashbordPage.ClickContinue();
	}
	
	/**
	 * @ScriptName : Verify all the details filled along with checkout button
	 * @Author : Shantanu Mondal
	 **/

	@Then("Verify the Final details with page title as {string}")
	public void verify_the_final_details_with_page_title_as(String string) {
		objDashbordPage.verifyFinalDetails(string);
	}
	
	/**
	 * @ScriptName : Click on the Finish button method
	 * @Author : Shantanu Mondal
	 **/

	@Then("Click on the Finish button")
	public void click_on_the_finish_button() {
		objDashbordPage.ClickFinish();
	}
	
	/**
	 * @ScriptName : Verify Order method
	 * @Author : Shantanu Mondal
	 **/

	
	@Then("Verify whether {string} and {string} is displayed successfully")
	public void verify_whether_and_is_displayed_successfully(String string, String string2) {
		objDashbordPage.verifyCompletionMessage(string, string2);
	    
	}

}
