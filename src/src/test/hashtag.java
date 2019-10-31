package test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class hashtag {
	Properties prop;
	Logger l=Logger.getLogger("hashtag");
	@Test
	public       void  hashtags() throws IOException
	{
		
		prop=new Properties();
		PropertyConfigurator.configure("C:\\New folder\\API\\log4j.properties");
	    FileInputStream fis=new FileInputStream("C:\\New folder\\API\\src\\data1.properties");
	    prop.load(fis);
		RestAssured.baseURI="https://api.twitter.com/1.1/trends";
		Response res=given().auth().oauth(prop.getProperty("consumerkey"),prop.getProperty("consumersecret"),prop.getProperty("Token"),prop.getProperty("Tokenscret")).
				
				when().get("/available.json").then().assertThat().statusCode(200).extract().response();
		String response=res.asString();
		System.out.println(response);
		

	JsonPath js=new JsonPath(response);
	l.info(response);
	int count=js.get("size()");
	for(int i=0;i<count;i++)
	{
		String country=js.get("["+i+"].country").toString();
		if(country.equalsIgnoreCase("india"))
		{String id=js.get("["+i+"].parentid").toString();
		Response res1=given().auth().oauth(prop.getProperty("consumerkey"),prop.getProperty("consumersecret"),prop.getProperty("Token"),prop.getProperty("Tokenscret")).
				param("id",id)
				.when().get("/place.json").then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		String response1=res1.asString();
		JsonPath js1=new JsonPath(response1);
		l.info(response1);
		int count1=js1.get("["+0+"].trends.size()");
		for(int j=0;j<count1;j++)
		{
			String hash=js1.getString("["+0+"].trends["+j+"].name");
			String hash1=js1.getString("["+0+"].trends["+j+"]").toString();
			if(hash.charAt(0)=='#' && j<=5)
			{System.out.println(hash1);
			l.info(hash1);
			}
			}
			break;
		}
		
		}
	}
				
		
	}


