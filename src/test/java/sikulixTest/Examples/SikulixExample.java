package sikulixTest.Examples;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import sikulixPage.General.MainPage;

/**
 * Class that allows to create example test using SikuliX.
 * 
 * @author Alan Buda
 */ 
public class SikulixExample {

	MainPage main = new MainPage();
	
	@Test(description = "Click on the icon and log in to the system")
	public void openAndLogin() throws FindFailed, InterruptedException {
		main.changeTimeout(80);
		main.openSystem();
		main.setUsername("test33");
		main.clickLogon();
	}
	
	@Test(description = "Pick domain", dependsOnMethods = "openAndLogin")
	public void pickDomain() throws FindFailed {
		main.pickDomain("domain1");
	}

}
