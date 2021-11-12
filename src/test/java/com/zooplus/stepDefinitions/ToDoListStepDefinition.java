package com.zooplus.stepDefinitions;

import com.zooplus.pageObjects.TodoList;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ToDoListStepDefinition {


	
	@Given("I am in the ToDo List main screen")
	public void i_am_in_the_ToDo_List_screen() {
		TodoList.verifyHomeScreen();
	}

	@When("I Create {int} tasks in the TODO list with {string} and {string}")
	public void i_Create_tasks_in_the_TODO_list_with_and(Integer tasks, String taskName, String taskDescription) {
	    TodoList.createTask(tasks, taskName, taskDescription);
		
	}

	@Then("I Mark one task as completed")
	public void i_Mark_one_task_as_completed() {
	    TodoList.markTaskAsCompleted();
	}

	@Then("I Verify the statistics for Active Tasks is {string}% and Completed Tasks is {string}%")
	public void i_Verify_the_statistics_for_Active_Tasks_is_and_Completed_Tasks_is(String active, String completed) {
		TodoList.activeTaskStatisticPercentage(active);
		TodoList.completedTaskStatisticPercentage(completed);
	}

	@And("I Clear completed task in TODO list")
	public void i_Clear_completed_task_in_TODO_list_and_verify_completed_task_is_no_longer_listed() {
	    TodoList.clearCompletedTasks();

	}
	
	@Then("I verify completed task is no longer listed")
	public void i_verify_completed_task_is_no_longer_listed() {
	   TodoList.verifyTaskNotPresent();
	}

}

