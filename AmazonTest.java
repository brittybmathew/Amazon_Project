package test;


import org.testng.annotations.Test;

import pages.AmazonHomepage;
import pages.AmazonLanguage;
import pages.AmazonLoginpage;
import pages.AmazonSearchpage;

public class AmazonTest extends AmazonBaseclass{
	
	@Test(priority=1)
	public void loginTest() {
		AmazonLoginpage ob=new AmazonLoginpage(driver);
		ob.signin();
		ob.setvalue("9876542");
		ob.continuebutton();
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(priority=2)
	public void homeTest(){
		AmazonHomepage ob=new AmazonHomepage(driver);
		ob.setvalue("mobiles");
		ob.results();
	}
	
	@Test(priority=3)
	public void searchTest() throws Exception {
		AmazonSearchpage ob=new AmazonSearchpage(driver);
		ob.checkBox();
		ob.setValues("20000", "40000");
		ob.clickGo();
		ob.selectProduct();
		ob.cartButton();
	}
	@Test(priority=4)
	public void languageTest() {
		AmazonLanguage ob=new AmazonLanguage(driver);
		ob.selectLang();
		ob.selectRadio();
		ob.clickSave();
	}

}	

