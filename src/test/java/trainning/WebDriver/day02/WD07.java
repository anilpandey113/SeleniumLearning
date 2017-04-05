package trainning.WebDriver.day02;

import org.openqa.selenium.WebDriver;

import trainning.WebDriver.WebDriverFactory;

public class WD07 {
	public static void main(String[] args) {
//		WebDriver webDriver = WebDriverFactory.Aut_Init("CH");
		WebDriver webDriver = WebDriverFactory.Aut_Init("CH");
		webDriver.navigate().to("http://www.seleniumhq.org");
		
		WebDriverFactory.turnOffBrowser();
	}
}
