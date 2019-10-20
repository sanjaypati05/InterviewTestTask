package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static  WebDriver driver = null;
	Utility ut = new Utility();

	@BeforeTest
	public void initialSetup() {
		String browserIE = ut.readProperty("ie", "config");
		String browserChrome = ut.readProperty("chrome", "config");
		String browserFirefox = ut.readProperty("firefox", "config");

		if (browserIE.equalsIgnoreCase("Yes")) {

			System.setProperty("webdriver.ie.driver", "src//test//resources//Drivers//IEDriverServer.exe");

			// Initialize browser
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		} else if (browserChrome.equalsIgnoreCase("Yes")) {
			System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");

			// Initialize browser
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		} else if (browserFirefox.equalsIgnoreCase("Yes")) {

			System.setProperty("webdriver.firefox.marionette", "src//test//resources//Drivers//geckodriver.exe");

			// Initialize browser
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
	}
@BeforeMethod
public void launchBaseURL() {
	driver.get(ut.readProperty("baseURL","config"));
}

	@AfterTest
	 	public void closeBrowser() {
		
		
		System.out.println("Quit the browser session");
		driver.quit();

	}
}
