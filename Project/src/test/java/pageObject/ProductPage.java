package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	WebDriver driver;
    WebDriverWait wait;

    By productTitle = By.cssSelector("h1.productname");
    By productPrice = By.cssSelector(".productfilneprice");
    By quantityInput = By.id("product_quantity");
    By addToCartBtn = By.cssSelector(".productpagecart");
    By cartPreview = By.cssSelector(".block_7");
    By viewCartBtn = By.cssSelector(".cart-info a[href*='checkout/cart']");
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }
    
    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }
    
    public void setQuantity(int quantity) {
        WebElement qtyField = wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        qtyField.clear();
        qtyField.sendKeys(String.valueOf(quantity));
    }
   
    public void addToCart() {

    	driver.findElement(addToCartBtn).click();
    }
    
    public void viewCart() {
    	driver.findElement(viewCartBtn).click();
    }

}
