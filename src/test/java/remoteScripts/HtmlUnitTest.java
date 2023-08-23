package remoteScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HtmlUnitTest {
	
	@Test
	public void headlessTest() {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorials");
		srcBox.submit();
		System.out.println("Page Title ...."+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorials - Google Search");
		
	}

}
