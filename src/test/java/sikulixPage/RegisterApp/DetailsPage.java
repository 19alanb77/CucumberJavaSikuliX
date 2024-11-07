package sikulixPage.RegisterApp;

import org.sikuli.basics.Debug;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sikulixPage.General.MainPage;

/**
 * Class representing Details page.
 * 
 * @author Alan Buda
 */ 
public class DetailsPage{
	
	//Page objects
	protected MainPage main = new MainPage();
	protected MainViewPage mainView = new MainViewPage();
	protected Screen s = new Screen();
	protected Region r = new Region(0,0,s.getBounds().width,s.getBounds().height,0);
	
	//Details page elements
	protected String address = "address.png";
	protected String addressCity = "addressCity.png";
	protected String addressCountry = "addressCountry.png";
	protected String addressFlat = "addressFlat.png";
	protected String addressModify = "addressModify.png";
	protected String addressPostcode = "addressPostcode.png";
	protected String addressStreet = "addressStreet.png";
	protected String addressTab = "addressTab.png";
	protected String contactTab = "contactTab.png";
	public String mobile = "mobile.png";
	public String mobileAdd = "mobileAdd.png";
	protected String mobileNumber = "mobileNumber.png";
	protected String ok = "okButton.png";
	public String okConfirm = "confirmButton.png";
	

	/**
	 * Click 'Address' tab.
	 * 
	 * @throws FindFailed
	 */
	@Then("Click Address tab")
	public void clickAddressTab() throws FindFailed {
		s.wait(addressTab, MainPage.timeout).click(addressTab);
	}
	
	/**
	 * Click 'Contact Details'.
	 * 
	 * @throws FindFailed
	 */
	@Then("Click Contact Details tab")
	public void clickContactDetailsTab() throws FindFailed {
		s.wait(contactTab, MainPage.timeout).click(contactTab);
	}

	
	/**
	 * Modify Address details.
	 * 
	 * @param flat
	 * 			value of 'Flat Number:' field to set
	 * @param street
	 * 			value of 'Street Number:' field to set
	 * @param city
	 * 			value of 'Town/City:' field to set
	 * @param country
	 * 			value of 'Country:' field to set
	 * @param postcode
	 * 			value of 'Postcode:' field to set
	 * 
	 * @throws FindFailed
	 * @throws InterruptedException 
	 */
	@When("Set new Address details {string} {string} {string} {string} {string}")
	public void modifyHomeAddress(String flat, String street, String city, String country, String postcode) throws FindFailed, InterruptedException {
		if(s.exists(addressModify, 10) != null) {
			s.wait(addressModify, MainPage.timeout).click(addressModify);
		} else {
			s.wait(address, MainPage.timeout).click(address);	
			s.wait(addressModify, MainPage.timeout).click(addressModify);
		}
		s.wait(addressModify, timeout).click(addressModify);
		s.wait(addressFlat, timeout).click(addressFlat);
		s.type(flat);
		s.wait(addressStreet, timeout).click(addressStreet);
		s.type(street);
		s.wait(addressCity, timeout).click(addressCity);
		s.type(city);
		s.wait(addressCountry, timeout).click(addressCountry);
		s.type(country);
		s.wait(addressPostcode, timeout).click(addressPostcode);
		s.type(postcode);
		clickOK();
	}
	
	/**
	 * Fill 'Number/E-mail:'.
	 * 
	 * @param mobileNo
	 * 			value of mobile number/email to set
	 * 
	 * @throws FindFailed
	 * @throws InterruptedException 
	 */
	@When("Set new Number\\/E-mail {string}")
	public void setMobileNumber(String mobileNo) throws FindFailed {
		if(s.exists(mobileAdd, 10) != null) {
			s.wait(mobileAdd, timeout).click(mobileAdd);
		} else {
			s.wait(mobile, timeout).click(mobile);	
			s.wait(mobileAdd, timeout).click(mobileAdd);
		}
		s.wait(mobileNumber, timeout).click(mobileNumber);
		s.type(mobileNo);
		clickOK();
	}
	
	/**
	 * Read confirmation value from the popup window.
	 * 
	 * @return
	 * 		 confirmation value
	 * 
	 * @throws FindFailed
	 * @throws InterruptedException 
	 */
	@Given("Read value from popup")
	public String readValue() throws FindFailed, InterruptedException {
		String initValue = null;
		s.wait(initValue, MainPage.timeout).hover();
		String value = r.setRect(r.find("popup.png").getX(),r.find("popup.png").getY(), 300, 300).text();
		initValue = initValue.substring(initValue.indexOf("VAL:") , initValue.indexOf("NUMBER") - 1).split(" ")[1];
		Debug.log("YOUR VALUE: " + initValue);
		return initValue;
	}
	

}
