package Step_Definitions;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import Manager.ExtentReportManager;
import Manager.PropertiesManager;
import Manager.WebDriverManager;
import Pages.Login_Pages;
import Pages.Logout_Pages;
import Util.CaptureScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Logout {
	private PropertiesManager pm;
	private ExtentReportManager reportMgr;
	
	private Logout_Pages logoutPages; 
	
	public Logout() {
	}
	
	@Before
	public void setUp() {
		pm = PropertiesManager.createInstance();
		reportMgr = ExtentReportManager.createInstance();
		
		logoutPages = PageFactory.initElements(WebDriverManager.driver, Logout_Pages.class);
	}
	
	@Given("^A user has login to Volare Collector$")
	public void assertLogin() {
		logoutPages.assertLogin();
	}
	
	@When("^Click logout button$")
	public void logout() {
		logoutPages.logout();
	}
	
	@Then("^Logout from Volare Collector and redirect to login page$")
	public void afterLogout() {
		logoutPages.assertLogout();
	}
	
	
	

}
