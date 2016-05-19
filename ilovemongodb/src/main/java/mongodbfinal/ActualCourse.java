package mongodbfinal;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class ActualCourse{
	
	@Reference
	private Course course;
	//attributes
	private int partial_1;
	private int partial_2;
	private int partial_3;
	private int finalNote;
	
	//constructor
	public ActualCourse(){}
	
	//setters and getters
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getPartial_1() {
		return partial_1;
	}
	public void setPartial_1(int partial_1) {
		this.partial_1 = partial_1;
	}
	public int getPartial_2() {
		return partial_2;
	}
	public void setPartial_2(int partial_2) {
		this.partial_2 = partial_2;
	}
	public int getPartial_3() {
		return partial_3;
	}
	public void setPartial_3(int partial_3) {
		this.partial_3 = partial_3;
	}
	public int getFinalNote() {
		return finalNote;
	}
	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}
	
}
