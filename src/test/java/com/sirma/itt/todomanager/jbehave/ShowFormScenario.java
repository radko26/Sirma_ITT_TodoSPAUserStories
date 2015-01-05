package com.sirma.itt.todomanager.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.sirma.itt.todomanager.steps.EndUserSteps;

public class ShowFormScenario {

	@Steps
	EndUserSteps steps;

	@Given("the user is on the main page")
	public void givenTheUserIsOnMainPage() {
		steps.goToMainPage();
	}

	@When("the user clicks on the add-task button")
	public void whenTheUserClicksOnTheAddTaskButton() {
		steps.openAddTaskForm();
	}

	

}
