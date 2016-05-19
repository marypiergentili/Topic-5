package mongodbfinal;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Schedule {
	
	//attributes
	private String day;
	private String startTime;
	private String finishTime;
	

	//setters and getters
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	

}
