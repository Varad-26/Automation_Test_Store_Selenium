package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FooterTest {
	
    WebDriver driver;
    FooterPage footerPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationteststore.com/");
        footerPage = new FooterPage(driver);
    }

    @Test(priority = 1)
    public void verifyFooter() {
        Assert.assertTrue(footerPage.isFooterDisplayed(), "Footer should be visible");
    }

    @Test(priority = 2)
    public void verifyFooterLinks() {
        java.util.List<WebElement> links = footerPage.getAllFooterLinks();
        Assert.assertFalse(links.isEmpty(), "Footer should contain links");
        Assert.assertTrue(links.size() > 5, "Footer should have multiple links");
    }

//    @Test(priority = 3)
//    public void testNewsletterSubscription() {
//        footerPage.subscribeToNewsletter("saurabh79@gmail.com");
//        
//        Assert.assertTrue(footerPage.isSubscriptionSuccessful(), 
//            "Newsletter subscription should show success message");
//    }

    @Test(priority = 4)
    public void contactUsNavigation() {
        footerPage.clickFooterLink("Contact Us");
        Assert.assertTrue(driver.getTitle().contains("Contact Us"),
            "Should navigate to Contact Us page");
        driver.navigate().back();
    }
    
    @Test(priority = 5)
    public void socialPlatforms() throws InterruptedException
    {
    	footerPage.socialMedia();
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public void tearDown() {
           driver.quit();
    }

}
