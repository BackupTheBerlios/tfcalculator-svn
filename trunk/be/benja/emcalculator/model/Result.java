package be.benja.emcalculator.model;

public class Result {
	private Integer score;
	private Integer predictedScore;
	private boolean done;
	private String comment;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Integer getPredictedScore() {
		return predictedScore;
	}
	public void setPredictedScore(Integer predictedScore) {
		this.predictedScore = predictedScore;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
