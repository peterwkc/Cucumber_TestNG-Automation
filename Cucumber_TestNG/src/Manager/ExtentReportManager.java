package Manager;

import java.util.logging.Level;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private ExtentHtmlReporter htmlReporter;
    private ExtentReports extent;
    private ExtentTest logger;
	
    private static ExtentReportManager reportMgr;
    
	private ExtentReportManager() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/report/Test-Report.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "MyTest");
        extent.setSystemInfo("Environment", "SIT");
        extent.setSystemInfo("User Name", "Peter Wong");
        
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public static ExtentReportManager createInstance() {
		try 
		{
			if (reportMgr == null) {
				reportMgr = new ExtentReportManager();
			}
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
		
		return reportMgr;
	}

	// ================================================================================================

	public ExtentHtmlReporter getHtmlReporter() {
		return htmlReporter;
	}

	public void setHtmlReporter(ExtentHtmlReporter htmlReporter) {
		this.htmlReporter = htmlReporter;
	}

	public ExtentReports getExtent() {
		return extent;
	}

	public void setExtent(ExtentReports extent) {
		this.extent = extent;
	}

	public ExtentTest getLogger() {
		return logger;
	}

	public void setLogger(ExtentTest logger) {
		this.logger = logger;
	}
	
	/*
	 * @BeforeMethod
		public void setup(Method method) {
    		String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
    		String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
    		test = extent.createTest(descriptiveTestName);
		}
     *  logger = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName().toString());
	 * 
	 * 
	 * 
	 */
	

}
