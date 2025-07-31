package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By registerBtn = By.xpath("//ul[@id='customer_menu_top']");
	By continueBtn = By.xpath("//button[@title='Continue']");
	By firstName = By.xpath("//input[@name='firstname']");
	By lastName = By.xpath("//input[@name='lastname']");
	By email = By.xpath("//input[@id='AccountFrm_email']");
	By address = By.xpath("//input[@name='address_1']");
	By city = By.id("AccountFrm_city");
	By country = By.xpath("//select[@id='AccountFrm_country_id']");
	By state = By.xpath("//select[@id='AccountFrm_zone_id']");
	By zipCode = By.xpath("//input[@id='AccountFrm_postcode']");
	By loginName = By.id("AccountFrm_loginname");
	By password = By.id("AccountFrm_password");
	By confirmPass = By.id("AccountFrm_confirm");
	By privacy = By.id("AccountFrm_agree");
	By contBtn = By.xpath("//button[@title='Continue']");
	
	public void clickRegisBtn()
	{
		driver.findElement(registerBtn).click();
	}
	
	public void clickContinueBtn()
	{
		driver.findElement(continueBtn).click();
	}
	
	public void setFirstname(String first)
	{
		driver.findElement(firstName).sendKeys(first);
	}
	
	public void setLastName(String last)
	{
		driver.findElement(lastName).sendKeys(last);
	}
	
	public void setEmail(String Email)
	{
		driver.findElement(email).sendKeys(Email);
	}
	
	public void setAddress(String add)
	{
		driver.findElement(address).sendKeys(add);
	}
	
	public void setCity(String City)
	{
		driver.findElement(city).sendKeys(City);
	}
	
	public void setCountry(String cntry)
	{
		WebElement dropdown = driver.findElement(country);
		Select select = new Select(dropdown);
		select.selectByVisibleText(cntry);
	}
	
	public void setState(String State)
	{
		WebElement drp = driver.findElement(state);
		Select select = new Select(drp);
		select.selectByVisibleText(State);
	}
	
	public void setZip(String zip)
	{
		driver.findElement(zipCode).sendKeys(zip);
	}
	
	public void setLoginName(String loginame)
	{
		driver.findElement(loginName).sendKeys(loginame);
	}
	
	public void setPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void setConfirmPass(String cnfrmPass)
	{
		driver.findElement(confirmPass).sendKeys(cnfrmPass);
	}
	
	public void setPrivacyPolicy()
	{
		driver.findElement(privacy).click();;
	}
	
	public void setContinueButton()
	{
		driver.findElement(contBtn).click();;
	}

}
