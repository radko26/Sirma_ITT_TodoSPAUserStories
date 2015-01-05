package com.sirma.itt.todomanager.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.sirma.itt.todomanager.pages.MainPage;
import com.sirma.itt.todomanager.pages.model.Task;

public class EndUserSteps extends ScenarioSteps {

	MainPage page;

	@Step
	public void openAddTaskForm() {
		page.clickOnAddTaskButton();
	}

	@Step
	public void goToMainPage() {
		page.open();
	}

	@Step
	public boolean findTaskWithContent(String content) {
		List<Task> tasks = page.getCurrentTasks();

		for (Task task : tasks) {
			if (task.getContent().equals(content)) {
				return true;
			}
		}
		return false;
	}

	@Step
	public boolean findTaskWithContent(String content, String date) {
		List<Task> tasks = page.getCurrentTasks();

		for (Task task : tasks) {
			if (task.getContent().equals(content) && task.getExprityDate().equals(date)) {
				return true;
			}
		}
		return false;
	}

	@Step
	public void addNewTaskWith(String content) {
		page.addContent(content);
		page.clickOnAddButtonInsideTheForm();
	}

	@Step
	public void addNewTaskWith(String content, String date) {
		page.addContent(content);
		page.setDate(date);
		page.clickOnAddButtonInsideTheForm();
	}

	public void finishTaskWithContent(String content) {
		page.markAsFinishedTaskWithContent(content);
		
	}

	public boolean isFinishedTaskWithContent(String content) {
		return page.isFinishedTaskWithContent(content);
	}

}