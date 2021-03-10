package Com.Criteria.Entity.Studentt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long studentId;
	private String studentFirstName;
	private String studentLastName;
	private int studentAge;
	public Student()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long studentId, String studentFirstName, String studentLastName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentAge = studentAge;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", studentAge=" + studentAge + "]";
	}

}
