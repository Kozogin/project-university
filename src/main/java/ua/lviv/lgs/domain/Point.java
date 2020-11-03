package ua.lviv.lgs.domain;

public class Point {
	
	private Integer pointId;
	private Integer applicantId;
	private Integer lessonId;
	private Double ball;
	
	public Point(Integer pointId, Integer applicantId, Integer lessonId, Double ball) {
		this.pointId = pointId;
		this.applicantId = applicantId;
		this.lessonId = lessonId;
		this.ball = ball;
	}
	
	public Point(Integer applicantId, Integer lessonId, Double ball) {
		this.applicantId = applicantId;
		this.lessonId = lessonId;
		this.ball = ball;
	}
	
	public Point() {}

	public Integer getPointId() {
		return pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public Double getBall() {
		return ball;
	}

	public void setBall(Double ball) {
		this.ball = ball;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((ball == null) ? 0 : ball.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (ball == null) {
			if (other.ball != null)
				return false;
		} else if (!ball.equals(other.ball))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [pointId=" + pointId + ", applicantId=" + applicantId + ", lessonId=" + lessonId + ", ball="
				+ ball + "]";
	}
	
	

}
