package docker;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;




public class TestBase {
	

	

	@BeforeTest
	void startDockerGrid() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(180000);
	}



	
@AfterTest
	void stopDockerGrid() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(60000);
        //Closes prompt
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}

}
