package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
    By viewProduct = By.xpath("//img[@alt='blue cotton t-shirt']");
	By addToCart = By.className("cart");
	
	By checkOutBtn = By.xpath("//a[@id='cart_checkout1']");
	By guestSelect = By.xpath("//input[@id='accountFrm_accountguest']");
	By continueBtn = By.xpath("//button[@title='Continue']");
	By firstName = By.id("guestFrm_firstname");
	By lastName = By.id("guestFrm_lastname");
	By Email = By.id("guestFrm_email");
	By address = By.id("guestFrm_address_1");
	By city = By.id("guestFrm_city");
	By country = By.xpath("//select[@name='country_id']");
	By state = By.id("guestFrm_zone_id");
	By zip = By.id("guestFrm_postcode");
	By cntinueBtn = By.xpath("//button[@title='Continue']");
	
	By orderDetails = By.xpath("//div[@id='maincontainer']");
	By cnfrmOrder = By.id("checkout_btn");
	
	public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
	
	public void viewProduct() {
	    wait.until(ExpectedConditions.elementToBeClickable(viewProduct)).click();
	}
	
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }
    
    public void proceedToCheckout()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
    }
    
    public void selectGuestCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(guestSelect)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }
    
    public void personalDetalis(String fName, String lName, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(Email).sendKeys(email);
    }
    
    public void BillingAddress(String addr, String cityName, String countryName, String stateName, String zipCode) {
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        
        new Select(driver.findElement(country)).selectByVisibleText(countryName);

        wait.until(ExpectedConditions.elementToBeClickable(state));
        new Select(driver.findElement(state)).selectByVisibleText(stateName);
        
        driver.findElement(zip).sendKeys(zipCode);
    }
    
    public void continueToDelivery() {
        wait.until(ExpectedConditions.elementToBeClickable(cntinueBtn)).click();
    }
    
    public void verifyOrderDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails));
    }
    
    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(cnfrmOrder)).click();
    }
    
}
