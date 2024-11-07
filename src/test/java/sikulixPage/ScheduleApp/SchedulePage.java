package sikulixPage.ScheduleApp;

import org.sikuli.basics.Debug;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sikulixPage.General.MainPage;
import sikulixPage.RegisterApp.MainViewPage;

/**
 * Class representing Schedule page.
 * 
 * @author Alan Buda
 */ 
public class SchedulePage{
	
	//Page objects
	protected MainPage main = new MainPage();
	protected MainViewPage pmoMainView = new MainViewPage();
	protected Screen s = new Screen();
	protected Region r = new Region(0,0,s.getBounds().width,s.getBounds().height,0);
	
	//Schedule page elements
	protected String confirmButton = "confirmButton.png";
	protected String closeButton = "closeButton.png";
	protected String moveButton = "moveButton.png";
	protected String taskTab = "tasktTab.png";	
	protected String selectButton = "selectButton.png";
	protected String okButton = "okButton.png";
	protected String suggestButton = "suggestButton.png";
	protected String confirmPrintYes = "printYes.png";
	protected String confirmPrintNo = "printNo.png";
	
	
	/**
	 * Click 'Tasks' tab.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Tasks tab")
	public void clickTaskTab() throws FindFailed {
		s.wait(taskTab, MainPage.timeout).click(taskTab);
	}
	
	/**
	 * Click 'Close' button in popup if exist.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click close popup")
	public void clickClosepopups() throws FindFailed {
		if(s.exists(closeButton, 5) != null) {
			s.wait(closeButton, MainPage.timeout).click(closeButton);
		}
	}
	
	/**
	 * Click 'Move' button.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Move button")
	public void clickMoveButton() throws FindFailed {
		s.wait(moveButton, MainPage.timeout).click(moveButton);
	}
	
	/**
	 * Click 'Suggest' button.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Suggest button")
	public void clickSuggestButton() throws FindFailed {
		s.wait(suggestButton, MainPage.timeout).click(suggestButton);
	}
	
	/**
	 * Click 'Select' button in Suggested Tasks window.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Select button in Suggested Tasks window")
	public void clickSelectButtonSuggestedTasks() throws FindFailed {
		s.wait(selectButton, MainPage.timeout).click(selectButton);
	}
	
	/**
	 * Click 'OK' button in Suggested Tasks window.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click OK button in Suggested Tasks window")
	public void clickOKButtonSuggestedTasks() throws FindFailed {
		s.wait(okButton, MainPage.timeout).click(okButton);
	}
	
	/**
	 * Click 'Confirm' button.
	 * 
	 * @throws FindFailed 
	 */
	@Then("Click Confirm button")
	public void clickConfirmButton() throws FindFailed {
		s.wait(confirmButton, MainPage.timeout).click(confirmButton);
	}
	
	/**
	 * Set 'Send confirmation' field.
	 * 
	 * @param printServices
	 * 			value of the field (Yes/No)
	 * 
	 * @throws FindFailed 
	 */
	@When("Set Send confirmation to Print Services {string}")
	public void clickConfirmPrint(String printServices) throws FindFailed {
		main.assertElement("Confirm");
		s.wait(confirmPrint, MainPage.timeout).click(confirmPrint);	
		if(MainPage.testData.get(0).get(printServices).equals("Yes")) {
			s.wait(confirmPrintYes, MainPage.timeout).click(confirmPrintYes);	
		} else if(MainPage.testData.get(0).get(printServices).equals("No")){
			s.wait(confirmPrintNo, MainPage.timeout).click(confirmPrintNo);	
		} else {
			Debug.log("Wrong option");
		}
	}
	
}
