#Author: alan.buda

@Test3
Feature: Schedule tasks for selected user 
  This workflow test script takes the user through the process
  of scheduling specific tasks for user in Schedule App.

  Background:
  Given Input data "./dataset/Test3.xlsx" "Sheet1"
  And Timeout 30
  
  @openAndLogin
  Scenario: Open and log in to the system
    	Given Open edge and app
   	When Set username "<username>"
    	And Set password "<password>"
    	And Set domain
    	Then Click log on
		
  @pickModule
  Scenario: Pick schedule module
	Then Click and open Schedule module

  @openAppointmentTab
  Scenario: Click Tasks tab
	Then Click close popup
	And Click Tasks tab

			
  @scheduleTask
  Scenario: Schedule task
	When Click Suggest button
	Then Check text exist "Suggested Tasks"
	When Click Suggest button
	And Click Select button in Suggested Tasks window
	Then Click OK button in Suggested Tasks window

  @confirmTask
  Scenario: Confirm tadk
	When Click Confirm button
	Then Check text exist "Confirm"
	When Set Send confirmation to Print Services "<printServices>"
	Then Click OK button in Suggested task window
