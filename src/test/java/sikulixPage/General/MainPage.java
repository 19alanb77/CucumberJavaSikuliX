package sikulixPage.General;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sikulixConfig.ExcelReader;

/**
 * Class representing main page.
 * 
 * @author Alan Buda
 */ 
public class MainPage {
	
	//Input data objects
	public ExcelReader reader = new ExcelReader();
	public static List<Map<String, String>> testData = new ArrayList<Map<String, String>>();
	public static int timeout = 30;
	
	//Page objects
	protected Screen s = new Screen();
	protected Region r = new Region(0,0,s.getBounds().width,s.getBounds().height,0);
	
	//Main page elements
	protected String edgeIcon = "edgeIcon.png";
	protected String edgeUrl = "edgeUrl.png";
	protected String icon = "icon.png";
	protected String logo = "logo.png";
	protected String logOn = "logon.png";
	protected String pass = "pass.png";
	protected String user = "user.png";

	
	/*
	 * Initialize global settings for all test scripts.
	 */
	@Before
	public void initGlobalData() {
		Settings.DebugLogs = true;
		Logger.getRootLogger().setLevel(Level.OFF);
		ImagePath.add("./images/");	
	}
	
	/**
	 * Load input data from .xlsx file.
	 * 
	 * @param filename
	 * 				path to the file
	 * @param sheetname
	 * 				name of the sheet
	 * 
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Given("Input data {string} {string}")
	public void inputData(String filename, String sheetname) throws InvalidFormatException, IOException {
		testData = reader.getData(filename, sheetname);
		Debug.log(testData.get(0).toString());
	}
	
	/**
	 * Change timeout value of waiting for an element.
	 * 
	 * @param time
	 *            period of time to set(in seconds)
	 * @throws InterruptedException 
	 */
	@Given("Timeout {int}")
	public void changeTimeout(int time) throws InterruptedException {
		timeout = time;
	}

	/**
	 * Check if element exists on the screen.
	 * 
	 * @param text
	 *            text that should exists on the screen
	 */
	@Then("Check text exist {string}")
	public void assertElement(String text) {
		s.existsText(text, timeout);
	}
	
	/**
	 * Press 'Enter' button.
	 */
	@Then("Press Enter button")
	public void pressEnter() {
		s.type(Key.ENTER);
	}
	
	/**
	 * Open Edge and insert app url.
	 * 
	 * @throws FindFailed 
	 */
	@Given("Open edge and app")
	public void openEdge() throws FindFailed {
		s.wait(edgeIcon, timeout).doubleClick(edgeIcon);
		s.wait(edgeUrl, timeout).click(edgeUrl);
		s.wait(logo,timeout);
	}
	
	/**
	 * Fill 'User name:' field in app.
	 * 
	 * @param username
	 * 			value of username to set
	 * 
	 * @throws FindFailed 
	 */
	@When("Set username {string}")
	public void setUsername(String username) throws FindFailed {
		s.wait(user,timeout).click(user);
		s.type(testData.get(0).get(username));
		s.click(logo);
	}
	
	/**
	 * Fill 'Password:' field in app.
	 * 
	 * @param password
	 * 			value of password to set
	 * 
	 * @throws FindFailed 
	 */
	@When("Set password {string}")
	public void setPassword(String password) throws FindFailed {
		s.wait(pass,timeout).click(pass);
		s.type(testData.get(0).get(password));
	}
	
	/**
	 * Fill 'Domain:' field in app.
	 * 
	 * @throws FindFailed 
	 */
	@When("Set domain")
	public void setDomain() throws FindFailed {
		s.wait(domain,timeout).click(somain);
	}
	
	/**
	 * Click 'Log On' button in app.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click log on")
	public void click() throws FindFailed {
		s.wait(logOn, timeout).click(logOn);	
	}
	
	
	/**
	 * Click domain folder. 
	 * 
	 * @param domainFolder
	 * 			name of the domain folder
	 * 
	 * @throws FindFailed
	 */
	@Then("Click domain folder {string}")
	public void pickDomainFolder(String domainFolder) throws FindFailed {
		r.waitText(testData.get(0).get(domainFolder), timeout);
		s.doubleClick(r.findText(testData.get(0).get(domainFolder)));
		try {
			s.wait(AppsFolder,30);
	 	} catch (Exception e) {
	 		Debug.log("Exeption raised");
	 		s.click(folderIcon);
			s.wait(AppsFolder,30);
	 	  }
	}
		
	/**
	 * Click Register App file.
	 * 
	 * @throws FindFailed
	 */
	@Then("Click and open Register module")
	public void openRegisterApp() throws FindFailed {
		s.wait(registerIcon).doubleClick(registerIcon);
		s.wait(logScreen, timeout);
	}
	
	/**
	 * Click Schedule App file.
	 * 
	 * @throws FindFailed
	 */
	@Then("Click and open Schedule module")
	public void openScheduleApp() throws FindFailed {
		s.wait(scheduleIcon).doubleClick(scheduleIcon);
		s.wait(logScreen, timeout);
	}
	
}
