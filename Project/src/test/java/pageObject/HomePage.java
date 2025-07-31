package pageObject;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
    WebDriver driver;
    WebDriverWait wait;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    By searchField = By.xpath("//input[@id='filter_keyword']");
    By searchButton = By.xpath("//i[@class='fa fa-search']");
    
    public void selectCategory(String categoryName) {

        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector(".nav-pills.categorymenu")));

        By categoryLocator = By.xpath("//ul[contains(@class,'categorymenu')]//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + 
            categoryName.toLowerCase() + "')]");

        WebElement category = wait.until(ExpectedConditions.presenceOfElementLocated(categoryLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", category);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", category);

        wait.until(ExpectedConditions.titleContains(categoryName));
    }
    
    public void searchForProduct(String productName) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        searchInput.clear();
        searchInput.sendKeys(productName);
        driver.findElement(searchButton).click();
    }

}
