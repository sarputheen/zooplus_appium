Feature: Todo List Feature Testing
Description: This feature will test the E2E functionality of Todo List.

@automated @todolist01 
Scenario Outline: As a user, I want to verify the TODO list App functionality
	Given I am in the ToDo List main screen
	When I Create <Tasks> tasks in the TODO list with "<TaskName>" and "<Description>"
	And I Mark one task as completed
	Then I Verify the statistics for Active Tasks is "<Active>"% and Completed Tasks is "<Completed>"%
	And I Clear completed task in TODO list
	Then I verify completed task is no longer listed
	
		Examples:
			|Tasks|TaskName|Description					 |Active|Completed|
			|2		|Task		 |Desrcription for task|50    |50			  |
	

