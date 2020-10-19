package factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory 
{
	public static final String strUSERNAME = "devarajalakshman1";
	public static final String strAUTOMATE_KEY = "5gHorHKKmoaYcrmx7yKU";
	public static final String strURL = "https://" + strUSERNAME + ":" + strAUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static WebDriver getBrowser(String browserName) throws MalformedURLException 
	{
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./Configuration/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Configuration/chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-web-security");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("requireWindowFocus", true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE); 
			driver = new ChromeDriver(capabilities);
		}
		if (browserName.equalsIgnoreCase("MSEdge")) 
		{
			System.setProperty("webdriver.edge.driver", "./Configuration/msedgedriver.exe");
			driver = new EdgeDriver();
			String strURl = "http://Automationpractice.com/";
			driver.get(strURl);
		}
		if (browserName.equalsIgnoreCase("BrowserStack")) 
		{
			/*
			DesiredCapabilities capabilities = new DesiredCapabilities().internetExplorer();
			capabilities.setBrowserName("internet explorer");
			capabilities.setPlatform(Platform.WIN8);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("requireWindowFocus", true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE); // Accept
																													// unexpected
																													// alerts
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), capabilities);
			*/
			//////////////////////////////////////////////////////////////////////////
			DesiredCapabilities caps = new DesiredCapabilities();
	        
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Catalina");
			caps.setCapability("browser", "Safari");
			caps.setCapability("browser_version", "13");
			caps.setCapability("name", "devarajalakshman1's First Test");
			
			driver = new RemoteWebDriver(new URL(strURL), caps);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitApplication(WebDriver driver) 
	{
		driver.quit();
	}
}
