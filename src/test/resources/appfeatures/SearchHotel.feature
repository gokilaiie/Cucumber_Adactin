Feature: Search Hotel Feature


Background:
Given User is already logged into the application
						| username      | password |
					  | ADTraining102 | Password102 |
					  
Scenario Outline: User Searches the Hotel

Given user is on the Search Hotel Page
When User get the title of the Search Hotel Page
Then Title of the Page should be "Adactin.com - Search Hotel"
When User enters Search Information "<Location>","<Hotels>","<Room_Type>","<No_of_Rooms>","<Check_In_Date>","<Check_Out_Date>","<Adults_Per_Room>" and "<Children_Per_Room>"
And User clicks on Search button
When User get the title of the Page

	Examples: 
			|    Location   | Hotels     | Room_Type |    No_of_Rooms   | Check_In_Date | Check_Out_Date | Adults_Per_Room |  Children_Per_Room |
      | Melbourne    | Hotel Creek | Standard  |   1-One         |   10/08/2024   |  12/08/2024    | 2-Two           | 1-One |
