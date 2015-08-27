package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author v-jasxia
 *对于新开启的浏览器窗口
 */
public class WindowLocator {
	
	public static WebDriver getNewWindow(WebDriver driver)
	{
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			driver = driver.switchTo().window(it.next());// 切换到新窗口
		}
		
		return driver;
		
	}
}
