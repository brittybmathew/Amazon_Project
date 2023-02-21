package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonLoginpage {
	WebDriver driver;
	
	By account=By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]");
	By signinButton=By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span");
	By mobno=By.xpath("//*[@id=\"ap_email\"]");
	By button=By.xpath("//*[@id=\"continue\"]");
	
	public AmazonLoginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void signin() {
		WebElement ele=driver.findElement(account);
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(signinButton).click();
		
	}
	public void setvalue(String phnno) {
		driver.findElement(mobno).sendKeys(phnno);
	}
	public void continuebutton() {
		driver.findElement(button).click();
	}
}
