#Author: alan.buda

@Test1
Feature: Add user and register to the system
  This workflow test script takes the user through the process
  of registering user to the system.
  
  Background:
  Given Input data "./dataset/Test1.xlsx" "Sheet1"
  And Timeout 80

  @openAndLogin
  Scenario: Open and log in to the system
    	Given Open edge and app
   	When Set username "<username>"
    	And Set password "<password>"
    	And Set domain
    	Then Click log on
		
  @pickModule
  Scenario: Pick register module
	Then Click and open Register module
		
  @userSearch
  Scenario: Search for new user and click Add User button
	  Then Click Reset button in Search window
	  When Search Surname "<searchSurname>" in Search window
          And Search Forename "<searchForename>" in Search window
	  And Search Gender "<searchGender>" in Search window
          And Search Postcode "<searchPostcode>" in Search window
          And Search Date of Birth "<searchDateOfBirth>" in Search window
	  Then Click Add User button in Search window
		
  @addAddressAndNumber
  Scenario: Add address and mobile number for new user
	  When Click User Contact Details tab
	  Then Set new user Number/E-mail "<mobileNumber>"
	  When Click Address tab
	  Then Set new user Address details "<addressFlat>" "<addressStreet>" "<addressCity>" "<addressCountry>" "<addressPostcode>"
	  And Click OK button to confirm completion of new user form
	  Given Read confirmation data from popup

