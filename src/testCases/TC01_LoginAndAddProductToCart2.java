package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProductPage;
import utilityFunctions.Utility;

public class TC01_LoginAndAddProductToCart2 
{
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String strbrowser) throws Exception 
	{
		/* String sourceText = "";
		  if (e.parameter.q){
		    sourceText = e.parameter.q;
		  }

		  String sourceLang = "auto";
		  if (e.parameter.source){
		    sourceLang = e.parameter.source;
		  }

		  String targetLang = "ja";
		  if (e.parameter.target){
		    targetLang = e.parameter.target;
		  }*/
		
	}

	@AfterClass
	public void tearDown() throws Exception 
	{
		
	}

	@Test 
	public void VerifyLogin () throws InterruptedException, IOException 
	{
		

	}
}
