package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
  @Test
  public void searchCypressTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.google.com/");
	  WebElement element = driver.findElement(By.name("q"));
	  element.sendKeys("Cypress Tutorials");
	  element.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Cypress Tutorials - Google Search");
	  
  }
}
