package test;
 import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;        

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class createtweet {
	Properties prop;
	Logger l=Logger.getLogger("createtweet");
	
		
		@Test  
		public void creattweet() throws IOException
		{
			prop=new Properties();
			PropertyConfigurator.configure("C:\\New folder\\API\\Log4j.properties");
		    FileInputStream fis=new FileInputStream("C:\\New folder\\API\\src\\data1.properties");
		    prop.load(fis);
			RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
			Response res=given().auth().oauth(prop.getProperty("consumerkey"),prop.getProperty("consumersecret"),prop.getProperty("Token"),prop.getProperty("Tokenscret")).
			queryParam("status","  learning API testing using RestAssured Java #Qualitest")
			.when().post("/update.json").then().extract().response();
			String response=res.asString();
			System.out.println(response);
			JsonPath js=new JsonPath(response);
			l.info(response);
			
			String id=js.getString("id");
			System.out.println(id);
			l.info(id);
			
			String text=js.getString("text");
			System.out.println(text);
			l.info(text);
		
		
	}
	

}
 