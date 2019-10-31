
    
package res;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.common.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class MyAccountPage {
    
    WebDriver driver;
    Properties prop;
    
    public MyAccountPage(WebDriver driver) {
        this.driver= driver;
    }
    
    By profile=By.xpath("//a[contains(text(),'My Profile')]");
    By password=By.xpath("//input[@placeholder='Password']");
    By conpassword=By.xpath("//input[@placeholder='Confirm Password']");
    By adress=By.xpath("//input[@placeholder='Address']");
    By city=By.xpath("//input[@placeholder='City']");
    By state=By.xpath("//input[@placeholder='State/Region']");
    By Postalcode=By.xpath("//input[@placeholder='Postal/Zip Code']");
    By country=By.xpath("//div[@class='chosen-container chosen-container-single']");
    By selectcountry=By.xpath("//input[@class='chosen-search-input']");
    
    
    By submitbtn=By.xpath("//button[@class='btn btn-action btn-block updateprofile']");
    
     public void profileaccount() throws IOException {
        
        prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\New folder\\Qtproject\\src\\main\\java\\res\\data.properties");
        prop.load(fis);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(profile).click();
        driver.findElement(password).sendKeys(prop.getProperty("Password1"));
        driver.findElement(conpassword).sendKeys(prop.getProperty("confirmpass1"));
        driver.findElement(adress).sendKeys(prop.getProperty("address1"));
        driver.findElement(city).sendKeys(prop.getProperty("city1"));
        driver.findElement(state).sendKeys(prop.getProperty("state1"));
        driver.findElement(Postalcode).sendKeys(prop.getProperty("postalcode"));
        driver.findElement(country).click();
        driver.findElement(selectcountry).click();
        
        driver.findElement(selectcountry).sendKeys(prop.getProperty("country1"));
        driver.findElement(selectcountry).sendKeys(Keys.ENTER);
       
        /*driver.findElement(country).getText();*/
        driver.findElement(submitbtn).click();
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Desktop\\screenshoots\\myaccount.png"));

        
        
    }


}
 








