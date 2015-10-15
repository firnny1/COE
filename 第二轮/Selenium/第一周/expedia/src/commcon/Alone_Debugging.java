package commcon;

import javax.print.attribute.standard.Media;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;



public class Alone_Debugging {
	
	public static void main(String [] p){
		
		new Thread() {
			
		public void run() {
			
         //   new JUnitCore().run(Request.method(MPF.class, "Employer_da1"));
            
		}  
    }.start();
	}
}
