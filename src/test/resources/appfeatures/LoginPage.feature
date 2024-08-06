Feature: Login Feature

Scenario Outline: User logs into the application

Given User is on the login Page
When User get the title of the Page
Then Title of the Page should be "Adactin.com - Hotel Reservation System"
When User enters "<username>" and "<password>"
And User clicks on Login button
When User get the title of the Page

	Examples: 
			|    username   | password |  
      | ADTraining102 | Password102 |
