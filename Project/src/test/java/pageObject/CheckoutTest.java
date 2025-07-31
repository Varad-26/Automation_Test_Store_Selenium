package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
	
	WebDriver driver;
	CheckoutPage chckout;
	
	@BeforeClass
	public void setup()
	{
		 driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://automationteststore.com/");
	     chckout = new CheckoutPage(driver);
	}
	
	@Test
	public void Checkout() throws InterruptedException
	{
		chckout.viewProduct();
		chckout.addToCart();
		
		chckout.proceedToCheckout();
		
		chckout.selectGuestCheckout();
		
		chckout.personalDetalis("Saurabh", "Mhatre", "saurabh79@gmail.com");
		
		chckout.BillingAddress("Opposite of SBI, Martin Road", "abc", "India", "Maharashtra", "402201");
		
		chckout.continueToDelivery();
		
		chckout.verifyOrderDetails();
		
		chckout.confirmOrder();
		
		  Thread.sleep(2000);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
