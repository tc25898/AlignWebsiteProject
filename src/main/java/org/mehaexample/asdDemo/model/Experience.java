package org.mehaexample.asdDemo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Experience {
	private int id;
	private String nueId;
	private String title;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNueId() {
		return nueId;
	}
	
	public void setNueId(String nueId) {
		this.nueId = nueId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
