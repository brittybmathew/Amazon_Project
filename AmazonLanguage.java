package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLanguage {
	
	WebDriver driver;
	
	By lang=By.xpath("//*[@id=\"icp-nav-flyout\"]/span");
	By malRadio=By.xpath("//*[@id=\"icp-language-settings\"]/div[7]/div/label/i");
	By saveButton=By.xpath("/html/body/div[1]/div[2]/div/span[2]/span/input");
		
	public AmazonLanguage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectLang() {
		driver.findElement(lang).click();
	}
	public void selectRadio() {
		driver.findElement(malRadio).click();
	}
	public void clickSave() {
		driver.findElement(saveButton).click();
	}

}
