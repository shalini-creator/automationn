package test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import res.Base;
import res.Login;

public class ValidateLoginPage  extends Base{
	By message1=By.xpath("//h3[@class='text-align-left']");
	
	@BeforeTest
	public void preconditions() throws Exception {
driver=Validate();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
		@Test
		public void validateLoginPage() throws IOException
		{
			Login lg=new Login(driver);
	    	lg.loginform();
	    	Assert.assertEquals("Hi, neha kumari", driver.findElement(message1).getText());
	    	
	    	log.info("succesfully loged in");
	    
		}

	}

    

	
	
	
	
	
	


