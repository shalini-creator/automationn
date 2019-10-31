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

public class Login  extends Base{
	WebDriver driver;
	Properties prop;
	public Login (WebDriver driver) {
		this.driver=driver;
				
			}
			By myaccount=By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/a[1]");
			By login=By.xpath("//a[@class='dropdown-item active tr']");
			By Email=By.xpath("//input[@placeholder='Email']");
			By Password=By.xpath("//input[@placeholder='Password']");
			By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
			By loginbtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]");
			
			public void loginform() throws IOException
			{
				prop=new Properties();
				FileInputStream fis=new FileInputStream("C:\\New folder\\Qtproject\\src\\main\\java\\res\\data.properties");
				prop.load(fis);
				driver.findElement(myaccount).click();
				driver.findElement(login).click();
				/*driver.findElement(Cookie).click();*/
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(Email).sendKeys(prop.getProperty("Email"));
				driver.findElement(Password).sendKeys(prop.getProperty("Password"));
				driver.findElement(Cookie).click();
				driver.findElement(loginbtn).click();
				
				File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Desktop\\screenshoots\\login.png"));
				
			}

		}
