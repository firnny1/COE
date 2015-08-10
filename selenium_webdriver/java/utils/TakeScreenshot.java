package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * 
 * @author v-jasxia
 * 保存屏幕截图
 */
public class TakeScreenshot {

	public static void setSavePath(TakesScreenshot driverName, String fileName)
	{
		String currentPath = System.getProperty("user.dir");
		 System.out.println("当前默认存储路径"+currentPath);
		 
		 File scrFile = driverName.getScreenshotAs(OutputType.FILE);
		 
		 try {
	            System.out.println("save screenshots path is:"+currentPath+"/"+fileName);
	            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+fileName));
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        } 
	        finally
	        {
	           
	            System.out.println("screen shot finished");
	        }
	}
}
