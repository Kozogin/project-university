package ua.lviv.lgs.service;

public class LessonDTO {
	
	private String name;
	private Double ball;
	
	public LessonDTO(String name, Double ball) {
		this.name = name;
		this.ball = ball;
	}
	
	public LessonDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBall() {
		return ball;
	}

	public void setBall(Double ball) {
		this.ball = ball;
	}

	@Override
	public String toString() {
		return "LessonDTO [name=" + name + ", ball=" + ball + "]";
	}
	
		

}
