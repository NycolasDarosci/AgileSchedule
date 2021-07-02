package br.com.agileschedule.entity;

import java.time.LocalTime;
import java.util.Date;

public class CourseProgresses {

	private int id;
	private String name;
	private String slug;
	private boolean finished;
	private Date lastAcessTime;
	private int progress;
	private boolean readyToFinish;

	public CourseProgresses(int id, String name, String slug, boolean finished, Date lastAcessTime, int progress,
			boolean readyToFinish) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.finished = finished;
		this.lastAcessTime = lastAcessTime;
		this.progress = progress;
		this.readyToFinish = readyToFinish;
	}

	public CourseProgresses() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Date getLastAcessTime() {
		return lastAcessTime;
	}

	public void setLastAcessTime(Date lastAcessTime) {
		this.lastAcessTime = lastAcessTime;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public boolean isReadyToFinish() {
		return readyToFinish;
	}

	public void setReadyToFinish(boolean readyToFinish) {
		this.readyToFinish = readyToFinish;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
