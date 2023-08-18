package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtilis.Utility;

public class SampleTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/sparkReport.html");
		extentReports.attachReporter(spark);
	}
	@BeforeMethod
	public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
  @Test
  public void searchCypressTest() {
	  
	  extentTest = extentReports.createTest("search Cypress Test");
	  driver.get("https://www.google.com/");
	  WebElement element = driver.findElement(By.name("q"));
	  element.sendKeys("Cypress Tutorials");
	  element.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Cypress Tutorials - Google Search");
	  
  }
  @Test
  public void searchCucumberTest() {
	  extentTest = extentReports.createTest("search Cucumber Test");
	  driver.get("https://www.google.com/");
	  WebElement element = driver.findElement(By.name("q"));
	  element.sendKeys("Cucumber Tutorials");
	  element.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");
	  
  }
  @AfterMethod
	public void tearDown(ITestResult result) {
	  if(ITestResult.FAILURE == result.getStatus()) {
		  extentTest.fail(result.getThrowable().getMessage());
		  String path = Utility.getScreenshotPath(driver);
		  extentTest.addScreenCaptureFromPath(path);
	  }
	 
		driver.close();
	}
  @AfterTest
  public void finishExtent() {
	  extentReports.flush();
  }
}
