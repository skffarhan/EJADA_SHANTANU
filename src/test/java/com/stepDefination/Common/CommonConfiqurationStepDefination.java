package com.stepDefination.Common;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.generics.BaseTest;
import com.generics.Pojo;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonConfiqurationStepDefination {

	private Pojo objPojo;


	public CommonConfiqurationStepDefination(BaseTest pojo) throws Exception {
		objPojo = pojo.initializeWebEnvironment();
		
	}

	@Before
	public void initializeScenario(Scenario scenario) {
		objPojo.setTestCaseID(scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) {
		((BaseTest) objPojo).tearDownWebEnvironment(scenario);
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		byte[] screenshotAs = ((TakesScreenshot) objPojo.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs, "image/png", scenario.getName());
	}

	/**
	 * @Method : Load URL
	 * @Description : Use Following method to Navigate to Specific URL
	 * @param : moduleName : Name of app path to be navigated
	 * @Author : Farhan Shaikh - AQM Technologies
	 */
	@When("Navigate To Specific Portal : {string}")
	public void navigate_To_Specific_Portal(String string) {
		objPojo.getObjWrapperFunctions().loadBaseURL();
	}

	/**
	 * @throws IOException
	 * @Method : Load Data Provider
	 * @Description : Use Following method to Get excel data
	 * @Author : Farhan Shaikh - AQM Technologies
	 */
	@Given("Load {string} TestData in Specific Excel Sheet{string}.")
	public void load_TestData_in_Specific_Excel_Sheet(String string, String SheetName) throws IOException {
		objPojo.getObjUtilities().loadDataProvider(SheetName);
		System.err.println("Test data Load for execution>>>>" + objPojo.getObjHashTable());
	}

	

	

}
