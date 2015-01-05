package com.sirma.itt.todomanager.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.*;
import com.sirma.itt.todomanager.steps.EndUserSteps;

public class FinishScenario {

	@Steps
	private EndUserSteps steps;
	
	@Given("the user has added a task with '$content' as content")
	public void givenTheUserHasAddedATask(String content){
		steps.openAddTaskForm();
		steps.addNewTaskWith(content);
	}
	
	@When("the user clicks the finish option on task with content '$content'")
	public void whenTheUserClicks(String content){
		steps.finishTaskWithContent(content);
	}
	
	@Then("he should see his task with '$content' marked as finished")
	public void thenHeShouldSee(String content){
		Assert.assertTrue(steps.isFinishedTaskWithContent(content));
	}
	
}
