package pactera.seleniumdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import utils.WindowLocator;


/**
 * Hello world!
 *截图 
 *弹出式窗口
 *元素定位
 *Junit的用法
 *等待
 *
 */
public class MainEntrance 
{
	
	@Test
	
	public void test_wait()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		
		//public void until(com.google.common.base.Predicate<T> isTrue)
		//Repeatedly applies this instance's input value to the given predicate until the timeout expires or the predicate evaluates to true.
		//public <V> V until(com.google.common.base.Function<? super T,V> isTrue)
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(By.id("id locator"));
					}
				});
		
	}
	
	@Test
	public void test_css()
	{
		 System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		  WebDriver driver = new FirefoxDriver();
		  
		  driver.get("http://www.baidu.com");
		  WebElement search=  driver.findElement(By.linkText("百度一下"));
		  WebElement search2=  driver.findElement(By.id("kw"));
		  System.err.println(search);
		  search2.sendKeys("selenium");
		  search.click();
	}

	@Test
	public void test_Staging1()throws Exception
	{
		//如果你的浏览器不是安装在默认路径就需要设置。
		  System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		  WebDriver driver = new FirefoxDriver();
		  
		  driver.get("http://www.staging1-hotels.cn");
		  
		  driver.manage().window().maximize();
		  
		  WebElement search=  driver.findElement(By.id("qf-0q-destination"));
		  
		  search.clear();
		  search.sendKeys("London");
		  
		  Thread.sleep(1000);
		  
		  WebElement  arrive_date= driver.findElement(By.id("qf-0q-localised-check-in"));
		  arrive_date.clear();
		  arrive_date.sendKeys("2015-10-03");
		  
		  Thread.sleep(1000);
		  WebElement departure_date= driver.findElement(By.id("qf-0q-localised-check-out"));
		  departure_date.clear();
		  departure_date.sendKeys("2015-10-04");
		  
		  
		  Thread.sleep(2000);
		  
		  
		  Select room_select= new Select(driver.findElement(By.id("qf-0q-compact-occupancy")));
		  room_select.selectByIndex(0);
		  System.out.println("title is " + driver.getTitle());
		  Thread.sleep(1000);
		  System.out.println("submit");
		  
		 // WebElement submit_button = driver.findElement(By.className("cta cta-strong"));
		  WebElement submit_button = driver.findElement(By.cssSelector(".cont-bd"));
		  
		  System.out.println(submit_button.isEnabled()+" "+	submit_button.isSelected());

		  submit_button.submit();
	}
	
	
  public static void main(String args[]) throws Exception
  {
	  //如果你的浏览器不是安装在默认路径就需要设置。
	  System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	  WebDriver driver = new FirefoxDriver();
	  
	  driver.get("http://www.staging1-hotels.cn");
	  //还有其他方法打开
	 //driver.navigate().to("www.staging1-hotels.cn");
	  
	  driver.manage().window().maximize();
	  
	  WebElement search=  driver.findElement(By.id("destination"));
	  
	  search.clear();
	  search.sendKeys("London");
	  
	  Thread.sleep(1000);
	  
	  WebElement  arrive_date= driver.findElement(By.id("arrival_date"));
	  arrive_date.clear();
	  arrive_date.sendKeys("2015-10-03");
	  
	  Thread.sleep(1000);
	  WebElement departure_date= driver.findElement(By.id("departure_date"));
	  departure_date.clear();
	  departure_date.sendKeys("2015-10-04");
	  
	  
	  Thread.sleep(2000);
	  
	  
	  Select room_select= new Select(driver.findElement(By.id("compact_occupancy_dropdown")));
	  room_select.selectByIndex(0);
	  System.out.println("title is " + driver.getTitle());
	  Thread.sleep(1000);
	  System.out.println("submit");
	  
	  WebElement submit_button = driver.findElement(By.id("qf-submit"));
	  
	  System.out.println(submit_button.isEnabled());
	  
	  submit_button.submit();
	  
	  
	  System.out.println("handler before "+driver.getWindowHandle());
//
	  Thread.sleep(5000);
//	  
	 System.out.println("title is " + driver.getTitle());
	 System.out.println("handler after"+driver.getWindowHandle());
	 // driver.getTitle();
	  
/*	  
	 List<WebElement> select_list= new ArrayList<WebElement>();
	 select_list = driver.findElements(By.linkText("选择"));

	System.out.println(select_list.size());*/
	
	 
	 WebElement hotel_select = driver.findElement(By.linkText("选择"));
	 
	 hotel_select.click();
	 //driver.quit();
	  Thread.sleep(6000);
	  
	  
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			driver = driver.switchTo().window(it.next());// 切换到新窗口
		}
	  
	  
	  WebElement book_now_buton= driver.findElement(By.id("book-now-button"));
	  book_now_buton.click();
	  
	  Thread.sleep(1000);
	  
/*	  WebElement text_PDP=driver.findElement(By.linkText("立即付款或到店付款"));
	  if(text_PDP.isDisplayed())
	  {
		  
	  }*/
	  
	  WebElement room_select_PDP = driver.findElement(By.id("room-1-rateplan-1"));
	
	  room_select_PDP.submit();
	  
	  if(!driver.getCurrentUrl().endsWith("/bookingInitialise.do"))
	  {
		  driver.findElement(By.id("pay-now-etp-form")).submit();
	  }

	  
	  WebElement last_name = driver.findElement(By.id("room-details-room-0-last-name"));
	  last_name.sendKeys("xia");
	  WebElement first_name = driver.findElement(By.id("room-details-room-0-first-name"));
	  first_name.sendKeys("shizhang");
	  
	  
	  WebElement last_name_again= driver.findElement(By.id("payment-details-last-name"));
	  last_name_again.clear();
	  last_name_again.sendKeys("Test");
	  WebElement first_name_again= driver.findElement(By.id("payment-details-first-name"));
	  first_name_again.clear();
	  first_name_again.sendKeys("Test");
	  
	 Select card_selection= new Select(driver.findElement(By.id("payment-details-card-type-selector")));
	
	 card_selection.selectByValue("CreditCard:MasterCard:MasterCard");
	 WebElement credit_card_number= driver.findElement(By.id("payment-details-card-number"));
	 credit_card_number.sendKeys("5555555555554444");
	 WebElement cvv= driver.findElement(By.id("payment-details-cvv"));
	 cvv.sendKeys("123");
	 
	 
	 
	 Select month = new Select(driver.findElement(By.id("payment-details-expiry-month")));
	 month.selectByIndex(5);
	 Select year = new Select(driver.findElement(By.id("payment-details-expiry-year")));
	 year.selectByIndex(5);
	 
	 WebElement email=driver.findElement(By.id("contact-details-email"));
	 email.sendKeys("v-jasxia@expedia.com");
	 WebElement phone=driver.findElement(By.id("contact-details-phone"));
	 phone.sendKeys("13111111111");
	 
	 WebElement book= driver.findElement(By.id("book-button"));
	 book.click();
	 
	 driver.quit();	

  }
  
}
