package com.sirma.itt.todomanager.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.sirma.itt.todomanager.steps.EndUserSteps;

public class AddTaskScenario {

	@Steps
	EndUserSteps steps;

	@Given("the user has clicked on the add-task button")
	public void givenTheUserHasOpenedTheForm() {
		steps.goToMainPage();
		steps.openAddTaskForm();
	}

	@When("the user fills in the fields with '$UserStoryAddTaskTest1' as content and click on the create button")
	public void whenTheUserAddContent(@Named("$UserStoryAddTaskTest1") String content) {
		steps.addNewTaskWith(content);
	}

	@Then("he should see his task with '$content' as content displayed on the main page")
	public void heShouldSeeTheTask(String content) {
		Assert.assertTrue(steps.findTaskWithContent(content));
	}

}
