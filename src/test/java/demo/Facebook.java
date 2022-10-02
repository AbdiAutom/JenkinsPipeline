package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Facebook {

	@Test
	public void openGoogle() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://fr-fr.facebook.com/");
		Thread.sleep(5000);
		
		
		driver.close();
	}
}
