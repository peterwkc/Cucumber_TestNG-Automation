package Step_Definitions;

import java.io.IOException;
import java.util.logging.Level;

import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;

import Manager.ExtentReportManager;
import Manager.LogManager;
import Manager.PropertiesManager;
import Manager.WebDriverManager;
import Pages.Login_Pages;
import Util.CaptureScreenshot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	private PropertiesManager pm;
	private ExtentReportManager reportMgr;
	private Login_Pages loginPages; 
	
	public Login() {
		
	}
	
	@Before
	public void setUp() {
		pm = PropertiesManager.createInstance();
		reportMgr = ExtentReportManager.createInstance();
		
		loginPages = PageFactory.initElements(WebDriverManager.driver, Login_Pages.class);
		
	}
	
	@Given("^Volare Collector Home Page opens in browser$")
	public void loadPage() {
		try {
			WebDriverManager.driver.get(pm.getProperties().getProperty("homepage"));
			WebDriverManager.driver.manage().window().maximize();

		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}

	@When("^I login to Volare Collector with Username and Password$")
	public void login() {
		try {
			
			loginPages.login();
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}

	@Then("^Page navigate to Volare Collector Home Page$")
	public void navigatePage() {
		try {
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}

	}
	
	@After
	public void tearDown(Scenario scen) throws IOException {
		ExtentTest logger = reportMgr.getLogger();
		String feature = getClass().getName();    //+ "." + Thread.currentThread().getStackTrace()[1].getMethodName().toString();
		
		logger = reportMgr.getExtent().createTest(feature);
	
		String screenShot = CaptureScreenshot.captureScreen(WebDriverManager.driver, CaptureScreenshot.generateFileName(feature));
		if (!scen.isFailed()) {
			logger.pass("Pass");
			logger.addScreenCaptureFromPath(screenShot);
		} else {
			logger.fail("Fail");
			logger.addScreenCaptureFromPath(screenShot);
		}
	}
	
	// ============================================================================================

	
	/*  Selenium Tutorial - https://www.seleniumhq.org/docs/index.jsp
	 * 
	 *  Explicit Wait
	 *  WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ID")));
		
		WaitForElementVisible
		WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));
		
		Wait Until Clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
		
		Wait Until Disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divProgress")));
		
		Wait Until Presence
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  		.until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
		
		wait.until(ExpectedConditions.alertIsPresent());

		Custom Expected Condition
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(...).getText().length() != 0;
            }
        });
        
        Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Fluent Wait
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
 		// It should poll webelement after every single second
 
        wait.pollingEvery(1, TimeUnit.SECONDS);
        
		// ----------------------------------------------------------------------------------------
		Drag and Drop
		// Create object of actions class
		Actions act=new Actions(driver);
		
		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
		
		// find element which we need to drop
		WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
		
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		
		Double Click 
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/div/table/tbody/tr[10]/td[1]"))).doubleClick().perform()
		
		Actions action = new Actions(driver);
		WebElement element=driver.findElement(By.linkText("TEST"));
		
		//Double click
		action.doubleClick(element).perform();
		
		//Mouse over
		action.moveToElement(element).perform();
		
		//Right Click
		action.contextClick(element).perform();
		
		
		Select Drop Down By Text
		Select dropdown = new Select(driver.findElement(By.id("identifier")));
		dropdown.selectByVisibleText("Programmer ");
		dropdown.selectByIndex(4);
		dropdown.selectByValue(“5”);
		
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		
		ele.getAttribute("innerHTML").contains("JavaScript"))
		
		Multi Select Check Box
		List<WebElement> elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
		elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
    	elements.get(i).click();
    
		Assert
		WebElement rxBtn = driver.findElement(By.className("icon-rx"));
    	WebElement otcBtn = driver.findElement(By.className("icon-otc"));
    	WebElement herbBtn = driver.findElement(By.className("icon-herb"));

	    Assert.assertEquals(true, rxBtn.isDisplayed());
	    Assert.assertEquals(true, otcBtn.isDisplayed());
	    Assert.assertEquals(true, herbBtn.isDisplayed());
		
		
		Alert Dialog
		Alert alert = driver.switchTo().alert();
        alert.accept();
		
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();		
		driver.switchTo().alert().sendKeys("Text");
		
		File Upload
		WebElement fileInput = driver.findElement(By.name("uploadfile"));
		fileInput.sendKeys("C:\\path\\to\\file.jpg");
		
		
		Click on Calendar
		driver.findElement(By.id("datepicker")).click();		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele:allDates) {
			String date=ele.getText();
			if(date.equalsIgnoreCase("28")){
				ele.click();
				break;
			}
		}
		
		java.awt.Robot;
		
		Scroll Page using javascript
		org.openqa.selenium.JavascriptExecutor
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		
		
		Handle Untrusted Certificate - Chrome
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriver driver=new ChromeDriver(cap);
		
		
		
		
		moveToElement(WebElement)-- Mouse Hover
		contextClick()-- Right click on page
		Actions act=new Actions(driver);
		act.contextClick(driver.findElement(By.linkText(“Gujarati”))).perform();

		contextClick(WebElement)-- Right click on specific Element
		sendKeys(KEYS.TAB)--For keyboard events
		act.contextClick(driver.findElement(By.linkText("Gujarati"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		clickAndHold(WebElement)--Click on element and hold until next operation
		release() Release the current control
		

		Test Focus
		element.equals(driver.switchTo().activeElement());
		
		Open New Tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		Open Multiple Window
		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
 
		while(I1.hasNext()){
		   String child_window=I1.next();
			if(!parent.equals(child_window)){
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
			}
		 
		}
		
		driver.switchTo().window(parent);
		 
		}
		
		Frame
		driver.switchTo().frames(0, "name");
		
		
		Solve Stale Exception in Selenium
		WebDriverManager.driver.navigate().refresh();
		
		Solve InvalidElementStateException
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('pass').value = 'mukeshotwani';");
		
		
		Solve WebDriverException: f.QueryInterface is not a function
		Pass protocol to navigate function
		
		Chrome Options
		ChromeOptions options = new ChromeOptions();
		// set some options
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new RemoteWebDriver(dc);
		
		Firefox Profile
		FirefoxProfile fp = new FirefoxProfile();
		// set something on the profile...
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, fp);
		WebDriver driver = new RemoteWebDriver(dc);
		
		Set Proxy Programmatically
		String PROXY = "localhost:8080";
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		     .setFtpProxy(PROXY)
		     .setSslProxy(PROXY);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
		
		WebDriver driver = new ChromeDriver(cap);
		
		
		
		
		Interview Questions
		http://learn-automation.com/selenium-interview-questions-and-answers/
		
		
		
		
		
		
		Running Cucumber from CLI
		mvn test
		java -cp "/Users/jreijn/.m2/repository/info/cukes/cucumber-core/1.2.5/cucumber-core-1.2.5.jar:/Users/jreijn/.m2/repository/info/cukes/gherkin/2.12.2/gherkin-2.12.2.jar:/Users/jreijn/.m2/repository/info/cukes/cucumber-java/1.2.5/cucumber-java-1.2.5.jar:/Users/jreijn/.m2/repository/info/cukes/cucumber-jvm-deps/1.0.5/cucumber-jvm-deps-1.0.5.jar" cucumber.api.cli.Main Developer/sources/github/cucumber-jvm-extentreport/src/test/resources/cucumber/feature_one.feature

	 */
	
	

}
