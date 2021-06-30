package br.com.agileschedule.entity;

import java.time.LocalTime;

public class Guides {

	private int id;
	private String code;
	private String name;
	private String url;
	private LocalTime lastAccessTime;
	private String kind;
	private int totalCourses;
	private int finishedCourses;
	private String color;
	private String author;

	public Guides(int id, String code, String name, String url, LocalTime lastAccessTime, String kind, int totalCourses,
			int finishedCourses, String color, String author) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.url = url;
		this.lastAccessTime = lastAccessTime;
		this.kind = kind;
		this.totalCourses = totalCourses;
		this.finishedCourses = finishedCourses;
		this.color = color;
		this.author = author;
	}

	public Guides() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalTime getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(LocalTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getTotalCourses() {
		return totalCourses;
	}

	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}

	public int getFinishedCourses() {
		return finishedCourses;
	}

	public void setFinishedCourses(int finishedCourses) {
		this.finishedCourses = finishedCourses;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
