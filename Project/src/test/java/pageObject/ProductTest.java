package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest {
	
	WebDriver driver;
    ProductPage productPage;
    
    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationteststore.com/index.php?rt=product/product&product_id=50");
        productPage = new ProductPage(driver);
    }
    
    @Test(priority = 1)
    public void verifyProductDetails() {
        String title = productPage.getProductTitle();
        String price = productPage.getProductPrice();
        
        Assert.assertFalse(title.isEmpty(), "Product title should not be empty");
        Assert.assertFalse(price.isEmpty(), "Product price should not be empty");
        System.out.println("Product: " + title + " | Price: " + price);
    }
    
    @Test(priority = 2)
    public void testAddToCart() {

        productPage.setQuantity(2);
  
        productPage.addToCart();
        
    }
    
    @Test(priority = 3)
    public void testViewCart() {
        productPage.viewCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout/cart"), 
            "Should be redirected to cart page");
    }
    
    @AfterClass
    public void teardown() {
            driver.quit();  
    }
}
