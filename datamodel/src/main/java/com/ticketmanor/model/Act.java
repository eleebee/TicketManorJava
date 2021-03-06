package com.ticketmanor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * An Act is one entity that people pay to see: A movie, a soloist, a troupe, a rock group, an orchestra...
 */
@XmlRootElement @JsonIgnoreProperties(ignoreUnknown=true)
@Entity @Table(name="acts")
@Inheritance(strategy=InheritanceType.JOINED)
public class Act   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	String title;
	ActType type;
	int year;
	String notes;
	@OneToMany
	List<Event> events;
	
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

	/** A list of recordings related to this Act that we can sell;
	 * can be movie soundtracks, music videos, etc. */
	// List<Recording> discography;
	
	public Act() {
		// required by JPA
	}
	
	public Act(ActType type) {
		this.type = type;
	}
	
	public Act(ActType type, String title) {
		this.type = type;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
