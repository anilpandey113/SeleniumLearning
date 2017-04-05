package trainning.WebDriver.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import trainning.WebDriver.ThreadSleep;
import trainning.WebDriver.WebDriverFactory;

public class WD03_MouseAction {
	
	private static WebDriver webDriver=null;
//	private static String surl="https://jqueryui.com/droppable";
	private static String surl="https://www.hdfcbank.com";
	
	static{
		webDriver=WebDriverFactory.Aut_Init("CH");
		webDriver.navigate().to(surl);
	}
	
	public static void main(String[] args) {
		hdfcBankExecution();
	}
	
	static void hdfcBankExecution(){
		
		webDriver.switchTo().frame("http-push");
		
		
		if(WebDriverFactory.elementExist(By.id("closeImange"), 10)){
			webDriver.findElement(By.id("closeImange")).click();
		}

		Actions action= new Actions(webDriver);
		
		WebElement sourceElement = webDriver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[1]/a"));
		WebElement targetElement1 = webDriver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[1]/ul/li[2]/a"));
		WebElement targetElement2 = webDriver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[2]/div[2]/div/ul/li[2]/a"));
		
		
		action.moveToElement(sourceElement).moveToElement(targetElement1).moveToElement(targetElement2).build().perform();;
		
		
		ThreadSleep.sleep(2000);
		WebDriverFactory.turnOffBrowser();
		
		
		
	
	}
	
	
	static void jquery_comExecution(){
		webDriver.switchTo().frame(0);
		Actions action= new Actions(webDriver);
		
		WebElement sourceElement=webDriver.findElement(By.xpath("//*[@id='draggable']/p"));
		WebElement targetElement=webDriver.findElement(By.xpath("//*[@id='droppable']"));
		
//		case1
		//action.dragAndDrop(sourceElement, targetElement).build().perform();
		
//		case2.
		action.clickAndHold(sourceElement);
		ThreadSleep.sleep(1000);
		action=action.moveToElement(targetElement);
		action.release().build().perform();;
		ThreadSleep.sleep(3000);
		
		
		WebDriverFactory.turnOffBrowser();
	
	}
}
