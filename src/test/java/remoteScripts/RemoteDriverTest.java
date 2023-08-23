package remoteScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteDriverTest {
	
	WebDriver driver;
	@Test
	public void remoteTest() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.BROWSER_VERSION, "116");
		String strHub = "http://172.31.8.80:4444";
		driver = new RemoteWebDriver(new URL(strHub), options);
		driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		System.out.println("Page Title ...."+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorials - Google Search");
	}

}
