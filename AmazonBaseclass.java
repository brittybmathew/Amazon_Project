package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class AmazonBaseclass {
	public WebDriver driver;
	
	@BeforeClass
	public void url() {
		driver=new ChromeDriver();
		String baseurl="https://www.amazon.in";
		driver.get(baseurl);
		driver.manage().window().maximize();
	}

}
