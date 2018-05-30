package Manager;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

	public static WebDriver driver = null;
	
	private WebDriverManager() {
	}
	
	public static void createDriver() {
		try {
			if (driver == null) {
				driver = new ChromeDriver();
			}
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}
	
	public static void tearDown() {
		try {
			driver.close();
			driver.quit();
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}
	
	

}
