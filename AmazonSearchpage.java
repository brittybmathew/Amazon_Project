package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AmazonSearchpage {
	
	WebDriver driver;
	
	By onePlus=By.xpath("//*[@id=\"p_89/OnePlus\"]/span/a/div/label/i");
	By min=By.xpath("//*[@id=\"low-price\"]");
	By max=By.xpath("//*[@id=\"high-price\"]");
	By goButton=By.xpath("//*[@id=\"a-autoid-1\"]/span/input");
	By product=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	By cart=By.xpath("//*[@id=\"add-to-cart-button\"]");

	public AmazonSearchpage(WebDriver driver) {
		this.driver=driver;
	}
	public void checkBox() {
		driver.findElement(onePlus).click();
		
	}
	public void setValues(String minimum,String maximum) {
		driver.findElement(min).sendKeys(minimum);
		driver.findElement(max).sendKeys(maximum);
	}
	public void clickGo() {
		driver.findElement(goButton).click();
	}
	public void selectProduct() {
		driver.findElement(product).click();
	}
	public void cartButton()throws Exception {
		try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(cart);
		js.executeScript("arguments[0].scrollIntoView();", ele);
		driver.findElement(cart).click();
		}
		catch(Exception e) {
			System.out.println("Unable to find cart button");
		}
	}
	

}
