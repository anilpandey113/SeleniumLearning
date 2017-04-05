package trainning.WebDriver.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import trainning.WebDriver.ThreadSleep;
import trainning.WebDriver.WebDriverFactory;

public class WD03_AlertBox {
	private static WebDriver webDriver=null;
	private static String surl="https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
	
	static{
		webDriver=WebDriverFactory.Aut_Init("FF");
		webDriver.navigate().to(surl);
	}
	
	public static void main(String[] args) {
		webDriver.switchTo().frame("iframeResult");

		WebDriverFactory.existAndCloseAlertBox(5);
		
		
		WebElement tryButton=webDriver.findElement(By.xpath("//button"));
		
		tryButton.click();
		String data=webDriver.switchTo().alert().getText();
		System.out.println("alert msg:"+data);
		
		ThreadSleep.sleep(2000);
//		webDriver.switchTo().alert().accept();
		WebDriverFactory.existAndCloseAlertBox(5);
		ThreadSleep.sleep(2000);
		WebDriverFactory.turnOffBrowser();
	}
}
