package commcon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.events.WebDriverEventListener;

public  class MyEventListener implements WebDriverEventListener {
    public void onException(Throwable ex, WebDriver arg1) {
        String filename = generateRandomFilename(ex);
        try {
            byte[] btDataFile = Base64.decodeBase64(extractScreenShot(ex).getBytes());
            File of = new File(filename);
            FileOutputStream osf = new FileOutputStream(of);
            osf.write(btDataFile);
            osf.flush();
            osf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String generateRandomFilename(Throwable ex) {
        Calendar c = Calendar.getInstance();
        String filename = ex.getMessage();
        int i = filename.indexOf('\n');
        filename = filename.substring(0, i).replaceAll("\\s", "_")
                    .replaceAll(":", "")
                    + ".png";
                    filename = "" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH)
                    + "-" + c.get(Calendar.DAY_OF_MONTH) + "-"
                    + c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE)
                    + "-" + c.get(Calendar.SECOND) + "-" + filename;
        return filename;
    }
    public String extractScreenShot(Throwable ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof ScreenshotException) {
            return ((ScreenshotException) cause).getBase64EncodedScreenshot();
        }
        return null;
    }
	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
 
	
}