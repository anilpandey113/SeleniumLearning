package trainning.WebDriver.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import trainning.WebDriver.ThreadSleep;
import trainning.WebDriver.WebDriverFactory;

public class WD03_TableContent {
	
	private static WebDriver webDriver=null;
	private static String surl="http://www.seleniumhq.org/download/";
	
	static{
		webDriver=WebDriverFactory.Aut_Init("IE");
		webDriver.navigate().to(surl);
	}
	public static void main(String[] args) {
		
//		reading data from table
		int iRow,iTotalRow,iCell,iTotalCell;
		String sXpathTable="//*[@id='mainContent']/table[1]";
		StringBuffer xVal=new StringBuffer();
		
		
		iTotalRow=webDriver.findElements(By.xpath(sXpathTable+"//tr")).size();
		
		for (int i = 0; i <=iTotalRow; i++) {
			if(i==0){
				  iTotalCell=webDriver.findElements(By.xpath(sXpathTable+"/thead/tr/th")).size();
				for (iCell = 1; iCell <= iTotalCell; iCell++) {
					xVal.append(webDriver.findElement(By.xpath(sXpathTable+"/thead/tr/th["+iCell+"]")).getText());
					xVal.append("\t");
				}
			}else{
				iTotalCell=webDriver.findElements(By.xpath(sXpathTable+"/tbody/tr["+i+"]/td")).size();
				for (iCell = 1; iCell <= iTotalCell; iCell++) {
					xVal.append(webDriver.findElement(By.xpath(sXpathTable+"/tbody/tr["+i+"]/td["+iCell+"]")).getText());
					xVal.append("\t");
				}
			}
			xVal.append("\n");
			
		}
		
		System.out.println(xVal.toString());
		
		
		JavascriptExecutor javascript = (JavascriptExecutor) webDriver;
		javascript.executeScript("alert('Browser is going to shut down...');");
		ThreadSleep.sleep(1000);
		webDriver.switchTo().alert();
		
		
		
		WebDriverFactory.turnOffBrowser();
		
		
		
		
		
		
		/*
		
		//*[@id='mainContent']/table[1]     -------------table
		.//*[@id='mainContent']/table[1]/thead --------------table head row
		.//*[@id='mainContent']/table[1]/thead/tr/th --------------all cells in table
		.//*[@id='mainContent']/table[1]/thead/tr/th[1]  ----------------------1st cell in table
		.//*[@id='mainContent']/table[1]/tbody  ----------------------table body
		.//*[@id='mainContent']/table[1]/tbody/tr  ----------------------all rows in table
		
		#mainContent>table:nth-of-type(1)
		#mainContent>table:nth-of-type(1)>thead
		#mainContent>table:nth-of-type(1)>thead>tr>th
		#mainContent>table:nth-of-type(1)>thead>tr>th:nth-of-type(1)
		#mainContent>table:nth-of-type(1)>tbody ==========entire table body
		#mainContent>table:nth-of-type(1)>tbody>tr ==========all the row into table body
		#mainContent>table:nth-of-type(1)>tbody>tr:nth-of-type(2) ==========2nd row into table body
		#mainContent>table:nth-of-type(1)>tbody>tr:nth-of-type(2)>td ==========2nd row all cells into table body
		#mainContent>table:nth-of-type(1)>tbody>tr:nth-of-type(2)>td:nth-of-type(2) ==========2nd row 2nd cells into table body
		
		
		
		
		*/
	}
}
