package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Manager.PropertiesManager;
import Manager.WebDriverManager;

public class Login_Pages {
	
	@FindBy(id = "inputName")
	private WebElement username;
	
	@FindBy(id = "inputPassword")
	private WebElement password; 
	
	@FindBy(xpath = "/html/body/div[1]/div/div/form/div/div[5]/div[2]/div/div[2]/button")
	private WebElement submitBtn;
	
	private PropertiesManager pm;
	
	public Login_Pages() {
		pm = PropertiesManager.createInstance();
	}
	
	public void login() {
		username.sendKeys(pm.getProperties().getProperty("username"));
		WebDriverManager.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		password.sendKeys(pm.getProperties().getProperty("password"));
		WebDriverManager.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		submitBtn.click();
	}
	
	

}
