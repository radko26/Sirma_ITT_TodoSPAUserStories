package com.sirma.itt.todomanager.pages.model;

/**
 * Wraps the date into an object.
 * 
 * @author radoslav
 */
public class Task {

	private String content;
	private String expiryDate;
	private boolean finished;

	public Task(String content, String expiryDate, boolean finished) {
		this.content = content;
		this.expiryDate = expiryDate;
		this.finished = finished;
	}

	public String getContent() {
		return content;
	}

	public String getExprityDate() {
		return expiryDate;
	}

	public boolean getFinished() {
		return finished;
	}

}
