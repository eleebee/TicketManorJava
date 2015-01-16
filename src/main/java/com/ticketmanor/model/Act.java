package com.ticketmanor.model;

import javax.persistence.*;

/*
 * An Act is one entity that people pay to see: A movie, a soloist, a troupe, a rock group, an orchestra...
 */
@Entity @Table(name="Acts")
@Inheritance(strategy=InheritanceType.JOINED)
public class Act   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	String title;
	ActType type;
	int year;
	String notes;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public ActType getType() {
		return type;
	}

	public void setType(ActType type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	/** A list of recordings related to this Act that we can sell */
	// Need to import the Recording hierarchy
	// List<Recording> discography;
	
	public Act() {
		// required by JPA
	}
	
	public Act(ActType type) {
		this.type = type;
	}
}
