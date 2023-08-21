package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setUp() throws IOException {
		String path = System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
		
		prop = new Properties();
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		String strBrowser = prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "loginData")
	public void validLogin(String strUser, String pwd) {

		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(strUser);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("radius")).click();
		boolean isdes = driver.findElement(By.cssSelector("div.flas.success")).isDisplayed();
		Assert.assertTrue(isdes);
		
	}
	@DataProvider(name = "loginData")
	public Object[][] getDta() throws CsvValidationException, IOException {
		String path = System.getProperty("user.dir")+"//src//test//resources/testData//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String arr[];
		ArrayList<Object> dataList = new ArrayList<Object>();
		while((arr=reader.readNext())!=null) {
			Object[]record = {arr[0],arr[1]};
			dataList.add(record);
			}
		return dataList.toArray(new Object[dataList.size()][]);
	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
