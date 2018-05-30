package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Manager.WebDriverManager;

public class Logout_Pages {

	@FindBy(xpath = "//*[@id=\"dropdownMenu2\"]/div/div/p")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"ddmenu2\"]/ul/li/a")
	private WebElement logout;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/form")
	private WebElement loginForm;
	
	
	public Logout_Pages() {
	}
	
	public void assertLogin() {
		String loginName = username.getText();
		Assert.assertTrue(loginName.contains("HI, PETER"));
	}
	
	public void logout () {
		username.click();
		logout.click();
	}
	
	public void assertLogout() {
		WebDriverWait wait = new WebDriverWait(WebDriverManager.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/form")));
		
		boolean isPresent = WebDriverManager.driver.findElements(By.xpath("/html/body/div[1]/div/div/form")).size() > 0;
		Assert.assertTrue(isPresent);
	}
	
	
	
	

}
