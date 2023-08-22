package testScripts;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.cachestorage.model.Header;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Headers;
import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.codec.binary.Base64;



public class CDPTest {
	
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
	}
	
	/*
	 * @Test public void viewPortTest() { Map deviceMetrics = new HashMap() {{
	 * put("width",600); put("height",1000); put("deviceScaleFactor",50);
	 * put("mobile",true); }};
	 * 
	 * driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
	 * driver.get("https://www.selenium.dev/");
	 * 
	 * }
	 * 
	 * @Test public void getNetworkTrafficDet() {
	 * devTools.send(Network.enable(Optional.empty(), Optional.empty(),
	 * Optional.empty())); devTools.addListener(Network.requestWillBeSent(), entry
	 * -> { System.out.println("Request URI :" + entry.getRequest().getUrl()+"\n" +
	 * "With method : "+entry.getRequest().getMethod()+ "\n");
	 * entry.getRequest().getMethod();}); driver.get("https://www.google.com/");
	 * devTools.send(Network.disable());
	 * 
	 * }
	 * 
	 * @Test public void geoLocTest() {
	 * devTools.send(Emulation.setGeolocationOverride( Optional.of(27.664827),
	 * Optional.of(-81.515755), Optional.of(100)));
	 * driver.get("https://oldnavy.gap.com/stores");
	 * 
	 * 
	 * 
	 * }
	 */
	@Test
	public void basicAuthTest() {
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		Map<String, Object> headers = new HashMap<>();
		String strUser = "admin";
		String strPwd = "admin";
		
		String basicAuth = "Baic "+new String(new Base64().encode(String.format("%s:%s", strUser, strPwd).getBytes()));
		
		
		System.out.println("Auth...+" +basicAuth);
		headers.put("Authorization", basicAuth);
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		String strMsg = driver.findElement(By.xpath("//div[@class='example']//p")).getText();
		Assert.assertEquals(strMsg, "Congratulations! You must have the proper credentials.");
	}
	
	

}
