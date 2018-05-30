package Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

public class PropertiesManager {

	Properties prop;
	InputStream input;
	
	private static PropertiesManager obj = null;
	
	private PropertiesManager() {
		prop = new Properties();
		try {
			input = new FileInputStream("config.properties");
			loadFile();
		} catch (FileNotFoundException ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}
	
	public static PropertiesManager createInstance() {
		try {
			if (obj == null) {
				obj = new PropertiesManager();
				obj.loadFile();
			}
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
		
		return obj;
	}

	public void loadFile() {
		try {
			prop.load(input);
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}
	
	public Properties getProperties() {
		return prop;
	}
	
	

}
