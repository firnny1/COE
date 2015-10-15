package Expedia_father;

import java.io.IOException;

import org.junit.BeforeClass;

import Interface.Expedia.Expedia_interface;
import commcon.Common_operations;
import commcon.Process_operation;
import commcon.Start;

//业务逻辑代码
public class Expdia_sg_father implements Expedia_interface {
	static Common_operations operation;
	 static Process_operation process;	 
	 
	@BeforeClass
	 public static void Start1(){
			
	    	
		   if(!Start.initResult){
				Start.Start();
			}
				
			operation=Start.operation;
				
			process=Start.process;	
			
}
/**
 * 	
 * @param name//测试的参数的名称，比如用户名
 * @param value  参数值，比如用户名称是多少
 * @param tu  截图的路径
 * @return
 * @throws InterruptedException
 * @throws IOException
 */
public static String Process_Login(String name,String value,String tu) throws InterruptedException, IOException {	
		
		
		 operation.input_Alone(name, value, input, expedia_xml, expedia_DB_xml);//循环添加input数据	 
		
		 operation.click(sing, expedia_xml);  //登录
		 
		 Thread.sleep(1000);	
		 
		 String name1=picture_url+tu;
		 
		 operation.Screenshot(name1);// 截图
		 
		return operation.getTitle();					
	
	}
}
