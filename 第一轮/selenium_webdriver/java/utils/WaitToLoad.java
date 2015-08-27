package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author v-jasxia
 *返回要查找的元素
 */

public class WaitToLoad {

	
	public static WebElement Wait(WebDriver driver, long timeOutInSeconds)
	{
	/*	new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.cssSelector("css locator"))
			);*/
		
	
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		
		
		WebElement e= wait.until(new ExpectedCondition<WebElement>() {

			public WebElement apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElement(By.id("213"));
			}
		});
	/*
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(By.id("id locator"));
					}
				});*/
		
		return e;
		

		
	}
	

}
