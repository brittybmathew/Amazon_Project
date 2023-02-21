package test;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.AmazonHomepage;
import pages.AmazonLanguage;
import pages.AmazonLoginpage;
import pages.AmazonSearchpage;
import testng.ExtentedReports;

public class AmazonReport extends AmazonBaseclass{
	
	String baseurl="https://www.amazon.in";
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void beftest() {
		reporter=new ExtentHtmlReporter("./Reports/AmazonReport.html");
		reporter.config().setDocumentTitle("AutomationReport");
		reporter.config().setReportName("Functional test");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Testername", "Britty");
		extent.setSystemInfo("Browsername", "Chrome");
		
	}
		
	@Test(priority=1)
	public void LoginPage() {
		test=extent.createTest("Loginpage_Test");
		AmazonLoginpage ob=new AmazonLoginpage(driver);
		ob.signin();
		ob.setvalue("9876542");
		ob.continuebutton();
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void HomePage() {
		test=extent.createTest("Homepage_Test");
		AmazonHomepage ob=new AmazonHomepage(driver);
		ob.setvalue("mobiles");
		ob.results();
	}
	
	@Test(priority=3)
	public void SearchPage() throws Exception {
		test=extent.createTest("Searchpage_Test");
		AmazonSearchpage ob=new AmazonSearchpage(driver);
		ob.checkBox();
		ob.setValues("20000", "40000");
		ob.clickGo();
		ob.selectProduct();
		ob.cartButton();
	}
	
	@Test(priority=4)
	public void Language() {
		test=extent.createTest("Language_Test");
		AmazonLanguage ob=new AmazonLanguage(driver);
		ob.selectLang();
		ob.selectRadio();
		ob.clickSave();
		driver.navigate().to(baseurl);
	}
	
	@AfterTest
	public void teardown() {
		extent.flush();
	}
	
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "testcase failed is "+result.getName());
			test.log(Status.FAIL, "testcase failed is "+result.getThrowable());
			String screenshotpath=ExtentedReports.screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "testcase skipped is "+result.getName());
			String screenshotpath=ExtentedReports.screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "testcase passed is "+result.getName());
			String screenshotpath=ExtentedReports.screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}
	}

	static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination="./Screenshot/"+screenshotname+".png";
		FileHandler.copy(src, new File(destination));
		
		return destination;
	}

}
