package expedia;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import Expedia_father.Expdia_sg_father;
import Interface.Expedia.Expedia_interface;


public class Expedia_sg extends Expdia_sg_father{
	/**
	 * ÓÃ»§Ãû´íÎó
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void login_name() throws InterruptedException, IOException {
		
         String title=Process_Login(user_name,"v-cji@expedia.com","name_001");			
			
		assertEquals(title, "Cheap Hotels, Resorts, and Flights Booking | Travel with Expedia Singapore");//¶ÏÑÔ
	}
}
