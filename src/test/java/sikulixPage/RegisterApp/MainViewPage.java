package sikulixPage.RegisterApp;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sikulixPage.General.MainPage;

/**
 * Class representing Main View page.
 * 
 * @author Alan Buda
 */ 
public class MainViewPage{
	
	//Page objects
	protected MainPage main = new MainPage();
	protected Screen s = new Screen();
	protected Region r = new Region(0,0,s.getBounds().width,s.getBounds().height,0);
	
	//Main View page elements
	protected String loginOk = "login_ok.png";
	protected String loginUser = "login_userLabel.png";
	protected String maximize = "maximize";
	
	//Main View - User Search window elements
	protected String searchAddUserButton = "searchWindow_addUser.png";
	protected String searchDateOfBirth = "searchWindow_dateOfBirth.png";
	protected String searchForename = "searchWindow_forename.png";
	protected String searchGender = "searchWindow_gender.png";
	protected String searchOkButton = "searchWindow_ok.png";
	protected String searchPostcode = "searchWindow_postcode.png";
	protected String searchResetButton = "searchWindow_reset.png";
	protected String searchSurname = "searchWindow_surname.png";

	
	/**
	 * Click and fill 'Surname:' field in Search window.
	 * 
	 * @param searchSurname
	 * 			value of Surname to set
	 * 
	 * @throws FindFailed
	 * @throws InterruptedException 
	 */
	@When("Search Surname {string} in Search window")
	public void searchSetSurname(String searchSurname) throws FindFailed, InterruptedException {
		s.wait(searchSurname,  MainPage.timeout);
		s.click(new Pattern(searchSurname).targetOffset(5,15));
		s.type(MainPage.testData.get(0).get(searchSurname));
	}
	
	/**
	 * Click and fill 'Forename:' field in Search window.
	 * 
	 * @param searchForename
	 * 			value of Forename to set
	 * 
	 * @throws FindFailed
	 */
	@When("Search Forename {string} in Search window")
	public void searchSetForename(String searchForename) throws FindFailed {
		s.wait(searchForename,  MainPage.timeout);
		s.click(new Pattern(searchForename).targetOffset(5,15));
		s.type(MainPage.testData.get(0).get(searchForename));
	}
	
	/**
	 * Click and fill 'Gender:' field in Search window.
	 * 
	 * @param searchGender
	 * 			value of Gender to set
	 * 
	 * @throws FindFailed
	 */
	@When("Search Gender {string} in Search window")
	public void searchSetGender(String searchGender) throws FindFailed {
		s.wait(searchGender,  MainPage.timeout);
		s.click(new Pattern(searchGender).targetOffset(5,15));
		s.type(MainPage.testData.get(0).get(searchGender));
	}
	
	/**
	 * Click and fill 'Date of Birth:' field in Search window.
	 * 
	 * @param searchDate
	 * 			value of Date of Birth to set
	 * 
	 * @throws FindFailed
	 */
	@When("Search Date of Birth {string} in Search window")
	public void searchSetDateOfBirth(String searchDate) throws FindFailed {
		s.wait(searchDateOfBirth,  MainPage.timeout);
		s.click(new Pattern(searchDateOfBirth).targetOffset(5,15));
		s.type(MainPage.testData.get(0).get(searchDate));
	}
	
	/**
	 * Click and fill 'Postcode:' field in Search window.
	 * 
	 * @param searchPostcode
	 * 			value of Postcode to set
	 * 
	 * @throws FindFailed
	 */
	@When("Search Postcode {string} in Search window")
	public void searchSetPostcode(String searchPostcode) throws FindFailed {
		s.wait(searchPostcode,  MainPage.timeout);
		s.click(new Pattern(searchPostcode).targetOffset(5,15));
		s.type(MainPage.testData.get(0).get(searchPostcode));
	}
	
		
	/**
	 * Click 'Search' button in Search window.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Search button in Search window")
	public void searchClickSearch() throws FindFailed {
		s.wait(searchSearchButton, MainPage.timeout).click(searchSearchButton);
	}
	
	/**
	 * Click 'Reset' button in Search window.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Reset button in Search window")
	public void searchClickReset() throws FindFailed {
		s.wait(searchResetButton, MainPage.timeout).click(searchResetButton);
	}
		
	/**
	 * Click X icon to close popup.
	 * 
	 * @throws FindFailed 
	 * @throws InterruptedException 
	 */
	@Then("Click X icon to close popup")
	public void closeWindow() throws FindFailed, InterruptedException {
		s.wait(searchX).click(searchX);
		s.waitVanish(closeInfo);
	}

}
