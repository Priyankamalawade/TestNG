package task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCogmento {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void logintoPage() {
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys("ABC");
		driver.findElement(By.name("password")).sendKeys("ABC");
		driver.findElement(By.className("ui fluid large blue submit button")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
