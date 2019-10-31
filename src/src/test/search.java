package test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class search {
	 Properties prop;
	 Logger l=Logger.getLogger("search");
	@Test
	public       void search_tweet() throws IOException
	{
		
		prop=new Properties();
		PropertyConfigurator.configure("C:\\New folder\\API\\log4j.properties");
	    FileInputStream fis=new FileInputStream("C:\\New folder\\API\\src\\data1.properties");
	    prop.load(fis);
		
	RestAssured.baseURI="https://api.twitter.com/1.1/search/";
	Response res=given().auth().oauth(prop.getProperty("consumerkey"),prop.getProperty("consumersecret"),prop.getProperty("Token"),prop.getProperty("Tokenscret")).
	queryParam("q", "Qualitest")
	.when().get("/tweets.json").then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
	
	String response=res.asString();
	System.out.println(response);
	l.info(response);
	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	