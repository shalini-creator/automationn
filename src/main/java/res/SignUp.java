package res;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.common.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SignUp extends Base {
	WebDriver driver;
	Properties prop;

	public SignUp(WebDriver driver) {
		this.driver=driver;
		
	}
	By myaccount=By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/a[1]");
	By singup=By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/a[2]");
	By fname=By.xpath("//input[@placeholder='First Name']");
	By lname=By.xpath("//input[@placeholder='Last Name']");
	By mobilenumber=By.xpath("//input[@placeholder='Mobile Number']");
	By email=By.xpath("//input[@placeholder='Email']");
	By password=By.xpath("//input[@placeholder='Password']");
	By confirmpass=By.xpath("//input[@placeholder='Confirm Password']");
	/*By Cookie = By.xpath("//button[@id='cookyGotItBtn']");*/
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By signbtn= By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[9]/button[1]");
	public void signupform() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\New folder\\Qtproject\\src\\main\\java\\res\\data.properties");
		prop.load(fis);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(myaccount).click();
		driver.findElement(singup).click();
		driver.findElement(fname).sendKeys(prop.getProperty("fname"));
		driver.findElement(lname).sendKeys(prop.getProperty("lname"));
		driver.findElement(mobilenumber).sendKeys(prop.getProperty("mobilenumber"));
		driver.findElement(email).sendKeys(prop.getProperty("Email"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		driver.findElement(confirmpass).sendKeys(prop.getProperty("confirmpass"));
		driver.findElement(Cookie).click();
		driver.findElement(signbtn).click();
		log.info("signup button is not working");
	
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src,new File("C:\\Users\\Online Test\\Desktop\\screenshoots\\signup.png"));
		
		
	}	
}