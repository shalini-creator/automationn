package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import res.Base;
import res.HotelSearch;

public class ValidateHotelSearch extends Base {
	
	@BeforeTest
	public void preconditions() throws Exception {
     driver=Validate();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
		@Test
		public void validateHotelSearchPage() throws IOException
		{
			HotelSearch hs=new HotelSearch(driver);
	    	hs.hotels();
	    	log.info("validated the hotel search page");
	    
		}

	}





	
	
	


