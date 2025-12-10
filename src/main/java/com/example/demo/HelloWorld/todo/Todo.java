package com.example.demo.HelloWorld.todo;

import java.util.Date;
import java.util.Objects;

public class Todo {


	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	protected Todo () {
		
	}
	public Todo(long id, String username, String description,String priority,Date targetDate) {
//		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.priority=priority;
		this.targetDate = targetDate;
//		this.isDone = isDone;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;
	private String priority;
	
	@Override
	public String toString() {
		return "Todo [priority=" + priority + "]";
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return id == other.id;
	}

}
