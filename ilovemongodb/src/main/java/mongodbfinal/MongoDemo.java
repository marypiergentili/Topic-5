package mongodbfinal;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

public class MongoDemo {

	public static void main(String[] args) {
		
		//MongoDBConnection mongoDB= MongoDBConnection.getInstance();
		String databaseName = "high_school_2";
		MongoClient mongo= new MongoClient();
		Morphia morphia = new Morphia();
		Datastore datastore = morphia.createDatastore(mongo,databaseName );
		
		//mapping our classes
		morphia.map(Course.class);
		morphia.map(Schedule.class);
		morphia.map(Teacher.class);
		morphia.map(Student.class);
		morphia.map(ActualCourse.class);
		
		//creating the schedule for maths course
		List <Schedule> scheduleListMaths= new ArrayList<Schedule>();
		Schedule schedule1= new Schedule();
		schedule1.setDay("Monday");
		schedule1.setStartTime("14:00:00");
		schedule1.setFinishTime("16:00:00");
		scheduleListMaths.add(schedule1);
		Schedule schedule2= new Schedule();
		schedule2.setDay("Tuesday");
		schedule2.setStartTime("14:00:00");
		schedule2.setFinishTime("15:00:00");
		scheduleListMaths.add(schedule2);
		Schedule schedule3= new Schedule();
		schedule3.setDay("Wednesday");
		schedule3.setStartTime("16:00:00");
		schedule3.setFinishTime("18:00:00");
		scheduleListMaths.add(schedule3);
		
		//creating the schedule for oop course
		List <Schedule> scheduleListOOP= new ArrayList<Schedule>();
		Schedule schedule4=new Schedule();
		schedule4.setDay("Monday");
		schedule4.setStartTime("16:00:00");
		schedule4.setFinishTime("18:00:00");
		scheduleListOOP.add(schedule4);
		Schedule schedule5=new Schedule();
		schedule5.setDay("Thursday");
		schedule5.setStartTime("14:00:00");
		schedule5.setFinishTime("16:00:00");
		scheduleListOOP.add(schedule5);
		
		//creating the schedule for logics course
		List <Schedule> scheduleListLogics= new ArrayList<Schedule>();
		Schedule schedule6=new Schedule();
		schedule6.setDay("Monday");
		schedule6.setStartTime("16:00:00");
		schedule6.setFinishTime("18:00:00");
		scheduleListLogics.add(schedule6);
		Schedule schedule7=new Schedule();
		schedule7.setDay("Friday");
		schedule7.setStartTime("14:00:00");
		schedule7.setFinishTime("16:00:00");
		scheduleListLogics.add(schedule7);
		
		//creating the course Maths
		Course course1= new Course();
		course1.setName("Maths");
		course1.setHoursPerWeek(5);
		course1.setYear(2016);
		//adding the schedule list to the course
		course1.setSchedule(scheduleListMaths);
		//inserting the course element to the db
		datastore.save(course1);
		
		//creating the course OOP
		Course course2= new Course();
		course2.setName("OOP");
		course2.setHoursPerWeek(4);
		course2.setYear(2016);
		//adding the schedule list to the course
		course2.setSchedule(scheduleListOOP);
		//inserting the course element to the db
		datastore.save(course2);
		
		//creating the course Logics
		Course course3= new Course();
		course3.setName("Logics");
		course3.setHoursPerWeek(2);
		course3.setYear(2016);
		//adding the schedule list to the course
		course3.setSchedule(scheduleListLogics);
		//inserting the course element to the db
		datastore.save(course3);
		
		
		//creating first teacher
		Teacher teacher1=new Teacher();
		teacher1.setLastName("Villarruel");
		teacher1.setFirstName("Aida");
		teacher1.setDateOfBirth("1956-04-19");
		//adding courses references to the teacher
		teacher1.getCourses().add(course1);
		teacher1.getCourses().add(course3);
		datastore.save(teacher1);
		
		//creating second teacher
		Teacher teacher2=new Teacher();
		teacher2.setLastName("Gabaldon");
		teacher2.setFirstName("Maria Esther");
		teacher2.setDateOfBirth("1940-03-02");
		//adding courses references to the teacher
		teacher2.getCourses().add(course2);
		teacher2.getCourses().add(course3);
		datastore.save(teacher2);
		
		//creating third teacher
		Teacher teacher3=new Teacher();
		teacher3.setLastName("Piergentili");
		teacher3.setFirstName("Raul");
		teacher3.setDateOfBirth("1954-07-31");
		//adding courses references to the teacher
		teacher3.getCourses().add(course1);
		teacher3.getCourses().add(course2);
		teacher3.getCourses().add(course3);
		datastore.save(teacher3);
		
		
		//creating first student
		Student student1=new Student();
		student1.setRegistrationNumber(1);
		student1.setFistName("Cynthia");
		student1.setLastName("Andrada");
		student1.setDateOfBirth("1987-08-20");
		datastore.save(student1);
		//creating this student actual course
		ActualCourse actualCourse1 = new ActualCourse();
		actualCourse1.setPartial_1(4);
		actualCourse1.setPartial_2(10);
		actualCourse1.setPartial_3(9);
		actualCourse1.setFinalNote(8);
		//adding the objects references
		actualCourse1.setCourse(course1);
		student1.getCourses().add(actualCourse1);
		ActualCourse actualCourse2 = new ActualCourse();
		actualCourse2.setPartial_1(10);
		actualCourse2.setPartial_2(9);
		actualCourse2.setPartial_3(8);
		actualCourse2.setFinalNote(9);
		//adding the objects references
		actualCourse2.setCourse(course2);
		student1.getCourses().add(actualCourse2);
		ActualCourse actualCourse3 = new ActualCourse();
		actualCourse3.setPartial_1(1);
		//adding the objects references
		actualCourse3.setCourse(course3);
		student1.getCourses().add(actualCourse3);
		datastore.save(student1);
		
		//creating second student
		Student student2=new Student();
		student2.setRegistrationNumber(2);
		student2.setFistName("Leonardo");
		student2.setLastName("Piergentili");
		student2.setDateOfBirth("1993-09-16");
		datastore.save(student2);
		//creating this student actual course
		actualCourse1 = new ActualCourse();
		actualCourse1.setPartial_1(8);
		actualCourse1.setPartial_2(7);
		actualCourse1.setPartial_3(4);
		actualCourse1.setFinalNote(6);
		//adding the objects references
		actualCourse1.setCourse(course1);
		student2.getCourses().add(actualCourse1);
		actualCourse3 = new ActualCourse();
		actualCourse3.setPartial_1(4);
		actualCourse3.setPartial_2(6);
		actualCourse3.setPartial_3(4);
		actualCourse3.setFinalNote(6);
		//adding the objects references
		actualCourse3.setCourse(course3);
		student2.getCourses().add(actualCourse3);
		datastore.save(student2);
		
		//creating third student
		Student student3=new Student();
		student3.setRegistrationNumber(3);
		student3.setFistName("Antonela");
		student3.setLastName("Piergentili");
		student3.setDateOfBirth("1993-09-16");
		datastore.save(student3);
		//creating this student actual course
		actualCourse1 = new ActualCourse();
		actualCourse1.setPartial_1(7);
		actualCourse1.setPartial_2(6);
		actualCourse1.setPartial_3(6);
		actualCourse1.setFinalNote(8);
		//adding the objects references
		actualCourse1.setCourse(course1);
		student3.getCourses().add(actualCourse1);
		actualCourse3 = new ActualCourse();
		actualCourse3.setPartial_1(9);
		actualCourse3.setPartial_2(9);
		actualCourse3.setPartial_3(4);
		actualCourse3.setFinalNote(7);
		//adding the objects references
		actualCourse3.setCourse(course3);
		student3.getCourses().add(actualCourse3);
		datastore.save(student3);
		
		//creating fourth student
		Student student4=new Student();
		student4.setRegistrationNumber(4);
		student4.setFistName("Fernanda");
		student4.setLastName("Valverde");
		student4.setDateOfBirth("1986-05-19");
		datastore.save(student4);
		//creating this student actual course
		actualCourse1 = new ActualCourse();
		actualCourse1.setPartial_1(5);
		actualCourse1.setPartial_2(4);
		actualCourse1.setPartial_3(5);
		actualCourse1.setFinalNote(5);
		//adding the objects references
		actualCourse1.setCourse(course1);
		student4.getCourses().add(actualCourse1);
		actualCourse2 = new ActualCourse();
		actualCourse2.setPartial_1(2);
		actualCourse2.setPartial_2(2);
		actualCourse2.setPartial_3(4);
		//adding the objects references
		actualCourse2.setCourse(course2);
		student4.getCourses().add(actualCourse2);
		actualCourse3 = new ActualCourse();
		actualCourse3.setPartial_1(2);
		actualCourse3.setPartial_2(4);
		actualCourse3.setPartial_3(2);
		//adding the objects references
		actualCourse3.setCourse(course3);
		student4.getCourses().add(actualCourse3);
		datastore.save(student4);
		
		//creating fifth student
		Student student5=new Student();
		student5.setRegistrationNumber(5);
		student5.setFistName("Ailin");
		student5.setLastName("Almaza");
		student5.setDateOfBirth("1986-12-08");
		datastore.save(student5);
		//creating this student actual course
		actualCourse2 = new ActualCourse();
		actualCourse2.setPartial_1(2);
		actualCourse2.setPartial_2(2);
		actualCourse2.setPartial_3(4);
		//adding the objects references
		actualCourse2.setCourse(course2);
		student5.getCourses().add(actualCourse2);
		datastore.save(student5);		
		
		//creating sixth student
		Student student6=new Student();
		student6.setRegistrationNumber(6);
		student6.setFistName("Marianela");
		student6.setLastName("Piergentili");
		student6.setDateOfBirth("1986-11-19");
		datastore.save(student6);
		//creating this student actual course
		actualCourse3 = new ActualCourse();
		actualCourse3.setPartial_1(8);
		actualCourse3.setPartial_2(8);
		actualCourse3.setPartial_3(6);
		actualCourse3.setFinalNote(7);
		//adding the objects references
		actualCourse3.setCourse(course3);
		student6.getCourses().add(actualCourse3);
		datastore.save(student6);
		
		
		//adding the course objects references
		//maths course
		course1.getTeachers().add(teacher1);
		course1.getTeachers().add(teacher2);
		course1.getStudents().add(student1);
		course1.getStudents().add(student2);
		course1.getStudents().add(student3);
		course1.getStudents().add(student4);
		datastore.save(course1);
		
		//oop course
		course2.getTeachers().add(teacher2);
		course2.getTeachers().add(teacher2);
		course2.getStudents().add(student1);
		course2.getStudents().add(student4);
		course2.getStudents().add(student5);
		datastore.save(course2);
		
		//logics course
		course3.getTeachers().add(teacher1);
		course3.getTeachers().add(teacher2);
		course3.getTeachers().add(teacher3);
		course3.getStudents().add(student1);
		course3.getStudents().add(student2);
		course3.getStudents().add(student3);
		course3.getStudents().add(student4);
		course3.getStudents().add(student6);
		datastore.save(course3);

		//query showing the students that passed Maths course
		Course query1 = datastore.createQuery(Course.class).filter("name =", "Maths").get();
		System.out.println(query1);
		ObjectId courseId= query1.getId();
		System.out.println(courseId);
		List<Student> studentsQuery= datastore.createQuery(Student.class).filter("courses.finalNote >", 4).filter("courses.course =", query1).asList();
		for (Student student : studentsQuery) {
			System.out.println(student.getFistName()+", "+student.getLastName()+"\n"+query1.getName());
		}
		
	}

}
