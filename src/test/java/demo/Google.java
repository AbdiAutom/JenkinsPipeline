package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {

	@Test
	public void openGoogle() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		
		
		driver.close();
	}
}
