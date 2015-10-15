package commcon;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;



//public class Login   implements Login_interface{
//	
//	  public static Common_operations operation;
//	  public static Process_operation process;
//	
//	@BeforeClass
//	public static void Start1() {
//		
//		 
//		if(!Start.initResult){
//			Start.Start();
//		}
//			
//		operation=Start.operation;
//			
//		process=Start.process;	
//		
//	}
//	
//	
//	public static String Process_Login(String name,String value,String tu) throws InterruptedException, IOException {	
//		
//		operation.get("http://183.62.136.194:8030/worldexgroup/LoginPage.aspx");
//		
//		 operation.input_Alone(name, value, login_input, Login_xml, Login_DB_xml);//循环添加input数据	 
//		
//		 operation.click(login, Login_xml);  //登录
//		 
//		 Thread.sleep(1000);	
//		 
//		 String name1=url+tu;
//		 
//		 operation.Screenshot(name1);
//		 
//		return operation.getTitle();					
//	
//	}
//	/**
//	 * 用户名错误
//	 * @throws InterruptedException
//	 * @throws IOException
//	 */
//	@Test
//	public void login_name() throws InterruptedException, IOException {
//		
//         String title=Process_Login(username,"001","name_001");			
//			
//		assertEquals(title, "User Login");//断言
//	}
//	/**
//	 * 用户名喝密码都是正确的
//	 * @throws InterruptedException
//	 * @throws IOException
//	 */
//	@Test
//	public void login_username() throws InterruptedException, IOException{
//		
//		 
//		String title=Process_Login(username,"001000001","name_001000001");		
//		
//		assertEquals(title, "HomePage");//断言
//		
//	}
//	/**
//	 * name输入%模拟sql注入
//	 * @throws InterruptedException
//	 * @throws IOException
//	 */
//	@Test
//	public void name() throws InterruptedException, IOException{
//		
//        String title=Process_Login(username,"00100%","name_00100%");
//					
//		Thread.sleep(1000);
//		
//		assertEquals(title, "User Login");//断言
//	}
//
///**
// * 
// * @throws InterruptedException
// * @throws IOException
// */
//	@Test
//   public void name1() throws InterruptedException, IOException{
//	
//    String title=Process_Login(username,"","name_");	
//	
//	Thread.sleep(1000);
//	
//	assertEquals(title, "User Login");//断言
//}
//   /**
//    * 空密码
//    * @throws InterruptedException
//    * @throws IOException
//    */
//	@Test
//   public void password() throws InterruptedException, IOException{
//		
//	    String title=Process_Login(password,"","pass_");	
//		
//		Thread.sleep(1000);
//		
//		assertEquals(title, "User Login");//断言
//	}
//	/**
//	 * 密码中间加空格
//	 * @throws InterruptedException
//	 * @throws IOException
//	 */
//	@Test
//	   public void password1() throws InterruptedException, IOException{
//			
//		    String title=Process_Login(password,"abc %123","pass_abc_%123");						
//			
//			Thread.sleep(1000);
//			
//			assertEquals(title, "User Login");//断言
//		}
//}
