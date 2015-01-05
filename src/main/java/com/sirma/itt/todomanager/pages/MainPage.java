package com.sirma.itt.todomanager.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.sirma.itt.todomanager.pages.model.Task;

/**
 * Page object representing the main page of the app.
 */

@DefaultUrl("http://localhost:8081")
public class MainPage extends PageObject {

	
	@FindBy(id = "addTaskButton")
	private WebElementFacade addButton;

	@FindBy(id = "addTaskFormModal")
	private WebElement formModal;
	
	@FindBy(id = "contentArea")
	private WebElement contentArea;
	
	@FindBy(id = "addTaskButtonInsideForm")
	private WebElement addTaskButtonInsideForm;
	
	@FindBy(id = "datePickerField")
	private WebElement datePickerField;
	
	/**
	 * Finds all entries in the table.
	 * 
	 * @return List containing all entries.
	 */

	public List<WebElementFacade> findEntries() {
		List<WebElementFacade> tasks = this.findAll(By.cssSelector("#taskTableBody > tr"));
		return tasks;
	}

	/**
	 * Gets the text value of each column of the entry.
	 * 
	 * @param by
	 *            The selector.
	 * @param facade
	 *            The row of the table.
	 * @return Its text value.
	 */
	private String getValueFrom(By by, WebElementFacade facade) {
		return facade.findElement(by).getText();
	}
	
	private boolean isFinished(By by, WebElementFacade facade) {
		return facade.findElement(by).getAttribute("class").contains("ng-hide");
	}

	/**
	 * Finds all current task.
	 * 
	 * @return List with the tasks.
	 */
	public List<Task> getCurrentTasks() {
		List<WebElementFacade> tasksAsWebElements = findEntries();
		List<Task> tasks = new ArrayList<>();
		for (WebElementFacade task : tasksAsWebElements) {
			Task t = new Task(getValueFrom(By.id("taskContent"), task), getValueFrom(
					By.id("taskExpiryDate"), task), isFinished(By.id("taskFinishButton"), task));
			tasks.add(t);
		}
		return tasks;
	}

	
	
	public void clickOnAddTaskButton() {
		addButton.click();
	}
	
	
	public void addContent(String content){
		contentArea.sendKeys(content);
	}

	public void clickOnAddButtonInsideTheForm() {
		addTaskButtonInsideForm.click();	
	}

	public void setDate(String date) {
		datePickerField.sendKeys(date);
	}

	public void markAsFinishedTaskWithContent(String content) {
		List<WebElementFacade> tasks = findEntries();
		
		for(WebElementFacade taskRow : tasks){
			if(getValueFrom(By.id("taskContent"), taskRow).equals(content)){
				if(!isFinished(By.id("taskFinishButton"), taskRow)){
					taskRow.findElement(By.id("taskFinishButton")).click();
					
				}
			}
		}
		
	}

	public boolean isFinishedTaskWithContent(String content) {
		List<Task> tasks = getCurrentTasks();
		for(Task task : tasks){
			if(task.getContent().equals(content)){
				return task.getFinished();
			}
		}
		throw new NotFoundException();
	}
	
}
