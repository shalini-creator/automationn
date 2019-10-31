package test;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import res.Base;
import res.SignUp;

public class ValidateSignUpPage extends Base {
	@BeforeTest
	public void preconditn() throws Exception {
	
		driver=Validate();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    
	}
	@Test
	public void validatesignup() throws IOException
	{
		SignUp sg=new SignUp(driver);
    	sg.signupform();
    	
    	log.info("successfully registered ");
    
	}

}
