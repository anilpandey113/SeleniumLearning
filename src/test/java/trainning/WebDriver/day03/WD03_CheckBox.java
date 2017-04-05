package trainning.WebDriver.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import trainning.WebDriver.ThreadSleep;
import trainning.WebDriver.WebDriverFactory;

public class WD03_CheckBox {
	private static WebDriver webDriver=null;
	private static String surl="http://www.echoecho.com/htmlforms09.htm";
	
	static{
		webDriver=WebDriverFactory.Aut_Init("CH");
		webDriver.navigate().to(surl);
	}
	
	public static void main(String[] args) {
		
		System.out.println("1st checkbox button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isSelected());
		System.out.println("2nd checkBox button status:"+webDriver.findElement(By.xpath("//td[3]/input[2]")).isSelected());
		System.out.println("3rd checkBox button status:"+webDriver.findElement(By.xpath("//td[3]/input[3]")).isSelected());

		
		
		WebDriverFactory.setCheckBoxOn(By.xpath("//td[3]/input[1]"));
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isEnabled());

		WebDriverFactory.setCheckBoxOn(By.xpath("//td[3]/input[1]"));
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isEnabled());
		
		WebDriverFactory.setCheckBoxOn(By.xpath("//td[3]/input[2]"));
		WebDriverFactory.setCheckBoxOn(By.xpath("//td[3]/input[3]"));
		
		ThreadSleep.sleep(2000);
		
		System.err.println("\n\n\n\nAGAIN CHECKING\n\n\n");
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isSelected());
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[2]")).isSelected());
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[3]")).isSelected());
		
		
		WebDriverFactory.setCheckBoxOff(By.xpath("//td[3]/input[1]"));
		WebDriverFactory.setCheckBoxOff(By.xpath("//td[3]/input[2]"));
		WebDriverFactory.setCheckBoxOff(By.xpath("//td[3]/input[3]"));
		
		ThreadSleep.sleep(2000);
		
		
		System.err.println("\n\n\n\nAGAIN CHECKING\n\n\n");
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isSelected());
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[2]")).isSelected());
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[3]")).isSelected());
		
		ThreadSleep.sleep(2000);
		
		
		JavascriptExecutor javascript = (JavascriptExecutor) webDriver;
		javascript.executeScript("alert('Browser is going to shut down...');");
		ThreadSleep.sleep(1000);
		webDriver.switchTo().alert().accept();
		
		
		WebDriverFactory.turnOffBrowser();
		
	}
	
}
