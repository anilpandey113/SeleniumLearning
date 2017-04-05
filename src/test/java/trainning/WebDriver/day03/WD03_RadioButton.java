package trainning.WebDriver.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import trainning.WebDriver.WebDriverFactory;

public class WD03_RadioButton {
	private static WebDriver webDriver=null;
	private static String surl="http://www.echoecho.com/htmlforms10.htm";
	
	static{
		webDriver=WebDriverFactory.Aut_Init("CH");
		webDriver.navigate().to(surl);
	}
	
	public static void main(String[] args) {
		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isSelected());
		System.out.println("2nd radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[2]")).isSelected());
		System.out.println("3rd radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[3]")).isSelected());
		
		
		webDriver.findElement(By.xpath("//td[3]/input[1]")).click();
		
		System.err.println("\n\n\nAgain trying to selected\n\n\n");

		System.out.println("1st radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[1]")).isSelected());
		System.out.println("2nd radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[2]")).isSelected());
		System.out.println("3rd radio button status:"+webDriver.findElement(By.xpath("//td[3]/input[3]")).isSelected());
		
		
		
	}
}
