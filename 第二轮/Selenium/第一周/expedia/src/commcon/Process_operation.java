package commcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;



public class Process_operation {
	 
 
   
   static WebDriver driver;
   static XmlReader xr;
   static Common_operations operation;
/**
 * 返回一个列表最后一个 tr的xpath路径
 * @return
 */
//	public String End_EmployeeID(){
// 		 
//		 Object j =   ((JavascriptExecutor)driver).executeScript("var table = document.getElementById"
//			 		+ "(\"dnn_ctr1889_ControlLoader_ctl00_GridView1-table\").rows.length;return table");
//		 	
////	 return xr.XmlReaderOne(Employee_ID_List,Employment_History_xml)+"/tbody/tr["+j+"]";
//	 
//	}

	public  int EmployeeID_Total(){
		 
		Object j =    ((JavascriptExecutor)driver).executeScript("var table = document.getElementById"
			 		+ "(\"dnn_ctr1889_ControlLoader_ctl00_GridView1-table\").rows.length;return table");					
		
		 	
	 return Integer.parseInt(j.toString());
	 
	}
	/**
	 * 
	 * @param name
	 * @param xml
	 * @return
	 */
	public int table_tr_Total(String name,String xml){
		
		String id=xr.XmlReaderOne(name,xml);
		
		Object j =    ((JavascriptExecutor)driver).executeScript("var table = document.getElementById(\""
		 		+ id+"\").rows.length;return table");					
	
        return Integer.parseInt(j.toString());
	}
/**
 * 获取一个input里面的value
 * @param name
 * @param xml
 * @return
 */
	public int getinput_value(String name,String xml){
		
		String id=xr.XmlReaderOne(name,xml);
		
		String value=driver.findElement(By.xpath(id)).getAttribute("value");
		System.out.println(value);
		return Integer.parseInt(value);
		 
	 }
	 
	/**
	 * 获取浏览器当前的URL
	 * @return
	 */
	public String getUrl(){
		
		Object  url=((JavascriptExecutor)driver).executeScript("var url=document.location.href;;return url");
		
		return url.toString();
		
	}
	
	
	/**
	 * 点击链接进入第三级页面
	 */
	public void Link(String URL1){
		
		
		String url=getUrl();
		
       if(url.equals(URL1)){
			
    	   operation.get(URL1);
			
		}else{
			
			operation.get("http://183.62.136.194:8030/worldexgroup/LoginPage.aspx");
//			
//			operation.input_Cycle(login_input,Login_xml, Login_DB_xml);
//			
//			operation.click(login, Login_xml);
//			
//			operation.click(Personal_Info_Management, Personal_Data_xml);
			
		}
		
		
		
	}
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
    public void  close_Alert(){
	
	driver.switchTo().alert().accept();

    }
}
