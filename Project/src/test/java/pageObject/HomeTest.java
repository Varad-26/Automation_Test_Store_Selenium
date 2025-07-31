package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest {
	
    WebDriver driver;
    HomePage homePage;
    
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationteststore.com/");
        homePage = new HomePage(driver);
    }
    
    @Test
    public void categoryNavigation() {

        String categoryName = "Men";
        homePage.selectCategory(categoryName);
        
        Assert.assertTrue(driver.getTitle().contains(categoryName), 
            "Not on the correct category page. Current title: " + driver.getTitle());
    }
    
    @Test
    public void searchFunctionality() {
        String productName = "Skinsheen Bronzer Stick";
        homePage.searchForProduct(productName);

        Assert.assertTrue(driver.getTitle().contains(productName), 
            "Search results page not displayed correctly");
    }
    
    @AfterClass
    public void teardown() {
            driver.quit();
    }
}
