package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest {
	
    WebDriver driver;
    CartPage cartPage;
    
    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationteststore.com/");
        cartPage = new CartPage(driver);
    }
    
    @Test
    public void testCartOperations() {
        cartPage.viewProduct();
        
        cartPage.addToCart();
        
        cartPage.increaseQuantity("2");
        
        cartPage.updateProduct();
        
        cartPage.removeProduct();
    }
    
    @AfterClass
    public void teardown() {

            driver.quit();
    }
}
