package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationteststore.com/");
	}
	
	
	@Test
	void test() throws InterruptedException
	{
		RegisterPage rp = new RegisterPage(driver);
		rp.clickRegisBtn();
		rp.clickContinueBtn();
		rp.setFirstname("Saurabh");
		rp.setLastName("Mhatre");
		rp.setEmail("saurabh979@gmail.com");
		rp.setAddress(" near State Bank, John road");
		rp.setCity("abc");
		rp.setCountry("India");
		rp.setState("Maharashtra");
		rp.setZip("402201");
		rp.setLoginName("Saurabh97");
		rp.setPassword("test#79");
		rp.setConfirmPass("test#79");
		rp.setPrivacyPolicy();
		rp.setContinueButton();
		
		Thread.sleep(4000);
		
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");
	}
	
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	

}
