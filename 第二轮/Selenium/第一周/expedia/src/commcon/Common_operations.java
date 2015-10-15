package commcon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

public class Common_operations {
	
	static XmlReader xr;
	
	static WebDriver driver;
	
	 public void input_All(String input1,String xml,String xmld) throws InterruptedException{
			
		 List db=xr.XmlReaderList(input1, xmld);
		 
		 Map map=(Map) xr.XmlReaderMap(input1, xml);
		 
		 List l1=(List) map.get("1");
		 
		 List l2=(List) map.get("2");
		 
		 Actions action = new Actions(driver) ;
		 
		 WebElement element=null;
		   
		 for(int i=0;i<l1.size();i++){									
				 
            element=driver.findElement( By.xpath(l2.get(i).toString()));
			 
			 action.click(element).perform();
			 
			 element.clear();		
			 
			 element.sendKeys(db.get(i).toString());   
				
		 
	     }
	}
	 public void input_All_time(String input1,String xml,String xmld, Long time ) throws InterruptedException{
			
		 List db=xr.XmlReaderList(input1, xmld);
		 
		 Map map=(Map) xr.XmlReaderMap(input1, xml);
		 
		 List l1=(List) map.get("1");
		 
		 List l2=(List) map.get("2");
		 
		 Actions action = new Actions(driver) ;
		 
		 WebElement element=null;
		   
		 for(int i=0;i<l1.size();i++){									
				 
            element=driver.findElement( By.xpath(l2.get(i).toString()));
			 
			 action.click(element).perform();
			 
			 element.clear();
			
			 Thread.sleep(time);
			 
			 element.sendKeys(db.get(i).toString());   
				
		 
	     }
	}
	
	public void input_one(String value,String name,String xml){
		
		String a=xr.XmlReaderOne(name, xml);
		
		driver.findElement(By.xpath(a)).sendKeys(value);
	}
		
	//公共的方法循环输入input里的值，待测的input单独赋值
	 /**
	  * 
	  * @param name
	  * @param value
	  * @param input1
	  * @param xmld
	  * @param xml
	  */
	 
	/**
	 * 判断alert是否存在
	 * @return
	 */
	public boolean isAlertPresent(){  
        try  
        {  
            driver.switchTo().alert();  
        
            return true;  
        }     
        catch (NoAlertPresentException Ex)  
        {  
            return false;  
        }     
	}
	/**
	 * 
	 * @param name
	 * @param value
	 * @param input1  xml中元素的名称 
	 * @param xml    输入框的xpath的路径
	 * @param xmld   数据 比如输入框要输入的数据
	 * @throws InterruptedException
	 */
	//替换掉name参数的值，将原有的值赋为value
	 public  void input_Alone(String name,String value,String input1,String xml,String xmld) throws InterruptedException{
			
		 List db=xr.XmlReaderList(input1, xmld);
		 
		 Map map=(Map) xr.XmlReaderMap(input1, xml);
		 
		 List l1=(List) map.get("1");//名称	 
     
		 List l2=(List) map.get("2");//xpath
		 
		 Actions action = new Actions(driver) ;
		 
		 WebElement element=null;
		 
		 boolean isAlert=false;
		   
		 int i=0;
		
		 System.out.println(l1.size());	
		 for(i=0;i<l1.size();i++){		
			 
			
				
			 if(l1.get(i).equals(name)){
				 
				 element=driver.findElement( By.xpath(l2.get(i).toString()));
				
				 action.click(element).perform();
				 							 
				 element.clear();
			
				
			     element.sendKeys(value);
			     action.click(element).perform();
			    
		 }else{
			
			 
			 element=driver.findElement( By.xpath(l2.get(i).toString()));
			 
			// element.clear();
			 
			 isAlert=isAlertPresent();
			 System.out.print(By.xpath(l2.get(i).toString()+ i+i));	
			 
			 element.sendKeys(db.get(i).toString());   
			 
			 action.click(element).perform();
				
		 }
	}

		 
	}
	 
	//将滚动条滚到适合的位置  
	    public static void setScroll(){  
	    	
	    	
	    	 
	    	 
	        try {  
	        	String js="document.body.scrollHeight=;";
	        	
	        	Object j=((JavascriptExecutor)driver).executeScript(js);
	        	System.out.println(j+"  ssss333");
	        } catch (Exception e) {  
	            System.out.println("Fail to set the scroll.");  
	        }             
	    }     
	 public  void input_Alone_NoClick(String name,String value,String input1,String xml,String xmld) throws InterruptedException{
			
		 List db=xr.XmlReaderList(input1, xmld);
		 
		 Map map=(Map) xr.XmlReaderMap(input1, xml);
		 
		 List l1=(List) map.get("1");//名称	 
     
		 List l2=(List) map.get("2");//xpath
		 
		 Actions action = new Actions(driver) ;
		 
		 WebElement element=null;
		 
		 boolean isAlert=false;
		   
		 int i=0;
		
		 for(i=0;i<l1.size();i++){			
			
					
			
			
				 if(l1.get(i).equals(name)){
					 
					 element=driver.findElement( By.xpath(l2.get(i).toString()));								
					 	
					 action.click(element).perform();
					 
					 element.clear();
					 
				     element.sendKeys(value);
				    
			 }else{

					if(i==6){
						
						setScroll();
						 element=driver.findElement( By.xpath(l2.get(i).toString()));
							
							
							
						 isAlert=isAlertPresent();
						 
						 element.clear();
						 
						 element.sendKeys(db.get(i).toString());   
						
						 action.click(element).perform();
					}else{
				 element=driver.findElement( By.xpath(l2.get(i).toString()));
				
				
				
				 isAlert=isAlertPresent();
				 
				 element.clear();
				 
				 element.sendKeys(db.get(i).toString());   
				
				 action.click(element).perform();
		}
				}
				}
		 
	}
 public void input_Alone_time(String name,String value,String input1,String xml,String xmld,Long time ) throws InterruptedException{
		
	 List db=xr.XmlReaderList(input1, xmld);
	 
	 Map map=(Map) xr.XmlReaderMap(input1, xml);
	 
	 List l1=(List) map.get("1");
	 
	 List l2=(List) map.get("2");
	 
	
	 
	 Actions action = new Actions(driver) ;
	 
	 WebElement element=null;
	   
	 for(int i=0;i<l1.size();i++){			
		
		 if(l1.get(i).equals(name)){
			 
			 String a=xr.XmlReaderOne(l1.get(i).toString(), xml);	
			 
			 element=driver.findElement( By.xpath(a));			 		 
			
			 action.click(element).perform();
			 
			 element.clear();
			 
			 element.sendKeys(value);
			 
		
	 }else{
		 Thread.sleep(time);
		 
		 element=driver.findElement( By.xpath(l2.get(i).toString())); 
		 
		 action.click(element).perform();
		 
		 element.clear();
		 
		 element.sendKeys(db.get(i).toString());
			
	 }
}
	 }
	 /**循环输
	  * 
	  * @param input1
	  * @param xmld
	  * @param xml
	  */
	 public void input_Cycle(String input1,String xml,String xmld){
		 
		 List xpath=xr.XmlReaderList(input1,xml);
		 
		 List db=xr.XmlReaderList(input1, xmld);
		 
		 Actions action = new Actions(driver) ;
		 
		 WebElement element=null;
		
		 for(int i=0;i<xpath.size();i++){
			 
			 element=driver.findElement( By.xpath(xpath.get(i).toString()));
			 
			 action.click(element).perform();
			 
			 element.sendKeys(db.get(i).toString());   
			
		 }
	 }
	 /**
	  * 
	  * @param button
	  * @param xml
	  */
	 public void click(String button,String xml){
		 
		 driver.findElement(By.xpath(xr.XmlReaderOne(button,xml))).click(); 
		 
	 }
	 
	 public void click_xpath(String xpath){
		
		 driver.findElement(By.xpath(xpath)).click();
	 }
	 /**
	  * 
	  * @param button
	  * @param xml
	  * @return
	  */
	 public String  getText(String button,String xml){
		 
		 return driver.findElement(By.xpath(xr.XmlReaderOne(button,xml))).getText();
	 }
	
	 public String getTitle(){
		 
		 return driver.getTitle();
	 }
	 
	 public void get(String url){
		 driver.get(url);
		
	 }
	 
	 public WebElement getElement(String name,String xmlname){
		 
		 return driver.findElement(By.xpath(xr.XmlReaderOne(name, xmlname)));
		 
	 }
	 
	 public void close(){
		
		 driver.quit();
		
	 }
	 
	 public void clear(String name,String xml){
		 
		 driver.findElement(By.xpath(xr.XmlReaderOne(name,xml))).clear();
		 
	 }
	 /**
	  * 截图
	  * @param url
	  * @throws IOException
	  */
	 public void Screenshot(String url) throws IOException{
		 
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
				 	                    
		 String tu=url+".jpg";
		 
	     FileUtils.copyFile (srcFile,new File(tu)); 
				 	             
	 }
	 
	 
	 
}
