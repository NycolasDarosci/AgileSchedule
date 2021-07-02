package br.com.agileschedule.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.agileschedule.entity.CourseProgresses;
import br.com.agileschedule.entity.Guides;

public class AluraForm {
	
	@NotNull @NotEmpty
	private int id;
	@NotNull @NotEmpty
	private List<CourseProgresses> courseProgresses;
	@NotNull @NotEmpty
	private List<Guides> guides;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CourseProgresses> getCourseProgresses() {
		return courseProgresses;
	}
	public void setCourseProgresses(List<CourseProgresses> courseProgresses) {
		this.courseProgresses = courseProgresses;
	}
	public List<Guides> getGuides() {
		return guides;
	}
	public void setGuides(List<Guides> guides) {
		this.guides = guides;
	}
	
	
}
