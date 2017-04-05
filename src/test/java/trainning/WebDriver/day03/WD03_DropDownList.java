package trainning.WebDriver.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import trainning.WebDriver.ThreadSleep;
import trainning.WebDriver.WebDriverFactory;

public class WD03_DropDownList {
	private static WebDriver webDriver=null;
	private static String surl="https://www.google.com/intl/id/gmail/about";
	
	static{
		webDriver=WebDriverFactory.Aut_Init("CH");
		webDriver.navigate().to(surl);
	}
	
	public static void main(String[] args) {
		WebElement selectElement=webDriver.findElement(By.xpath("//select"));
		Select selectList=new Select(selectElement);
		
		System.out.println("Total no of options:"+selectList.getOptions().size());
		System.out.println("Selected Options:"+selectList.getAllSelectedOptions().get(0).getText());
		
//		case1.
		selectList.selectByVisibleText("English (India)");
		ThreadSleep.sleep(2000);
		

//		case2.
		 selectElement=webDriver.findElement(By.xpath("//select"));
		 selectList=new Select(selectElement);		
		 selectList.selectByIndex(42);
		 ThreadSleep.sleep(2000);

		 
		
//		case3.
		 selectElement=webDriver.findElement(By.xpath("//select"));
		 selectList=new Select(selectElement);		
		selectList.selectByValue("/intl/te/gmail/about/");
		ThreadSleep.sleep(2000);
		
		
		WebDriverFactory.turnOffBrowser();
	}
}
