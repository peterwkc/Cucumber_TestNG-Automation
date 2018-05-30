/**
 * 
 */
package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.CucumberException;
import cucumber.api.testng.PickleEventWrapper;
//import cucumber.runtime.testng.*;

import java.io.IOException;
import java.util.logging.Level;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Manager.ExtentReportManager;
import Manager.LogManager;
import Manager.PropertiesManager;
import Manager.WebDriverManager;
 
@CucumberOptions(
        features = "src/Feature",
        glue = {"Step_Definitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
})
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    private ExtentReportManager reportMgr;
    private PropertiesManager pm;
    
    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        
        pm = PropertiesManager.createInstance();
        reportMgr = ExtentReportManager.createInstance();
        
        WebDriverManager.createDriver();
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature"/*, dataProvider = "dataProvider"*/)
    public void feature(ITestContext context) {
    	try { 
    		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

            for (Object[] scenario : testNGCucumberRunner.provideScenarios()) {
                PickleEventWrapper pickleEvent = (PickleEventWrapper) scenario[0];
                testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
            }
    	} catch (CucumberException ex) {
    		LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
    	} catch (Throwable ex) {
    		LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
    	
    	// testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    /*@DataProvider(name = "dataProvider")
    public Object[][] features(CucumberFeature asd) {
        return testNGCucumberRunner.provideFeatures();
    }*/
 
    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
    	reportMgr.getExtent().flush();
    	WebDriverManager.tearDown();
    	
        testNGCucumberRunner.finish();
    }
    
    // =========================================================================================
   
    /* 	BeforeSuite
		BeforeTest
		BeforeClass
		BeforeMethod
		myTestMethod3
		AfterMethod
		BeforeMethod
		myTestMethod4
		AfterMethod
		AfterClass
		AfterTest
		BeforeTest
		BeforeClass
		BeforeMethod
		myTestMethod1
		AfterMethod
		BeforeMethod
		myTestMethod2
		AfterMethod
		AfterClass
     * 
     * BeforeSuite > BeforeTest > BeforeClass > BeforeMethod
     * 
     * 
     * 
     * 	
     *
     *	Can insert any custom HTML in the logs by using an HTML tag.
	 *	Can show the screenshots in the report wherever we need.
	 *	Can add recording of your test runs in the report.
     *
     * http://picocontainer.com/introduction.html 
     */
    
    /*  
    @Test
    public void passTest(){
    	logger = extent.createTest("passTest");
    	Assert.assertTrue(true);
    	logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
    
    	 try {
 			logger.fail("Pass Details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
 		} catch (IOException ex) {
 			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
 		}
    }
    
    @Test
    public void failTest(){
	    logger = extent.createTest("failTest");
	    Assert.assertTrue(false);
	    logger.log(Status.PASS, "Test Case (failTest) Status is passed");
	    logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.RED));
    
	    try {
			logger.fail("Fail Details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (IOException ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
    }
    
    @Test
    public void skipTest(){
	    logger = extent.createTest("skipTest");
	    throw new SkipException("Skipping - This is not ready for testing ");
    }*/
  /*  
    @AfterMethod
    public void getResult(ITestResult result){
	    if(result.getStatus() == ITestResult.FAILURE) {
	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	    }
	    else if(result.getStatus() == ITestResult.SKIP) {
	    	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
	    }
    }
    */
    
    // ===============================================================================================
    
    
    /* Latest Test Runner Example
     * https://github.com/cucumber/cucumber-jvm/blob/master/testng/src/test/java/cucumber/api/testng/TestNGCucumberRunnerTest.java
     *  
     * 
     * 
     * 
     * 
     * 
     */
     
    
    
    
}