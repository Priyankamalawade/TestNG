package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GooglePageTest {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	//@BeforeTest
	public void setUp(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void searchJavaTest() {

		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Java Tutorials");
		element.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Java Tutorials - Google Search");

	}

	@Test
	public void searchSeleniumTest() {

		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium Tutorials");
		element.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorials - Google Search");

	}

	//@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
