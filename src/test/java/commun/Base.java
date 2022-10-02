
package commun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;


/**
 * Objectif de cette classe : Contient toutes methodes communes avec les tests. 
 * Permet aussi d'ouvrir le navigateur et le fermer une fois le test terminé.
 * Date de création : 29/06/2022
 * 
 * => trouve une solution pour fermer tous les drivers couverts
 */

public class Base {

	/*
	 * Comprendre la différence entre public et public static, l'impact sur la variable driver par exemple?
	 */
	
	public static WebDriver driver ;
	public Properties prop = new Properties();
	
	//@BeforeSuite
	@SuppressWarnings("deprecation")
	public WebDriver setUpDriver() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("/Users/abdi.bileh17/eclipse-workspace/WebDemo/src/test/java/commun/Donnees.Properties");
		//FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/Java/Web/src/test/Streaming/commun/Donnees.Properties");
		//FileInputStream file = new FileInputStream("user.dir"+"/src/test/Streaming/commun/Donnees.Properties"); // Vérifie si le lien est ok 
		
		
		
		
		prop.load(file);
		String browserName = prop.getProperty("browser");
		String url6play = prop.getProperty("url");
		System.out.println("Le test tourne avec le browser : "+browserName);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
		}			
		else if(browserName.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			  driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//execute avec IE driver
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url6play);
		driver.manage().window().maximize();
		
		
		return driver;
	}
	@AfterSuite
	public void tearnDownDriver()
	{
		driver.close();
		driver.quit(); 
		
		//Fais en sorte de parcourir tous les driver ouvert et les fermer les uns après les autres.
		/*Set<String> fenetre = driver.getWindowHandles();
		Iterator<String> iter = fenetre.iterator();
		String parent=driver.getWindowHandle();
		
		while(iter.hasNext())
		{
			String child_window = iter.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);

			System.out.println("dans le teranDown : "+driver.switchTo().window(child_window).getTitle());

			driver.close();
			}
		} */
	}
	
}
 