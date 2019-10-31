package res;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class Base {                                                                                                                                                                                                                                                                       

    public WebDriver driver;
		public Properties prop;
		public static org.apache.logging.log4j.Logger log;
		@BeforeSuite
		public void logs() throws FileNotFoundException, IOException
		{
			String Logconfig="C:\\New folder\\Qtproject\\log4j.xml";
			ConfigurationSource src=new ConfigurationSource(new FileInputStream(Logconfig));
			Configurator.initialize(null,src);
			log= LogManager.getLogger(Base.class.getName());	
		}
     public WebDriver Validate() throws Exception {
	    	prop=new Properties();
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			driver=new ChromeDriver();
			FileInputStream fis=new FileInputStream("C:\\New folder\\Qtproject\\src\\main\\java\\res\\data.properties");
			prop.load(fis);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			return driver;
	    }
}
			
			
			
			
			
	    			
	    			
	   


