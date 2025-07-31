package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	By loginBtn = By.cssSelector("ul#customer_menu_top");
	By loginName = By.xpath("//input[@name='loginname']");
	By password = By.cssSelector("input[name='password']");
	By loginButton = By.xpath("//button[@title='Login']");
	By forgotLogin = By.linkText("Forgot your login?");
	By forgotPassword = By.linkText("Forgot your password?");
	
	By errorMessage = By.cssSelector(".alert.alert-error, .alert-danger");
	By welcomMessage = By.cssSelector(".menu_text");
	
	public void loginButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	}
	
	public void LoginName(String loginame)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginName)).sendKeys(loginame);
	}
	
	public void Password(String pass)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
	}
	
	public void LoginBtn()
	{
		driver.findElement(loginButton).click();
	}
	
	public void forgotlogin()
	{
		driver.findElement(forgotLogin).click();
	}
	
	public void forgotPassword()
	{
		driver.findElement(forgotPassword).click();
	}
	
	public String geterrormessage()
	{
		return driver.findElement(errorMessage).getText();
	}
	
	public String getwelcomMsg()
	{
		return driver.findElement(welcomMessage).getText();
	}
	
	public boolean isLoginSuccessfull()
	{
		wait.until(ExpectedConditions.urlContains("account/account"));
		return getwelcomMsg().contains("Welcome back");
	}
	
	public void login(String username, String password)
	{
		loginButton();
		LoginName(username);
		Password(password);
		LoginBtn();
	}
	
	public void loginWithInvalidData(String username, String password)
	{
		loginButton();
		LoginName(username);
		Password(password);
		LoginBtn();
	}

}
