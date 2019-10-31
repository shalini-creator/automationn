package test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class wheathertweet {
	Properties prop;
	@Test
	public       void getweather() throws Exception
	{
		prop=new Properties();
	    FileInputStream fis=new FileInputStream("C:\\New folder\\API\\src\\data1.properties");
	    prop.load(fis);
		
		RestAssured.baseURI="https://api.twitter.com/1.1/search/";
		Response res=given().auth().oauth(prop.getProperty("consumerkey"),prop.getProperty("consumersecret"),prop.getProperty("Token"),prop.getProperty("Tokenscret")).
		queryParam("q","weather,Bangalore").
		when().
		get("/tweets.json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
extract().response();
		String response=res.asString();
		
		System.out.println(response);
		
	}

}
