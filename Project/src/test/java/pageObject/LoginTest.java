package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	LoginPage lp;
	@BeforeClass
	public void setup()
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationteststore.com/");
		lp = new LoginPage(driver);
	}
	
	@Test(priority = 4)
	public void SuccessLogin()
	{
		driver.get("https://automationteststore.com/");
		String username = "Saurabh";
		String password = "test#79";
		
		lp.login(username, password);
		
		Assert.assertTrue(lp.isLoginSuccessfull(),"Login was not successful");
		String wlcmMessage = lp.getwelcomMsg();
	    Assert.assertTrue(wlcmMessage.contains(username),"Welcome message doesn't contain username");
	}
	
    @Test(priority = 1)
    public void InvalidLogin() {

        String invalidUsername = "neverExist";
        String invalidPassword = "32541";
        
        lp.login(invalidUsername, invalidPassword);
        
        String errorMessage = lp.geterrormessage();
        Assert.assertTrue(errorMessage.contains("Error: Incorrect login or password provided"),
            "Expected error message not displayed");
    }
    
    @Test(priority = 2)
    public void testForgotLoginLink() {
    	driver.get("https://automationteststore.com/");
        lp.loginButton();
        lp.forgotlogin();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("forgotten/loginname"),"Not redirected to forgot login page");
    }
    
    @Test(priority = 3)
    public void testForgotPasswordLink() {
    	driver.get("https://automationteststore.com/");
    	lp.loginButton();
        lp.forgotPassword();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("forgotten/password"),"Not redirected to forgot password page");
    }
    
    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
