package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomepage {
	WebDriver driver;
	
	By field=By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By search=By.xpath("//*[@id=\"nav-search-submit-button\"]");
	
	public AmazonHomepage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setvalue(String searchfield) {
		driver.findElement(field).sendKeys(searchfield);
	}
	public void results() {
		driver.findElement(search).click();
	}

}
