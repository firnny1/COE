package commcon;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class Start {
	
public static boolean initResult = false;

public static Common_operations operation;

public static Process_operation process;
	
//启动浏览器，初始化

 public  static synchronized  void  Start() {
	 			
	 System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\FireFox\\firefox.exe");
	 
	 String url = "https://wwwexpediacomsg.integration.sb.karmalab.net/user/signin?ckoflag=0"; 
	 
	 WebDriver driver = new FirefoxDriver();
	 
	 driver.get(url);
	 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //设置隐形等待时间
	 
	 driver.manage().window().maximize();//浏览器最大化
	 
	 XmlReader  xr=new XmlReader();//读取数据只用
	 
	 operation=new Common_operations();	//具体的业务方法
	 
	 operation.driver=driver;	
	 
	 operation.xr=xr;//XPath路径和数据
	 
	 process=new Process_operation();
	 
	 process.operation=operation;
	 
//	 process.driver=driver;
//	 
//	 process.xr=xr;
	 
	 initResult = true;
	
 }
 
 
}
