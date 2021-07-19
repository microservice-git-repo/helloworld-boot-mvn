package com.springboot.cache.entity;

public class Book {
	
	private int id;
	private String name;
	private String author;
	private String category;
	private String publisher;
	private String edition;
	
	public Book(int id, String name, String author, String category, String publisher, String edition) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
		this.edition = edition;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	

}
