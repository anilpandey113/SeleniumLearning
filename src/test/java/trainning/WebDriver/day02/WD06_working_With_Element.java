package trainning.WebDriver.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import trainning.WebDriver.ThreadSleep;
import trainning.WebDriver.WebDriverFactory;

public class WD06_working_With_Element {
	 public static void main(String[] args) {
		WebDriver webDriver=WebDriverFactory.Aut_Init("IE");
		
		
		webDriver.navigate().to("http://seleniumhq.org/download");
		
		System.out.println("asdfasdfasdfasdfsdfas");
		webDriver.findElement(By.xpath("//*[@id='menu_projects']/a")).click();
		ThreadSleep.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id='menu_documentation']/a")).click();
		ThreadSleep.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id='menu_support']/a")).click();
		ThreadSleep.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id='menu_about']/a")).click();
		
//		String data=webDriver.findElement(By.cssSelector("#mainContent>p:nth-of-type(2)")).getText();
		String data=webDriver.findElement(By.xpath("//*[@id='mainContent']/p[2]")).getText();
//		
		System.out.println("-------------DATA----------");
		System.out.println(data);
		
//		data=webDriver.findElement(By.xpath("//*[@id='mainContent']/h3[1]/a")).getText();
		webDriver.findElement(By.xpath("//*[@id='mainContent']/h3[1]/a")).click();
//		
//		System.out.println("-------------DATA----------");
		System.out.println(data);
//		
//		ThreadSleep.sleep(2000);
//		
//		data=webDriver.findElement(By.cssSelector("#mainContent>h3:nth-of-type(1)>a:nth-of-type(1)")).getText();
//		System.out.println(data);
		
		
		
//		WebDriverFactory.turnOffBrowser();
		
	}
}
