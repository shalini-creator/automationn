package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import res.Base;
import res.Login;
import res.MyAccountPage;

public class ValidateMyAccountPage extends Base {
	
	@BeforeTest
	public void preconditions() throws Exception {
     driver=Validate();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
		@Test
		public void validatemyaccountPage() throws IOException
		{
			Login lg=new Login(driver);
	    	lg.loginform();
			MyAccountPage my=new MyAccountPage(driver);
			my.profileaccount();
	    	log.info("submit button is not working in  myaccount page");
	    
		}

	}

