package mongodbfinal;

import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.annotations.*;

@Entity
public class Student extends BaseEntity{
	
	//attributes
	private int registrationNumber;
	private String fistName;
	private String lastName;
	private String dateOfBirth;
	@Embedded
	private List<ActualCourse> courses;
	
	public Student(){
		courses = new ArrayList<ActualCourse>();
	}

	//setters and getters
	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<ActualCourse> getCourses() {
		return courses;
	}

	public void setCourses(List<ActualCourse> courses) {
		this.courses = courses;
	}
	
	
	

}
