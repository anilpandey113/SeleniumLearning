package trainning.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	private static String sDriverPath_Mozilla="C:/work/browserDriver/geckodriver.exe";//.supproted .exe file which will help mozilla to prepare enviroment.
	private static String sDriverPath_chrome="C:/work/browserDriver/chromedriver.exe";
	private static String sDriverPath_ie="C:/work/browserDriver/IEDriverServer.exe";
	//127.0.0.1:26423
	private static String sDriverPath_Mozilla_key="webdriver.gecko.driver";
	private static String sDriverPath_ie_key="webdriver.ie.driver";
	private static String sDriverPath_chrome_key="webdriver.chrome.driver";
	
	private static WebDriver webDriver=null; 
	private static boolean flag=true;

	
	
	public static WebDriver Aut_Init(String sBr) {
		if (sBr.isEmpty()) {
			System.err.println("Broser Type is Empty");
			flag=false;
		} else {
			switch (sBr) {
			case "FF":
				System.setProperty(sDriverPath_Mozilla_key, sDriverPath_Mozilla);
				webDriver = new FirefoxDriver();
				break;
			case "IE":
				System.setProperty(sDriverPath_ie_key, sDriverPath_ie);
				webDriver = new InternetExplorerDriver();
				break;
			case "CH":
				System.setProperty(sDriverPath_chrome_key, sDriverPath_chrome);
				webDriver = new ChromeDriver();
				break;
			default:
				System.err.println("Invalid Browser Type --->"+sBr);
				flag=false;
				break;
			}
			
			if (flag) {
//				webDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			//	webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//				webDriver.manage().deleteAllCookies();
//				webDriver.manage().window().maximize();
			}
		}
		flag=true;
		return webDriver;
	}
	public static WebDriver Aut_Init_With_Proxy(String sBr) {
		if (sBr.isEmpty()) {
			System.err.println("Broser Type is Empty");
			flag=false;
		} else {
			switch (sBr) {
			case "FF":
				System.setProperty(sDriverPath_Mozilla_key, sDriverPath_Mozilla);
//				webDriver = new FirefoxDriver(set_Proxy());
				webDriver = new FirefoxDriver(setFirefoxProfileInstanse());
				break;
			case "IE":
				System.setProperty(sDriverPath_ie_key, sDriverPath_ie);
				webDriver = new InternetExplorerDriver(set_Proxy());
				break;
			case "CH":
				System.setProperty(sDriverPath_chrome_key, sDriverPath_chrome);
				webDriver = new ChromeDriver(set_Proxy());
				break;
			default:
				System.err.println("Invalid Browser Type --->"+sBr);
				flag=false;
				break;
			}
			
			if (flag) {
//				webDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				//	webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//				webDriver.manage().deleteAllCookies();
//				webDriver.manage().window().maximize();
			}
		}
		flag=true;
		return webDriver;
	}
	
	static DesiredCapabilities set_Proxy(){
		Proxy proxy=new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
//		proxy.setHttpProxy("127.0.0.1:8080");
		proxy.setHttpProxy("191.1.1.1:4444");
		
		DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
		
		return desiredCapabilities;
		
	}
	static FirefoxProfile setFirefoxProfileInstanse(){
		
		FirefoxProfile firefoxProfile=new FirefoxProfile();
		firefoxProfile.setPreference("network.proxy.ftp", "192.000.1.1");
		firefoxProfile.setPreference("network.proxy.ftp_port", 8080);
		firefoxProfile.setPreference("zoom.maxPercent", 250);
		firefoxProfile.setPreference("zoom.minPercent", 50);
		
		firefoxProfile.setPreference("Selenium.WebDriver", "jdk_server");
		
		return firefoxProfile;
	}
	
	public static boolean Navigate_to_AUT(String sURL){
		boolean flag=false;
		if(sURL!=null && sURL.length()>0){
			webDriver.navigate().to(sURL);
			return webDriver.getCurrentUrl().contains(sURL);
		}else{
			System.err.println("Aut is null or empty object.");
		}
		return flag;
	}
	
	public static boolean turnOffBrowser(){
		System.out.println("Broswer is going to shutdown.\t after 3 seconds.");
//		ThreadSleep.sleep(3000);
		webDriver.quit();
		return flag;
	}
	public static boolean turnOffBrowserWithTime(Long long1){
		System.out.println("Broswer is going to shutdown.\t after 3 seconds.");
		ThreadSleep.sleep(long1);
		webDriver.quit();
		return flag;
	}
	public static boolean elementExist(By element,int sec){
		int count=0;
		
		try{
//			Thread.sleep(1000);
			count++;
			webDriver.findElement(element);
			return true;
		}catch (Exception e) {
			//if(count>=sec)
				return false;
		}
//		return false;
	}
	
	public static void setCheckBoxOn(By by){
		WebElement checkBoxElement=webDriver.findElement(by);
		if(!checkBoxElement.isSelected()){
			checkBoxElement.click();
		}
	}
	public static void setCheckBoxOff(By by){
		WebElement checkBoxElement=webDriver.findElement(by);
		if(checkBoxElement.isSelected()){
			checkBoxElement.click();
		}
	}
	
	public static void existAndCloseAlertBox(int iMaxTimeOut) {
		int count = 0;
		while (true) {
			try {
				Thread.sleep(500);
				webDriver.switchTo().alert().dismiss();
			} catch (Exception e) {
				count++;

				if (count >= iMaxTimeOut) {
					System.err.println("alert not found");
					break;
				}
			}
		}
	}
}

