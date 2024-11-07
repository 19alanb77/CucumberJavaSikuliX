#Author: alan.buda

@Test2
Feature: Add specific user and register to the system on admin access rights
  This workflow test script takes the user through the process
  of registering specific user to the system in Register App with admin access rights.

  Background:
  Given Input data "./dataset/Test2.xlsx" "Sheet1"
  And Timeout 80
  
  @openAndLogin
  Scenario: Open and log in to the system
    	Given Open edge and app
   	When Set username "<username>"
    	And Set password "<password>"
    	And Set domain
	And Set Admin access
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
	  Then Set Admin Access checkbox
	  And Click Add User button in Search window
		
  @addAddressAndNumber
  Scenario: Add address and mobile number for new user
	  When Click User Contact Details tab
	  Then Set new user Number/E-mail "<mobileNumber>"
	  When Click Address tab
	  Then Set new user Address details "<addressFlat>" "<addressStreet>" "<addressCity>" "<addressCountry>" "<addressPostcode>"
	  And Click OK button to confirm completion of new user form
	  Given Read confirmation data from popup

