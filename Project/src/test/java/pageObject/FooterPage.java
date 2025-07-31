package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {
	
    WebDriver driver;
    WebDriverWait wait;

    By footerSection = By.xpath("//div[@id='footer']");
    By allFooterLinks = By.cssSelector("footer a");
    By newsletterField = By.id("appendedInputButton");
    By subscribeButton = By.xpath("//button[@type='submit']");
    By firstName = By.xpath("//input[@id='SubscriberFrm_firstname']");
    By lastName = By.xpath("//input[@id='SubscriberFrm_lastname']");
    By capthcha = By.xpath("//img[@src='https://automationteststore.com/index.php?rt=common/captcha']");
    By facebook = By.xpath("//a[@title='Facebook']");
    By twitter = By.xpath("//a[@title='Twitter']");
    By linkedin = By.xpath("//a[@class='linkedin']");
    
   
    By successMessage = By.xpath("//span[@class='maintext']");

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isFooterDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(footerSection)).isDisplayed();
    }

    public java.util.List<WebElement> getAllFooterLinks() {
        return driver.findElements(allFooterLinks);
    }

    public void clickFooterLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
    
    public void socialMedia() throws InterruptedException
    {
    	String mainWindow = driver.getWindowHandle();
    	
    	driver.findElement(facebook).click();
    	driver.switchTo().window(mainWindow);
    	Thread.sleep(5000);
    	
    	driver.findElement(twitter).click();
    	driver.switchTo().window(mainWindow);
    	Thread.sleep(5000);
    	
    	driver.findElement(linkedin).click();
    	driver.switchTo().window(mainWindow);
    	Thread.sleep(5000);
    }

//    public void subscribeToNewsletter(String email) {
//        driver.findElement(newsletterField).sendKeys(email);
//        driver.findElement(subscribeButton).click();
//        
//        driver.findElement(firstName).sendKeys("Saurabh");
//        driver.findElement(lastName).sendKeys("Mhatre");
//        
//        driver.findElement(capthcha).sendKeys(capthcha);
//    }

//    public boolean isSubscriptionSuccessful() {
//
//      return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText().contains("successfully");
//    	}
    }


