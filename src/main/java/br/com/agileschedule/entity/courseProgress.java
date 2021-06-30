package br.com.agileschedule.entity;

public class courseProgress {

	private Long id;
	private String slug;
	private boolean finished; 
	private Long lasAcessTime;
	private int progress;
	private boolean readyToFinish;
	
	public courseProgress(Long id, String slug, boolean finished, Long lasAcessTime, int progress,
			boolean readyToFinish) {
		super();
		this.id = id;
		this.slug = slug;
		this.finished = finished;
		this.lasAcessTime = lasAcessTime;
		this.progress = progress;
		this.readyToFinish = readyToFinish;
	}

	
	
	public courseProgress() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getLasAcessTime() {
		return lasAcessTime;
	}

	public void setLasAcessTime(Long lasAcessTime) {
		this.lasAcessTime = lasAcessTime;
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
	
	
	
	
}
