package com.sirma.itt.todomanager.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.sirma.itt.todomanager.steps.EndUserSteps;

public class AddTaskWithExpiryDateScenario {
	@Steps
	EndUserSteps steps;

	@When("the user fills in the fields with '$content' as content and '$date' as expiry date and click on the create button")
	public void whenTheUserFillsTheForm(String content, String date) {
		steps.addNewTaskWith(content, date);
	}
	
	@Then("he should see his task with '$content' as content and '$date' as expiry date displayed on the main page")
	public void heShouldSeeTheTask(String content,String date) {
		Assert.assertTrue(steps.findTaskWithContent(content,date));
	}
}
