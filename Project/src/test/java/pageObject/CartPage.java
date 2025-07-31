package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
    WebDriver driver;
    WebDriverWait wait;
    
    // Corrected locators
    By viewProduct = By.xpath("//img[@alt='blue cotton t-shirt']");
    By addToCart = By.className("cart");
    By quantityInput = By.xpath("//input[@value='1']");
    By updateProduct = By.xpath("//button[contains(@title,'Update')]");
    By removeProduct = By.xpath("//a[@class='btn btn-sm btn-default']");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    public void viewProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(viewProduct)).click();
    }
    
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

    }

    public void increaseQuantity(String quantity) {
        WebElement qtyInput = wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        qtyInput.clear();
        qtyInput.sendKeys(quantity);
    }
    
    public void updateProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(updateProduct)).click();
  
    }
    
    public void removeProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(removeProduct)).click();
    }

}
